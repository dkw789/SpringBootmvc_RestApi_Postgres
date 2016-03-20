package messaging;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
		Assert.assertTrue("{\"id\":1,\"userName\":\"donny\",\"userName2\":\"houde\",\"createdAt\":null,\"messageID\":\"1\",\"location\":\"123\",\"latitude\":\"321\",\"longitude\":null,\"temperature\":null,\"messageContent\":\"Hello\"}".equals(content.trim()));

	}

	@Test
	public void testCreate() throws Exception {

	}

	@Test
	@DatabaseSetup("classpath:datasets/SampleData.xml")
	public void testDelete() throws Exception {
		MessagingController.delete(1L);

		String uri = "/Message/1";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("failure - expected HTTP status", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() == 0);
	}

	@Test
	public void testUpdate() throws Exception {
		Message message = new Message();
		message.setId(1L);
		message.setUserName("Jin");
		message.setUserName2("Bhummi");
		message.setMessageID("10");
		message.setLocation("Markham");
		message.setLatitude("321");
		message.setMessageContent("Hello");


		MessagingController.update(1L, message);
		String uri = "/Message/1";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("failure - expected HTTP status", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
		Assert.assertTrue(content.trim().contains("{\"id\":1,\"userName\":\"Jin\",\"userName2\":\"Bhummi\",\"createdAt\":1458353370913,\"messageID\":\"10\",\"location\":\"Markham\",\"latitude\":\"321\",\"longitude\":null,\"temperature\":null,\"messageContent\":\"Hello\"}"));
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
