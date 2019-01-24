layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	
	// 获取表格数据 getAddsBySE
	var postTable = table.render({
		elem : '#post',
		url : 'salary/getStaffPayBySe',
		title : '职位表',
		cols : [ [{
			field : 'staff_id',
			title : '工号',
			width : 120,
			sort : true
		},{
			field : 'staff_name',
			title : '姓名',
			width : 100,
			sort : true
		}, {
			field : 'mypay_moth',
			title : '月份',
			width : 100,
			sort : true
		},{
			field : 'mypay_time',
			title : '发放时间',
			width : 120,
			sort : true
		}, {
			field : 'position_name',
			title : '职位',
			minWidth : 100,
			sort : true
		}, {
			field : 'department_name',
			title : '部门',
			minWidth : 100,
			sort : true
		}, {
			field : 'work_address_name',
			title : '工作地址',
			minWidth : 100,
			sort : true
		}, {
			field : 'actual_pay',
			title : '工资合计',
			minWidth : 100,
			sort : true
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 100,
			fixed: 'right'
		} ] ],
		page : true
	});
	
	
	
	// 排序事件
	table.on('sort(post)', function(obj) { // 注：tool是工具条事件名，test是table原始容器的属性
		table.reload('post', {
			initSort : obj // 记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
			,
			where : { // 请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
				field : obj.field // 排序字段
				,
				order : obj.type
			// 排序方式
			}
		});
	});
	

	// 搜索工具 start
	var filter=new Set();// 需要查询的字段
	filter.add("staff_id");
	filter.add("staff_name");
	filter.add("position_name");
	filter.add("department_name");
	filter.add("work_address_name");
	// 字段拦截按钮事件
	$('#filter').on('click', function() {
		$("#filter-ul-div").fadeToggle();
	});
	// 字段拦截收起按钮事件
	$('#close-filter').on('click', function() {
		$("#filter-ul-div").fadeToggle();
	});
	// 搜索按钮事件
	$('#search-i').on('click', function() {
		searchAdd($("#serach-address-key").val());
	});
	// 输入框回车事件
	$('#serach-address-key').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			searchAdd($("#serach-address-key").val());
		}
	});
	// 查询字段修改事件
	form.on('checkbox(filter)', function(data) {
		if(data.elem.checked){
			filter.add(data.value);
		}else if (filter.size>1) {
			filter.delete(data.value);
		}else {
			layer.msg("至少选择一个");
			data.elem.checked=true;
			form.render('checkbox');
		}
	});
	// 开始查询
	function searchAdd(key) {
		$("#filter-ul-div").fadeOut();
		table.reload('post', {
			url : 'salary/getStaffPayBySe?key=' + key + '&filter=' + Array.from(filter),
		});
	}
	// 搜索工具 end


	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		if (obj.event === 'set') {
			layer.open({
				  type: 2,
				  title: ''+data.staff_name+'薪资',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['90%', '80%'],
				  content: 'salary/salaryShow?staff_id='+data.staff_id+"&month="+data.mypay_moth
			}); 
		} 
	});
	

	// 重载表格 防止拉伸
	window.reloadTable = function() {
		postTable.reload();
	};
	
	form.render();
	
});