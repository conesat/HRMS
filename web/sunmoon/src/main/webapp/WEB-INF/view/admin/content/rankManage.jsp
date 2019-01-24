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
			<h2 class="div-title">职级管理</h2>
		</div>
		<div class="layui-card-body">
			<!-- 顶部工具栏 -->
			<div class="map-tools">

				<button class="layui-btn layui-btn-sm layui-btn-normal"
					id='add-post' style="display:;">
					<i class="layui-icon">&#xe608;</i> 添加
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
								<li><input type="checkbox" value="rank_name" title="名称"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rank_level" title="等级"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rank_msg" title="描述"
									lay-skin="primary" lay-filter='filter' checked></li>
								<hr>
								<li id='close-filter' style="cursor: pointer;"><i
									class="layui-icon">&#x1006;</i>关闭</li>
							</ul>
						</form>
					</div>
				</div>
			</div>
			<div class="map-tools" style="display: none; margin-bottom: 10px;">
				<button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
					<i class="layui-icon">&#xe65c;</i> 返回
				</button>
			</div>


			<div id='table'>
				<table class="layui-hide" id="post" lay-filter="post"></table>
			</div>

			<div id='add-post-content' style="display: none;">
				<div class="content-form">
					<div>
						<form class="layui-form" action="" id="add-post-form">
							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item">
									<label class="layui-form-label">名称</label>
									<div class="layui-input-block">
										<input type="text" id="rank_name" name="rank_name" required
											lay-verify="required" placeholder="请输入名称" autocomplete="off"
											class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">等级</label>
									<div class="layui-input-block">
										<input type="text" id="rank_level" name="rank_level" required
											lay-verify="required|number" placeholder="请输入等级"
											autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">描述</label>
									<div class="layui-input-block">
										<textarea id='rank_msg' name="rank_msg" placeholder="请输入内容"
											class="layui-textarea"></textarea>
									</div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn" id='addpost-change' lay-submit
										lay-filter="addpost">添加</button>
									<button type="reset" class="layui-btn layui-btn-primary">重置</button>
								</div>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>


</div>
<script type="text/html" id="toolBar">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delChecked">删除所选</button>
  </div>
</script>

<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">查看/编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript" src="res/js/admin/rankManage.js"></script>


</html>