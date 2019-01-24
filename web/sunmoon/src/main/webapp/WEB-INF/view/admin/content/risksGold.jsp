<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/recConfiguration.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<style>
.myinput {
	width: 100%;
	color: #158456;
	background: #f2f2f2;
	border: none;
}
</style>
<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
	<div class="layui-card">
		<div class="layui-card-header">
			<h2 class="div-title">五险一金配置</h2>
		</div>
		<div class="layui-card-body">
			<form class="layui-form" action="" style="margin: 10px;"
				id='risks-gold-setting'>
				<div style="width: 100%; overflow-x: scroll; margin-bottom: 10px;">
					<table class="layui-table" style="min-width: 800px;">
						<thead>
							<tr>
								<th lay-data="{align:'center'}" style="width: 80px;">出资方</th>
								<th lay-data="{align:'center'}">养老保险金</th>
								<th lay-data="{align:'center'}">医疗保险金</th>
								<th lay-data="{align:'center'}">失业保险金</th>
								<th lay-data="{align:'center'}">基本住房公积金</th>
								<th lay-data="{align:'center'}">工伤保险金</th>
								<th lay-data="{align:'center'}">生育保险金</th>
								<th lay-data="{align:'center'}" style="width: 80px;">合计</th>
							</tr>
							<tr>
								<th lay-data="{align:'center'}">单位</th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='c1' name='c1' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='c2' name='c2' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='c3' name='c3' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='c4' name='c4' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='c5' name='c5' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='c6' name='c6' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}" id='c-all'>0</th>
							</tr>

							<tr>
								<th lay-data="{align:'center'}">个人</th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='p1' name='p1' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='p2' name='p2' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='p3' name='p3' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='p4' name='p4' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='p5' name='p5' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}"><input class="myinput"
									id='p6' name='p6' maxlength="10" value="0" /></th>
								<th lay-data="{align:'center'}" id='p-all'>0</th>
							</tr>

						</thead>
					</table>
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
<script type="text/javascript" src="res/js/admin/risksGold.js"></script>
</html>