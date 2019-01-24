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
			<h2 class="div-title">合同管理</h2>
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
								<li><input type="checkbox" value="contract_name" title="名称"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="contract_long" title="时长"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="contract_msg" title="描述"
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
									<label class="layui-form-label">合同名称</label>
									<div class="layui-input-block">
										<input type="text" id="contract_name" name="contract_name"
											required lay-verify="required" placeholder="请输入名称"
											autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">时长：天</label>
									<div class="layui-input-block">
										<input type="text" id="contract_long" name="contract_long"
											required lay-verify="required|number" placeholder="请输入天数"
											autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">合同描述</label>
									<div class="layui-input-block">
										<textarea id='contract_msg' name="contract_msg"
											placeholder="请输入内容" class="layui-textarea"></textarea>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">合同文件</label>
									<div class="layui-input-block">
										<div class="layui-upload-drag" id="contract">
											<i class="layui-icon"></i>
											<p>点击上传，或将文件拖拽到此处</p>
										</div>
										<button class="layui-btn" type="button" id="contract-show"
											style="display: none;">下载合同</button>

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
<script type="text/javascript" src="res/js/admin/contractManage.js"></script>


</html>