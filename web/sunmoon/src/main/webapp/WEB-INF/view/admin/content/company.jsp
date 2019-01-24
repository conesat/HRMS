<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">

<style>
.layui-input {
	border-top: none;
	border-left: none;
	border-right: none;
}
</style>
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
	<div class="layui-card" style="height: 100%; overflow: hidden;">
		<div class="layui-card-header">
			<h2>公司概况设置</h2>
		</div>
		<div class="layui-card-body" style="height: 100%;">
			<form mothod="post" enctype="multipart/form-data" class="layui-form"
				id="updaate-company" action="">


				<div class="layui-form-item">
					<label class="layui-form-label">公司名称：</label>
					<div class="layui-input-block">
						<input type="text" name="company_name" id="company_name" required
							lay-verify="required" placeholder="请输入内容" autocomplete="off"
							class="layui-input">
					</div>

				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">公司电话：</label>
					<div class="layui-input-block">
						<input type="text" id="company_phone" name="company_phone"
							required lay-verify="required" placeholder="请输入内容"
							autocomplete="off" class="layui-input">
					</div>

				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">公司传真：</label>
					<div class="layui-input-block">
						<input type="text" name="company_fax" id="company_fax" required
							lay-verify="required" placeholder="请输入内容" autocomplete="off"
							class="layui-input">
					</div>

				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">公司官网：</label>
					<div class="layui-input-block">
						<input type="text" name="company_net" id="company_net" required
							lay-verify="required" placeholder="请输入内容" autocomplete="off"
							class="layui-input">
					</div>

				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">公司地址：</label>
					<div class="layui-input-block">
						<input type="text" name="company_address" id="company_address"
							required lay-verify="required" placeholder="请输入内容"
							autocomplete="off" class="layui-input">
					</div>

				</div>
				<div></div>


				<div class="layui-form-item layui-form-text">

					<label class="layui-form-label">公司概况：</label>
					<div class="layui-input-block">
						<textarea id="company_msg" name="company_msg" placeholder="请输入内容"
							class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="submit" class="layui-btn" lay-submit
							lay-filter="companyto">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>

<script>
	// img
	layui.use([ 'form', 'jquery' ], function() {
		var form = layui.form;
		var $ = jQuery = layui.jquery;

		//查询 已有信息并显示
		function getCompany() {

			$.ajax({
				type : "get",
				url : "company/getCompany",
				success : function(data) {
					var jsonData = JSON.parse(data);
					if (jsonData.code == 100) {

						$("#company_name").val(jsonData.data.company_name);
						$("#company_net").val(jsonData.data.company_net);
						$("#company_msg").val(jsonData.data.company_msg);
						$("#company_fax").val(jsonData.data.company_fax);
						$("#company_phone").val(jsonData.data.company_phone);
						$("#company_address")
								.val(jsonData.data.company_address);

					} else if (jsonData.code == 101) {
						layer.msg("数据库获取失败");
					} else {
						layer.msg("未知错误");
					}
				},

			});
		}

		//监听 提交按钮
		form.on('submit(companyto)', function() {
			$.ajax({
				type : "post",
				url : "company/updateCompany?"
						+ $("#updaate-company").serialize(),//表单数据
				success : function(data) {
					var jsonData = JSON.parse(data);
					if (jsonData.code == 100) {
						layer.confirm('已完成', {
							icon : 1,
							title : '提示'
						}, function(index) {
							layer.close(index);
							window.location.reload;
						});
					} else if (jsonData.code == 102) {
						layer.msg("获取失败");
					} else {
						layer.msg("未知错误");
					}
				},

			});
			return false;
		});

		getCompany();
	});
</script>
</html>