layui.use([ 'table', 'jquery', 'form', 'element','laydate' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var opID = '';// 需要操作的 数据id
	var opNumber=0;
	var choiceDay="";
	var element = layui.element;
	var laydate = layui.laydate;
	// 获取表格数据 getAddsBySE
	var fileTable="";
	table.render({
		elem : '#staff-detailed',
		url : 'checkManage/getDayCheckDetailed',
		title : '签到详细',
		cols : [ [{
			field : 'work_address_name',
			title : '地址',
			width : 100,
			sort : true
		},{
			field : 'staff_name',
			title : '姓名',
			width : 100,
			sort : true
		}, {
			field : 'staff_id',
			title : '工号',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_detailed_day',
			title : '日期',
			minWidth : 120,
			sort : true
		}, {
			field : 'check_detailed__time1',
			title : '上午签到',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_detailed__time2',
			title : '上午签退',
			minWidth : 100,
			sort : true
		},{
			field : 'check_detailed__time3',
			title : '下午签到',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_detailed__time4',
			title : '下午签退',
			minWidth : 100,
			sort : true
		},{
			field : 'check_detailed__time5',
			title : '晚上签到',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_detailed__time6',
			title : '晚上签退',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_detailed_state',
			title : '状态',
			minWidth : 100,
			sort : true,
			fixed: 'right'
		}] ],
		page : true
	});
	
	
	 // 限定可选日期
	 var choiceDate = laydate.render({
		 elem: '#choice-date-show'
	    ,eventElem: '#choice-date'
	    ,trigger: 'click'
	    ,done: function(value, date){
	    	if(value!=''){
	    		choiceDay=value;
	    	}
	    	table.reload('staff-detailed', {
				url : 'checkManage/getDayCheckDetailed?day=' +value 
			});
	        
	    }
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
	filter.add("work_address_name");
	filter.add("staff_name");
	filter.add("staff_id");
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
		table.reload('staff-detailed', {
			url : 'checkManage/getDayCheckDetailed?key=' + key + '&filter=' + Array.from(filter)+"&day="+choiceDay,
		});
	}
	// 搜索工具 end
	
	form.verify({
		range: function(value, item){ // value：表单的值、item：表单的DOM对象
			if ($("#range_on")[0].checked && value=='') {
				return "请输入范围值";
			}
		  }
		  
	}); 

	// 重载表格 防止拉伸
	window.reloadTable = function() {
		postTable.reload();
		if (fileTable!='') {
			fileTable.reload();
		}
		
	};
	
	form.render();
	
});
