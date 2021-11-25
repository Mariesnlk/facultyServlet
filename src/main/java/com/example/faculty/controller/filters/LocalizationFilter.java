package com.example.faculty.controller.filters;

import com.example.faculty.utils.CookiesUtils;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;


public class LocalizationFilter implements Filter {

    private final Logger LOGGER = Logger.getLogger(LocalizationFilter.class);
    private String defaultBundle;
    private String locale;

    @Override
    public void init(FilterConfig filterConfig) {
        defaultBundle = filterConfig.getInitParameter("bundle");
        locale = filterConfig.getInitParameter("locale");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String localeParameter = request.getParameter("locale");
        LOGGER.info("set locale Filter " + localeParameter);

        locale = localeParameter != null
                ? localeParameter
                : CookiesUtils.readCookie(httpRequest, "locale") != null
                ? (String) CookiesUtils.readCookie(httpRequest, "locale")
                : this.locale;
        Config.set(httpRequest.getSession(), Config.FMT_LOCALE, locale);

        httpResponse.addCookie(new Cookie(CookiesUtils.LOCALE, locale));

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
