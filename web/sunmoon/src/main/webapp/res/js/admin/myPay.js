layui.use([ 'table', 'jquery', 'form', 'element'], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var element = layui.element;
	// 获取表格数据 getAddsBySE
	var fileTable="";
	var staff_state="";// 职员状态
	var staff_type="";// 职员类型
	
	var myTable = table.render({
		elem : '#test',
		url :'myPay/selectmypay',
		title : '申请表',
		cols : [ [ {
			field : 'mypay_staff_id',
			title : '工号',
			minWidth : 110,
		},{
			field : 'mypay_moth',
			title : '月份',
			minWidth : 80,
			sort : true
		}, {
			field : 'base_pay',
			title : '基本工资',
			minWidth :100,
			sort : true
		
		},{
			field : 'post_pay',
			title : '岗位工资',
			minWidth : 100,
			sort : true
		}
		, {
			field : 'bonus',
			title : '奖金',
			minWidth : 80,
			sort : true
		}, {
			field : 'achievements',
			title : '绩效工资',
			minWidth :100,
			sort : true
		
		},{
			field : 'year_pay',
			title : '年限工资',
			minWidth : 80,
			sort : true
		}, {
			field : 'deduction',
			title : '五险一金',
			minWidth :80,
			sort : true
		
		}, {
			field : 'individual_income_tax',
			title : '个人所得税',
			minWidth :120,
			sort : true
		
		},{
			field : 'actual_pay',
			title : '实发工资',
			minWidth : 120,
			sort : true
		}, {
			field : 'mypay_time',
			title : '发放日期',
			minWidth :100,
		
		},{
			field : 'mypay_msg',
			title : '备注说明',
			minWidth : 100,
			
		}] ],
		page : true
	});
	
});