package com.wangzunbin._01_filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MessageRequestWapper extends HttpServletRequestWrapper {

	public MessageRequestWapper(HttpServletRequest request) {
		super(request);
	}

	// 对getParameter方法做增强
	// 使用该方法具有敏感字过滤功能
	public String getParameter(String name) {
		String val = super.getParameter(name); // 默认情况下的参数值
		// 如果请求参数名为title或者content, 就对参数值做过滤
		if ("title".equals(name) || "content".equals(name)) {
//			val = FilterUtil.filter(val);
		}
		return val;
	}
}
