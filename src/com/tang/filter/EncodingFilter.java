package com.tang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器（开始没有在web中配置）
 * @author Administrator
 *
 */

public class EncodingFilter implements Filter{
	private String charSet;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		servletrequest.setCharacterEncoding(this.charSet);
		servletresponse.setCharacterEncoding(this.charSet);
		filterchain.doFilter(servletrequest, servletresponse);
	}

	public void init(FilterConfig filterconfig) throws ServletException {
		this.charSet = filterconfig.getInitParameter("charset");
		
	}

}
