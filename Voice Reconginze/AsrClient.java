package com.unisound.asr.webapi.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ASR webAPI 示例程序
 * 
 * @author unisound
 * @date 2015年1月27日
 */
public class AsrClient {
	
	private String mWebApiUrl;

	public AsrClient(String webApiUrl) {
		this.mWebApiUrl = webApiUrl;
	}

	public String parseAudio(String fileName) {
		
		// 云知声开放平台网站上申请应用后获得的 appKey
		// 云知声开放平台网站上开发者的用户名
		String userId = "zw3d2lo7tchdymekq4pqpxujn3u4gi6lvabaulyh";
		// 标记请求来源的标识，如用户所设备序列号 (SN)，IMEI，MAC地址等
		String deviceId = "fduhackathon2017";

		HttpURLConnection conn = null;
		FileInputStream inputStream = null;
		
		try {
			URL url = new URL(this.mWebApiUrl + "?appkey=" + userid + "&userid=" + userId + "&id=" + deviceId);
			conn = (HttpURLConnection) url.openConnection();
			// 上传的语音数据流格式
			conn.setRequestProperty("Content-Type", "audio/x-wav;codec=pcm;bit=16;rate=16000");
			// 识别结果返回的格式
			conn.setRequestProperty("Accept", "text/plain");
			// 语音数据流记录的语种及识别结果的语种
			conn.setRequestProperty("Accept-Language", "zh_CN");
			// 编码格式
			conn.setRequestProperty("Accept-Charset", "utf-8");
			// 指定ASR识别的引擎
			conn.setRequestProperty("Accept-Topic", "general");

			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			OutputStream out = conn.getOutputStream();
			
			// 上传语音数据
			byte[] buffer = new byte[640];
			inputStream = new FileInputStream(new File(fileName));
			int len = -1;
			while ((len = inputStream.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			inputStream.close();
			inputStream = null;
			out.flush();
			out.close();

			// 获取结果
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader resultReader = new BufferedReader(new InputStreamReader(
						conn.getInputStream(), "utf-8"));
				String line = "";
				String result = "";
				while ((line = resultReader.readLine()) != null) {
					result += line;
				}
				resultReader.close();
				return result;
			}
			else {
				System.out.println("识别失败: ResponseCode=" + conn.getResponseCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (conn != null) {
				conn.disconnect();
			}
			
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {

		AsrClient client = new AsrClient("http://api.hivoice.cn/USCService/WebApi");
		String result = client.parseAudio("fdu.m4a");

		if(result != null) {
			System.out.println("识别结果:\n" + result);
		}
	}
}