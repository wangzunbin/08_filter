package com.wangzunbin._01_filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class CharacterEncodingFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 129259689196840168L;

	private String encoding;
	private Boolean force = Boolean.FALSE;
	
	@Override
	public void init(FilterConfig  config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
		this.force = Boolean.valueOf(config.getInitParameter("forceEncoding"));
	}


	@Override
	public void doFilter(ServletRequest  req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("过滤了......................");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// ----------------------------------------------
		// 如果请求中, 之前没有设置过编码, 而此时我们配置了字符编码, 那么用我们配置的
		// 如果请求中之前已经设置过编码, 要不要使用我们自己配置的编码
		if (hasLength(encoding) && (request.getCharacterEncoding() == null || force)) {
			request.setCharacterEncoding(encoding);
		}
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}


	@Override
	public void destroy() {
		
	}

	

}
