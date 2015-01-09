package org.ops4j.web.samples.helloworld.servlet3.internal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.pinsightmedia.adgateway.dsp.admarvel.AdMarvelProperties;


@WebServlet(name = "helloWorld", urlPatterns = {"/hello", "/hello/filter"})
public class HelloWorld extends HttpServlet {

	/**
	 * 
	 */
	private static final String BUCKET_NAME = "ad-gateway-dev";//System.getProperty("aws.s3.bucket");

	private static final long serialVersionUID = 1L;
	//private static AdMarvelPropertiesXXXX props = AdMarvelPropertiesXXXX.getInstance();
	private static AdMarvelProperties props = AdMarvelProperties.getInstance();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final PrintWriter writer = response.getWriter();
		writer.println("<head>");
		writer.println("<link rel=\"stylesheet\" href=\""
				+ request.getServletContext().getContextPath()
				+ "/css/content.css\">");
		writer.println("</head>");
		writer.println("<body align='center'>");
		writer.println("<h1>Hello World</h1>");
		writer.println("<img src='"
				+ request.getServletContext().getContextPath()
				+ "/images/logo.png' border='0'/>");
		writer.println("<h1>from WEB-INF/classes</h1>");
		writer.println("</body>");
		//props.load("cassandra.properties");
		props.hello("Jeff");
	}
	
}
