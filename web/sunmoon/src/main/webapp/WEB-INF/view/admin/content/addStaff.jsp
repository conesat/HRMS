<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addStaff.css">

<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12" >

	<div class="layui-card">
		<div class="layui-card-header">
			<h2 class="div-title">添加职员</h2>
		</div>
		<div class="layui-card-body">

			<form class="layui-form" id='add-form'>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item">
						<label class="layui-form-label"><a style="color: red;">*
						</a>姓名</label>
						<div class="layui-input-block">
							<input type="text" name="staff_name" id='staff_name' required
								lay-verify="required" placeholder="请输入" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item">
						<label class="layui-form-label"><a style="color: red;">*
						</a>性别</label>
						<div class="layui-input-block">
							<select name="staff_sex" id="staff_sex" lay-verify="required">
								<option value="">请选择</option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">    
						</a>证件类型 </label>
						<div class="layui-input-block">
							<select name="staff_certificates_type"
								id="staff_certificates_type" lay-verify="required">
								<option value="">请选择</option>
								<option value="身份证">身份证</option>
								<option value="护照">护照</option>
							</select>
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>证件号</label>
						<div class="layui-input-block">
							<input type="text" name="staff_certificates_number"
								id='staff_certificates_number' required
								lay-verify="required|identity" placeholder="请输入"
								autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">生日</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" id="staff_birthday"
								name="staff_birthday" placeholder="yyyy-MM-dd"
								readonly="readonly">
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">学历 </label>
						<div class="layui-input-block">
							<select name="staff_education" id="staff_education">
								<option value="">请选择</option>
								<option value="博士">博士</option>
								<option value="硕士">硕士</option>
								<option value="研究生">研究生</option>
								<option value="本科">本科</option>
								<option value="专科">专科</option>
								<option value="高中">高中</option>
								<option value="初中">初中</option>
								<option value="小学">小学</option>
								<option value="其他">其他</option>
							</select>
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">住址</label>
						<div class="layui-input-block">
							<input type="text" name="staff_address" id="staff_address"
								placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*</a>邮箱 </label>
						<div class="layui-input-block">
							<input type="text" name="staff_email" id="staff_email"  lay-verify="required|email"
								placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">婚否 </label>
						<div class="layui-input-block">
							<select name="staff_marriage"
								id="staff_marriage" >
								<option value="">请选择</option>
								<option value="已婚">已婚</option>
								<option value="未婚">未婚</option>
							</select>
						</div>
					</div>
				</div>
				
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>职员类型</label>
						<div class="layui-input-block">
							<select name="staff_type"
								id="staff_type" lay-verify="required">
								<option value="">请选择</option>
								<option value="正式员工">正式员工</option>
								<option value="非正式员工">非正式员工</option>
							</select>
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>手机号</label>
						<div class="layui-input-block">
							<input type="text" name="staff_phone" id="staff_phone" required
								lay-verify="required|phone" placeholder="请输入" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>部门 </label>
						<div class="layui-input-block">
							<select name="department_id" id="department_id"
								lay-verify="required" lay-search>
								<option value="">请选择</option>
							</select>
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>职位 </label>
						<div class="layui-input-block">
							<select name="position_id" id="position_id" lay-verify="required">
								<option value="">请选择</option>
							</select>
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>工作地点 </label>
						<div class="layui-input-block">
							<select name="work_address_id" id="work_address_id"
								lay-verify="required">
								<option value="">请选择</option>
							</select>
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>入职日期</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" id="staff_in_date" lay-verify="staff_state"
								name="staff_in_date" placeholder="yyyy-MM-dd"
								readonly="readonly">
						</div>
					</div>
				</div>

				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
					<div class="layui-form-item">
						<label class="layui-form-label"><a style="color: red;">*
						</a>状态</label>
						<div class="layui-input-block">
							<select name="staff_state" id="staff_state" lay-verify="required|staff_state">
								<option value="">请选择</option>
								<option value="待入职">待入职</option>
								<option value="在职">在职</option>
							</select>
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">备注 </label>
						<div class="layui-input-block">
							<textarea name="staff_msg" id='staff_msg' placeholder="请输入内容"
								class="layui-textarea"></textarea>
						</div>
					</div>
				</div>
				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
					<fieldset class="layui-elem-field">
						<legend>合同</legend>
						<div class="layui-field-box">
							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label"><a style="color: red;">*
									</a>起始日期 </label>
									<div class="layui-input-block">
										<input type="text" class="layui-input"
											id="contract_start_date" name="contract_start_date"
											placeholder="yyyy-MM-dd" readonly="readonly">
									</div>
								</div>
							</div>

							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label"><a style="color: red;">*
									</a>合同类型 </label>
									<div class="layui-input-block">
										<select name="contract_id" id="contract_id"
											lay-verify="required">
											<option value="">请选择</option>
										</select>
									</div>
								</div>
							</div>

							<div
								class="content layui-col-xs12 layui-col-sm12 layui-col-md6 layui-col-lg6">
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label"><a style="color: red;">*
									</a>合同电子档</label>
									<div class="layui-input-block">
										<div class="layui-upload-drag" id="contract">
											<i class="layui-icon"></i>
											<p >点击上传，或将文件拖拽到此处</p>
										</div>
									</div>
								</div>
							</div>

						</div>
					</fieldset>
				</div>






				<div
					class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label"><a style="color: red;">*
						</a>证件照 </label>
						<div class="layui-input-block">
							<div style="margin: 5px; float: left;">
								<div
									style="background-color: #fff; height: 200px; width: 200px; border-radius: 3px; border: 1px solid #b9b9b9; display: flex;"
									align="center">
									<img class="layui-upload-img" id="imgOne"
										src="res/image/add.png"
										style="width: auto; height: auto; max-width: 100%; max-height: 100%; margin: auto;">
								</div>
								<p id="textOne" style="text-align: center; color: #737373;">身份证正面</p>
							</div>

							<div style="margin: 5px; float: left;">
								<div
									style="background-color: #fff; height: 200px; width: 200px; border-radius: 3px; border: 1px solid #b9b9b9; display: flex;"
									align="center">
									<img class="layui-upload-img" id="imgTow"
										src="res/image/add.png"
										style="width: auto; height: auto; max-width: 100%; max-height: 100%; margin: auto;">
								</div>
								<p id="textTwo" style="text-align: center; color: #737373;">身份证反面</p>
							</div>

							<div style="margin: 5px; float: left;">
								<div
									style="background-color: #fff; height: 200px; width: 200px; border-radius: 3px; border: 1px solid #b9b9b9; display: flex;"
									align="center">
									<img class="layui-upload-img " id="imgThree"
										src="res/image/add.png"
										style="width: auto; height: auto; max-width: 100%; max-height: 100%; margin: auto;">
								</div>
								<p id="textThree" style="text-align: center; color: #737373;">一寸照</p>
							</div>
						</div>
					</div>
				</div>

				<div class="layui-form-item my-form-item" id="submit-button">
					<div class="layui-btn-group">
						<button class="layui-btn my-button" lay-submit
							lay-filter="add-staff" id="add-staff">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>



</div>

<script type="text/javascript" src="res/js/admin/addStaff.js"></script>
</html>