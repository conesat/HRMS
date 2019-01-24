var NOTICEINDEX = 0;
layui.define(['jquery','layer'], function(exports) {
  var $ = layui.jquery;
  var layer = layui.layer;
  var cssStyle = $('<style type="text/css">.notices-group{position: fixed; right: 0px; top: 0; z-index: 9999999;} .layui-notice{width: 300px; right: 10px; z-index: 9999; position: relative;} .layui-notice-right{margin-left: 0px; margin-right: 15px;} .notice{position: relative; margin-bottom: 1.5rem; color: #fff; padding: .75rem 1.25rem; top: 5vh;} .notice i{margin-right: 5px;} .notice a{color: rgba(255, 255, 255, 0.8);} .notice a:hover{color: white;} .notice .has-border{border: 1px solid #ecedf2 !important;} .notice .text-left{text-align: left;} .notice .text-right{text-align: right;} .notice .text-center{text-align: center;cursor: pointer;} .notice .pull-left{float: left;} .notice .pull-right{position: absolute; top: 8px; right: 5px;} .has-radius{border-radius: 5px !important;} .layui-bg-green2{background-color: #52c41a !important;} .layui-bg-yellow{background-color: #FFB800 !important;} .layui-bg-grey{background-color: #768093 !important;}</style>');
  $('head link:last')[0] && $('head link:last').after(cssStyle) || $('head').append(cssStyle);
  var noticeObj = {
    default: {
      data:"",
      type: "",
      className: "",
      title: "This is a notice",
      radius: "",
      icon: "",
      style: "",
      align: "",
      autoClose: true,
      time: 3000,
      click: true,
      desktop: false,
      itemClick:null,
      end: null
    },
    init: function($data) {
      var options = $.extend(this.default, $data);
      var classN_ = "layui-bg-blue";
      switch (options.type) {
        case 'warm':
          classN_ = "layui-bg-yellow";
          break;
        case 'danger':
          classN_ = "layui-bg-red";
          break;
        case 'custom':
          classN_ = options.className;
          break;
        default:

          break;
      };
      if(!$('.notices-group').length){
        $("body").append('<div class="notices-group"></div>');
      }
      var noticeObjHtml = '<div class="layui-container layui-anim layui-anim-up layui-notice"><div class="notice ' + classN_ + ' has-radius">';

      var noticeClass = 'layui-notice-' + NOTICEINDEX;

      switch (options.align) {
        case 'left':
          noticeObjHtml += '<p class="' + noticeClass + '">';
          break;
        case 'right':
          noticeObjHtml += '<p class="text-right ' + noticeClass + '">';
          break;
        default:
          noticeObjHtml += '<p class="text-center ' + noticeClass + '">';
          break;
      };

      if (options.icon) {
        noticeObjHtml += '  <i class="layui-icon ' + options.icon + '"></i>';
      }
      noticeObjHtml +="<a class='item' onclick="+'"'+"opend('"+options.data.msg_title+"','"+options.data.msg_body+
      "','"+options.data.send_name+"','"+options.data.send_time+"','"+options.data.msg_id+"','"+options.data.send_id+"',this)"+'"'+">"+options.title+"</a>";
      if (options.click) {
        noticeObjHtml +=
          '</p><a href="javascript:;" class="pull-right"><i class="layui-icon layui-icon-close notice-close"></i></a>';
      }
      // 结束
      noticeObjHtml += '</div></div>';
      $(".notices-group").append(noticeObjHtml);

      if (options.autoClose) {
        window.setTimeout(function() {
          $("." + noticeClass).parents(".layui-notice").addClass("layui-anim-fadeout").remove();
        }, options.time);
      }

      if (options.click) {
        $(".notice-close").click(function() {
          $(this).parents(".layui-notice").addClass("layui-anim-fadeout").remove();
        });
      }

      if(options.desktop){
        this.desktopNotice(options.title);
      }

  	window.returnMsg=function(send_id) {
  		layer.prompt({
  		  formType: 2,
  		  value: '',
  		  title: '请输入回复信息',
  		  area: ['400px', '100px'] //自定义文本域宽高
  		}, function(value, index, elem){
  		  if (value!='') {
  			  layer.close(index);
  			  $.ajax({
  					type : "post",
  					url : "msg/sendMsg?object_id="+send_id+"&msg_body="+value,
  					async : false,
  					success : function(data) {
  						var jsonData = JSON.parse(data);
  						if (jsonData.code == 100) {
  							 layer.msg("已回复");
  						}
  					},
  					error : function(jqObj) {
  					}
  				});
  		   }else{
  			   layer.msg("请输入回复信息");
  		   }
  		  
  		});
  	}
  	
      window.opend=function (d1,d2,d3,d4,d5,d6,this_){
    	  
    	  $(this_).parents(".layui-notice").addClass("layui-anim-fadeout").remove();
    	 layer.open({
  			type : 1,
  			title : "消息",
  			area : '300px;',
  			shade : 0.8,
  			id : 'new_notice',
  			btn : [ '回复','已读' ],
  			btnAlign : 'c',
  			moveType : 1,
  			content : '<div style="padding: 20px; line-height: 22px; background-color: #ffffff; color: #6d6d6d;"><span style="font-size: 16px;color: #000;">标题 </span>'
  					+ d1
  					+ '<br><br><span style="font-size: 16px;color: #000;">内容 </span>'
  					+ d2
  					+ '<br><br><br>发布者：'
  					+ d3
  					+ '<br>时间：'
  					+ d4 + '</div>',
  			success : function(layero) {
  				var btn = layero.find('.layui-layer-btn');
  				btn.find('.layui-layer-btn0').on('click',function() {
  					$.ajax({
  						type : "post",
  						url : "msg/readMsg?msg_id="
  								+ d5,
  						async : false
  					});
  					returnMsg(d6);
  				});
  				btn.find('.layui-layer-btn1').on('click',function() {
  					$.ajax({
  						type : "post",
  						url : "msg/readMsg?msg_id="
  								+ d5,
  						async : false
  					});
  				});
  			}
  		});
      }
      
      
      this.itemClick = function(callback) {
	        callback(options.id);
	  };

      this.end = function(callback) {
        callback();
      };
      NOTICEINDEX++;
    },
    desktopNotice :function(info){
        if(window.Notification && Notification.permission !== "denied") {
            Notification.requestPermission(function(status) {
                var body_ = info ? info : '您有新的消息';
                var notice_ = new Notification('新的消息', { body: body_});
                notice_.onclick = function() {//单击消息提示框，进入浏览器页面
                    window.focus();                    
                };
            });
        }   
    },
    close: function() {
      var noticeClass = 'layui-notice-' + NOTICEINDEX;
      $("." + noticeClass).parents(".layui-notice").addClass("layui-anim-fadeout").remove();
    },
    closeAll: function() {
      $(".notice-close").parents(".layui-notice").addClass("layui-anim-fadeout").remove();
    }
  };
  exports('notice', noticeObj);
  
 
});