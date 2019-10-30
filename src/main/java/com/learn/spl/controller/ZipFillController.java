package com.learn.spl.controller;

import com.learn.spl.entity.ResponseResult;
import com.sun.xml.internal.ws.encoding.ContentType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author created by zzz at 2019/10/25 10:01
 */

@RestController
@RequestMapping("/file")
public class ZipFillController {

    @RequestMapping("/zipFile")
    public ResponseResult zipFile(HttpServletResponse response) {
        String dir = "D:\\pythonProject\\requestUtils\\";
        String[] filePath = new String[] { "data.py", "logger.py", "request.py" };
        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();
            if (new Random().nextInt(2) > 0) {
                response.setHeader("errorCode", "DOWNLOAD_FILE_FAILED");
                response.setHeader("errorMessage", URLEncoder.encode("无法下载文件", "UTF-8"));
                response.setContentType("application/json;charset=utf8");
                throw new RuntimeException("下载文件随机错误");
//                return ResponseResult.failed("DOWNLOAD_FILE_FAILED", "无法下载文件");
            }
            ZipOutputStream zipOutputStream = new ZipOutputStream(servletOutputStream);
            for (String path : filePath) {
                writeEntry(dir, path, zipOutputStream);
            }
            response.setHeader("errorCode", "SUCCESS");
            response.setHeader("errorMessage",  URLEncoder.encode("下载成功", "UTF-8"));
            response.setContentType("application/x-zip-compressed");
            zipOutputStream.close();
//            servletOutputStream.close();
        } catch (IOException e) {
        }
        return null;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> downloadFile() {
        String dir = "D:\\pythonProject\\requestUtils\\";
        String[] filePath = new String[] { "data.py", "logger.py", "request.py" };
        try {
            if (new Random().nextInt(2) > 0) {
                HttpHeaders failedHeader = new HttpHeaders();
                failedHeader.setContentType(MediaType.APPLICATION_JSON);
                failedHeader.add("errorCode", "DOWNLOAD_FILE_FAILED");
                failedHeader.add("errorMessage", URLEncoder.encode("无法下载文件", "UTF-8"));
                String result = "{\"errorCode\": \"DOWNLOAD_FILE_FAILED\", \"errorMessage\": \"无法下载文件\"}";
                byte[] resultByte = result.getBytes(Charset.forName("UTF-8"));
                return new ResponseEntity<>(resultByte, failedHeader, HttpStatus.OK);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            for (String path : filePath) {
                writeEntry(dir, path, zipOutputStream);
            }
            zipOutputStream.close();
            byte[] resultBytes = byteArrayOutputStream.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/x-zip-compressed"));
            headers.add("errorCode", "SUCCESS");
            headers.add("errorMessage",  URLEncoder.encode("下载成功", "UTF-8"));
            ResponseEntity.ok().headers(headers).body(resultBytes);
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(resultBytes, headers, HttpStatus.OK);
            byteArrayOutputStream.close();
            return responseEntity;
        } catch (IOException e) {

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void writeEntry(String dir, String name, ZipOutputStream zipOutputStream){
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(dir + name))) {
            zipOutputStream.putNextEntry(new ZipEntry(name));
            int length;
            byte[] buffer = new byte[1024];
            while ((length = bufferedInputStream.read(buffer)) > -1) {
                zipOutputStream.write(buffer, 0, length);
            }
        } catch (Exception e) {
        }
    }
}
