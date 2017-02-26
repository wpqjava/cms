package org.wpq.cms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.wpq.cms.model.CmsException;
import org.wpq.cms.model.User;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		HandlerMethod hm = (HandlerMethod) handler;
		User user = (User) session.getAttribute("loginUser");
		if(user==null) {
			/*String url = request.getRequestURL()
					.substring(0,request.getRequestURL()
							.indexOf(request.getContextPath()))+request.getContextPath()+"/login";
			sendLogin(response,url);
			System.out.println(url);*/
			response.sendRedirect(request.getContextPath()+"/login");
		}else{
			if(((int)session.getAttribute("isAdmin"))!=1){
				Set<String> userAuth = (Set<String>) session.getAttribute("userAuth"); 
				String name = hm.getBean().getClass().getName()+"."+hm.getMethod().getName();
				if(!userAuth.contains(name))throw new CmsException("没有权限");
			}
		}
		return super.preHandle(request, response, handler);
	}

	private void sendLogin(HttpServletResponse response, String url) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><script>window.open ('"+url+"','_top')</script></html>");  
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
