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
			<h2 class="div-title">招聘管理</h2>
		</div>
		<div class="layui-card-body" style="margin-bottom: 20px;">
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
								
								<li><input type="checkbox" value="position_name"
									title="招聘职位" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rel_rec_title"
									title="招聘标题" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rel_rec_desc"
									title="招聘描述" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rel_rec_number"
									title="人数" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="rel_rec_money" title="薪资"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="apply_staff_name"
									title="发布者" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="check_state" title="状态"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="check_staff_name"
									title="审核人" lay-skin="primary" lay-filter='filter' checked></li>
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
						<form class="layui-form" id='rec-form'>
							<div class="layui-form-item">
								<label class="layui-form-label">标题</label>
								<div class="layui-input-block">
									<input type="text" name="rel_rec_title" id='rel_rec_title'
										required lay-verify="required" placeholder="请输入标题"
										autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">职位</label>
								<div class="layui-input-block">
									<select name="position_id" id="position_sel"
										lay-verify="required">
										<option value=""></option>

									</select>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label layui-form-label-inner">人数</label>
								<div class="layui-input-block">
									<input type="text" name="rel_rec_number" id='rel_rec_number'
										required lay-verify="required|number" placeholder="请输入人数"
										autocomplete="off" class="layui-input">
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label layui-form-label-inner">薪资</label>
								<div class="layui-input-block">
									<input type="text" name="rel_rec_money" id='rel_rec_money'
										required lay-verify="required|number" placeholder="请输入薪资"
										autocomplete="off" class="layui-input">
								</div>
							</div>

							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">详细</label>
								<div class="layui-input-block">
									<textarea name="rel_rec_desc" id='rel_rec_desc'
										placeholder="请输入内容" class="layui-textarea"></textarea>
								</div>
							</div>


							<div id='upload-table-div'>
								<table class="layui-table">
									<colgroup>
										<col>
										<col>
										<col>
										<col>
									</colgroup>
									<thead>
										<tr>
											<th>申请时间</th>
											<th>申请人</th>
											<th>审核时间</th>
											<th>审核人</th>
											<th>审核结果</th>
											<th>审核意见</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td id='apply_time'></td>
											<td id='apply_staff_name'></td>
											<td id='check_time'></td>
											<td id='check_staff_name'></td>
											<td id='check_state'></td>
											<td id='check_msg'></td>
										</tr>
									</tbody>
								</table>
								<table class="layui-hide" id="upload-table"
									lay-filter="upload-table"></table>
								<button id="printer" type="button" class="layui-btn layui-btn-primary">凭条</button>
							</div>

							<div class="layui-form-item layui-form-text" id="upload-div">
								<label class="layui-form-label">上传<br>附件
								</label>
								<div class="layui-input-block">
									<div class="layui-upload">
										<div class="layui-upload-list">
											<table class="layui-table">
												<thead>
													<tr>
														<th>文件名</th>
														<th>大小</th>
														<th>状态</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody id="fileList"></tbody>
											</table>
										</div>
										<button type="button" class="layui-btn" id="choiceFile">
											<i class="layui-icon"></i>选择附件
										</button>
									</div>

								</div>
							</div>

							<div class="layui-form-item my-form-item" id="submit-button">
								<div class="layui-btn-group">
									<button class="layui-btn my-button" lay-submit
										lay-filter="addRec" id="add-change">提交申请</button>
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

<script type="text/html" id="toolBar">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delChecked">删除所选</button>
  </div>
</script>

<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="opreationBarUpload">
  <a class="layui-btn layui-btn-xs" lay-event="edit" style="margin-top: 4px;">查看</a>
<a class="layui-btn layui-btn-xs" lay-event="download" style="margin-top: 4px;">下载</a>
</script>

<script type="text/javascript" src="res/js/admin/recruitManage.js"></script>
</html>