<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<a id='headerUrl' style="display: none; height: 0px; width: 0px;">${url}</a>
<div class="layui-header">
	<div class="layui-logo">
		<div class="logo-icon">
			<img src='res/image/sun.png' />
		</div>
		<div class="cmpany-name">日&月 股份</div>
	</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left nav-max">
		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/index"
			id="staff-index">首页</a></li>
		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/approval"
			id="staff-approval">我的审批结果</a></li>
		<li class="layui-nav-item"><a href="gotoJsp?jsp=staff/myPay"
			id="staff-myPay">我的薪资福利</a></li>
		<li class="layui-nav-item"><a
			href="gotoJsp?jsp=staff/myAttendance" id="staff-myAttendance">我的考勤</a></li>
		<li class="layui-nav-item"><a href="javascript:;"
			id="staff-apply">申请中心</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="gotoJsp?jsp=staff/leave" id="staff-leave">请假申请</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/evection" id="staff-evection">出差申请</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/staffTransfer" id="staff-staffTransfer">调动申请</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/overtime" id="staff-overtime">加班申请</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/expense" id="staff-expense">报销申请</a>
				</dd>
				<dd>
					<a href="gotoJsp?jsp=staff/staffQuit" id="staff-staffQuit">离职申请</a>
				</dd>
			</dl></li>

	</ul>

	<ul class="layui-nav layui-layout-left nav-mid">
		<li class="layui-nav-item"><a href="" id="staff-index-mini">首页</a></li>
		<li class="layui-nav-item"><a href="javascript:;" id="">功能</a>
			<dl class="layui-nav-child">
				<dd id="staff-apply-mini">
					<a href="">申请中心</a>
				</dd>
				<dd id="staff-approval-mini">
					<a href="gotoJsp?jsp=staff/approval">我的审批结果</a>
				</dd>
				<dd id="staff-myPay-mini">
					<a href="gotoJsp?jsp=staff/myPay">我的薪资福利</a>
				</dd>
				<dd id="staff-myAttendance-mini">
					<a href="gotoJsp?jsp=staff/leave">我的考勤</a>
				</dd>

				<dd id="staff-leave-mini">
					<a href="gotoJsp?jsp=staff/leave" >请假申请</a>
				</dd>
				<dd id="staff-evection-mini">
					<a href="gotoJsp?jsp=staff/evection" >出差申请</a>
				</dd>
				<dd id="staff-staffTransfer-mini">
					<a href="gotoJsp?jsp=staff/staffTransfer" >调动申请</a>
				</dd>
				<dd  id="staff-overtime-mini">
					<a href="gotoJsp?jsp=staff/overtime">加班申请</a>
				</dd>
				<dd id="staff-expense-mini">
					<a href="gotoJsp?jsp=staff/expense" >报销申请</a>
				</dd>
				<dd id="staff-staffQuit-mini">
					<a href="gotoJsp?jsp=staff/staffQuit" >离职申请</a>
				</dd>
			</dl></li>
	</ul>


	<ul class="layui-nav layui-layout-right">
		<li class="layui-nav-item"><div id='search-div'
				class="min-search">
				<input onblur="searchFocusOver()" onclick="searchFocus()"
					placeholder="搜索我的申请记录" /> <img src="res/image/search.png">
			</div></li>
		<li class="layui-nav-item" style="margin-left: 10px;"><a
			href="javascript:;"> <img src="res/image/sun.png"
				class="layui-nav-img"> ${staff.staff_name}
		</a>
			<dl class="layui-nav-child">
				<dd onclick="changePass()">
					<a href="javascript:;">修改密码</a>
				</dd>
				<dd>
					<hr>
					<a href="loginOut">注销</a>
				</dd>
			</dl></li>
	</ul>
</div>
