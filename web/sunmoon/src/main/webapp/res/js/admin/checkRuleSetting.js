layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var element = layui.element;
	
	// 获取部门
	$.ajax({
		url : "checkRule/getCheckRule",
		type : "get",
		success : function(data) {
			var jsonData=JSON.parse(data);
			$("#rule1").val(jsonData.data.rule1);
			$("#rule2").val(jsonData.data.rule2);
			$("#rule3").val(jsonData.data.rule3);
			$("#rule4").val(jsonData.data.rule4);
			$("#rule5").val(jsonData.data.rule5);
			$("#rule6").val(jsonData.data.rule6);
		}
	});
	
	// 监听提交
	form.on('submit(check-submit)', function(data) {
		layer.prompt({
			formType : 1,
			value : '',
			title : '验证密码',
			maxlength : 20,
		}, function(value, index, elem) {
			layer.close(index);
			if (varifyPass(value)) {
				$.ajax({
					type : "post",
					url : "checkRule/updateCheckRule?"+$("#check-setting").serialize(),
					async : true,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							layer.msg('已完成', {
								icon : 1,
								time : 2500
							}, function() {
								window.location.reload();
							});
						}else if (jsonData.code == 102) {
							layer.msg("访问受限,权限不足");
						}
					},
					error : function(jqObj) {

					}
				});
			}
		});
		return false;
	});

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
	};
});