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
				<div class="layui-form" style="display: inline-block;">
					<div class="layui-form-item layui-form-text" style="margin-bottom: 0px;">
					<label class="layui-form-label">按部门浏览&nbsp;&nbsp;</label>
						<div class="layui-input-inline">
							<select name="department_id" id="department_id"  lay-filter="department_id"
								lay-verify="required" lay-search>
								<option value="">请选择</option>
							</select>
						</div>
					</div>
				</div>


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
								<li><input type="checkbox" value="staff_id" title="工号"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="staff_name" title="名称"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="position_name" title="职位"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="contract_name"
									title="合同名称" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="state" title="状态"
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

		</div>
	</div>
</div>
<script type="text/html" id="stateTpl">
  {{#  if(d.state === '使用中'){ }}
    <span style="color: #20c12e;">{{ d.state }}</span>
  {{#  } else if(d.state === '已过期') { }}
    <span style="color: #d82b2b;">{{ d.state }}</span>
  {{#  } }}
</script>
<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">合同变更</a>
</script>
<script type="text/javascript" src="res/js/admin/staffContractManage.js"></script>


</html>