layui.use([ 'table', 'jquery', 'form', 'element','upload'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var itemState='';//选择的条目状态
	var element = layui.element;
	var upload = layui.upload;
	var applyId="";
	var fileTable='';
	// 获取表格数据 getAddsBySE
	var postTable = table.render({
		elem : '#post',
		url : 'recruitManage/getMyRecruitBySE',
		toolbar : '#toolBar',
		title : '职位表',
		cols : [ [ {
			type : 'checkbox',
			fixed : 'left'
		}, {
			field : 'position_name',
			title : '招聘职位',
			minWidth : 130,
			sort : true
		}, {
			field : 'rel_rec_title',
			title : '标题',
			minWidth : 200,
			sort : true
		}, {
			field : 'rel_rec_desc',
			title : '描述',
			minWidth : 100
		}, {
			field : 'rel_rec_number',
			title : '人数',
			minWidth : 100,
			sort : true
		}, {
			field : 'rel_rec_money',
			title : '薪资',
			minWidth : 100,
			sort : true
		}, {
			field : 'apply_staff_name',
			title : '发布者',
			minWidth : 100,
			 
			sort : true
		}, {
			field : 'check_state',
			title : '状态',
			minWidth : 100,
			templet: '#stateTpl',
			sort : true
		}, {
			field : 'check_staff_name',
			title : '审核人',
			minWidth : 100,
			sort : true
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 130,
			fixed: 'right'
		} ] ],
		page : true
	});
	

	
	// 获取部门信息
	$.ajax({
		url : "positionManage/getAllPositionIdName",
		type : "get",
		success : function(data) {
			var jsonData=JSON.parse(data);
			var op="<option value=''>请选择职位</option>";
			for(var x in jsonData.data){
				op+="<option value='"+jsonData.data[x].position_id+"'>"+jsonData.data[x].position_name+"</option>";
			}
			$("#position_sel").html(op);
			form.render("select");
		}
	});
	
	
	// 多文件列表示例
	  var demoListView = $('#fileList')
	  ,uploadListIns = upload.render({
	    elem: '#choiceFile'
	    ,url: 'file/upload'
	    ,accept: 'file'
	    ,multiple: true
	    ,auto: false
	    ,before: function(obj){ // obj参数包含的信息，跟 choose回调完全一致，可参见上文。
	        layer.load(); // 上传loading
	        this.data={'id':applyId};
	      }
	    ,choose: function(obj){   
	      var files = this.files = obj.pushFile(); // 将每次选择的文件追加到文件队列
	      // 读取本地文件
	      obj.preview(function(index, file, result){
	        var tr = $(['<tr id="upload-'+ index +'">'
	          ,'<td>'+ file.name +'</td>'
	          ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
	          ,'<td>等待上传</td>'
	          ,'<td>'
	            ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide type="button"">重传</button>'
	            ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
	          ,'</td>'
	        ,'</tr>'].join(''));
	        
	        // 单个重传
	        tr.find('.demo-reload').on('click', function(){
	          obj.upload(index, file);
	        });
	        
	        // 删除
	        tr.find('.demo-delete').on('click', function(){
	          delete files[index]; // 删除对应的文件
	          tr.remove();
	          uploadListIns.config.elem.next()[0].value = ''; // 清空 input file
																// 值，以免删除后出现同名文件不可选
	        });
	        
	        demoListView.append(tr);
	      });
	    }
	    ,done: function(res, index, upload){
	      if(res.code == 100){ // 上传成功
	    	  layer.closeAll('loading'); // 关闭loading
	        var tr = demoListView.find('tr#upload-'+ index)
	        ,tds = tr.children();
	        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
	        tds.eq(3).html(''); // 清空操作
	        return delete this.files[index]; // 删除文件队列已经上传成功的文件
	       
	      }
	      this.error(index, upload);
	  
	    }
	    ,allDone: function(obj){ // 当文件全部被提交后，才触发
	        if (obj.total==obj.successful) {
	        	 layer.confirm('已完成', {
	 				icon : 1,
	 				title : '提示'
	 			}, function(index) {
	 				layer.close(index);
	 				window.location.href = window.location.href;
	 			});
			}
	      }
	    ,error: function(index, upload){
	      var tr = demoListView.find('tr#upload-'+ index)
	      ,tds = tr.children();
	      tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
	      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); // 显示重传
	      layer.closeAll('loading'); // 关闭loading
	    }
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
		
		$('#rel_rec_title').val("");
		$('#rel_rec_number').val("");
		$('#rel_rec_money').val("");
		$('#rel_rec_desc').val("");
		$("#position_sel").val("");
		
		$('#rel_rec_title').attr("disabled",false);
		$('#rel_rec_number').attr("disabled",false);
		$('#rel_rec_money').attr("disabled",false);
		$('#rel_rec_desc').attr("disabled",false);
		$('#position_sel').attr("disabled",false);
		$('#submit-button').show();
		$('#upload-div').show();
		$('#upload-table-div').hide();
		
		
		$('#add-change').html('添加');
		
		$('#add-post').parent().hide();
		$('#back').parent().show();
		if($("#table").css('display')=='block'){
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
		};
		form.render(); // 更新全部000
		
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
	filter.add("position_name");
	filter.add("rel_rec_title");
	filter.add("rel_rec_desc");
	filter.add("rel_rec_number");
	filter.add("rel_rec_money");
	filter.add("apply_staff_name");
	filter.add("check_state");
	filter.add("check_staff_name");
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
			url : 'recruitManage/getMyRecruitBySE?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end

	// 监听提交
	form.on('submit(addRec)', function(data) {
		var url = "";
		if (type == 1) {
			url = "recruitManage/update?"
					+ $("#rec-form").serialize() + "&rel_rec_id="
					+ opID;
		} else {
			url = "recruitManage/add?"
					+ $("#rec-form").serialize();
		}
		$.ajax({
			type : "post",
			url : url,
			async : true,
			success : function(data) {
				var jsonData = JSON.parse(data);
				
				if (jsonData.code == 100) {
					applyId=jsonData.id;
					uploadListIns.upload();
				} else if (jsonData.code == 101) {
					layer.msg('身份已过期，请重新登录', {
						icon : 2,
						time : 2500
					}, function() {
						window.location.href = "gotoLogin";
					});
				} else if (jsonData.code == 102) {
					layer.msg("权限不足");
				} else {
					layer.msg("未知错误");
				}
			},
			error : function(jqObj) {

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
						ids[x] = data[x].rel_rec_id;
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
					delAdds(data.rel_rec_id);
				}
			});
		} else if (obj.event === 'edit') {
			type = 1;// 查看与编辑
			opID = data.rel_rec_id;// 操作数据id
			itemState=data.check_state;
			if(itemState=='已通过'){
				$('#printer').show();
			}else{
				$('#printer').hide();
			}
			$('#rel_rec_title').attr("disabled",true);
			$('#rel_rec_number').attr("disabled",true);
			$('#rel_rec_money').attr("disabled",true);
			$('#rel_rec_desc').attr("disabled",true);
			$('#position_sel').attr("disabled",true);
			$('#submit-button').hide();
			$('#upload-div').hide();
			$('#upload-table-div').show();
			
			$('#rel_rec_title').val(data.rel_rec_title);
			$('#rel_rec_number').val(data.rel_rec_number);
			$('#rel_rec_money').val(data.rel_rec_money);
			$('#rel_rec_desc').val(data.rel_rec_desc);
			$("#position_sel").val(data.position_id);
			
			$('#apply_time').html(data.apply_time);
			$('#apply_staff_name').html(data.apply_staff_name);
			$('#check_time').html(data.check_time);
			$('#check_staff_name').html(data.check_staff_name);
			$("#check_state").html(data.check_state);
			$("#check_msg").html(data.check_msg);
			
			form.render(); // 更新全部000
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
			$('#add-post').parent().hide();
			$('#back').parent().show();
			
			fileTable=table.render({
				elem : '#upload-table',
				url : 'file/getFilesByParentId?id='+data.apply_id,
				title : '职位表',
				cols : [ [ {
					field : 'file_name',
					title : '文件名',
					minWidth:200,
					sort : true
				}, {
					title : '操作',
					toolbar : '#opreationBarUpload',
					width : 120
				} ] ]
			});
		}
	});
	
	// 监听行工具事件
	table.on('tool(upload-table)', function(obj) {
		var data = obj.data;
		var url=data.file_url;
		var name=data.file_name;
		if (obj.event === 'edit') {
			$.ajax({
				url : "file/verifyFile?path="+url,
				type : "get",
				success : function(data) {
					var jsonData=JSON.parse(data);
					if (jsonData.code==100) {
						 layer.open({
						      type: 2,
						      title: '查看文件',
						      shadeClose: true,
						      shade: false,
						      maxmin: true, // 开启最大化最小化按钮
						      area: ['893px', '600px'],
						      maxmin: true,
						      content: 'file/getFile?path='+url
						 });
					}else {
						layer.confirm('不支持浏览的文件是否下载？', function(index){
							  window.location.href="file/downLoadFile?path="+url+"&fileName="+name;
							  layer.close(index);
						});   
					}
				}
			});
			
		}else if (obj.event === 'download') {
			  window.location.href="file/downLoadFile?path="+url+"&fileName="+name;
		}
	});
	
	// 批量删除地址
	function delAdds(ids) {
		$.ajax({
			type : "post",
			url : "recruitManage/del?ids=" + ids,
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
		if (fileTable!='') {
			fileTable.reload();
		}
	};
	
	// 编辑职员基本信息
	$('#printer').on('click',function(){
		console.log(1);
		if(itemState=='已通过'){
			layer.open({
				  type: 2,
				  title: '打印凭条',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['90%', '80%'],
				  content: 'recruitManage/printer?rel_rec_id='+opID
				}); 
		}else{
			layer.msg("非法操作");
		}
	});
	
	form.render();
	
});
