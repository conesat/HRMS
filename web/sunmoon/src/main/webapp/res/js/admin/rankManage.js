layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	
	// 获取表格数据 getAddsBySE
	var postTable = table.render({
		elem : '#post',
		url : 'rankManage/getRanksBySE',
		toolbar : '#toolBar',
		title : '职位表',
		cols : [ [ {
			type : 'checkbox',
			fixed : 'left'
		}, {
			field : 'rank_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'rank_level',
			title : '等级',
			minWidth : 100
		}, {
			field : 'rank_msg',
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
		
		$('#rank_name').val("");
		$('#rank_level').val("");
		$('#addpost-change').html('添加');
		$("#rank_msg").val("");
		
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
	filter.add("rank_name");
	filter.add("rank_level");
	filter.add("rank_msg");
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
			url : 'rankManage/getRanksBySE?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end

	// 监听提交
	form.on('submit(addpost)', function(data) {
		var url = "";
		if (type == 1) {
			url = "rankManage/update?"
					+ $("#add-post-form").serialize() + "&rank_id="
					+ opID;
		} else {
			url = "rankManage/add?"
					+ $("#add-post-form").serialize();
		}
		console.log(type);
		$.ajax({
			type : "post",
			url : url,
			async : true,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == 100) {
					layer.confirm('已完成', {
						icon : 1,
						title : '提示'
					}, function(index) {
						layer.close(index);
						window.location.href = window.location.href;
					});
				} else if (jsonData.code == 101) {
					layer.msg('身份已过期，请重新登录', {
						icon : 2,
						time : 2500
					}, function() {
						window.location.href = "gotoLogin";
					});
				} else if (jsonData.code == 102) {
					layer.msg("访问受限，权限不足");
				} else if (jsonData.code == 103) {
					layer.confirm("等级-"+$('#rank_level').val()+" 已被使用", {
						icon : 3,
						title : '提示'
					}, function(index) {
						layer.close(index);
						
					});
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
			opID = data.rank_id;// 操作数据id
			$('#rank_name').val(data.rank_name);
			$('#rank_level').val(data.rank_level);
			$('#addpost-change').html('修改');
			$("#rank_msg").val(data.rank_msg);
			form.render(); // 更新全部000
			$("#table").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
			$('#add-post').parent().hide();
			$('#back').parent().show();
		}
	});
	
	// 批量删除地址
	function delAdds(ids) {
		$.ajax({
			type : "post",
			url : "rankManage/del?ids=" + ids,
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
					layer.msg("访问受限，权限不足");
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