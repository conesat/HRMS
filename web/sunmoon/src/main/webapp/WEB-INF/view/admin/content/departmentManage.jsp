<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
<div class="layui-card">
  <div class="layui-card-header"><h2 class="div-title">部门管理</h2></div>
  <div class="layui-card-body">
     <!-- 顶部工具栏 -->
	<div class="map-tools">

		<button class="layui-btn layui-btn-sm layui-btn-normal"
			id='add-department' style="display:;">
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
						
						<li><input type="checkbox" value="department_name"
							title="部门名称" lay-skin="primary" lay-filter='filter' checked></li>
						<li><input type="checkbox" value="department_describe"
							title="部门描述" lay-skin="primary" lay-filter='filter' checked></li>
						<li><input type="checkbox" value="staff_name" title="主管名称"
							lay-skin="primary" lay-filter='filter' checked></li>
						<li><input type="checkbox" value="staff_id" title="主管工号"
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

		<!-- 顶部工具栏 end-->
		<table class="layui-hide" id="department" lay-filter="department"></table>


	</div>
	<div class="org-wrap">
		<h3>组织架构图</h3>
		<hr style="background: #fff; padding: 0; margin: 0; height: 2px;">
		<div class="org-wrap">
			<div class="orgWrap"></div>
		</div>
	</div>

	<div id='add-department-content'>


		<div class="content-form">
			<form class="layui-form" action="" id="add-department-form">
				<div class="layui-form-item">
					<label class="layui-form-label">名称</label>
					<div class="layui-input-block">
						<input type="text" id="department_name" name="department_name"
							required lay-verify="required" placeholder="请输入名称"
							autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">描述</label>
					<div class="layui-input-block">
						<textarea id='department_describe' name="department_describe"
							placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">父级 </label>
					<div class="layui-input-block">
						<input type="text" id="parent_id" name="parent_id"
							placeholder="请选择组织架构中节点" autocomplete="off" class="layui-input"
							style="display: none;"> <input type="text" required
							lay-verify="required" id="parent_id_show"
							placeholder="请选择组织架构中节点" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">主管</label>
					<div class="layui-input-block">
						<select name="staff_id" id='staff_id' lay-search>

						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" id='adddepartment-change' lay-submit
							lay-filter="addDepartment">添加</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
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
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript" src="res/js/admin/departmentManage.js"></script>
</html>