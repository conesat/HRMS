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
			<h2 class="div-title">规则配置</h2>
		</div>
		<div class="layui-card-body">
			<form class="layui-form" action="" style="margin: 10px;" id='check-setting'>

				<div class="layui-field-box" style="padding: 20px; color: #525252;">
					<div class="layui-form-item">
						上班后 <input class="layui-input my-input" maxlength="2"
							id="rule1" name="rule1"> 分钟打卡，算迟到
					</div>
					<div class="layui-form-item">
						上班后 <input class="layui-input my-input" maxlength="2"
							id="rule2" name="rule2"> 分钟打卡，算旷工 <input
							class="layui-input my-input" maxlength="3" id="rule3"
							name="rule3"> 天
					</div>
					<div class="layui-form-item">
						下班前 <input class="layui-input my-input" maxlength="2"
							id="rule4" name="rule4"> 分钟打卡，算早退
					</div>
					<div class="layui-form-item">
						下班前 <input class="layui-input my-input" maxlength="2"
							id="rule5" name="rule5"> 分钟打卡，算旷工 <input
							class="layui-input my-input" maxlength="3" id="rule6"
							name="rule6"> 天
					</div>
					<div class="layui-form-item">
						固定规则：（如需改动请联系开发商） <br>
						迟到：迟到次数的计算以月为限。累计迟到3次（不含3次）不满6次按旷工半天计，累计迟到超过6次按旷工1天计，以后每迟到3次按旷工半天计。
						<br> 早退：月早退累计超过3次，未满六次按旷工半天计，累计超过6次按旷工1天计，以后每早退3次按旷工半天计。 <br>
						旷工：请假未批准或假期已满未续（续假需请部门主管呈报总经理批准）而擅自不到者，视为旷工。员工旷工一天扣发当日工资，旷工两天或两天以上加倍扣发。连续旷工4天或全月累计旷工4天以上者解聘。旷工不满半天按半天计算。
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="check-submit">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="res/js/admin/checkRuleSetting.js"></script>
</html>