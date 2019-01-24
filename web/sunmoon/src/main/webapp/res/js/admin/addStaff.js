layui.use([ 'table', 'jquery', 'form', 'laydate','upload' ], function() {
	var table = layui.table;
	var $ = jQuery = layui.jquery;
	var laydate = layui.laydate;
	var form = layui.form;
	var type = 0;// 操作类型 0新增地点 1查看修改
	var opID = '';// 需要操作的 数据id
	var upload = layui.upload;
	var one='',tow='',three='',cont="";

	//起始日期
	laydate.render({
		elem : '#contract_start_date',
		theme: '#0078d7'
	});
	//生日
	 laydate.render({
		elem: '#staff_birthday',
		theme: '#0078d7'
	 });
	 //入职日期
	 laydate.render({
		elem: '#staff_in_date',
		theme: '#0078d7'
	 });
	 
		  
	 //上传合同
	 var contract=upload.render({
	    elem: '#contract'
	    ,url: 'staffManage/uploadContract'
	    ,accept: 'file'
	    ,auto: false
	    ,before: function(obj){
	    	this.data={"staff_id":opID,"contract_id":$('#contract_id').val(),"start_time":$('#contract_start_date').val(),'state':'0'}
	      }
	 	,choose: function(obj){ 
			cont="yes";
			obj.preview(function(index, file, result){
		        $('#contract').html('<i class="layui-icon">&#xe605</i><p >已选择文件：'+file.name+"</p>");
		    });
			
		}
	    ,done: function(res){
	      console.log(res)
	    }
	  });
	  
		// 获取职位
		$.ajax({
			url : "positionManage/getAllPositionIdName",
			type : "get",
			success : function(data) {
				var jsonData=JSON.parse(data);
				var op="<option value=''>请分配职位</option>";
				for(var x in jsonData.data){
					op+="<option value='"+jsonData.data[x].position_id+"'>"+jsonData.data[x].position_name+"</option>";
				}
				$("#position_id").html(op);
				form.render("select");
			}
		});
		
		// 获取部门
		$.ajax({
			url : "department/getAllMyOrgs",
			type : "get",
			success : function(data) {
				var jsonData=JSON.parse(data);
				var op="<option value=''>请分配部门</option>";
				for(var x in jsonData.data){
					op+="<option value='"+jsonData.data[x].department_id+"'>"+jsonData.data[x].department_name+"</option>";
				}
				$("#department_id").html(op);
				form.render("select");
			}
		});
		
		// 获取工作地址
		$.ajax({
			url : "workAddress/getAddsIdName",
			type : "get",
			success : function(data) {
				var jsonData=JSON.parse(data);
				var op="<option value=''>请分配部门</option>";
				for(var x in jsonData.data){
					op+="<option value='"+jsonData.data[x].work_address_id+"'>"+jsonData.data[x].work_address_name+"</option>";
				}
				$("#work_address_id").html(op);
				form.render("select");
			}
		});
		
		// 获取合同类型
		$.ajax({
			url : "contractManage/getAllContractIdName",
			type : "get",
			success : function(data) {
				var jsonData=JSON.parse(data);
				var op="<option value=''>请选择合同</option>";
				for(var x in jsonData.data){
					op+="<option value='"+jsonData.data[x].contract_id+"'>"+jsonData.data[x].contract_name+"</option>";
				}
				$("#contract_id").html(op);
				form.render("select");
			}
		});
	
	 //上传证件照
	 var imgOne=upload.render({
	    elem: '#imgOne'
	    ,url: 'staffManage/upload?name=imgOne'
	    ,auto: false
	    ,before: function(obj){
	    	this.data={"staff_id":opID}
	      }
	 	,choose: function(obj){ 
			//预读本地文件示例，不支持ie8
			 obj.preview(function(index, file, result){
				 one="yes";
		          $('#imgOne').attr('src', result); //图片链接（base64）
		        });
		 },done: function(res){
	        //如果上传失败
	        if(res.code != 100){
	          return layer.msg('上传失败');
	        }
	        //上传成功
	     }
	      ,error: function(){
	        //演示失败状态，并实现重传
	        var demoText = $('#textOne');
	        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	        demoText.find('.demo-reload').on('click', function(){
	          uploadInst.upload();
	        });
	      }
	  });
	 
	 var imgTow=upload.render({
		    elem: '#imgTow'
		    ,url: 'staffManage/upload?name=imgTow'
		    ,auto: false
		    ,before: function(obj){
		    	this.data={"staff_id":opID}
		      }
		 	,choose: function(obj){ 
				//预读本地文件示例，不支持ie8
				 obj.preview(function(index, file, result){
					 tow="yes";
			          $('#imgTow').attr('src', result); //图片链接（base64）
			        });
			 },done: function(res){
		        //如果上传失败
		        if(res.code != 100){
		          return layer.msg('上传失败');
		        }
		        //上传成功
		     }
		      ,error: function(){
		        //演示失败状态，并实现重传
		        var demoText = $('#textTwo');
		        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		        demoText.find('.demo-reload').on('click', function(){
		          uploadInst.upload();
		        });
		      }
		  });
	 
	 var imgThree=upload.render({
		    elem: '#imgThree'
		    ,url: 'staffManage/upload?name=imgThree'
		    ,auto: false
		    ,before: function(obj){
		    	this.data={"staff_id":opID}
		      }
		 	,choose: function(obj){ 
				//预读本地文件示例，不支持ie8
				 obj.preview(function(index, file, result){
					 three="yes";
			          $('#imgThree').attr('src', result); //图片链接（base64）
			        });
			 },done: function(res){
		        //如果上传失败
		        if(res.code != 100){
		          return layer.msg('上传失败');
		        }
		        //上传成功
		     }
		      ,error: function(){
		        //演示失败状态，并实现重传
		        var demoText = $('#textThree');
		        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		        demoText.find('.demo-reload').on('click', function(){
		          uploadInst.upload();
		        });
		      }
		  });
	 //上传证件照-end

	  
	// 监听提交
		form.on('submit(add-staff)', function(data) {
			
			
			
			if (cont=='') {
				layer.msg("请上传电子档合同");
				return false;
			}else if(one==''){
				layer.msg("请上身份证正面");
				return false;
			}else if(tow==''){
				layer.msg("请上传身份证反面");
				return false;
			}else if(three==''){
				layer.msg("请上传一寸照");
				return false;
			}
			
			$.ajax({
				type : "get",
				url : "staffManage/getStaffIdSetting",
				async : true,
				success : function(data) {
					 
					var jsonData = JSON.parse(data);
					if (jsonData.data.auto != 'on') {
						layer.prompt({
							  formType: 3,
							  value: '',
							  title: '请输入职工工号'
							}, function(value, index, elem){
								 if(value==''){
									 layer.msg("不能为空");
								 }else{
									 addStaff(value);
									 layer.close(index);
								 }
							 
							});
						
					} else {
						addStaff();
					}
				},
				error : function(jqObj) {
					
				}
			});
			
			
			
			
			
			return false;
		});
		
	
		
		form.verify({
			staff_state: function(value, item){ //value：表单的值、item：表单的DOM对象
			  if (value=='在职') {
				  var evalue = $('#staff_in_date').val();
				  var dB = new Date(evalue.replace(/-/g, "/"));//获取当前选择日期
				  var d = new Date();
				  var str = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();//获取当前实际日期
				  if (Date.parse(str) < Date.parse(dB)) {//时间戳对比
					      return "入职员工日期必须在今天以前";
				  } 
			  }
			 }
		});    
		var load;
		//添加方法
		function addStaff(id) {
			load= layer.open({
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
						type : "post",
						url : "staffManage/add?"
							+ $("#add-form").serialize()+"&staff_id="+id,
						async : true,
						success : function(data) {
							
							var jsonData = JSON.parse(data);
							if (jsonData.code == 100) {
								if (jsonData.id!='') {
									opID=jsonData.id;
									imgOne.upload();
									imgTow.upload();
									imgThree.upload();
									contract.upload();
									layer.confirm('已完成', {
										icon : 1,
										title : '提示'
									}, function(index) {
										layer.close(index);
										window.location.href = window.location.href;
									});
									
								}else {
									layer.confirm('添加出错！', {
										icon : 2,
										title : '提示'
									}, function(index) {
										layer.close(index);
										window.location.href = window.location.href;
									});
								}
							} else if (jsonData.code == 101) {
								layer.msg('身份已过期，请重新登录', {
									icon : 2,
									time : 2500
								}, function() {
									window.location.href = "gotoLogin";
								});
							} else if (jsonData.code == 102) {
								layer.msg("访问受限,权限不足");
							}  else if (jsonData.code == 103) {
								layer.msg("工号已被占用");
							} else {
								layer.msg("未知错误");
							}
							layer.close(load); 
						},
						error : function(jqObj) {
							layer.close(load); 
						}
					});
		       }
			});
			
		}
	  
	  
	// 重载表格 防止拉伸
	window.reloadTable = function() {
		/*postTable.reload();
		if (fileTable!='') {
			fileTable.reload();
		}*/
		
	};
	form.render("select");
	form.render();
	
	console.log(1);
	
});