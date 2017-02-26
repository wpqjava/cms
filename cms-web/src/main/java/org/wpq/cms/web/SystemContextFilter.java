package org.wpq.cms.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.wpq.cms.model.SystemContext;

public class SystemContextFilter implements Filter {
	private int pageOffset;
	private int pageSize;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		pageOffset = 0;
		try {
			pageOffset = Integer.parseInt(arg0.getParameter("pager.offset"));
		} catch (NumberFormatException e1) {}
		
		try {
			String order = arg0.getParameter("order");
			SystemContext.setOrder(order);
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(pageSize);
			SystemContext.setRealPath(((HttpServletRequest)arg0).getSession().getServletContext().getRealPath("/"));
			arg2.doFilter(arg0, arg1);
		} catch (Exception e) {
		} finally{
			SystemContext.removeOrder();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeRealPath();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		try {
			pageSize = Integer.parseInt(arg0.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 15;
		}
	}

}
