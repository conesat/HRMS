package com.nncq.sunmoon.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nncq.sunmoon.entity.StaffAndPosition;

/**
 * 权限验证拦截
 * 
 * @author 拉布拉多是条狗
 *
 */
public class AuthorizedInterceptor implements HandlerInterceptor {

	/** 定义不需要拦截的请求 */
	private static final String[] IGNORE_URI = { "/loadSystem", "/login", "/loginOut", "/gotoLogin", "/404.html",
			"/nopowers", "/appLogin" };

	/**
	 * 该方法需要preHandle方法的返回值为true时才会执行。 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

	}

	/**
	 * 这个方法在preHandle方法返回值为true的时候才会执行。 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {

	}

	/**
	 * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
	 * 当preHandle的返回值为false的时候整个请求就结束了。
	 * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/** 默认用户没有登录 */
		boolean flag = false;
		/** 获得请求的ServletPath */
		String servletPath = request.getServletPath();
		/** 判断请求是否需要拦截 */
		for (String s : IGNORE_URI) {
			if (servletPath.compareTo(s) == 0) {
				flag = true;
				break;
			}
		}
		/** 拦截请求 */
		if (!flag) {

			int re = SessionListener.verifyUser(request);
			if (re == 1) {
				request.setAttribute("msg",
						"身份已过期，请重新登录 &nbsp;&nbsp;&nbsp;<a href='gotoLogin' class='layui-btn layui-btn-sm layui-btn-radius layui-btn-normal'>去登陆</a>");
				request.getRequestDispatcher("/nopowers").forward(request, response);
				return flag;
			} else if (re == 2) {
				request.setAttribute("msg",
						"您的账号在别处登录，如非本人操作，请及时更改密码 &nbsp;&nbsp;&nbsp;<a href='gotoLogin' class='layui-btn layui-btn-sm layui-btn-radius layui-btn-normal'>去登陆</a>");
				request.getRequestDispatcher("/nopowers").forward(request, response);
				return flag;
			} else {
				flag = true;
			}
			String url = servletPath + "?jsp=" + request.getParameter("jsp");
			url = url.substring(1, url.length());
			StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");

			if (url.indexOf("gotoJsp?jsp=admin/") != -1) {
				if (staff.getPowerMap().get(StaticValues.powerMap.get("login?staffType=0")) == null) {
					request.setAttribute("msg",
							"访问受限，你的权限不足，如有需求请向人事部门申请相关权限 &nbsp;&nbsp;&nbsp;<a href='gotoLogin' class='layui-btn layui-btn-sm layui-btn-radius layui-btn-normal'>重新登录</a>");
					request.getRequestDispatcher("/nopowers").forward(request, response);
					return flag;
				} else if (staff.getPowerMap().get(StaticValues.powerMap.get(url)) == null
						&& url.indexOf("gotoJsp?jsp=admin/index") == -1) {
					request.setAttribute("msg",
							"访问受限，你的权限不足，如有需求请向人事部门申请相关权限 &nbsp;&nbsp;&nbsp;<a href='gotoJsp?jsp=admin/index' class='layui-btn layui-btn-sm layui-btn-radius layui-btn-normal'>首页</a>");
					request.getRequestDispatcher("/nopowers").forward(request, response);
					return flag;
				}
			}
		}
		return flag;

	}

}
