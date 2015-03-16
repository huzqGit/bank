package com.bank.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Constants;
import com.bank.beans.User;

public class LoginFilter implements Filter {

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		User user = (User) session.getAttribute(Constants.SESSION_AUTH_USER);

		if (user == null) {
			if (uri.endsWith(".jsp") || uri.endsWith(".do")) {
				if (!(uri.matches(".*login\\.jsp||.*login\\.do"))) {
					response.sendRedirect(contextPath + "/jsp/login/login.jsp");
					return;
				}
			}
		}

		filterChain.doFilter(sRequest, sResponse);
	}

	public void init(FilterConfig fc) throws ServletException {

	}

	public void destroy() {
	}
}
