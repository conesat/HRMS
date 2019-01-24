<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的薪资福利</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="res/css/my.css">
<link rel="stylesheet" href="res/css/index.css">
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
<body>
	<div class="layui-layout layui-layout-admin"> 
		<%@ include file="../../jsp/staff/header.jsp"%>

		<div class="layui-body" id='body-div' style="padding: 20px;">
				<table class="layui-hide" id="test" lay-filter="test">
				</table>
	     </div>
	</div>
	
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script src="res/js/admin/myPay.js"></script>

</body>
</html>