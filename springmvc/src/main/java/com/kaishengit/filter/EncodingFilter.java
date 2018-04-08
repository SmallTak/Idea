package com.kaishengit.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter extends AbstractFilter {

//    String encoding = "utf-8";
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        String encoding = config.getInitParameter("encoding");
//        if(StringUtils.isNotEmpty(encoding)) {
//            this.encoding = encoding;
//        }
//    }
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//        req.setCharacterEncoding(encoding);
//        resp.setCharacterEncoding(encoding);
//        chain.doFilter(req, resp);
//    }

}
