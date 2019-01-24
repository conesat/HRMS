<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="res/css/eleTree.css" media="all">
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
	<div class="layui-card">
		<div class="layui-card-header">
			<h2 class="div-title">职位基本薪资</h2>
		</div>
		<div class="layui-card-body">
			<!-- 顶部工具栏 -->
			<div class="map-tools">
				<button class="layui-btn layui-btn-sm layui-btn-normal"
					id='setting-salary-base'>
					<i class="layui-icon">&#xe614;</i> 设置基本工资
				</button>
				<button class="layui-btn layui-btn-sm layui-btn-normal" style="background: #fff;color: #333;"
					id='salary-now'>
					 当前基本工资
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
								
								<li><input type="checkbox" value="position_name"
									title="职位名称" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="position_msg"
									title="职位描述" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="post_id" title="职务ID"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="post_name" title="职务名称"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rank_level" title="职级"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="salaryBase" title="基本工资"
									lay-skin="primary" lay-filter='filter' checked></li>
								<hr>
								<li id='close-filter' style="cursor: pointer;"><i
									class="layui-icon">&#x1006;</i>关闭</li>
							</ul>
						</form>
					</div>
				</div>
			</div>


			<div id='table'>
				<table class="layui-hide" id="post" lay-filter="post"></table>
			</div>

		</div>
	</div>


</div>
<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="set">设置岗位工资</a>
</script>
<script type="text/javascript" src="res/js/admin/salaryBase.js"></script>


</html>