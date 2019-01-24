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
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">
<link href="res/image/icon.png" rel="shortcut icon" type="image/x-icon" />
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<%@ include file="../../jsp/admin/header.jsp"%>

		<div class="layui-side layui-bg-black" id='menue-div'>
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->

				<ul class="layui-nav layui-nav-tree" lay-filter="test" id='menue-ul'>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;"><img alt="..."
							src="res/image/icon/attendance_configuration.png" width="14"
							height="14"> 考勤配置</a>
						<dl class="layui-nav-child">
							<dd id="checkConfigure">
								<a href="javascript:;" onclick="changeBody('checkConfigure')"><img
									alt="..." src="res/image/icon/punch_the_clock.png" width="14"
									height="14"> 打卡配置</a>
							</dd>
							<dd id="checkRuleSetting">
								<a href="javascript:;" onclick="changeBody('checkRuleSetting')"><img
									alt="..." src="res/image/icon/punch_the_clock.png" width="14"
									height="14"> 规则配置</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;"><img alt="..."
							src="res/image/icon/attendance_management.png" width="14"
							height="14"> 考勤管理</a>
						<dl class="layui-nav-child">
							<dd id='checkRecordToday'>
								<a href="javascript:;" onclick="changeBody('checkRecordToday')"><img
									alt="..." src="res/image/icon/basic_setup.png" width="14"
									height="14"> 今日打卡记录</a>
							</dd>
							<dd id='checkRecord'>
								<a href="javascript:;" onclick="changeBody('checkRecord')"><img
									alt="..." src="res/image/icon/basic_setup.png" width="14"
									height="14"> 考勤记录</a>
							</dd>
							<dd id='scheduling'>
								<a href="javascript:;" onclick="changeBody('scheduling')"><img
									alt="..." src="res/image/icon/jobmanagement.png" width="14"
									height="14"> 排班</a>
							</dd>
						</dl></li>

				</ul>
			</div>
		</div>

		<div class="layui-body" style="padding: 15px;" id='body-div'>
			<!-- 内容主体区域 -->
		</div>


	</div>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script src="res/js/admin/content.js"></script>
</body>
</html>