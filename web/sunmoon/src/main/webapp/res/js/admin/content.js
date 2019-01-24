//JavaScript代码区域
layui.use([ 'element', 'jquery' ], function() {
	var element = layui.element;
	var $ = jQuery = layui.jquery;
	var con = $('#con').html();// 加载内容

	if ($(window).width() <= 800) {
		$("#menue-i").removeClass("layui-icon-shrink-right");// 改变 菜单按钮
		$("#menue-i").addClass("layui-icon-spread-left");
	}

	// 菜单按钮点击事件
	$("#menue-i").on('click', function() {
		if ($("#menue-div").width() > 40) {
			$("#menue-i").removeClass("layui-icon-shrink-right");
			$("#menue-i").addClass("layui-icon-spread-left");
			$("#body-div").animate({
				left : '0px'
			});

			$("#menue-div").animate({
				width : '0px'
			});

			$("#menue-ul").fadeOut();

			if ($(window).width() >= 800) {
				$("#menue").fadeOut('', function() {
					$('#header-max').animate({
						left : '60px'
					});
					$('#header-mid').animate({
						left : '60px'
					});
				});
			}
		} else {
			$("#menue-i").removeClass("layui-icon-spread-left");
			$("#menue-i").addClass("layui-icon-shrink-right");

			if ($(window).width() <= 800) {
				if ($("#body-div").css('left') > 40) {
					$("#body-div").animate({
						left : '0px'
					});
				}
			} else {
				$("#body-div").animate({
					left : '200px'
				});
				$("#menue").fadeIn();
				$('#header-max').animate({
					left : '200px'
				});
				$('#header-mid').animate({
					left : '200px'
				});
			}
			$("#menue-div").animate({
				width : '200px'
			});

			$("#menue-ul").fadeIn();
		}

	});
	
	//监听屏幕变化
	$(window).resize(function () {
		if ($(window).width() <= 800) {
	
			$("#menue-i").removeClass("layui-icon-shrink-right");
			$("#menue-i").addClass("layui-icon-spread-left");
			$("#body-div").animate({
				left : '0px'
			});

			$("#menue-div").animate({
				width : '0px'
			});

			$("#menue-ul").fadeOut();

			$("#menue").fadeOut('', function() {
				$('#header-mid').animate({
					left : '60px'
				});
			});
		}else{
			
			$("#menue-i").removeClass("layui-icon-spread-left");
			$("#menue-i").addClass("layui-icon-shrink-right");

			$("#body-div").animate({
				left : '200px'
			});
			$("#menue").fadeIn();
			$('#header-mid').animate({
				left : '200px'
			});
			$('#header-max').animate({
				left : '200px'
			});
			$("#menue-div").animate({
				width : '200px'
			});

			$("#menue-ul").fadeIn();
		}
	});

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

	// 修改地址栏
	function changeURLArg(arg, arg_val) {
		var pattern = arg + '=([^&]*)';
		var replaceText = arg + '=' + arg_val;
		var url = window.location.href;
		if (url.match(pattern)) {
			var tmp = '/(' + arg + '=)([^&]*)/gi';
			tmp = url.replace(eval(tmp), replaceText);
			return tmp;
		} else {
			if (url.match('[\?]')) {
				return url + '&' + replaceText;
			} else {
				return url + '?' + replaceText;
			}
		}
		return url + '\n' + arg + '\n' + arg_val;
	}

	// 嵌套显示
	window.changeBody = function(url) {
		window.history.pushState({}, "", changeURLArg('con', url));
		$('#body-div').load('gotoJsp?jsp=admin/content/' + url);
		$('#' + url).addClass('layui-this');
	}
	if(con!=''){
		changeBody(con);
	}

});