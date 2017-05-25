package com.plugins.crawler.executor;

import com.alibaba.fastjson.JSON;
import com.plugins.crawler.bean.Response;
import org.apache.http.HttpHost;
import org.apache.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by david.yun on 2017/5/25.
 */
public class CrawlerExecutor {
    private Logger log = Logger.getLogger(this.getClass());

    public static void main(String[] args) {
        CrawlerExecutor crawlerExecutor = new CrawlerExecutor();
        CrawlerConfig config = new CrawlerConfig().setUrl("https://www.google.com").setReadTimeout(30000).setProxy(new HttpHost("192.168.1.175", 1080, "http"));
        crawlerExecutor.start(config);
    }

    public void start(CrawlerConfig crawlerConfig) {
        RestTemplate RestClient = RestClientConfig.GenerateRestClient(crawlerConfig);
        Arrays.stream(HttpMethod.values()).forEach(httpMethod -> {
            Response response = RestClientConfig.request(RestClient, crawlerConfig.getUrl(), httpMethod);
            System.out.println(JSON.toJSON(response));
        });
    }

}
