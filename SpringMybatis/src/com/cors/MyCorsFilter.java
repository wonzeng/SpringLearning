package com.cors;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author wonzeng
 * 2020年7月3日
 * 	跨域请求的过滤器, 需要在web.xml中配置filter标签
 */
public class MyCorsFilter implements Filter {


    public MyCorsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		/* 允许跨域的主机地址 */
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//		response.setHeader("Access-Control-Allow-Headers","*");
		response.setHeader("Access-Control-Allow-Method","*");
		  response.setHeader("Access-Control-Expose-Headers", "*");
//		允许所有的域名跨域访问
//		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		// pass the request along the filter chain
		
		chain.doFilter(servletRequest, servletResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
