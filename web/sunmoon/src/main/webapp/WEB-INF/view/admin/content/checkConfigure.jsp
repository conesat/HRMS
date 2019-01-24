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
			<h2 class="div-title">打卡配置</h2>
		</div>
		<div class="layui-card-body">

			<!-- 顶部工具栏 -->
			<div class="map-tools" id="examine-search-div" style="display: flex;">

				<div class="search-filter-main">
					<i id='filter' class="layui-icon">&#xe6b2;</i>
					<div id='filter-ul-div' class="filter-ul-div">
						<form class="layui-form">
							<ul id='filter-ul'>
								<li><input type="checkbox" value="work_address_name"
									title="名称" lay-skin="primary" lay-filter='filter' checked></li>
								<hr>
								<li id='close-filter' style="cursor: pointer;"><i
									class="layui-icon">&#x1006;</i>关闭</li>
							</ul>
						</form>
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
			</div>
			<div class="map-tools" style="margin-bottom: 10px; display: none;">
				<button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
					<i class="layui-icon">&#xe65c;</i> 返回
				</button>
			</div>

			<div id='table'>
				<table class="layui-hide" id="post" lay-filter="post"></table>
			</div>

			<div id='add-post-content' style="display: none;">
				<div class="content-form">

					<form class="layui-form" action="" id="check-setting">


						<div
							class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
							<div class="layui-form-item">
								<label class="layui-form-label" id='work_address_name'></label>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">上午时间段</label>
								<div class="layui-input-inline">
									<input type="text" class="layui-input" id="morning-time"
										name="morning-time" readonly="readonly" placeholder=" - ">
								</div>
								<div class="layui-form-mid layui-word-aux">留空即为不上班</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">下午时间段</label>
								<div class="layui-input-inline">
									<input type="text" class="layui-input" id="afternoon-time"
										name="afternoon-time" readonly="readonly" placeholder=" - ">
								</div>
								<div class="layui-form-mid layui-word-aux">留空即为不上班</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">晚上时间段</label>
								<div class="layui-input-inline">
									<input type="text" class="layui-input" id="night-time"
										name="night-time" readonly="readonly" placeholder=" - ">
								</div>
								<div class="layui-form-mid layui-word-aux">留空即为不上班</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">范围签到</label>
								<div class="layui-input-block">
									<input type="checkbox" name="range_on" id="range_on"
										lay-skin="switch">
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">范围</label>
								<div class="layui-input-inline">
									<input type="text" name="range_value" id="range_value"
										placeholder="请输入距离" autocomplete="off" class="layui-input"
										lay-verify="range|number">
								</div>
								<div class="layui-form-mid layui-word-aux">单位：米</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">wifi签到</label>
								<div class="layui-input-block">
									<input type="checkbox" name="wifi_on" id="wifi_on"
										lay-skin="switch">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">地址</label>
								<div class="layui-input-inline">
									<input type="text" name="wifi_mac" id="wifi_mac"
										placeholder="请输入地址" autocomplete="off" class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux">WIFI的MAC地址</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">是否开启人脸</label>
								<div class="layui-input-block">
									<input type="checkbox" name="face" id="face" lay-skin="switch">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">是否开启指纹</label>
								<div class="layui-input-block">
									<input type="checkbox" name="finger" id="finger"
										lay-skin="switch">
								</div>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" id='check-submit' lay-submit
									lay-filter="check-submit">配置</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</div>

<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">配置/查看</a>
</script>


<script type="text/javascript" src="res/js/admin/checkConfigure.js"></script>
</html>