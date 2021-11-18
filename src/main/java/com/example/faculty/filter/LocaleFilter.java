package com.example.faculty.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Servlet Filter implementation class LocaleFilter
 */
@WebFilter("/LocaleFilter")
public class LocaleFilter implements Filter {

	private String locales;
	private String defaultLocale;

	public LocaleFilter() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("++++++++++++++++++++++FILTER");

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();

		String chooseLocale = null;

		String[] arLocales = this.locales.split(",");

		session.setAttribute("locales", arLocales);

		if (request.getParameter("lang") != null) {
			chooseLocale = request.getParameter("lang");
		}

		if (chooseLocale != null) {
				session.setAttribute("locale", chooseLocale);
		}

		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		locales = fConfig.getInitParameter("locales");
		defaultLocale = fConfig.getInitParameter("defaultLocale");
	}
}
