package com.learn.spl.filter;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author created by zzz at 2019/10/29 10:38
 */

public class MultiReadHttpServletResponse extends HttpServletResponseWrapper {

    private ByteArrayOutputStream byteArrayOutputStream;

    private boolean needRecord = false;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response The response to be wrapped
     * @throws IllegalArgumentException if the response is null
     */
    public MultiReadHttpServletResponse(HttpServletResponse response) {
        super(response);
        this.byteArrayOutputStream = new ByteArrayOutputStream();
    }

    public void setNeedRecord(boolean needRecord) {
        this.needRecord = needRecord;
    }

    public boolean isNeedRecord() {
        return needRecord;
    }

    public ByteArrayOutputStream getByteArrayOutputStream() {
        return byteArrayOutputStream;
    }

    public ServletOutputStream getOriginOutputStream() throws IOException {
        return super.getOutputStream();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (needRecord) {
            return new CacheOutputStream(super.getOutputStream(), byteArrayOutputStream);
        }
        return super.getOutputStream();
    }
}
