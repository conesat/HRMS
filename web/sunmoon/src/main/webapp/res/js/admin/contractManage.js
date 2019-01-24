layui.use([ 'table', 'jquery', 'form', 'element','upload'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	var upload = layui.upload;
	var filePath="";
	var load;
	// 获取表格数据 getAddsBySE
	var postTable = table.render({
		elem : '#post',
		url : 'contractManage/getContractsBySE',
		toolbar : '#toolBar',
		title : '职位表',
		cols : [ [ {
			type : 'checkbox',
			fixed : 'left'
		}, {
			field : 'contract_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'contract_long',
			title : '时长(天)',
			minWidth : 100
		}, {
			field : 'contract_msg',
			title : '描述',
			minWidth : 200
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 150,
			fixed : 'right'
		} ] ],
		page : true
	});
	
	
	// 排序事件
	table.on('sort(post)', function(obj) { // 注：tool是工具条事件名，test是table原始容器的属性
		table.reload('post', {
			initSort : obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
			,
			where : { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
				field : obj.field // 排序字段
				,
				order : obj.type
			// 排序方式
			}
		});
	});
	
	// 添加方法
	$('#add-post').on('click', function() {
		type = 0;
		
		$('#contract_name').val("");
		$('#contract_long').val("");
		$('#addpost-change').html('添加');
		$("#contract_msg").val("");
		
		$('#contract-show').hide();
		
		$('#add-post').parent().hide();
		$('#back').parent().show();
		if($("#table").css('display')=='block'){
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
		};
		form.render(); // 更新全部000
		
	});
	
	//上传合同
	var uploadContract= upload.render({
	    elem: '#contract'
	    ,url: 'contractManage/upload'
	    ,accept: 'file'
	    ,auto: false
	    ,before: function(obj){ // obj参数包含的信息，跟 choose回调完全一致，可参见上文。
	    	console.log(opID);
	        this.data={'contract_id':opID};
	      }
	    ,done: function(res, index, upload){ //每个文件提交一次触发一次。详见“请求成功的回调”
	    	layer.close(load); 
	    	layer.confirm('已完成', {
				icon : 1,
				title : '提示'
			}, function(index) {
				layer.close(index);
				window.location.href = window.location.href;
			});
	    },error: function(index, upload){
	    	layer.confirm('上传失败，是否重新尝试?', function(index){
	    		uploadContract.upload();
	    		layer.close(index);
	    	});     
	    }
	  });
	

	// 返回按按钮点击事件
	$('#back').on('click', function() {
		$('#add-post').parent().show(); 
		$('#back').parent().hide();
		if($("#table").css('display')=='none'){
			$("#add-post-content").slideUp('', function() {
				$("#table").slideDown();
			});
		}
	});

	// 搜索工具 start
	var filter=new Set();// 需要查询的字段
	filter.add("contract_name");
	filter.add("contract_long");
	filter.add("contract_msg");
	// 字段拦截按钮事件
	$('#filter').on('click', function() {
		$("#filter-ul-div").fadeToggle();
	});
	// 字段拦截收起按钮事件
	$('#close-filter').on('click', function() {
		$("#filter-ul-div").fadeToggle();
	});
	// 搜索按钮事件
	$('#search-i').on('click', function() {
		searchAdd($("#serach-address-key").val());
	});
	// 输入框回车事件
	$('#serach-address-key').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			searchAdd($("#serach-address-key").val());
		}
	});
	// 查询字段修改事件
	form.on('checkbox(filter)', function(data) {
		if(data.elem.checked){
			filter.add(data.value);
		}else if (filter.size>1) {
			filter.delete(data.value);
		}else {
			layer.msg("至少选择一个");
			data.elem.checked=true;
			form.render('checkbox');
		}
	});
	// 开始查询
	function searchAdd(key) {
		$("#filter-ul-div").fadeOut();
		table.reload('post', {
			url : 'contractManage/getContractsBySE?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end

	// 监听提交
	form.on('submit(addpost)', function(data) {
		var url = "";
		if (type == 1) {
			url = "contractManage/update?"
					+ $("#add-post-form").serialize() + "&contract_id="
					+ opID;
		} else {
			url = "contractManage/add?"
					+ $("#add-post-form").serialize();
		}
		
		load= layer.open({
	        type: 1
	        ,title: false //不显示标题栏
	        ,closeBtn: false
	        ,area: ['100px','100px']
	        ,shade: 0.8
	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	        ,btnAlign: 'c'
	        ,moveType: 1 //拖拽模式，0或者1
	        ,content: '<div class="spinner">  <div class="double-bounce1"></div>  <div class="double-bounce2"></div> </div>'
	        ,success: function(layero, index){
	        	$.ajax({
	    			type : "post",
	    			url : url,
	    			async : true,
	    			success : function(data) {
	    				var jsonData = JSON.parse(data);
	    				console.log(jsonData);
	    				if (jsonData.code == 100&&jsonData.id!='') {
	    					opID=jsonData.id;
    						uploadContract.upload();
	    				} else if (jsonData.code == 101) {
	    					layer.msg('身份已过期，请重新登录', {
	    						icon : 2,
	    						time : 2500
	    					}, function() {
	    						window.location.href = "gotoLogin";
	    					});
	    					layer.close(load); 
	    				}else if (jsonData.code == 102) {
	    					layer.msg("访问受限,权限不足");
	    				} else if (jsonData.code == 103) {
	    					layer.confirm("等级-"+$('#rank_level').val()+" 已被使用", {
	    						icon : 3,
	    						title : '提示'
	    					}, function(index) {
	    						layer.close(index);
	    						
	    					});
	    					layer.close(load); 
	    				} else {
	    					layer.msg("未知错误");
	    					layer.close(load); 
	    				}
	    			},
	    			error : function(jqObj) {
	    				layer.close(load); 
	    			}
	    		});
	        	
	        	
	       }
		});
		
		
		
		return false;
	});
	// 头工具栏事件
	table.on('toolbar(post)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch (obj.event) {
		case 'delChecked':
			var data = checkStatus.data;
			layer.prompt({
				formType : 1,
				value : '',
				title : '验证密码',
				maxlength : 20,
			}, function(value, index, elem) {
				layer.close(index);
				if (varifyPass(value)) {
					var ids = new Array();
					for ( var x in data) {
						ids[x] = data[x].rank_id;
					}
					delAdds(ids);
				}
			});
			break;
		}
		;
	});

	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		// console.log(obj)
		if (obj.event === 'del') {
			layer.prompt({
				formType : 1,
				value : '',
				title : '验证密码',
				maxlength : 20,
			}, function(value, index, elem) {
				layer.close(index);
				if (varifyPass(value)) {
					delAdds(data.post_id);
				}
			});
		} else if (obj.event === 'edit') {
			type = 1;// 查看与编辑
			filePath=data.contract_url;
			opID = data.contract_id;// 操作数据id
			$('#contract_name').val(data.contract_name);
			$('#contract_long').val(data.contract_long);
			$('#addpost-change').html('修改');
			$("#contract_msg").val(data.contract_msg);
			
			if (data.contract_url!='') {
				$('#contract-show').show();
			}else{
				$('#contract-show').hide();
			}
			
			form.render(); // 更新全部000
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
			$('#add-post').parent().hide();
			$('#back').parent().show();
		}
	});
	
	//下载文件
	$('#contract-show').on('click',function(){
		window.location.href="file/downLoadFile?path="+filePath+"&fileName="+$('#contract_name').val();
	});
	
	// 批量删除地址
	function delAdds(ids) {
		$.ajax({
			type : "post",
			url : "contractManage/del?ids=" + ids,
			async : true,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == '100') {
					layer.msg('已完成', {
						icon : 1,
						time : 2500
					}, function() {
						window.location.reload();
					});
				}else if (jsonData.code == 102) {
					layer.msg("访问受限,权限不足");
				} else {
					layer.msg("未知错误", {
						icon : 2
					});
				}
			},
			error : function(jqObj) {

			}
		});
		return false;
	}

	// 验证账号密码
	function varifyPass(pass) {
		var re = false;
		$.ajax({
			type : "post",
			url : "verifyStaff?staff_password=" + pass,
			async : false,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == 100) {
					re = true;
				} else if (jsonData.code == 101) {
					layer.msg("密码验证不通过", {
						icon : 4
					});
				} else if (jsonData.code == 102) {
					layer.msg('身份已过期，请重新登录', {
						icon : 2,
						time : 2500
					}, function() {
						window.location.href = "gotoLogin";
					});
				} else {
					layer.msg("未知错误", {
						icon : 2
					});
				}
			},
			error : function(jqObj) {

			}
		});
		return re;
	}
	// 重载表格 防止拉伸
	window.reloadTable = function() {
		postTable.reload();
	};
	
	form.render();
	
});