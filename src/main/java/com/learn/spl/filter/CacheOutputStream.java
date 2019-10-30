package com.learn.spl.filter;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author created by zzz at 2019/10/29 10:41
 */

public class CacheOutputStream extends ServletOutputStream {

    private ByteArrayOutputStream byteArrayOutputStream;

    private ServletOutputStream originServletOutputStream;

    public CacheOutputStream(ServletOutputStream originServletOutputStream, ByteArrayOutputStream byteArrayOutputStream) {
        this.originServletOutputStream = originServletOutputStream;
        this.byteArrayOutputStream = byteArrayOutputStream;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener listener) {

    }

    @Override
    public void write(int b) throws IOException {
        originServletOutputStream.write(b);
        byteArrayOutputStream.write(b);
    }

    @Override
    public void flush() throws IOException {
        originServletOutputStream.flush();
        byteArrayOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        originServletOutputStream.close();
        byteArrayOutputStream.close();
    }
}
