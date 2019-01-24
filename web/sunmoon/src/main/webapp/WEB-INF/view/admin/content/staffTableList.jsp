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
			<h2 class="div-title">职员列表</h2>
		</div>
		<div class="layui-card-body">
			<!-- 顶部工具栏 -->
			<div class="map-tools" id="examine-search-div">
				<div class="layui-form" style="display: inline-block;">
					<div class="layui-form-item layui-form-text"
						style="margin-bottom: 0px;">
						<label class="layui-form-label">按部门浏览&nbsp;&nbsp;</label>
						<div class="layui-input-inline">
							<select name="department_id" id="department_id"
								lay-filter="department_id" lay-verify="required" lay-search>
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
								<li><input type="checkbox" value="staff_name" title="名字"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="work_address_name"
									title="上班地点" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="position_name" title="职位"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="staff_phone" title="电话"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="staff_state" title="状态"
									lay-skin="primary" lay-filter='filter' checked>
									<hr>
								<li id='close-filter' style="cursor: pointer;"><i
									class="layui-icon">&#x1006;</i>关闭</li>
							</ul>
						</form>
					</div>
				</div>


			</div>
			<div class="map-tools" style="margin-bottom: 10px; display: none;">
				<button class="layui-btn layui-btn-sm layui-btn-normal" id='back'>
					<i class="layui-icon">&#xe65c;</i> 返回
				</button>
			</div>

			<div id='table'>
				<table class="layui-hide" id="myTable" lay-filter="myTable"></table>
			</div>

			<div id='add-post-content' style="display: none;">
				<div class="content-form">
					<fieldset class="layui-elem-field layui-field-title"
						style="margin: 0px;">
						<legend>基本信息</legend>
					</fieldset>
					<div style="display: flex;">
						<div style="flex: 1">
							<table class="layui-table">
								<colgroup>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
								</colgroup>
								<thead>
									<tr>
										<th>工号</th>
										<th>姓名</th>
										<th>性别</th>
										<th>证件类型</th>
										<th>证件号</th>
										<th>生日</th>
										<th>学历</th>
										<th>住址</th>
										<th>婚否</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td id='staff_id'></td>
										<td id='staff_name'></td>
										<td id='staff_sex'></td>
										<td id='staff_certificates_type'></td>
										<td id='staff_certificates_number'></td>
										<td id='staff_birthday'></td>
										<td id='staff_education'></td>
										<td id='staff_address'></td>
										<td id='staff_marriage'></td>
									</tr>
								</tbody>
							</table>
							<table class="layui-table">
								<colgroup>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
									<col>
								</colgroup>
								<thead>
									<tr>
										<th>邮箱</th>
										<th>手机号</th>
										<th>部门</th>
										<th>职位</th>
										<th>工作地点</th>
										<th>入职日期</th>
										<th>职员类型</th>
										<th>状态</th>
										<th>备注</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td id='staff_email'></td>
										<td id='staff_phone'></td>
										<td id='department_name'></td>
										<td id='position_name'></td>
										<td id='work_address_name'></td>
										<td id='staff_in_date'></td>
										<td id='staff_type'></td>
										<td id='staff_state'></td>
										<td id='staff_msg'></td>
									</tr>
								</tbody>
							</table>
						</div>

						<div
							style="padding-left: 25px; padding-right: 25px; cursor: pointer; padding-top: 50px; text-align: center;">
							<div id='change-staff-base'>
								<img alt="" src="res/image/icon/edit.png" width="30" height="30">
								<p>编辑</p>
							</div>

						</div>

					</div>


					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 20px;">
						<legend>证件照</legend>
					</fieldset>

					<div style="display: flex;">
						<div id="layer-photos-demo" class="layer-photos-demo"
							style="flex: 1"></div>
						<div id='changeImg'
							style="padding-left: 25px; padding-right: 25px; cursor: pointer; padding-top: 75px; text-align: center;">
							<div>
								<img alt="" src="res/image/icon/upload.png" width="30"
									height="30">
								<p>更新图片</p>
							</div>

						</div>
					</div>


					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 20px;">
						<legend>合同文件</legend>
					</fieldset>

					<table class="layui-hide" id="upload-table"
						lay-filter="upload-table"></table>
					<div class="layui-btn-group" id="layui-btn-group"
						style="width: 100%; text-align: center; padding-top: 20px;">
						<button class="layui-btn" id="regular">
							<i class="layui-icon">&#xe66f;</i>转正
						</button>
						<button class="layui-btn" id="transfer">
							<i class="layui-icon">&#xe674;</i>调动
						</button>
						<button class="layui-btn" id="change-staff-contract">
							<i class="layui-icon">&#xe63c;</i>合同变更/续签
						</button>
						<button class="layui-btn" id="reset-password">
							<i class="layui-icon">&#xe673;</i>重置密码
						</button>
						<button class="layui-btn" id='quit'>
							<i class="layui-icon">&#x1006;</i>离职
						</button>

					</div>
				</div>
			</div>
		</div>
	</div>



</div>
<script type="text/html" id="stateTpl">
  {{#  if(d.staff_state === '待入职'){ }}
    <span style="color: #b5b21e;">{{ d.staff_state }}</span>
  {{#  } else if(d.staff_state === '已离职') { }}
    <span style="color: #d82b2b;">{{ d.staff_state }}</span>
 {{#  } else if(d.staff_state === '在职') { }}
    <span style="color: #20c12e;">{{ d.staff_state }}</span>
  {{#  } }}
</script>

<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">管理/查看</a>
</script>

<script type="text/html" id="opreationBarContract">
  <a class="layui-btn layui-btn-xs" lay-event="edit" style="margin-top: 4px;">查看</a>
<a class="layui-btn layui-btn-xs" lay-event="download" style="margin-top: 4px;">下载</a>
</script>

<script type="text/javascript" src="res/js/admin/staffTableList.js"></script>
</html>