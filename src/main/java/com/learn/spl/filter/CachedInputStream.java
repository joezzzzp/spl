package com.learn.spl.filter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author created by zzz at 2019/10/29 10:05
 */

public class CachedInputStream extends ServletInputStream {

    private ByteArrayInputStream byteArrayInputStream;

    public CachedInputStream(ByteArrayInputStream byteArrayInputStream) throws IOException {
        this.byteArrayInputStream = byteArrayInputStream;
    }

    @Override
    public int read() throws IOException {
        return byteArrayInputStream.read();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReadListener(ReadListener listener) {

    }
}
