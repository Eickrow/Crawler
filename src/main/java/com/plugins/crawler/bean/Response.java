package com.plugins.crawler.bean;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

/**
 * Created by david.yun on 2017/5/25.
 */
public class Response {
    private int statusCodeValue;
    private String body;
    private HttpStatus statusCode;
    private HttpHeaders httpHeaders;

    public int getStatusCodeValue() {
        return statusCodeValue;
    }

    public void setStatusCodeValue(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }
}
