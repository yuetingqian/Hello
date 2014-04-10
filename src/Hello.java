import hello.Greeter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import com.thoughtworks.xstream.XStream;



public class Hello {
	
	
	public static void main(String[] args) throws HttpException, IOException {
		XStream xstream = new XStream();
		xstream.alias("request", Request.class);
		
		Request req = new Request();
		req.setA(1);
		req.setB("fksfjksa");
		String xml = xstream.toXML(req);
		System.out.println(xml);
		
		
		
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
		System.out.println("Hello world!");

		String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
				+ "<soap12:Body>"
				+ " <getCountryCityByIp xmlns=\"http://WebXml.com.cn/\">"
				+ "    <theIpAddress>219.137.167.157</theIpAddress>"
				+ "   </getCountryCityByIp>" + "  </soap12:Body>"
				+ "</soap12:Envelope>";
		PostMethod postMethod = new PostMethod("http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx");
		byte[] b = soapRequestData.getBytes("utf-8");
		InputStream is = new ByteArrayInputStream(b, 0, b.length);
		RequestEntity re = new InputStreamRequestEntity(is, b.length, 
				"application/soap+xml; charset=utf-8");
		postMethod.setRequestEntity(re);
		HttpClient httpClient = new HttpClient();
		int statusCode = httpClient.executeMethod(postMethod);
		System.out.println(statusCode);
		String soapResponseData = postMethod.getResponseBodyAsString();
		System.out.println(soapResponseData);
	}
}