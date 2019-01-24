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
					<h2 class="div-title">发布公告</h2>
				</div>
				<div class="layui-card-body">
					<form class="layui-form" id='transfer-form'>

						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">

							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>通报部门</label>
								<div class="layui-input-block">
									<select name="notice_department_id" xm-select="selectId"
										lay-verify="required">
										<option value="">请选择</option>
									</select>
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label"><a style="color: red;">*
								</a>公告标题</label>
								<div class="layui-input-block">
									<input type="text" name="notice_title" id='notice_title'
										required lay-verify="required" placeholder="请输入"
										autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><a style="color: red;">*
								</a>公告内容 </label>
								<div class="layui-input-block">
									<textarea id='notice_msg' placeholder="请输入内容" class="layui-textarea"></textarea>
								</div>
							</div>
						</div>
						<div class="layui-form-item my-form-item" id="submit-button">
							<div class="layui-btn-group">
								<button class="layui-btn my-button" lay-submit
									lay-filter="transfer-staff" id="transfer-staff">发布</button>
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
		//全局定义一次, 加载formSelects
		layui.config({
			base : '../layui/lay/mymodules/' //此处路径请自行处理, 可以使用绝对路径
		}).extend({
			formSelects : 'formSelects-v4'
		});
		layui.use([ 'element', 'jquery', 'form', 'laydate', 'formSelects', 'layedit' ],
				function() {
					var element = layui.element;
					var $ = jQuery = layui.jquery;
					var form = layui.form;
					var layedit = layui.layedit;
					
					//自定义工具栏
					 var editor = layedit.build('notice_msg', {
					    tool: [  'strong' //加粗
					    	  ,'italic' //斜体
					    	  ,'underline' //下划线
					    	  ,'del' //删除线
					    	  
					    	  ,'|' //分割线
					    	  
					    	  ,'left' //左对齐
					    	  ,'center' //居中对齐
					    	  ,'right' //右对齐
					    	  ,'link' //超链接
					    	  ,'unlink' //清除链接
					    	  ]
					})
					// 获取部门
					$.ajax({
						url : "../department/getAllOrgs",
						type : "get",
						success : function(data) {
							var jsonData = JSON.parse(data);
							var ARR = new Array();
							var op = "<option value=''>请分配部门</option>";
							for ( var x in jsonData.data) {
								op += "<option value='"
										+ jsonData.data[x].department_id + "'>"
										+ jsonData.data[x].department_name
										+ "</option>";
								ARR[ARR.length] = {
									'name' : jsonData.data[x].department_name,
									'value' : jsonData.data[x].department_id
								};
							}
							$("#department_id").html(op);
							form.render("select");
							layui.formSelects.data('selectId', 'local', {
								arr : ARR
							});
						}
					});
		
					// 监听提交
					form.on('submit(transfer-staff)', function(data) {
						if(layedit.getContent(editor)==""){
							layer.msg("请输入公告内容");
							return false;
						}
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
									url : "addNotice?"
											+ $("#transfer-form").serialize()+"&notice_msg="+layedit.getContent(editor),
									async : false,
									success : function(data) {
										var jsonData = JSON.parse(data);
										if (jsonData.code == 100) {
											layer.confirm('已完成', {
												icon : 1,
												title : '提示'
											}, function(index) {
												layer.closeAll();
												var index = parent.layer
														.getFrameIndex(window.name); //先得到当前iframe层的索引
												parent.layer.close(index); //再执行关闭  
												parent.location.reload();
											});
										} else if (jsonData.code == 100) {
											layer.confirm('身份已过期', {
												icon : 2,
												title : '提示'
											}, function(index) {
												layer.closeAll();
												var index = parent.layer
														.getFrameIndex(window.name); //先得到当前iframe层的索引
												parent.layer.close(index); //再执行关闭  
												parent.location.href = "gotoLogin";
											});
										} else {
											layer.msg("未知错误");
										}
									},
									error : function(jqObj) {
										layer.msg("连接失败");
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