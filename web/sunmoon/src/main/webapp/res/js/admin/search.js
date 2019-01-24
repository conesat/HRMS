layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var element = layui.element;
    var key=$('#key').html();
    $('#serach-key').val(key);
    
    var filter=new Set();// 需要查询的字段
	filter.add("staff_id");
	filter.add("staff_name");
	filter.add("work_address_name");
	filter.add("department_name");
	filter.add("position_name");
	filter.add("staff_phone");
	filter.add("staff_state");
	table.render({
		elem : '#staff-table',
		url : 'staffManage/getStaffsBySE?key=' + key+ '&filter=' + Array.from(filter) ,
		title : '员工表',
		toolbar : ' ',
		cols : [ [ {
			field : 'staff_id',
			title : '工号',
			minWidth : 110,
			sort : true
		},  {
			field : 'staff_name',
			title : '名字',
			minWidth : 130,
			sort : true
		}, {
			field : 'staff_sex',
			title : '性别',
			minWidth : 100,
			sort : true
		}, {
			field : 'work_address_name',
			title : '上班地点',
			minWidth : 100,
			sort : true
		}, {
			field : 'department_name',
			title : '部门',
			minWidth : 100,
			sort : true
		}, {
			field : 'position_name',
			title : '职位',
			minWidth : 100,
			sort : true
		}, {
			field : 'staff_phone',
			title : '电话',
			width : 160,
			sort : true
		},{
			field : 'staff_state',
			title : '状态',
			minWidth : 100,
			templet: '#stateTpl',
			sort : true
		}] ],
		page : true
	});
	
	filter.clear();
	filter.add("work_address_id");
	filter.add("work_address_name");
	table.render({
		elem : '#work-add',
		url : 'workAddress/getAddsBySE?key=' + key+ '&filter=' + Array.from(filter),
		toolbar : ' ',
		title : '上班地点',
		cols : [ [  {
			field : 'work_address_id',
			title : 'ID',
			width : 100,
			sort : true
		}, {
			field : 'work_address_name',
			title : '地点',
			minWidth : 100,
			sort : true
		}, {
			field : 'work_address_xy',
			title : '坐标',
			minWidth : 100
		}] ],
		page : true
	});
	
	
	filter.clear();
	filter.add("department_id");
	filter.add("department_name");
	filter.add("department_describe");
	filter.add("staff_name");
	filter.add("staff_id");
	table.render({
		elem : '#department',
		url : 'department/getDepsBySE?key=' + key+ '&filter=' + Array.from(filter),
		toolbar : ' ',
		title : '部门表',
		cols : [ [{
			field : 'department_id',
			title : 'ID',
			width : 100,
			sort : true
		}, {
			field : 'department_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'parent_name',
			title : '所属部门',
			minWidth : 100,
			sort : true
		}, {
			field : 'department_describe',
			title : '描述',
			minWidth : 200
		}, {
			field : 'staff_name',
			title : '管理者',
			minWidth : 100,
			sort : true
		}, {
			field : 'staff_id',
			title : '主管工号',
			minWidth : 100,
			sort : true
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 120
		} ] ],
		page : true
	});
	
	filter.clear();
	filter.add("post_id");
	filter.add("post_name");
	filter.add("post_msg");
	table.render({
		elem : '#post',
		url : 'postManage/getPostsBySE?key=' + key+ '&filter=' + Array.from(filter),
		toolbar : ' ',
		title : '职务表',
		cols : [ [  {
			field : 'post_id',
			title : 'ID',
			width : 100,
			sort : true
		}, {
			field : 'post_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'post_msg',
			title : '描述',
			minWidth : 200
		} ] ],
		page : true
	});
	
	filter.clear();
	filter.add("position_id");
	filter.add("position_name");
	filter.add("position_msg");
	table.render({
		elem : '#position',
		url : 'positionManage/getPositionsBySE?key=' + key+ '&filter=' + Array.from(filter),
		toolbar : ' ',
		title : '职位表',
		cols : [ [  {
			field : 'position_id',
			title : 'ID',
			width : 100,
			sort : true
		}, {
			field : 'position_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'position_msg',
			title : '描述',
			minWidth : 200
		}, {
			field : 'post_id',
			title : '职务ID',
			minWidth : 100
		}, {
			field : 'post_name',
			title : '职务',
			minWidth : 100
		}, {
			field : 'rank_level',
			title : '职级',
			minWidth : 100
		} ] ],
		page : true
	});
	
	filter.clear();
	filter.add("rank_name");
	filter.add("rank_level");
	filter.add("rank_msg");
	table.render({
		elem : '#rank',
		url : 'rankManage/getRanksBySE?key=' + key+ '&filter=' + Array.from(filter),
		toolbar : ' ',
		title : '职级表',
		cols : [ [ {
			field : 'rank_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'rank_level',
			title : '等级',
			minWidth : 100
		}, {
			field : 'rank_msg',
			title : '描述',
			minWidth : 200
		} ] ],
		page : true
	});
	
	
	window.changeShow=function(id){
		if(id==''){
			showAll();
		}else{
			hideAll();
			$('#'+id).show();
		}
		
	}
	
	function hideAll(){
		$('#staff-div').hide();
		$('#work-add-div').hide();
		$('#department-div').hide();
		$('#post-div').hide();
		$('#position-div').hide();
		$('#rank-div').hide();
	}
	
	function showAll(){
		$('#staff-div').show();
		$('#work-add-div').show();
		$('#department-div').show();
		$('#post-div').show();
		$('#position-div').show();
		$('#rank-div').show();
	}
	
});