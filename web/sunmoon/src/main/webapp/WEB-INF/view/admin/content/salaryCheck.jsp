<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="res/css/admin/departmentManage.css">
<link rel="stylesheet" href="res/css/admin/addressManage.css">
<link rel="stylesheet" href="res/css/admin/postManage.css">
<link rel="stylesheet" href="res/css/eleTree.css" media="all">

<div
	class="content layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12">
	<div class="layui-card">
		<div class="layui-card-header">
			<h2 class="div-title">职位薪资</h2>
		</div>
		<div class="layui-card-body">
			<!-- 顶部工具栏 -->
			<div class="map-tools">
				<button class="layui-btn layui-btn-sm layui-btn-normal"
					id='pay-befor-month'>
					<i class="layui-icon">&#xe628;</i> 一键发放上个月份工资
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
								<li><input type="checkbox" value="staff_id" title="工号"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="staff_name" title="姓名"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="position_name" title="职位"
									lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="department_name"
									title="部门" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="work_address_name"
									title="工作地址" lay-skin="primary" lay-filter='filter' checked></li>
								<li><input type="checkbox" value="actual_pay" title="工资合计"
									lay-skin="primary" lay-filter='filter' checked></li>
								<hr>
								<li id='close-filter' style="cursor: pointer;"><i
									class="layui-icon">&#x1006;</i>关闭</li>
							</ul>
						</form>
					</div>
				</div>
			</div>


			<div id='table'>
				<table class="layui-hide" id="post" lay-filter="post"></table>
			</div>

		</div>
	</div>


</div>

<script type="text/html" id="stateTpl">
  {{#  if(d.mypay_time === ''){ }}
    {{#  if(d.actual_pay === ''){ }}
    	<span style="color: #b5b21e;">{{ '未核对' }}</span>
    {{#  }else { }}
		<span style="color: #20c12e;">{{ '已核对' }}</span>
 	{{#  } }}
  {{#  }else { }}
   <span style="color: #d82b2b;">{{ '已发放' }}</span>
  {{#  } }}
</script>

<script type="text/html" id="opreationBar">
  <a class="layui-btn layui-btn-xs" lay-event="set">手工核对上月薪资</a>
</script>
<script type="text/javascript" src="res/js/admin/salaryCheck.js"></script>


</html>