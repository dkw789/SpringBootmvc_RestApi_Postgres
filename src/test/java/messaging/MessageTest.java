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
		Assert.assertEquals("failure -- expecting list size", 4, obj_list.size());

	}

	@Test
	public void testFindOne() {
		long id = 1;
		Message obj = repo.findOne(id);
		Assert.assertNotNull("failure --expecting list not null", obj);
		Assert.assertEquals("failer --expecting id 1", 1, obj.getId());

	}

	@Test
	public void testSave() {
/*
		Message obj = new Message();
		obj.setUserName("houde");
		obj.setCreatedAt("13:26");
//		obj.setCreatedBy("houde");
		obj.setMessageID("fourth_m");
		obj.setUpdatedAt("13:33");
//		obj.setUpdatedBy("houde");

		repo.save(obj);
		Assert.assertNotNull("failure --expecting list not null", obj);
		Assert.assertEquals("failer --expecting Messages id to be fourth_m", "fourth_m", obj.getMessageID());
*/

	}

	@Test
	public void testDelete() {
		long id = 1;
		repo.delete(id);
		Assert.assertNull("failure --expecting Messages 1 to be gone", repo.findOne(id));

	}


}
