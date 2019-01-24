<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 800px;
	height: 500px;
	margin: auto;
	border-collapse: collapse;
 border: 1px solidblack; 
 height: 30px;
}

table tr td {
	border: 1px solid black;
	height: 40px;
}
</style>
</head>
<body>

	<table style="text-align: center;">

		<caption>
			<h3>
				<font size="6"><b id="apply_name"></b></font>
			</h3>
		</caption>
		<tr>
			<td width="120"><font size="3"><b>申请人工号</b></font></td>
			<td width="120" id="apply_staff_id">${re.apply_staff_id}</td>
			<td width="120"><font size="3" ><b>申请时间</b></font></td>
			<td width="120" id="apply_time"><a>${re.apply_time}</a></td>
		</tr>
		<tr>
			<td colspan="1" height="50"><font size="3"><b>申请类型</b></font></td>
			<td colspan="4" height="50" id="apply_type"><a>${re.apply_name}</a></td>
		</tr>
		<tr>
			<td width="120"><font size="3"><b>审批人工号</b></font></td>
			<td width="120" id="check_staff_id">${re.check_staff_id}</td>
			<td width="120"><font size="3"><b>审批时间</b></font></td>
			<td width="120"><font size="3">${re.check_time}</font></td>
		</tr>
		<tr>
			<td colspan="1" height="50"><font size="3"><b>审批状态</b></font></td>
			<td colspan="4" height="50" id="check_state"><b>${re.check_state}</b></td>
		</tr>
		<tr>
			<td colspan="4" height="50"><font size="3"><b>处理意见</b></font></td>
			
		
		</tr>
		<tr>
			<td colspan="4" style="height:150px"><font size="3"><a style="text-indent:2em" id="check_msg">
			${re.check_msg}</a></font></td>
			
		</tr>
		
		

	</table>
	<footer>注：如有疑问请及时反馈</footer>
</body>
</html>