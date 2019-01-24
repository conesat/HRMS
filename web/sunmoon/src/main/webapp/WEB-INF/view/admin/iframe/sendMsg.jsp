<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>日&月股份有限公司</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<link rel="stylesheet" href="../res/css/my.css">
<link rel="stylesheet" href="../res/css/formSelects-v4.css">

</head>
<body class="layui-layout-body">


	<div class="layui-layout layui-layout-admin">

		<div class="layui-body" id='body-div'
			style="left: 0px; top: 0px; bottom: 0px; padding: 20px;"
			align="center">
			<div class="layui-card">
				<div class="layui-card-header">
					<h2 class="div-title">发送消息</h2>
				</div>
				<div class="layui-card-body">
					<form class="layui-form" id='transfer-form'>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>发送对象</label>
								<div class="layui-input-block">
								<input type="text" disabled="disabled" value="${staff_name}-工号：${staff_id}"class="layui-input">
									
								</div>
							</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>消息内容 </label>
								<div class="layui-input-block">
									<textarea id='msg_body' required lay-verify="required" placeholder="请输入内容" class="layui-textarea"></textarea>
								</div>
							</div>
						</div>
						<div class="layui-form-item my-form-item" id="submit-button">
							<div class="layui-btn-group">
								<button class="layui-btn my-button" lay-submit
									lay-filter="transfer-staff" id="transfer-staff">发送</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<script src="../layui/layui.js"></script>
	<script type="text/javascript">

		layui.use([ 'element', 'jquery', 'form'],function() {
			var element = layui.element;
			var $ = jQuery = layui.jquery;
			var form = layui.form;
			var staff_id='${staff_id}';

			// 监听提交
			form.on('submit(transfer-staff)', function(data) {
				 $.ajax({
					type : "post",
					url : "sendMsg?object_id="+staff_id+"&msg_body="+$('#msg_body').val(),
					async : false,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭  
							parent.layer.msg("已发送");
						}
					},
					error : function(jqObj) {
					}
				});
				return false;
			});
		
		});
	</script>
</body>

</html>