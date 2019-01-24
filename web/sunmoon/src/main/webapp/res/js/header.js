layui.config({
    base: "layui/lay/mymodules/"
}).use([ 'element', 'jquery', 'layer' ,'notice'], function() {
	var element = layui.element;
	var $ = jQuery = layui.jquery;
	var layer = layui.layer;
	var urlF = $('#headerUrl').html();
	var notice = layui.notice;
	$("#" + urlF).addClass("layui-this");
	$("#" + urlF + "-mini").addClass("layui-this");

	window.searchFocus = function() {
		$("#search-div").animate({
			width : '300px'
		}, 100);
	};

	window.searchFocusOver = function() {
		$("#search-div").animate({
			width : '250px'
		}, 100);
	};
	
	$('#show-my').on('click', function() {

		layer.open({
			type : 1,
			title : false,
			shadeClose : true, // 开启遮罩关闭
			closeBtn : 0, // 不显示关闭按钮
			shade : [ 0.2 ],
			area : [ '340px', ($(window).height() - 50) + 'px' ],
			offset : [ '50px', ($(window).width() - 340) + "px" ],
			anim : 5,
			content : $('#my-content').html(),
			end : function() { // 此处用于演示

			}
		});
	});
	
	
	
    var yime=setInterval(setTime, 1000);
    
    function setTime() {
    	var myDate = new Date();
    	var h=myDate.getHours();       //获取当前小时数(0-23)
    	var m=myDate.getMinutes();     //获取当前分钟数(0-59)
    	var s=myDate.getSeconds(); 
    	if (h<10) {
			h='0'+h;
		}
    	if (m<10) {
			m="0"+m;
		}
    	if (s<10) {
			s='0'+s;
		}
		$('#time').html(h+":"+m+":"+s);
	}
    
	// 输入框回车事件
	$('#serach-key').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			window.location.href="search?key="+$("#serach-key").val();
		}
	});
    
 
		
	
	
	window.getMsg=function() {
		$.ajax({
			type : "post",
			url : "msg/getMsg",
			async : false,
			success : function(data) {
				clearInterval(runTime);
				var jsonData = JSON.parse(data);
				if (jsonData.code == 101 || jsonData.code == 102) {
					window.location.href = "gotoLogin";
				} else if (jsonData.code == 103) {
					//示范一个公告层
					layer.open({
						type : 1,
						title : "最新公告",
						closeBtn : false,
						area : '300px;',
						shade : 0.8,
						id : 'new_notice',
						btn : [ '我知道了' ],
						btnAlign : 'c',
						moveType : 1,
						content : '<div style="padding: 20px; line-height: 22px; background-color: #ffffff; color: #6d6d6d;"><span style="font-size: 16px;color: #000;">标题 </span>'
								+ jsonData.notice.notice_title
								+ '<br><br><span style="font-size: 16px;color: #000;">内容 </span>'
								+ jsonData.notice.notice_msg
								+ '<br><br><br>发布者：'
								+ jsonData.notice.notice_staff_name
								+ '<br>发布时间：'
								+ jsonData.notice.notice_time + '</div>',
						success : function(layero) {
							var btn = layero.find('.layui-layer-btn');
							btn.find('.layui-layer-btn0').on('click',function() {
								$.ajax({
									type : "post",
									url : "notice/readNotice?notice_id="
											+ jsonData.notice.notice_id,
									async : false
								});
								runTime = setInterval(getMsg, 2000);
							});
						}
					});

				} else if (jsonData.code == 104) {
					
					for (var x in jsonData.msgs) {
						notice.init({
							data:jsonData.msgs[x],
							autoClose :false,
					        title: "来自："+jsonData.msgs[x].send_name+" 新消息",
					        click: true,  
					        desktop: true // 开启桌面提醒    
					    });
					 }
					 try{
						indexReFMsg();
					 } catch(err){}
				
				    
				   runTime=setInterval(getMsg,2000);
				} else {
				   runTime=setInterval(getMsg,2000);
				}
			},
			error : function(jqObj) {

			}
		});
	}
	
	
	 window.changePass=function(){
		 layer.prompt({
				formType : 1,
				value : '',
				title : '输入新密码',
				maxlength : 20,
			}, function(value, index, elem) {
				layer.close(index);
				if(value.length<6){
					layer.msg("密码长度不得小于6");
				}else{
					var that=value;
					layer.prompt({
						formType : 1,
						value : '',
						title : '确认密码',
						maxlength : 20,
					}, function(value, index, elem) {
						layer.close(index);
						if(value!=that){
							layer.msg("两次密码不一致");
						}else{
							
							$.ajax({
								type : "post",
								url : "staffManage/setPassword?staff_password=" + value,
								async : false,
								success : function(data) {
									var jsonData = JSON.parse(data);
									if (jsonData.code == 100) {
										layer.msg('已修改密码，请重新登录', {
											icon : 1,
											time : 2500
										}, function() {
											window.location.href = "gotoLogin";
										});
									} else if (jsonData.code == 101) {
										layer.msg('身份已过期，请重新登录,后操作', {
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
									layer.msg("链接失败", {
										icon : 2
									});
								}
							});
							
							
						}
					});
				}
			});
	 }

	 
	//显示时间
	setTime();
	
	//getMsg();
	// 定时轮询
	var runTime = setInterval(getMsg, 2000);
	
});