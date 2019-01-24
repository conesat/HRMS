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
		url :'myApproval/selectmyApproval',
		title : '申请表',
		cols : [ [ {
			field : 'apply_id',
			title : 'id',
			minWidth : 100,
			sort : true
		},  {
			field : 'apply_name',
			title : '申请类型',
			minWidth : 280,
			templet: '#nameStateTpl',
			sort : true
		}, {
			field : 'check_state',
			title : '状态',
			templet: '#stateTpl',
			minWidth :280,
		
		},{
			field : 'apply_time',
			title : '申请时间',
			minWidth : 200,
			sort : true
		},{
			title : '操作',
			toolbar : '#details',
			width : 250,
		} ] ],
		page : true
	});
	
	  // 监视按钮 弹窗
	  table.on('tool(test)', function(obj){
	    var data = obj.data;
	   console.log(obj)
        if(obj.event === 'details'){
        
      	  layer.open({
      		  type: 2,
      		  shade: 0.5,
      		  area: ['1000px','600px'],
      		  maxmin: true,
      		  content: 'myApproval/Detailed?apply_id='+data.apply_id,//对应controle层中的方法
      		  zIndex: layer.zIndex, //重点1
      		  success: function(layero){
      		    layer.setTop(layero); //重点2
      		  }
      		});     
	    }
	  });
	  

});