package com.books.token.util;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientUtils {

	public interface ResultListener {
		public void onConnectionPoolTimeoutError();
	}

	// 传输超时时间，默认30秒
	private static final int socketTimeout = 30000;

	// 连接超时时间，默认30秒
	private static final int connectTimeout = 30000;

	// 请求器的配置
	private static RequestConfig requestConfig;

	// HTTP请求器
	private static CloseableHttpClient httpClient;

	private HttpClientUtils() {
	}

	/**
	 * 发送post请求
	 *
	 * @param url API地址
	 * @param obj 请求参数对象
	 * @return 响应结果
	 */

	public static String sendPost(String url, Object obj) {

		httpClient = HttpClients.custom().build();
		// 根据默认超时限制初始化requestConfig
		requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout)
				.build();

		String result = null;

		HttpPost httpPost = new HttpPost(url);

		String postData = JSONObject.toJSONString(obj);

		log.info("url:{},请求参数:{}", url, postData);

		StringEntity postEntity = new StringEntity(postData, "UTF-8");
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.setEntity(postEntity);

		// 设置请求器的配置
		httpPost.setConfig(requestConfig);

		log.info("executing request" + httpPost.getRequestLine());

		try {
			HttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity, "UTF-8");

			log.info("response result:{}", result);
		} catch (Exception e) {
			log.error(String.format("http post throw Exception:%s", e.getMessage()));
		} finally {
			httpPost.abort();
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				log.error(ExceptionUtils.getStackTrace(e));
			}
		}
		return result;
	}

}
