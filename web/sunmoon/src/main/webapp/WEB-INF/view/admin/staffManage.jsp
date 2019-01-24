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
					<li class="layui-nav-item layui-nav-itemed" id="addStaff"
						onclick="changeBody('addStaff')"><a class=""
						href="javascript:;"><img alt="..."
							src="res/image/icon/add_staff.png" width="14" height="14">
							添加职员</a></li>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;" id="staffTableList"
						onclick="changeBody('staffTableList')"><img alt="..."
							src="res/image/icon/employee_list.png" width="14" height="14">
							职员列表</a></li>
					<li class="layui-nav-item layui-nav-itemed" id="transferStaff"
						onclick="changeBody('transferStaff')"><a class=""
						href="javascript:;"><img alt="..."
							src="res/image/icon/roster.png" width="14" height="14">
							调动申请</a></li>
					<li class="layui-nav-item layui-nav-itemed" id="roster"
						onclick="changeBody('roster')"><a class=""
						href="javascript:;"><img alt="..."
							src="res/image/icon/roster.png" width="14" height="14"> 花名册</a></li>

					<li class="layui-nav-item layui-nav-itemed" id="staffIdSetting"
						onclick="changeBody('staffIdSetting')"><a class=""
						href="javascript:;"><img alt="..."
							src="res/image/icon/basic_setup.png" width="14" height="14">
							工号设置</a></li>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;"><img alt="..."
							src="res/image/icon/contract_allocation.png" width="14"
							height="14"> 合同</a>
						<dl class="layui-nav-child">
							<dd id='staffContractManage'>
								<a href="javascript:;"
									onclick="changeBody('staffContractManage')"><img alt="..."
									src="res/image/icon/job_management.png" width="14" height="14">
									职员合同管理</a>
							</dd>
							<dd id='contractManage'>
								<a href="javascript:;" onclick="changeBody('contractManage')"><img
									alt="..." src="res/image/icon/basic_setup.png" width="14"
									height="14"> 合同配置</a>
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