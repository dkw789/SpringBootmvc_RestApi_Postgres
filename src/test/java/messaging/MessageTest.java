package messaging;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

/*
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

@RunWith(UnitilsJUnit4TestClassRunner.class)
@org.unitils.database.annotations.Transactional(TransactionMode.ROLLBACK)
@SpringApplicationContext({ "classpath:spring-context-test.xml" })
*/


@Transactional
public class MessageTest extends abstractTestClass{

	@Autowired
	private MessageRepository repo;

	@Before
	public void setup() {

	}

	@After
	public void post_process() {

	}

	@Test
//    @DataSet("/datasets/SampleData.xml")
    public void testFindAll() {
		Collection<Message> obj_list = (Collection<Message>) repo.findAll();
		Assert.assertNotNull("failure --expecting list not null", obj_list);
		Assert.assertEquals("failure -- expecting list size", 0, obj_list.size());
//        Assert.assertEquals("failure -- expecting list size", 3, obj_list.size());


    }


	@Test
	public void testSave() {
		Message obj = new Message();
		obj.setId(4);
		obj.setUserName("houde");
		//obj.setCreatedAt(Sun Mar 06 01:57:32 EST 2016);
		obj.setMessageID("007");
		obj.setMessageContent("Hello");
		//obj.getLatitude("152");
		obj.setLongitude("123");
		obj.setLocation("Markham");

		repo.save(obj);
		Assert.assertNotNull("failure --expecting list not null", obj);
		Assert.assertEquals("failure --expecting Messages id to be 007", "007", obj.getMessageID());

	}
//    <message id = "1" userName ="donny" userName2="houde" messageID ="1" location="123" latitude ="321" MessageContent ="Hello"/>

	@Test
//    @DataSet("/datasets/SampleData.xml")
	public void testFindOne() {
		long id = 1;
		Message obj = repo.findOne(id);

		Assert.assertNotNull("failure --expecting list not null", obj);
//		Assert.assertEquals("failure --expecting id 1", 1, obj.getId());

	}


	@Test
//    @DataSet("/datasets/SampleData.xml")
    public void testDelete() {

        long id = 1;
		repo.delete(id);
        //		Assert.assertNull("failure --expecting Messages 1 to be gone", repo.findOne(id));

	}


}
