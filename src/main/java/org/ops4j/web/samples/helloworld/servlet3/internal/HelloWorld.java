package org.ops4j.web.samples.helloworld.servlet3.internal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "helloWorld", urlPatterns = {"/hello", "/hello/filter"})
public class HelloWorld extends HttpServlet {

	/**
	 * 
	 */
	private static final String BUCKET_NAME = "ad-gateway-dev";//System.getProperty("aws.s3.bucket");

	private static final long serialVersionUID = 1L;
	//private static AdMarvelPropertiesXXXX props2 = AdMarvelPropertiesXXXX.getInstance();
	//private static AdMarvelProperties props = AdMarvelProperties.getInstance();
	private String s3filename = "cassandra.properties";
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
		//props2.load("cassandra.properties");
		//writer.println("Test " + props.hello("Jeff"));
		load();
	}
	
	public void load() throws IOException{
		
		
		System.out.println("Sending email using SES ");
        //AmazonS3Client s3Client = new AmazonS3Client();
		AmazonSESSample se = new AmazonSESSample();
		se.send();
        System.out.println("Amazon SES Done ");
        /*try (S3Object object = s3Client.getObject(BUCKET_NAME, s3filename)) {
            if (object != null) {            	
            	System.out.println("Initialize here Amazon S3 1");
                // create a temporary Properties object so we don't have to block for reads while downloading from s3
                Properties newProps = new Properties();
                newProps.load(object.getObjectContent());
                //this.putAll(newProps);
                //this.filename = s3filename;
                //S3PropertyRegistry.getInstance().register(this);
                System.out.println("Initialize here Amazon S3 2");
            }
        } catch (AmazonClientException ace) {
        	System.out.println("Exception caught when loading file: {} " + s3filename);
            throw ace;
        }*/
	}
	
}
