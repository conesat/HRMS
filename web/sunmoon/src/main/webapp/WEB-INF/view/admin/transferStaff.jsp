<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>登录</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<link rel="stylesheet" href="../res/css/my.css">

<link rel="stylesheet" href="../res/css/admin/departmentManage.css">
<link rel="stylesheet" href="../res/css/admin/addStaff.css">
<link rel="stylesheet" media="../screen and (min-width:1200px)"
	href="../res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="../res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="../res/css/min.css">
<link rel="stylesheet" href="../res/css/login.css">
</head>


<body class="layui-layout-body">

	<div class="layui-layout layui-layout-admin">


		<div class="layui-body" style="top: -30%;">
			<!-- 内容主体区域 -->

			<div
				class="content layui-col-xs12 layui-col-sm12 layui-col-md8 layui-col-lg6">

				<div class="layui-card">
					<div class="layui-card-header"
						style="background-color: #009688; color: #ffffff;">
						<h2>调动申请</h2>
					</div>
					<div class="layui-card-body">
						<form class="layui-form" id='adminTransfer'>
							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">调动方向</label>
									<div class="layui-input-block"
										style="border-radius: 5px; border: 1px solid #eee; color: #525252; line-height: 38px; padding-left: 10px;">
										${transfer.department_name} <a id='transfer_type'></a>
										${transfer.object_department_name}
									</div>
								</div>
							</div>
							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item">
									<label class="layui-form-label">目标职员</label>
									<div class="layui-input-block"
										style="border-radius: 5px; border: 1px solid #eee; color: #525252; line-height: 38px; padding-left: 10px;">
										${transfer.staff_name}</div>
								</div>
							</div>
							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item">
									<label class="layui-form-label">申请人工号</label>
									<div class="layui-input-block"
										style="border-radius: 5px; border: 1px solid #eee; color: #525252; line-height: 38px; padding-left: 10px;">
										${transfer.apply_staff_id}</div>
								</div>
							</div>
							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item">
									<label class="layui-form-label">申请人姓名</label>
									<div class="layui-input-block"
										style="border-radius: 5px; border: 1px solid #eee; color: #525252; line-height: 38px; padding-left: 10px;">
										${transfer.apply_staff_name}</div>
								</div>
							</div>
							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">原由 </label>
									<div class="layui-input-block">
										<textarea name="msg" id='staff_msg' disabled="disabled"
											lay-verify="required" class="layui-textarea">${transfer.msg}</textarea>
									</div>
								</div>
							</div>
							<div class="layui-form-item my-form-item" id="submit-button">
								<div class="layui-btn-group">
									<button type="button" class="layui-btn my-button"  onclick="sendOK('ok')">同意</button>
									<button type="button"  onclick="sendOK('no')"
										class="layui-btn layui-btn-primary">拒绝</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="../layui/layui.js"></script>
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script>
		//JavaScript代码区
		layui.use([ 'element', 'jquery', 'form', 'layer' ], function() {
			var element = layui.element;
			var $ = jQuery = layui.jquery;
			var form = layui.form;
			var layer = layui.layer;
			var type = '${transfer.transfer_type}';
			var state = '${transfer.state}';
			var id = '${transfer.id}';
			if (state != '待反馈') {
				$('#submit-button').html("已被处理");
			}
			if (type == 'in') {
				$('#transfer_type').html("<<----");
			} else if (type == 'out') {
				$('#transfer_type').html("---->>");
			}
			
			
			
			window.sendOK=function(ok){
				layer.prompt({
					formType : 1,
					value : '',
					title : '验证密码',
					maxlength : 20,
				}, function(value, index, elem) {
					layer.close(index);
					if (varifyPass(value)) {
						$.ajax({
							url : "transferStaffRes?id="+id+"&ok="+ok,
							type : "post",
							success : function(data) {
								var jsonData=JSON.parse(data);
								if (jsonData.code==100) {
									layer.msg('已提交', {
										icon : 1,
										time : 2500
									}, function() {
										window.location.reload();
									});
								}else {
									layer.msg('异常');  
								}
							}
						});
					}
				});
				
				
			}
			
			// 验证账号密码
			function varifyPass(pass) {
				var re = false;
				$.ajax({
					type : "post",
					url : "../verifyStaff?staff_password=" + pass,
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
		});
	</script>
</body>
</html>