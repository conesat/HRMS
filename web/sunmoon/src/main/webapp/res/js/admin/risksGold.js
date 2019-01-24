layui.use([ 'table', 'jquery', 'form', 'element' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var element = layui.element;

	// 获取五险一金
	$.ajax({
		url : "risksGold/getRisksGold",
		type : "get",
		success : function(data) {
			var jsonData = JSON.parse(data);
			$("#c1").val(jsonData.data.c1);
			$("#c2").val(jsonData.data.c2);
			$("#c3").val(jsonData.data.c3);
			$("#c4").val(jsonData.data.c4);
			$("#c5").val(jsonData.data.c5);
			$("#c6").val(jsonData.data.c6);

			$("#p1").val(jsonData.data.p1);
			$("#p2").val(jsonData.data.p2);
			$("#p3").val(jsonData.data.p3);
			$("#p4").val(jsonData.data.p4);
			$("#p5").val(jsonData.data.p5);
			$("#p6").val(jsonData.data.p6);

			count();
		}
	});

	$('.layui-table :input').bind(
			'input propertychange',
			function() {
				var point = false;
				if ($(this).val() == '') {
					$(this).val('0')
				}
				for (i = 0; i < $(this).val().length; i++) {
					if ($(this).val().charAt(i) == '.') {
						if (point) {
							console.log(1);
							layer.msg('非法数值');
							$(this).val(
									$(this).val().substring(0,
											$(this).val().length - 1));
							return;
						} else {
							point = true;
						}
					} else if (($(this).val().charAt(i) < "0" || $(this).val()
							.charAt(i) > "9")) {
						layer.msg('非法数值');
						console.log(2);
						$(this).val(
								$(this).val().substring(0,
										$(this).val().length - 1));
						return;
					}
				}
				count();
			})

	function count() {
		$("#c-all").html((
				parseFloat($("#c1").val()) + parseFloat($("#c2").val())
						+ parseFloat($("#c3").val())
						+ parseFloat($("#c4").val())
						+ parseFloat($("#c5").val())
						+ parseFloat($("#c6").val())).toFixed("2"));
		$("#p-all").html((
				parseFloat($("#p1").val()) + parseFloat($("#p2").val())
						+ parseFloat($("#p3").val())
						+ parseFloat($("#p4").val())
						+ parseFloat($("#p5").val())
						+ parseFloat($("#p6").val())).toFixed("2"));
	}

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
					url : "risksGold/updateRisksGold?"
							+ $("#risks-gold-setting").serialize(),
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
						} else {
							layer.msg('未知异常');
						}
					},
					error : function(jqObj) {
						layer.msg('连接失败');
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