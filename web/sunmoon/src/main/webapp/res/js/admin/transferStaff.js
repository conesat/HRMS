layui.use([ 'jquery', 'form' ], function() {
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var transferType='in';

	// 获取部门
	$.ajax({
		url : "department/getAllOrgsHadAdmin",
		type : "get",
		success : function(data) {
			var jsonData = JSON.parse(data);
			var op = "<option value=''>请选择来源部门</option>";
			for ( var x in jsonData.data) {
				op += "<option value='" + jsonData.data[x].department_id + "'>"
						+ jsonData.data[x].department_name + "</option>";
			}
			$("#department_id").html(op);
			form.render("select");
		}
	});
	
	form.on('select(transfer-type)', function(data) {
		transferType=data.value;
		$("#staff_id").html("");
		if(transferType=='out'){
			$.ajax({
				url : "staffManage/getDepartmentStaff",
				type : "get",
				success : function(data) {
					var jsonData = JSON.parse(data);
					var op = "<option value=''>请选择需要调入的人员</option>";
					for ( var x in jsonData.data) {
						op += "<option value='" + jsonData.data[x].staff_id + "'>"
								+ jsonData.data[x].staff_name + "</option>";
					}
					$("#staff_id").html(op);
					form.render("select");
				}
			});
		}else{
			$.ajax({
				url : "staffManage/getDepartmentStaff?depid="+$("#department_id").val(),
				type : "get",
				success : function(data) {
					var jsonData = JSON.parse(data);
					var op = "<option value=''>请选择需要调入的人员</option>";
					for ( var x in jsonData.data) {
						op += "<option value='" + jsonData.data[x].staff_id + "'>"
								+ jsonData.data[x].staff_name + "</option>";
					}
					$("#staff_id").html(op);
					form.render("select");
				}
			});
		}
	});

	form.on('select(department_id)', function(data) {
		console.log(1)
		if(transferType=='in'){
			$("#staff_id").html("");
			$.ajax({
				url : "staffManage/getDepartmentStaff?depid="+data.value,
				type : "get",
				success : function(data) {
					var jsonData = JSON.parse(data);
					var op = "<option value=''>请选择需要调入的人员</option>";
					for ( var x in jsonData.data) {
						op += "<option value='" + jsonData.data[x].staff_id + "'>"
								+ jsonData.data[x].staff_name + "</option>";
					}
					$("#staff_id").html(op);
					form.render("select");
				}
			});
		}
	});

	// 监听提交
	form.on('submit(submit)', function(data) {
		$.ajax({
			type : "post",
			url : "staffManage/transferAdminStaff?"
					+ $("#adminTransfer").serialize()+"&staff_name="+$("#staff_id").find("option:selected").text(),
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
					layer.confirm('身份已过期，请重新登录', {
						icon : 2,
						title : '提示'
					}, function(index) {
						layer.close(index);
						window.location.href = "gotoLogin";
					});
				} else if (jsonData.code == 102) {
					layer.msg("访问受限,权限不足");
				} else {
					layer.msg("未知错误");
				}
			},
			error : function(jqObj) {

			}
		});
		return false;
	});

	// 重载表格 防止拉伸
	window.reloadTable = function() {
		/*
		 * postTable.reload(); if (fileTable!='') { fileTable.reload(); }
		 */

	};
	form.render("select");
	form.render();

});