<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="res/css/admin/scheduling.css">
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
	<div class="layui-card">
		<div class="layui-card-header">
			<h2 class="div-title">排班</h2>
		</div>
		<div class="layui-card-body" style="display: flex; margin: 10px;">
			<div style="width: 100%;">
				<div
					class="layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<form class="layui-form" action="" id='check-setting'>
						<div id="date"></div>
						<div>请选择不上班的日期</div>
						<div class="layui-form-item" style="margin-top: 20px;">
							<div class="layui-input-block" >
								<button class="layui-btn" lay-submit id="check-month-submit"
									lay-filter="check-month-submit">提交排班</button>
								<button id="reset" type="button"
									class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>

				<div
					class="layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6"
					style="height: 300px; padding-left: 5px; padding-right: 5px; display: flex; flex-direction: column;">
					<div class="map-search" style="margin-bottom: 5px;">
						<div id="r-result" style="display: flex; flex-direction: row;">
							<input style="flex: 1" type="text" id="serach-address-key" maxlength="8"
								size="18" placeholder="搜索" /><i id='search-i'
								class="layui-icon" style="color: #fff;line-height: 30px;">&#xe615;</i>
						</div>
					</div>
					<table class="layui-hide" id="schedule" lay-filter="post"></table>
				</div>
			</div>

		</div>
	</div>
</div>
<script type="text/html" id="opreationBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
<script type="text/javascript" src="res/js/admin/scheduling.js"></script>
</html>