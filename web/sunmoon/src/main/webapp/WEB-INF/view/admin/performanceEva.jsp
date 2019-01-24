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
						href="javascript:;"><img alt="..." src="res/image/icon/performance_evaluation.png" width="14" height="14">  绩效评估</a>
						<dl class="layui-nav-child">
							<dd id='performanceEvaNew'> 
								<a href="javascript:;" onclick="changeBody('performanceEvaNew')"><img alt="..." src="res/image/icon/basic_setup.png" width="14" height="14">  评估绩效</a>
							</dd>
							<dd id="performanceEvaHistory">
								<a href="javascript:;" onclick="changeBody('performanceEvaHistory')"><img alt="..." src="res/image/icon/jobmanagement.png" width="14" height="14">  历史绩效</a>
							</dd>
						</dl></li>
					
				</ul>
			</div>
		</div>

		<div class="layui-body" id='body-div'  style="padding: 15px;">
			<!-- 内容主体区域 -->
		</div>

	</div>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script src="res/js/admin/content.js"></script>
</body>
</html>