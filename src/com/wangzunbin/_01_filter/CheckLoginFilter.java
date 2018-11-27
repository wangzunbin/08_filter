package com.wangzunbin._01_filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CheckLoginFilter implements Filter {

	private String[] unCheckUrls = {"/login.jsp", "/login"};
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String requestURI = req.getRequestURI(); // 获取当前客户端请求的资源
		System.out.println(requestURI);
		if (!Arrays.asList(unCheckUrls).contains(requestURI)) {
			// 判断session中是否存在USER_IN_SESSION
			Object user = req.getSession().getAttribute("USER_IN_SESSION");
			if (user == null) {
				resp.sendRedirect("/login.jsp");
				return;
			}
		}
		chain.doFilter(req, resp); //放行
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}


}
