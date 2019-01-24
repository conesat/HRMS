<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">

	<div class="layui-card">
		<div class="layui-card-header">
			<h2>调动申请</h2>
		</div>
		<div class="layui-card-body">
			<form class="layui-form" id='adminTransfer'>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">调动类型</label>
						<div class="layui-input-block">
							<select name="transfer_type" id="transfer-type" lay-filter="transfer-type">
								<option value="in">调入</option>
								<option value="out">调出</option>
							</select>
						</div>
					</div>
				</div>
				<hr>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">目标部门</label>
						<div class="layui-input-block">
							<select name="object_department_id" id="department_id" lay-filter="department_id"
								lay-verify="required" lay-search>
								<option value="">请选择</option>
							</select>
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item">
						<label class="layui-form-label">目标职员</label>
						<div class="layui-input-block">
							<select name="staff_id" id='staff_id' lay-search lay-verify="required">

							</select>
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">原由 </label>
						<div class="layui-input-block">
							<textarea name="msg" id='staff_msg' placeholder="请输入内容" lay-verify="required"
								class="layui-textarea"></textarea>
						</div>
					</div>
				</div>
				<div class="layui-form-item my-form-item" id="submit-button">
					<div class="layui-btn-group">
						<button class="layui-btn my-button" lay-submit lay-filter="submit"
							id="submit">提交申请</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="res/js/admin/transferStaff.js"></script>
</html>