package com.learn.spl.filter;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author created by zzz at 2019/10/29 10:10
 */

public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

    private byte[] body;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public MultiReadHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        InputStream inputStream = request.getInputStream();
        body = StreamUtils.copyToByteArray(inputStream);
        inputStream.close();
    }

    public byte[] getBody() {
        return body;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedInputStream(new ByteArrayInputStream(body));
    }
}
