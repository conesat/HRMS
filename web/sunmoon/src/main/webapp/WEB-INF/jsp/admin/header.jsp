<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 隐藏的取值内容 -->
<a id='headerUrl' style="display: none; height: 0px; width: 0px;">${url}</a>
<a style="display: none" id='con'>${con}</a>
<!-- 隐藏的取值内容 -->
<div class="layui-header">
	<div class="layui-logo">
		<div class="logo-icon">
			<img src='res/image/sun.png' />
		</div>
		<div class="cmpany-name" id='menue' style="flex: 1">日&月股份</div>
		<i id='menue-i' class="layui-icon layui-icon-shrink-right"
			style="width: 40px;"></i>


	</div>

	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left nav-max" id='header-max'>

		<li class="layui-nav-item "><a href="gotoJsp?jsp=admin/index"
			id="admin-index">首页</a></li>
		<li class="layui-nav-item"><a
			href="gotoJsp?jsp=admin/orgplan&con=addressManage" id="admin-orgplan">组织规划</a></li>
		<li class="layui-nav-item"><a
			href="gotoJsp?jsp=admin/staffManage&con=addStaff"
			id="admin-staffManage">员工管理</a></li>
		<li class="layui-nav-item"><a
			href="gotoJsp?jsp=admin/checkManage&con=checkConfigure"
			id="admin-checkManage">考勤管理</a></li>
		<li class="layui-nav-item"><a
			href="gotoJsp?jsp=admin/performanceEva&con=performanceEvaNew" id="admin-performanceEva">绩效评估</a></li>
		<li class="layui-nav-item"><a href="javascript:;">更多</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="gotoJsp?jsp=admin/recConfiguration&con=recruitManage"
						id="admin-recConfiguration">招聘配置</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/statStatement&con=staffCharts" id="admin-statStatement">统计报表</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/salaryManage&con=salaryBase" id="admin-salaryManage">薪酬管理</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/trainingDevelopment"
						id="admin-trainingDevelopment">培训开发</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/examineCentrality&con=examineRrcruit"
						id="admin-examineCentrality">审批中心</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/companyAccount&con=companyProfile"
						id="admin-companyAccount">公司账户</a>
				</dd>
			</dl></li>
	</ul>

	<ul class="layui-nav layui-layout-left nav-mid" id='header-mid'>
		<li class="layui-nav-item"><a href="gotoJsp?jsp=admin/index"
			id="admin-index-mini">首页</a></li>
		<li class="layui-nav-item"><a href="javascript:;">功能</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="gotoJsp?jsp=admin/orgplan&con=addressManage"
						id="admin-orgplan-mini">组织规划</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/staffManage&con=addStaff"
						id="admin-staffManage-mini">员工管理</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/checkManage&con=checkConfigure"
						id="admin-checkManage-mini">考勤管理</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/performanceEva&con=performanceEvaNew"
						id="admin-performanceEva-mini">绩效评估</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/recConfiguration&con=recruitManage"
						id="admin-recConfiguration-mini">招聘配置</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/statStatement&con=staffCharts"
						id="admin-statStatement-mini">统计报表</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/salaryManage&con=salaryBase"
						id="admin-salaryManage-mini">薪酬管理</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/trainingDevelopment"
						id="admin-trainingDevelopment-mini">培训开发</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/examineCentrality&con=examineRrcruit"
						id="admin-examineCentrality">审批中心</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=admin/companyAccount&con=companyProfile"
						id="admin-companyAccount-mini">公司账户</a>
				</dd>
			</dl></li>
	</ul>


	<ul class="layui-nav layui-layout-right">
		<li class="layui-nav-item"><div id='search-div'
				class="min-search">
				<input onblur="searchFocusOver()" onclick="searchFocus()" id='serach-key'
					placeholder="查找内容" /> <img src="res/image/search.png">
			</div></li>
		<li class="layui-nav-item" style="margin-left: 10px;"><a
			id='show-my' href="javascript:;"> ${staff.staff_name} &nbsp; <i
				class="layui-icon" style="font-weight: bold;">&#xe66f;</i>
		</a></li>
	</ul>
</div>
<script type="text/html" id="my-content" >
<div style="width: 100%;padding-top: 20px;text-align: center;">
    <div  style="border: 1px solid #eee; background-image: url('file/getFile?path=${staff.staff_person_picture}'); border-radius: 100px; width: 100px;height: 100px;display: flex;margin: 0 auto; background-size: cover;background-repeat: no-repeat;background-position: center;">
    </div>
    <div style="margin: 10px;"> ${staff.staff_name} -  ${staff.position_name}<br>部门：${staff.department_name}</div>
	<div id='time' style="margin: 20px;font-size: 40px;color: #79797;">时间</div>
	<a href="loginOut" class="layui-btn layui-btn-primary">注销</a>
	<a onclick="changePass()" class="layui-btn layui-btn-primary">修改密码</a>
</div>
</script>
