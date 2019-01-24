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
<link rel="stylesheet" href="res/css/admin/addressManage.css">
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
							height="14"> 搜索结果</a>
						<dl class="layui-nav-child">
							<dd >
								<a href="javascript:;" onclick="changeShow('')"><img
									alt="..." src="res/image/icon/punch_the_clock.png" width="14"
									height="14"> 全部</a>
							</dd>
							<dd >
								<a href="javascript:;" onclick="changeShow('staff-div')"><img
									alt="..." src="res/image/icon/add_staff.png" width="14"
									height="14"> 职员</a>
							</dd>
							<dd >
								<a href="javascript:;" onclick="changeShow('work-add-div')"><img
									alt="..." src="res/image/icon/address.png" width="14"
									height="14"> 工作地址</a>
							</dd>
							<dd >
								<a href="javascript:;" onclick="changeShow('department-div')"><img
									alt="..." src="res/image/icon/department_management.png" width="14"
									height="14"> 部门</a>
							</dd>
							<dd >
								<a href="javascript:;" onclick="changeShow('post-div')"><img
									alt="..." src="res/image/icon/job_management.png" width="14"
									height="14"> 职务</a>
							</dd>
							<dd >
								<a href="javascript:;" onclick="changeShow('position-div')"><img
									alt="..." src="res/image/icon/hierarchy_management.png" width="14"
									height="14"> 职位</a>
							</dd>
							<dd >
								<a href="javascript:;" onclick="changeShow('rank-div')"><img
									alt="..." src="res/image/icon/jobmanagement.png" width="14"
									height="14"> 职级</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body" style="padding: 15px;margin-bottom: 20px;" id='body-div'>
			<div
				class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12"
				style="margin: 0 auto;">
				<div class="layui-card">
					<div class="layui-card-header">
						<h2>搜索结果</h2>
					</div>
					<div class="layui-card-body">
						<div id='staff-div'>
							<blockquote class="layui-elem-quote">职员</blockquote>
							<table class="layui-hide" id="staff-table"
								lay-filter="staff-table"></table>
							<hr>
						</div>

						<div id='work-add-div'>
							<blockquote class="layui-elem-quote">工作地址</blockquote>
							<table class="layui-hide" id="work-add" lay-filter="work-add"></table>
							<hr>
						</div>
						
						<div id='department-div'>
							<blockquote class="layui-elem-quote">部门</blockquote>
							<table class="layui-hide" id="department" lay-filter="department"></table>
							<hr>
						</div>
						
						<div id='post-div'>
							<blockquote class="layui-elem-quote">职务</blockquote>
							<table class="layui-hide" id="post" lay-filter="post"></table>
							<hr>
						</div>
						
						<div id='position-div'>
							<blockquote class="layui-elem-quote">职位</blockquote>
							<table class="layui-hide" id="position" lay-filter="position"></table>
							<hr>
						</div>
						
						<div id='rank-div'>
							<blockquote class="layui-elem-quote">职级</blockquote>
							<table class="layui-hide" id="rank" lay-filter="rank"></table>
							<hr>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<a id='key' style="display: none;">${key}</a>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<script type="text/javascript" src="res/js/admin/search.js"></script>
	<script src="res/js/admin/content.js"></script>

</body>
</html>