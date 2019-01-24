<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的考勤</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="res/css/my.css">
<link rel="stylesheet" media="screen and (min-width:1200px)"
	href="res/css/max.css">
<link rel="stylesheet"
	media="screen and (min-width:800px) and (max-width:1200px)"
	href="res/css/mid.css">
<link rel="stylesheet" media="screen and (max-width:800px)"
	href="res/css/min.css">
<style>
#layui-laydate1 {
	width: 70%;
	margin-top: 2%;
	margin-left: 10%;
}

.layui-laydate-main {
	width: 100%;
}

#layui-laydate-main, #laydate-main-list-0{
   width: 100%;
}
.layui-laydate .layui-laydate-main{
  width: 100%;
}
.layui-laydate-content table{
	width: 100%;
	height: 320px;
}
.layui-laydate-main{
	width: 100%;
}
.layui-table{
width: 70%;
}
</style>
</head>
<body>
	<script src="layui/layui.js"></script>
	<script src="res/js/header.js"></script>
	<div class="layui-layout layui-layout-admin">
			<%@ include file="../../jsp/staff/header.jsp"%>
			<div class="layui-body" id='body-div'>
				<div class="site-demo-laydate">
					<div class="layui-inline" id="test-n1" style="width: 100%"></div>

				</div>
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
 
</fieldset>
 <form action="" id="Attendanceform"> 
<div class="layui-form" style="margin-left: 20%;">
  <table class="layui-table">
    <colgroup>
      <col width="150">
      <col width="150">
      <col width="200">
      <col>
    </colgroup>
    <thead>
      <tr>
        <th>本月需出勤天数</th>
        <th>本月实际出勤天数</th>
        <th>请假</th>
        <th>早退</th>
        <th>迟到</th>
        <th>出勤率</th>
      </tr> 
    </thead>
    <tbody>
      <tr>
        <td id="attendance_need"></td>
        <td id="absence"></td>
        <td id="staff_leave"></td>
        <td id="early"></td>
        <td id="late"></td>
        <td id="xjj"></td>
      </tr>
      </tbody> 
      </table>
		</div>
		</form>
			</div>
		</div>
	
	<script>
	layui.use([ 'form', 'layedit', 'laydate' ,'jquery'],
			function() {
				var form = layui.form, 
				layer = layui.layer,
				layedit = layui.layedit, 
				laydate = layui.laydate;
				var $ = jQuery = layui.jquery;	
				var staffid="${staff_id}";
				
				
         laydate.render({
    	    elem: '#test-n1'
    	    ,position: 'static'
    	    ,btns: ['now']
    	  });
          
          $.ajax({
				type : "get",
				url : "myAttendance/getAbsence?"
						+"&staff_id="+staffid,
				success : function(data) {
					var jsonData = JSON.parse(data);
                 if (jsonData.code == 100) {
						$("#absence").text(jsonData.data.attendance);
						$("#attendance_need").text(jsonData.data.attendance_need);
						$("#staff_leave").text(jsonData.data.staff_leave);
						$("#early").text(jsonData.data.early);
						$("#late").text(jsonData.data.late);
				 		$("#xjj").text((jsonData.data.attendance/jsonData.data.attendance_need*100).toFixed(2)+"%"); 	
				 		
					} else if (jsonData.code == 101) {
						layer.msg("数据库访问异常");
					} else {
						layer.msg("未知错误");
					}
				},

			});
    
	  });
  </script>
</body>
</html>