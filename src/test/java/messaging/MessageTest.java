package messaging;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public class MessageTest extends abstractTestClass {

	@Autowired
	private MessageRepository repo;

//	@Before
//	public void setup() {
//
//	}
//
//	@After
//	public void post_precoess() {
//
//	}

	@Test
	public void testFindAll() {
		Collection<Message> obj_list = (Collection<Message>) repo.findAll();
		Assert.assertNotNull("failure --expecting list not null", obj_list);
		Assert.assertEquals("failure -- expecting list size", 0, obj_list.size());

	}


	@Test
	public void testSave() {
		Message obj = new Message();
		obj.setId(1);
		obj.setUserName("houde");
		//obj.setCreatedAt(03/05/2016);
		obj.setMessageID("007");
		obj.setMessageContent("Hello");
		//obj.getLatitude("152");
		obj.setLongitude("178");
		obj.setLocation("Markham");

		repo.save(obj);
		Assert.assertNotNull("failure --expecting list not null", obj);
		Assert.assertEquals("failure --expecting Messages id to be 007", "007", obj.getMessageID());

	}

	@Test
	public void testFindOne() {
		long id = 1;
		Message obj = repo.findOne(id);
		Assert.assertNotNull("failure --expecting list not null", obj);
		Assert.assertEquals("failure --expecting id 1", 1, obj.getId());

	}


	@Test
	public void testDelete() {

			long id = 1;
		repo.delete(id);
		Assert.assertNull("failure --expecting Messages 1 to be gone", repo.findOne(id));

	}


}
