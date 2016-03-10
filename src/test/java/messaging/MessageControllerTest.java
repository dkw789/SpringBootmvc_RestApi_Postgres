package messaging;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class})

public class MessageControllerTest extends abstractControllerTestClass{
	@Autowired
	private MessageController MessagingController;

	@Before 
	public void setUp(){
		super.setUp();
	}
	
	@Test
	public void testGet() throws Exception{
		String uri ="/Message/greeting";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		
		Assert.assertEquals("failure - expected HTTP status", 200, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
	}

	@Test

	public void testGetAll() throws Exception {

		String uri ="/Message";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
	}


	@Test
	@DatabaseSetup("classpath:datasets/SampleData.xml")
	public void testGetIndividual() throws Exception {
		String uri ="/Message/1";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);


	}

	@Test
	public void testCreate() throws Exception {

	}

	@Test
	public void testDelete() throws Exception {

	}

	@Test
	public void testUpdate() throws Exception {

	}

	@Test
	public void testGreetingForm() throws Exception {

	}

	@Test
	public void testGreetingSubmit() throws Exception {

	}

	@Test
	public void testShowAllMessages() throws Exception {

	}
}
