layui.use([ 'jquery', 'form' ], function() {
	var $ = jQuery = layui.jquery;
	var form = layui.form;
	var ID="";
	var mid="";
	var date=new Date;
	var year=date.getFullYear(); 
	//获取工号设置
	$.ajax({
		url : "staffManage/getStaffIdSetting",
		type : "get",
		success : function(data) {
			var jsonData=JSON.parse(data);
			$('#prefix').val(jsonData.data.prefix)
			$('#middle').val(jsonData.data.middle);
			$('#suffix').val(jsonData.data.suffix);
			$('#separate').val(jsonData.data.separate);
			$('#password').val(jsonData.data.password);
			if (jsonData.data.auto=='on') {
				$('#auto').prop('checked','checked');
			}
			form.render("checkbox");
			form.render("select");
			preId();
		}
	});
	
	$('#pre-show').on('click',function(){
		preId();
	});
	
	$("#prefix").bind("input propertychange",function () {
		preId();
	});
	
	form.on('select()', function(data){
		preId();
	});    
	
	$("#suffix").bind("input propertychange",function () {
		preId();
	});
	
	$("#separate").bind("input propertychange",function () {
		preId();
	});
	
	function preId(){
		ID="";
		if ($('#middle').val()==1) {
			mid=year+"0001";
		}else {
			mid="0001";
		}
		if ($('#prefix').val()!='') {
			ID=$('#prefix').val()+$('#separate').val();
		}
		ID+=mid;
		if ($('#suffix').val()!='') {
			ID+=$('#separate').val()+$('#suffix').val();
		}
		$('#pre').html(ID);
	}
	

	//监听提交
	form.on('submit(update)', function(data){
		$.ajax({
			type : "post",
			url : "staffManage/updateStaffSetting?"
				+ $("#staff-id-setting").serialize(),
			async : true,
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.code == 100) {
					layer.confirm('已完成', {
						icon : 1,
						title : '提示'
					}, function(index) {
						layer.close(index);
						window.location.href = window.location.href;
					});
				} else if (jsonData.code == 101) {
					layer.confirm('身份已过期，请重新登录', {
						icon : 2,
						title : '提示'
					}, function(index) {
						layer.close(index);
						window.location.href = "gotoLogin";
					});
				} else if (jsonData.code == 102) {
					layer.msg("访问受限,权限不足");
				} else {
					layer.msg("未知错误");
				}
			},
			error : function(jqObj) {

			}
		});
	   return false;
	});
	
	  
	// 重载表格 防止拉伸
	window.reloadTable = function() {
		/*postTable.reload();
		if (fileTable!='') {
			fileTable.reload();
		}*/
		
	};
	form.render("select");
	form.render();
	
	
});