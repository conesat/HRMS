<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
	<div class="layui-card" >
		<div class="layui-card-header">
			<h2 class="div-title">上班地点管理</h2>
		</div>
		<div class="layui-card-body" >
			<div id='table'>
				<!-- 顶部工具栏 -->
				<div class="map-tools">
					<button class="layui-btn layui-btn-sm layui-btn-normal"
						id='add-address'>
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
									
									<li><input type="checkbox" value="work_address_name"
										title="地点名称" lay-skin="primary" lay-filter='filter' checked></li>

									<hr>
									<li id='close-filter' style="cursor: pointer;"><i
										class="layui-icon">&#x1006;</i>关闭</li>
								</ul>
							</form>
						</div>
					</div>
				</div>
				<!-- 顶部工具栏 end-->
				<table class="layui-hide" id="address" lay-filter="address" ></table>
			</div>
			<div id='addAddress-content'>
				<!-- 顶部工具栏 -->
				<div class="map-tools">
					<button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
						<i class="layui-icon">&#xe65c;</i> 返回
					</button>
					<div class="map-search">
						<div id="r-result">
							<input type="text" id="suggestId" size="18" placeholder="搜索地址 " /><i
								class="layui-icon" style="color: #fff;">&#xe615;</i>
						</div>
						<div id="searchResultPanel"></div>
					</div>
				</div>
				<!-- 顶部工具栏 end-->
				<div style="height: 500px;">
					<div id="allmap"></div>
				</div>
				
				<!-- 底部工具栏 -->
				<div class="map-footer">
					<form class="layui-form" id="add-address-form">
						<div class="layui-form-item">
							<label class="layui-form-label">名称</label>
							<div class="layui-input-block">
								<input type="text" id="name" name="work_address_name" required
									lay-verify="required" placeholder="请输入名称" autocomplete="off"
									class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">坐标</label>
							<div class="layui-input-block">
								<input type="text" name="work_address_xy" required
									lay-verify="required" readonly="readonly" id='xy'
									placeholder="请选择地图上的地点" autocomplete="off" class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" id='add-change' lay-submit
									lay-filter="addAddress">添加</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
				<!-- 底部工具栏 end-->
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

<script type="text/javascript" src="res/js/admin/addressManage.js"></script>
</html>