layui.use([ 'table', 'jquery', 'form', 'element','upload'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	var upload = layui.upload;
	var checkDep='';
	var key='';
	var filePath="";
	var load;
	// 获取表格数据 getAddsBySE
	var postTable = table.render({
		elem : '#post',
		url : 'contractManage/getStaffContractsBySE',
		toolbar : '#toolBar',
		title : '职位表',
		cols : [ [ {
			field : 'staff_id',
			title : '工号',
			minWidth : 100,
			sort : true
		}, {
			field : 'staff_name',
			title : '名称',
			minWidth : 100,
			sort : true
		}, {
			field : 'position_name',
			title : '职位',
			minWidth : 200,
			sort : true
		}, {
			field : 'department_name',
			title : '部门',
			minWidth : 200,
			sort : true
		}, {
			field : 'contract_name',
			title : '合同名称',
			minWidth : 200,
			sort : true
		}, {
			field : 'end_time',
			title : '结束时间',
			minWidth : 200,
			sort : true
		}, {
			field : 'state',
			title : '合同状态',
			minWidth : 100,
			templet: '#stateTpl',
			sort : true
		}, {
			title : '操作',
			toolbar : '#opreationBar',
			width : 100,
			fixed : 'right'
		} ] ],
		page : true
	});
	
	// 获取部门
	$.ajax({
		url : "department/getAllMyOrgs",
		type : "get",
		success : function(data) {
			var jsonData=JSON.parse(data);
			var op="<option value=''>全部可用部门</option>";
			for(var x in jsonData.data){
				op+="<option value='"+jsonData.data[x].department_id+"'>"+jsonData.data[x].department_name+"</option>";
			}
			$("#department_id").html(op);
			form.render("select");
		}
	});
	
	form.on('select(department_id)', function(data){
		//  console.log(data.value); //复选框value值，也可以通过data.elem.value得到
		  checkDep=data.value;
		  searchAdd();
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
	filter.add("contract_name");
	filter.add("state");
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
			key=$("#serach-address-key").val();
			searchAdd();
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
	function searchAdd() {
		$("#filter-ul-div").fadeOut();
		table.reload('post', {
			url : 'contractManage/getStaffContractsBySE?key=' + key + '&filter=' + Array.from(filter)+"&department_id="+checkDep,
		});
	}
	// 搜索工具 end

	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		// console.log(obj)
		if (obj.event === 'edit') {
			// 合同变更
			layer.open({
				  type: 2,
				  title: ''+opID+'职员合同变更',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['90%', '80%'],
				  content: 'staffManage/gotoJsp?id='+data.staff_id+"&jsp=changeStaffContract"
			}); 
	
		}
	});
	
	// 重载表格 防止拉伸
	window.reloadTable = function() {
		postTable.reload();
	};
	
	form.render();
	
});