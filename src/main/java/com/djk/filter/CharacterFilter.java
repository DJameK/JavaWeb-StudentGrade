package com.djk.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements Filter{

    private String encoding;

    public void destroy() {
        this.encoding =null;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (encoding != null) {
            request.setCharacterEncoding(this.encoding);
            response.setContentType("text/html;charset=" + encoding);
        }

        chain.doFilter(request, response);

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

}
