package com.plugins.crawler.executor;

import com.plugins.crawler.bean.Response;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by david.yun on 2017/5/25.
 */
public class RestClientConfig {
    private static Logger logger = Logger.getLogger(RestClientConfig.class);

    public static RestTemplate GenerateRestClient(CrawlerConfig crawlerConfig) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(clientHttpRequestFactory(crawlerConfig));
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }

    public static HttpComponentsClientHttpRequestFactory clientHttpRequestFactory(CrawlerConfig crawlerConfig) {
        System.setProperty("jsse.enableSNIExtension", "false");
        System.setProperty("jdk.tls.ephemeralDHKeySize", "2048");
        try {
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            httpClientBuilder.setProxy(crawlerConfig.getProxy());
            httpClientBuilder.setDefaultHeaders(crawlerConfig.getHeaders());
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (arg0, arg1) -> true).build();
            httpClientBuilder.setSSLContext(sslContext);
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                    new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2", "SSLv2Hello"},
                    new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
                            "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
                            "TLS_RSA_WITH_AES_256_CBC_SHA256",
                            "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384",
                            "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384",
                            "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
                            "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256",
                            "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                            "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                            "TLS_RSA_WITH_AES_256_CBC_SHA",
                            "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA",
                            "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA",
                            "TLS_DHE_RSA_WITH_AES_256_CBC_SHA",
                            "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
                            "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
                            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
                            "TLS_RSA_WITH_AES_128_CBC_SHA256",
                            "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256",
                            "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256",
                            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
                            "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256",
                            "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                            "TLS_RSA_WITH_AES_128_CBC_SHA",
                            "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",
                            "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",
                            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
                            "TLS_DHE_DSS_WITH_AES_128_CBC_SHA",
                            "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA",
                            "TLS_ECDHE_RSA_WITH_RC4_128_SHA",
                            "SSL_RSA_WITH_RC4_128_SHA",
                            "TLS_ECDH_ECDSA_WITH_RC4_128_SHA",
                            "TLS_ECDH_RSA_WITH_RC4_128_SHA",
                            "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                            "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                            "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                            "TLS_RSA_WITH_AES_256_GCM_SHA384",
                            "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384",
                            "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384",
                            "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384",
                            "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384",
                            "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                            "TLS_RSA_WITH_AES_128_GCM_SHA256",
                            "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256",
                            "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256",
                            "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
                            "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256",
                            "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
                            "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
                            "SSL_RSA_WITH_3DES_EDE_CBC_SHA",
                            "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA",
                            "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA",
                            "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA",
                            "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA",
                            "SSL_RSA_WITH_RC4_128_MD5",
                            "TLS_EMPTY_RENEGOTIATION_INFO_SCSV",
                            "TLS_DH_anon_WITH_AES_256_GCM_SHA384",
                            "TLS_DH_anon_WITH_AES_128_GCM_SHA256",
                            "TLS_DH_anon_WITH_AES_256_CBC_SHA256",
                            "TLS_ECDH_anon_WITH_AES_256_CBC_SHA",
                            "TLS_DH_anon_WITH_AES_256_CBC_SHA",
                            "TLS_DH_anon_WITH_AES_128_CBC_SHA256",
                            "TLS_ECDH_anon_WITH_AES_128_CBC_SHA",
                            "TLS_DH_anon_WITH_AES_128_CBC_SHA",
                            "TLS_ECDH_anon_WITH_RC4_128_SHA",
                            "SSL_DH_anon_WITH_RC4_128_MD5",
                            "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA",
                            "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA",
                            "TLS_RSA_WITH_NULL_SHA256",
                            "TLS_ECDHE_ECDSA_WITH_NULL_SHA",
                            "TLS_ECDHE_RSA_WITH_NULL_SHA",
                            "SSL_RSA_WITH_NULL_SHA",
                            "TLS_ECDH_ECDSA_WITH_NULL_SHA",
                            "TLS_ECDH_RSA_WITH_NULL_SHA",
                            "TLS_ECDH_anon_WITH_NULL_SHA",
                            "SSL_RSA_WITH_NULL_MD5",
                            "SSL_RSA_WITH_DES_CBC_SHA",
                            "SSL_DHE_RSA_WITH_DES_CBC_SHA",
                            "SSL_DHE_DSS_WITH_DES_CBC_SHA",
                            "SSL_DH_anon_WITH_DES_CBC_SHA",
                            "SSL_RSA_EXPORT_WITH_RC4_40_MD5",
                            "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5",
                            "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA",
                            "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA",
                            "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA",
                            "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA",
                            "TLS_KRB5_WITH_RC4_128_SHA",
                            "TLS_KRB5_WITH_RC4_128_MD5",
                            "TLS_KRB5_WITH_3DES_EDE_CBC_SHA",
                            "TLS_KRB5_WITH_3DES_EDE_CBC_MD5",
                            "TLS_KRB5_WITH_DES_CBC_SHA",
                            "TLS_KRB5_WITH_DES_CBC_MD5",
                            "TLS_KRB5_EXPORT_WITH_RC4_40_SHA",
                            "TLS_KRB5_EXPORT_WITH_RC4_40_MD5",
                            "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA",
                            "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5"},
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                    .<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslConnectionSocketFactory)
                    .build();
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            poolingHttpClientConnectionManager.setMaxTotal(200);
            poolingHttpClientConnectionManager.setDefaultMaxPerRoute(20);
            httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
            httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(crawlerConfig.getRetryTimes(), true));
            HttpClient httpClient = httpClientBuilder.build();
            HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            clientHttpRequestFactory.setConnectTimeout(crawlerConfig.getConnectTimeout());
            clientHttpRequestFactory.setReadTimeout(crawlerConfig.getReadTimeout());
            clientHttpRequestFactory.setConnectionRequestTimeout(2000);
            return clientHttpRequestFactory;
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Response request(RestTemplate RestClient, String url, HttpMethod httpMethod) {
        Response response = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Object> formEntity = new HttpEntity<>("", headers);
            ResponseEntity<String> responseEntity = RestClient.exchange(url, httpMethod, formEntity, String.class);
            response = GenerateResponse(responseEntity, null);
        } catch (HttpClientErrorException e) {
            response = GenerateResponse(null, e);
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
        return response;
    }

    private static Response GenerateResponse(ResponseEntity<String> responseEntity, HttpClientErrorException httpClientErrorException) {
        Response response = new Response();
        if (responseEntity != null) {
            response.setStatusCodeValue(responseEntity.getStatusCodeValue());
            response.setBody(responseEntity.getBody());
            response.setStatusCode(responseEntity.getStatusCode());
            response.setHttpHeaders(responseEntity.getHeaders());
        }
        if (httpClientErrorException != null) {
            response.setStatusCodeValue(httpClientErrorException.getRawStatusCode());
            response.setBody(httpClientErrorException.getResponseBodyAsString());
            response.setStatusCode(httpClientErrorException.getStatusCode());
            response.setHttpHeaders(httpClientErrorException.getResponseHeaders());
        }
        return response;
    }
}
