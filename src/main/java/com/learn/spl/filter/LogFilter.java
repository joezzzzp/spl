package com.learn.spl.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author created by zzz at 2019/10/29 10:03
 */
@Component
@WebFilter
public class LogFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    private ObjectMapper objectMapper;

    private ThreadLocal<RequestInfo> requestInfoThreadLocal = ThreadLocal.withInitial(RequestInfo::new);

    @Value("${app.service.name}")
    private String appName;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestInfo requestInfo = requestInfoThreadLocal.get();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        MultiReadHttpServletRequest multiReadHttpServletRequest = new MultiReadHttpServletRequest(httpServletRequest);
        MultiReadHttpServletResponse multiReadHttpServletResponse = new MultiReadHttpServletResponse(httpServletResponse);
        requestInfo.setAppName(appName);
        requestInfo.setRequestUrl(httpServletRequest.getRequestURI());
        requestInfo.setMethod(HttpMethod.resolve(httpServletRequest.getMethod()));
        requestInfo.setParams(httpServletRequest.getParameterMap());
        if (multiReadHttpServletRequest.getBody().length > 0) {
            requestInfo.setRequestBody(objectMapper.readValue(multiReadHttpServletRequest.getBody(), Map.class));
        }
        try {
            chain.doFilter(multiReadHttpServletRequest, multiReadHttpServletResponse);
        } catch (Exception e) {

        } finally {
            if (multiReadHttpServletResponse.isNeedRecord()) {
                byte[] responseData = multiReadHttpServletResponse.getByteArrayOutputStream().toByteArray();
                if (responseData.length > 0) {
                    requestInfo.setResponseBody(objectMapper.readValue(responseData, Map.class));
                }
                logger.info(objectMapper.writeValueAsString(requestInfo));
            }
            requestInfoThreadLocal.remove();
        }
    }

    @Override
    public void destroy() {

    }

    public class RequestInfo {

        private String appName;

        private String requestUrl;

        private HttpMethod method;

        private Map<String, String[]> params;

        private Map requestBody;

        private Map responseBody;

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getRequestUrl() {
            return requestUrl;
        }

        public void setRequestUrl(String requestUrl) {
            this.requestUrl = requestUrl;
        }

        public HttpMethod getMethod() {
            return method;
        }

        public void setMethod(HttpMethod method) {
            this.method = method;
        }

        public Map<String, String[]> getParams() {
            return params;
        }

        public void setParams(Map<String, String[]> params) {
            this.params = params;
        }

        public Map getRequestBody() {
            return requestBody;
        }

        public void setRequestBody(Map requestBody) {
            this.requestBody = requestBody;
        }

        public Map getResponseBody() {
            return responseBody;
        }

        public void setResponseBody(Map responseBody) {
            this.responseBody = responseBody;
        }
    }
}
