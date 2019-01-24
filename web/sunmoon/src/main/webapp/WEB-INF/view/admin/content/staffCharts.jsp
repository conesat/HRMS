<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">

	<div class="layui-card" style="height: 100%;overflow: hidden;">
		<div class="layui-card-header">
			<h2>人员报表</h2>
		</div>
		<div class="layui-card-body" style="height: 100%; overflow-y: scroll;">
			<div
				class=" layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
				<div id="man_women" style="height: 300px;"></div>
			</div>
			<div
				class=" layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
				<div id="age" style="height: 300px;"></div>
			</div>
			<div
				class=" layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
				<div id="work-add" style="height: 300px;"></div>
			</div>
			<div
				class=" layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
				<div id="money-in" style="height: 300px;"></div>
			</div>
			<div
				class=" layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
				<div id="staff-state" style="height: 400px;margin-bottom: 100px;"></div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="res/js/echarts.common.min.js"></script>
<script type="text/javascript" src="res/js/admin/staffCharts.js"></script>
</html>