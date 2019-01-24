<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">

<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
	<div class="layui-card">
		<div class="layui-card-header">
			<h2 class="div-title">日期打卡记录记录</h2>
		</div>
		<div class="layui-card-body">
			<div id='table'>
				<!-- 顶部工具栏 -->
				<div class="map-tools">
					<button class="layui-btn layui-btn-sm layui-btn-normal"
						id='choice-date'>
						<i class="layui-icon">&#xe637;</i> 选择日期 <span
							id='choice-date-show'>yyyy-MM-ss</span>
					</button>
					<div class="map-search">
						<div id="r-result">
							<input type="text" id="serach-address-key" size="18"
								placeholder="搜索" /><i id='search-i' class="layui-icon"
								style="color: #fff;">&#xe615;</i>
						</div>
						<div id="searchResultPanel"></div>
					</div>

					<div class="search-filter-main">
						<i id='filter' class="layui-icon">&#xe6b2;</i>
						<div id='filter-ul-div' class="filter-ul-div">
							<form class="layui-form">
								<ul id='filter-ul'>

									<li><input type="checkbox" value="work_address_name"
										title="地点名称" lay-skin="primary" lay-filter='filter' checked></li>
									<li><input type="checkbox" value="staff_name" title="姓名"
										lay-skin="primary" lay-filter='filter' checked></li>
									<li><input type="checkbox" value="staff_id" title="工号"
										lay-skin="primary" lay-filter='filter' checked></li>

									<hr>
									<li id='close-filter' style="cursor: pointer;"><i
										class="layui-icon">&#x1006;</i>关闭</li>
								</ul>
							</form>
						</div>
					</div>
				</div>
				<!-- 顶部工具栏 end-->
				<div id='staff-detailed-div'>
					<table class="layui-hide" id="staff-detailed"
						lay-filter="staff-detailed"></table>
				</div>
			</div>
		</div>


	</div>
</div>

<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
</script>


<script type="text/javascript" src="res/js/admin/checkRecordToday.js"></script>
</html>