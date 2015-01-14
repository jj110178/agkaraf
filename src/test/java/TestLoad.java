import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ops4j.web.samples.helloworld.servlet3.internal.AmazonSESSample;


public class TestLoad {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
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
