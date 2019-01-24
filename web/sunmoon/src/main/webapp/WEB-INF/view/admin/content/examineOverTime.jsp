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
			<h2 class="div-title">加班申请</h2>
		</div>
		<div class="layui-card-body">

			<!-- 顶部工具栏 -->
			<div class="map-tools" id="examine-search-div" >
				

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
								<li><input type="checkbox" value="rel_rec_id" title="招聘ID"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="position_name"
									title="申请人" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rel_rec_title"
									title="申请类别" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="check_state" title="状态"
									lay-skin="primary" lay-filter='filter' checked></li>
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
				<table class="layui-hide" id="post" lay-filter="post"></table>
			</div>

			<div id='add-post-content' style="display: none;">
				<div class="content-form">
					<fieldset class="layui-elem-field layui-field-title"
						style="margin: 0px;">
						<legend>申请信息</legend>
					</fieldset>
					<table class="layui-table">
						<colgroup>
							<col>
							<col>
							<col>
							<col>
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>申请人</th>
								<th>申请人职工号</th>
								<th>状态</th>
							</tr>
							<tr style="background-color: #ffffff">
								<td id='apply_staff_name'></td>
								<td id='apply_staff_id'></td>
								<td id='check_state' rowspan="3"></td>
							</tr>

							<tr>
								<th>所属部门</th>
								<th>现任岗位</th>
							</tr>
							<tr style="background-color: #ffffff">
								<td id='overtime_post'></td>
								<td id='overtime_department'></td>
							</tr>
							<tr>
								<th>加班开始日期</th>
								<th>加班结束日期</th>
								<th>总时长</th>
							</tr>
							<tr style="background-color: #ffffff">
								<td id='overtime_start_time'></td>
								<td id='overtime_end_time'></td>
								<td id='overtime_duration'></td>
							</tr>
						</tbody>
					</table>

					<!-- 			<div style="padding:10px;" id="leave_msg"></div> -->
					<table class="layui-hide" id="upload-table"
						lay-filter="upload-table"></table>
					<fieldset class="layui-elem-field layui-field-title"
						style="margin-bottom: 0px;">
						<legend>加班事由</legend>
					</fieldset>
					<table class="layui-table">
						<colgroup>
							<col>
							<col>
							<col>
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>审核人</th>
								<th>审核时间</th>


							</tr>
						</thead>
						<tbody>
							<tr>
								<td id='check_staff_name'></td>
								<td id='check_time'></td>


							</tr>
						</tbody>
					</table>
					<fieldset class="layui-elem-field layui-field-title"
						style="margin-bottom: 0px;">
						<legend>审核意见</legend>
					</fieldset>
					<table class="layui-table">
						<thead>
							<tr style="background-color: #ffffff">
								<td id="check_msg"></td>
							</tr>
						</thead>
					</table>
					<div id="check-form-div">
						<fieldset class="layui-elem-field layui-field-title"
							style="margin-top: 30px; margin-bottom: 10px;">
							<legend>提交审核</legend>
						</fieldset>
						<form class="layui-form" id='apply-form'>
							<div class="layui-form-item">
								<label class="layui-form-label">结果</label>
								<div class="layui-input-block">
									<select name="check_state" id="position_sel"
										lay-verify="required">
										<option value="已通过">通过</option>
										<option value="不通过">不通过</option>
									</select>
								</div>
							</div>


							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">反馈</label>
								<div class="layui-input-block">
									<textarea name="check_msg" id='rel_rec_desc'
										lay-verify="required" placeholder="请输入内容"
										class="layui-textarea"></textarea>
								</div>
							</div>
							<div class="layui-form-item my-form-item" id="submit-button">
								<div class="layui-btn-group">
									<button class="layui-btn my-button" lay-submit
										lay-filter="check-apply" id="add-change">提交</button>
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
<script type="text/html" id="stateTpl">
  {{#  if(d.check_state === '待审核'){ }}
    <span style="color: #b5b21e;">{{ d.check_state }}</span>
  {{#  } else if(d.check_state === '不通过') { }}
    <span style="color: #d82b2b;">{{ d.check_state }}</span>
 {{#  } else if(d.check_state === '已通过') { }}
    <span style="color: #20c12e;">{{ d.check_state }}</span>
  {{#  } }}
</script>

<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">审核/查看</a>
</script>


<script type="text/javascript" src="res/js/admin/examineOverTime.js"></script>
</html>