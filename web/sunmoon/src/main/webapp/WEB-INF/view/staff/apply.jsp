<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>日&月股份有限公司</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="res/css/my.css">
<link rel="stylesheet" href="res/css/index.css">
<link rel="stylesheet" href="res/css/apply.css">
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">
<style>
.back {
	width: 800px;
	height: 400px;
	margin: 0 auto;
	background-color: #ffffff;
}

.backfather {
	width: 100%;
	height: 1000px;
	margin: 0 auto;
	background-color: grey;
	display: flex;
	magrin-top: 100px;
}
</style>

</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/staff/header.jsp"%>

		<div class="layui-body" id='body-div'>
			<form class="layui-form" action="" lay-filter="example">

				<div class="backfather">

					<div class="back">

						<div class="layui-form-item">
							<br>
							<br>
							<br>
							<br> <label class="layui-form-label">用户名</label>
							<div class="layui-input-block">
								<input name="username" class="layui-input" type="text"
									placeholder="请输入用户名" autocomplete="off" lay-verify="title">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">选择框</label>
							<div class="layui-input-block">
								<select name="interest" lay-filter="aihao">
									<option value=""></option>
									<option value="0">请假</option>
									<option value="1">出差</option>
									<option value="2">调动</option>
									<option value="3">报销</option>
									<option value="4">项目</option>
								</select>
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">具体描述</label>
							<div class="layui-input-block">
								<textarea name="desc" class="layui-textarea" placeholder="请输入内容"></textarea>
							</div>
						</div>


						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
							</div>
						</div>
					</div>
				</div>

			</form>
		</div>
	</div>

	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script>
		layui
				.use(
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

							//日期
							laydate.render({
								elem : '#date'
							});
							laydate.render({
								elem : '#date1'
							});

							//创建一个编辑器
							var editIndex = layedit.build('LAY_demo_editor');

							//自定义验证规则
							form.verify({
								title : function(value) {
									if (value.length < 5) {
										return '标题至少得5个字符啊';
									}
								},
								pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
								content : function(value) {
									layedit.sync(editIndex);
								}
							});

							//监听提交
							form.on('submit(demo1)', function(data) {
								layer.alert(JSON.stringify(data.field), {
									title : '最终的提交信息'
								})
								return false;
							});

							//表单初始赋值
							form.val('example', {
								"username" : "贤心" // "name": "value"
								,
								"password" : "123456",
								"interest" : 1,
								"like[write]" : true //复选框选中状态
								,
								"close" : true //开关状态
								,
								"sex" : "女",
								"desc" : "我爱 layui"
							})

						});
	</script>

</body>
</html>