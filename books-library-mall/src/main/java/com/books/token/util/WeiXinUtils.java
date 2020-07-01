package com.books.token.util;

import com.alibaba.fastjson.JSONObject;
import com.books.token.consts.ConfigConsts;
import com.books.token.weixin.mp.aes.WXBizMsgCrypt;
import com.books.token.weixin.mp.model.ResAccessToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@Slf4j
public class WeiXinUtils {

	private static final String sToken = "xxxx";
	private static final String sCorpID = "wxcbd0f9329f0d5e73";
	private static final String sEncodingAESKey = "ArNefiBedn2w8cKbf0OO1QeiQEZ8FL5uiDbGSWWWFO1";
	// private static final String corpSecret =
	// "slhjw29Nqat3ySmfIfNGbzR2FHb-STRyHyZFpM3alL49X7MoZakAR1uV97Q7pv-7";

	public static String validate(HttpServletRequest request) throws Exception {

		WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);

		String msg_signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		return wxcpt.verifyUrl(msg_signature, timestamp, nonce, echostr);

	}

	/**
	 * 获报文字符串
	 * 
	 * @param request
	 * @return
	 */
	public static String getStringInputStream(HttpServletRequest request) {

		InputStreamReader in = null;

		BufferedReader breader = null;

		String str = null;

		StringBuffer strb = new StringBuffer();

		try {

			in = new InputStreamReader(request.getInputStream(), "UTF-8");

			breader = new BufferedReader(in);

			while (null != (str = breader.readLine())) {
				strb.append(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (null != breader) {

				try {
					breader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return strb.toString();
	}

	public static String getEncryptStrForReturn(HttpServletRequest request) {

		String msg_signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		try {
			return (new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID)).decryptMsg(msg_signature, timestamp, nonce,
					getStringInputStream(request));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param requestStr 请求对应的明文字符串
	 * @param tagName    CDATA标签属性名
	 * @return
	 * 
	 */
	public static String getXMLCDATA(String requestStr, String tagName) {

		// TODO 暂时用官方的，后续可以优化读取xml的方式
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(requestStr);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();

			return root.getElementsByTagName(tagName).item(0).getTextContent();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ResAccessToken getAccessToken(String formatUrl, String appId, String appSecret) {
		ResAccessToken resAccessToken = null;
		URL url = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		InputStreamReader reader = null;
		BufferedReader breader = null;
		StringBuffer strb = new StringBuffer();
		try {
			// "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+sCorpID+"&corpsecret="+corpSecret
			url = new URL(String.format(formatUrl, appId, appSecret));
			conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			in = conn.getInputStream();
			reader = new InputStreamReader(in);
			breader = new BufferedReader(reader);
			String str = null;
			while (null != (str = breader.readLine())) {
				strb.append(str);
			}
			log.info("AccessToken Response:{}", strb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (breader != null) {
					breader.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				log.error(ExceptionUtils.getStackTrace(e));
			}
			conn.disconnect();
		}
		resAccessToken = JSONObject.parseObject(strb.toString(), ResAccessToken.class);
		return resAccessToken;
	}

	public static String getEncryptStrForReturn(String str) {
		String timestamp = new Date().getTime() + "";
		String nonce = new Date().getTime() + "";
		try {
			return (new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID)).encryptMsg(str, timestamp, nonce);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResAccessToken getTicketWithAccessToken(String url) {
		String responseStr = sendGET(url);
		log.info("requestUrl:{},responseStr:{}", url, responseStr);
		JSONObject requestJson = JSONObject.parseObject(responseStr);
		ResAccessToken token = new ResAccessToken();
		token.setAccess_token(requestJson.getString("ticket"));
		token.setExpires_in(requestJson.getIntValue("expires_in"));
		token.setErrcode(requestJson.getIntValue("errcode"));
		return token;
	}

	public static String sendGET(String url) {
		StringBuffer strb = new StringBuffer();
		InputStream inputStream = null;
		BufferedReader in = null;
		HttpURLConnection httpURLConnection = null;
		try {
			httpURLConnection = getHttpURLConnection(url);
			inputStream = httpURLConnection.getInputStream();
			in = new BufferedReader(new InputStreamReader(inputStream, ConfigConsts.DEFAULT_CHARSET));
			String lines = "";
			while ((lines = in.readLine()) != null) {
				strb.append(lines);
			}
		} catch (IOException e) {
			log.error(ExceptionUtils.getStackTrace(e));
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				log.error(ExceptionUtils.getStackTrace(e));
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
			}
		}
		return strb.toString();
	}

	private static HttpURLConnection getHttpURLConnection(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		return httpURLConnection;
	}

}
