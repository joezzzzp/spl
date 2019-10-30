package com.learn.spl.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spl.NeedLog;
import com.learn.spl.entity.ResponseResult;
import com.learn.spl.filter.MultiReadHttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author created by zzz at 2019/10/29 17:05
 */
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    private static final ThreadLocal<Boolean> needRecord = ThreadLocal.withInitial(() -> false);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (response instanceof MultiReadHttpServletResponse
                && handler instanceof HandlerMethod
                && ((HandlerMethod) handler).hasMethodAnnotation(NeedLog.class)) {
            ((MultiReadHttpServletResponse) response).setNeedRecord(true);
            needRecord.set(true);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            MultiReadHttpServletResponse multiReadHttpServletResponse = (MultiReadHttpServletResponse) response;
            multiReadHttpServletResponse.setNeedRecord(true);
            multiReadHttpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseResult exResult = ResponseResult.failed("SERVER_INTERNAL_ERROR", "Unknown error");
            ResponseResult exLog = ResponseResult.failed("SERVER_INTERNAL_ERROR", "Unknown error", ex);
            objectMapper.writeValue(multiReadHttpServletResponse.getOriginOutputStream(), exResult);
            objectMapper.writeValue(multiReadHttpServletResponse.getByteArrayOutputStream(), exLog);
        }
        needRecord.set(false);
    }
}
