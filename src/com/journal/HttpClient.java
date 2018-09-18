package com.journal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpClient {
	
	private static final int TIME_OUT = 6000;
	
	public String get(String server) throws IOException{
		return service("GET", server, null, null);
	}
	
	public String post(String server, String request) throws IOException{
		return service("POST", server, request, new HashMap<String, String>());
	}
	
	private String service(String method, String server, String request, Map<String, String> headers) throws IOException{
		HttpURLConnection conn = connect(method, server, headers);
		StringBuffer response = new StringBuffer();
		if("POST".equals(method)){
			OutputStream os = conn.getOutputStream();
			if(os != null){
				PrintWriter out	= new PrintWriter(new BufferedWriter(new OutputStreamWriter(os, "UTF-8")));
				if (request != null){
					out.print(request);
				}
				out.flush();
			}			
		}

		InputStream stream = null;
		HttpURLConnection c = (HttpURLConnection)conn;

		if(c.getResponseCode()==200){
			stream = c.getInputStream();
		}else{
			stream = c.getErrorStream();
		}
		
		if(stream!=null){
			BufferedReader in = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
			
			String temp;
			while ((temp = in.readLine()) != null) {
				response.append(temp);
				response.append("\n");
			}
			in.close();					
		}	
		return response.toString();
	}

	private HttpURLConnection connect(String method, String endpoint, Map<String, String> headers) throws IOException {
		HttpURLConnection conn = null;
		//headers.put("Accept-Encoding", "gzip");
		URL url = new URL(endpoint);

		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};

		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		// Create a trust manager that does not validate certificate chains

		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		SSLContext sc = null;
		try {
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, null);
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}

		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(method);

		conn.setConnectTimeout(TIME_OUT);
		conn.setDoOutput(true);
		conn.setUseCaches(false);

		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) "
						+ "Chrome/23.0.1271.97 Safari/537.11");
		if (headers != null) {
			for (String key : headers.keySet()) {
				conn.setRequestProperty(key, headers.get(key));
			}
		}

		conn.connect();
		return conn;
	}
}
