layui.use([ 'table', 'jquery', 'form', 'element','laydate' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var opID = '';// 需要操作的 数据id
	var opNumber=0;
	var choiceMonth="";
	var element = layui.element;
	var laydate = layui.laydate;
	// 获取表格数据 getAddsBySE
	var fileTable="";
	var postTable = table.render({
		elem : '#post',
		url : 'checkManage/getChecksBySE',
		title : '上班地点',
		cols : [ [{
			field : 'check_month',
			title : '月份',
			width : 100,
			sort : true
		}, {
			field : 'check_attendance',
			title : '总出勤天数',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_late',
			title : '总迟到人次',
			minWidth : 100,
			sort : true
		},{
			field : 'check_early_retreat',
			title : '总早退人次',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_leave',
			title : '总请假天数',
			minWidth : 100,
			sort : true
		}, {
			field : 'check_absence',
			title : '总旷工天数',
			minWidth : 100,
			sort : true
		},{
			title : '操作',
			toolbar : '#opreationBar',
			width : 100,
			fixed: 'right'
		} ] ],
		page : true
	});
	
	
	 // 限定可选日期
	 var choiceDate = laydate.render({
		 elem: '#choice-date-show'
	    ,eventElem: '#choice-date'
	    ,trigger: 'click'
	    ,type: 'month'
	    ,done: function(value, date){
	    	if(value!=''){
	    		value=date.year+"-"+date.month;
	    	}
	    	table.reload('post', {
				url : 'checkManage/getChecksBySE?key=' +value + '&filter=check_month'
			});
	        
	    }
	 });
	 
	 // 结算当前月份
	 $('#statistics').on("click",function(){
		var load= layer.open({
		        type: 1
		        ,title: false //不显示标题栏
		        ,closeBtn: false
		        ,area: ['100px','100px']
		        ,shade: 0.8
		        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
		        ,btnAlign: 'c'
		        ,moveType: 1 //拖拽模式，0或者1
		        ,content: '<div class="spinner">  <div class="double-bounce1"></div>  <div class="double-bounce2"></div> </div>'
		        ,success: function(layero, index){
		        	$.ajax({
		    			type : "GET",
		    			url : "checkManage/statisticsCheckDetailedByMoth",
		    			async : true,
		    			success : function(data) {
		    				layer.close(load); 
		    				var jsonData = JSON.parse(data);
		    				if (jsonData.code == 100) {
		    					layer.msg('已完成', {
		    						icon : 1,
		    						time : 2500
		    					}, function() {
		    						window.location.reload();
		    					});
		    				}
		    			},
		    			error : function(jqObj) {
		    				layer.close(load); 
	    					layer.msg('出错了', {
	    						icon : 2,
	    						time : 2500
	    					}, function() {
	    						
	    					});
	    				
		    			}
		    		});  
		       }
		 });
		
		 
		 
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
	

	// 返回按按钮点击事件
	$('#back').on('click', function() {
		if(opNumber==2){
			$("#staff-detailed-div").slideUp('', function() {
				$("#add-post-content").slideDown();
			});
			
			$('#examine-search-div').show(); 
			opNumber=1;
		}else if(opNumber==1){
			$('#examine-search-div').hide(); 
			$('#back').parent().hide();
			if($("#table").css('display')=='none'){
				$("#add-post-content").slideUp('', function() {
					$("#table").slideDown();
				});
			}
			opNumber=0;
		}
		
		
	});

	// 搜索工具 start
	var filter=new Set();// 需要查询的字段
	filter.add("staff_name");
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
		table.reload('detailed', {
			url : 'checkManage/getCheckMothDetailedsBySE?key=' + key + '&filter=' + Array.from(filter)+"&month="+choiceMonth,
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

	// 监听提交
	form.on('submit(check-submit)', function(data) {
		layer.prompt({
			formType : 1,
			value : '',
			title : '验证密码',
			maxlength : 20,
		}, function(value, index, elem) {
			layer.close(index);
			if (varifyPass(value)) {
				$.ajax({
					type : "post",
					url : "workAddress/updateCheckSetting?work_address_id="+opID+"&"+$("#check-setting").serialize(),
					async : true,
					success : function(data) {
						var jsonData = JSON.parse(data);
						if (jsonData.code == 100) {
							layer.msg('已完成', {
								icon : 1,
								time : 2500
							}, function() {
								window.location.reload();
							});
						}
					},
					error : function(jqObj) {

					}
				});
			}
		});
		return false;
	});

	// 监听行工具事件
	table.on('tool(post)', function(obj) {
		var data = obj.data;
		 if (obj.event === 'edit') {
			choiceMonth=data.check_month;
			op1(choiceMonth);
			opNumber=1;
		}
	});
	
	// 监听行工具事件
	table.on('tool(detailed)', function(obj) {
		var data = obj.data;
		 if (obj.event === 'edit') {
			op2(data.month,data.staff_id);
			opNumber=2;
		 }
	});
	
	
	function op1(choiceMonth){
		$("#table").slideUp('', function() {
			$("#add-post-content").slideDown();
		});
		
		$('#examine-search-div').show(); 
		$('#back').parent().show();
		table.render({
			elem : '#detailed',
			url : 'checkManage/getCheckMothDetailedsBySE?month='+choiceMonth,
			title : '签到详细',
			cols : [ [{
				field : 'staff_id',
				title : '工号',
				minWidth : 90,
				sort : true
			},{
				field : 'staff_name',
				title : '姓名',
				width : 100,
				sort : true
			},{
				field : 'month',
				title : '月份',
				width : 90
			}, {
				field : 'absence',
				title : '旷工天数',
				minWidth : 100,
				sort : true
			}, {
				field : 'late',
				title : '迟到次数',
				minWidth : 100,
				sort : true
			}, {
				field : 'early',
				title : '早退次数',
				minWidth : 100,
				sort : true
			},{
				field : 'staff_leave',
				title : '请假天数',
				minWidth : 100,
				sort : true
			}, {
				field : 'attendance',
				title : '实际出勤天数',
				minWidth : 120,
				sort : true
			},{
				field : 'attendance_need',
				title : '理应出勤天数',
				minWidth : 120
			},{
				title : '操作',
				toolbar : '#opreationBar',
				width : 100,
				fixed: 'right'
			} ] ],
			page : true
		});
	}
	
	function op2(choiceMonth,staffId){
		$("#add-post-content").slideUp('', function() {
			$("#staff-detailed-div").slideDown();
		});
		
		$('#examine-search-div').hide(); 
		
		table.render({
			elem : '#staff-detailed',
			url : 'checkManage/getCheckDetailedsBySE?month='+choiceMonth+"&staff_id="+staffId,
			title : '签到详细',
			cols : [ [{
				field : 'work_address_name',
				title : '地址',
				width : 100
			},{
				field : 'staff_name',
				title : '姓名',
				width : 100
			}, {
				field : 'staff_id',
				title : '工号',
				minWidth : 100
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
	}
	

	// 验证账号密码
	function varifyPass(pass) {
		var re = false;
		$.ajax({
			type : "post",
			url : "verifyStaff?staff_password=" + pass,
			async : false,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == 100) {
					re = true;
				} else if (jsonData.code == 101) {
					layer.msg("密码验证不通过", {
						icon : 4
					});
				} else if (jsonData.code == 102) {
					layer.msg('身份已过期，请重新登录', {
						icon : 2,
						time : 2500
					}, function() {
						window.location.href = "gotoLogin";
					});
				} else {
					layer.msg("未知错误", {
						icon : 2
					});
				}
			},
			error : function(jqObj) {

			}
		});
		return re;
	}
	// 重载表格 防止拉伸
	window.reloadTable = function() {
		postTable.reload();
		if (fileTable!='') {
			fileTable.reload();
		}
		
	};
	
	form.render();
	
});
