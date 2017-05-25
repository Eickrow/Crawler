package com.plugins.crawler.executor;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;

import java.util.List;
import java.util.Map;

/**
 * Created by david.yun on 2017/5/25.
 */
public class CrawlerConfig {
    private String url;
    private int retryTimes = 2;
    private int connectTimeout = 5000;
    private int readTimeout = 5000;
    private HttpHost proxy;
    private List<Header> headers;

    public String getUrl() {
        return url;
    }

    public CrawlerConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public CrawlerConfig setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
        return this;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public CrawlerConfig setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public CrawlerConfig setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public HttpHost getProxy() {
        return proxy;
    }

    public CrawlerConfig setProxy(HttpHost proxy) {
        this.proxy = proxy;
        return this;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public CrawlerConfig addHeaders(String key, String object) {
        this.headers.add(new BasicHeader(key, object));
        return this;
    }
}
