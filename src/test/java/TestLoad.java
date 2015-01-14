import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ops4j.web.samples.helloworld.servlet3.internal.AmazonSESSample;
import org.ops4j.web.samples.helloworld.servlet3.internal.HelloWorld;


public class TestLoad {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		HelloWorld hello = new HelloWorld();
		try {
			hello.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testEmail() {
		try {
			AmazonSESSample sendEmail = new AmazonSESSample();			
			sendEmail.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

}
