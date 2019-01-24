<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">

	<div class="layui-card">
		<div class="layui-card-header"><h2>工号设置</h2></div>
		<div class="layui-card-body">
			<blockquote class="layui-elem-quote" style="display: flex;">
				<button class="layui-btn layui-btn-normal" id="pre-show">点击预览</button>
				&nbsp;&nbsp;&nbsp;
				<h3 id='pre' style="line-height: 38px;"></h3>

			</blockquote>
			<form class="layui-form" id='staff-id-setting'>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md3 layui-col-lg3">
					<div class="layui-form-item">
						<label class="layui-form-label">工号前缀</label>
						<div class="layui-input-block">
							<input type="text" name="prefix" id='prefix' placeholder="请输入"
								autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md3 layui-col-lg3">
					<div class="layui-form-item">
						<label class="layui-form-label">工号中部</label>
						<div class="layui-input-block">
							<select name="middle" id="middle" lay-verify="required">
								<option value="0">自增数值</option>
								<option value="1">当前年份+自增数值</option>
							</select>
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md3 layui-col-lg3">
					<div class="layui-form-item">
						<label class="layui-form-label">工号后缀</label>
						<div class="layui-input-block">
							<input type="text" name="suffix" id='suffix' placeholder="请输入"
								autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md3 layui-col-lg3">
					<div class="layui-form-item">
						<label class="layui-form-label">分割符号</label>
						<div class="layui-input-block">
							<input type="text" name="separate" id='separate'
								placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md3 layui-col-lg3">
					<div class="layui-form-item">
						<label class="layui-form-label">初始密码</label>
						<div class="layui-input-block">
							<input type="text" name="password" id='password' lay-verify="required"
								placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md3 layui-col-lg3">
					<div class="layui-form-item">
						<label class="layui-form-label">自动工号</label>
						<div class="layui-input-block">
							<input type="checkbox" name="auto" id='auto' lay-skin="switch" >
						</div>
					</div>
				</div>
				<div class="layui-form-item my-form-item" id="submit-button">
					<div class="layui-btn-group">
						<button class="layui-btn my-button" lay-submit
							lay-filter="update" id="update">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>


			</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="res/js/admin/staffIdSetting.js"></script>
</html>