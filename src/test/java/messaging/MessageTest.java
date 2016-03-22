package messaging;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;




@Transactional
public class MessageTest extends abstractTestClass{

	@Autowired
	private MessageRepository repo;



	@Before
	public void setup() {
        Message obj = new Message();
        //obj.setId(9);
        obj.setUserName("William");
        obj.setMessageID("555");
        obj.setMessageContent("Hey Brother");
        obj.setLatitude("172");
        obj.setLongitude("173");
        obj.setLocation("Downtown");
        repo.save(obj);
	}



	@After
	public void post_process() {
//        repo.deleteAll();
	}


    @Test
    public void testSave(){
        Message obj = new Message();
//        obj.setId(4);
        obj.setUserName("houde");
        obj.setMessageID("007");
        obj.setMessageContent("Hello");
        obj.setLatitude("152");
        obj.setLongitude("123");
        obj.setLocation("Markham");
        repo.save(obj);
        Assert.assertNotNull("failure --expecting list not null", obj);
        Assert.assertEquals("failure --expecting Messages id to be 007", "007", obj.getMessageID());

    }


	@Test
//    @DataSet("/datasets/SampleData.xml")
    public void testFindAll() {


        Collection<Message> obj_list = (Collection<Message>) repo.findAll();
        Assert.assertNotNull("failure --expecting list not null", obj_list);

		Assert.assertEquals("failure -- expecting list size", 1, obj_list.size());
//        Assert.assertEquals("failure -- expecting list size", 3, obj_list.size());


    }




	@Test
//    @DataSet("/datasets/SampleData.xml")
	public void testFindOne() {
        Message obj = new Message();
//        obj.setId(4);
        obj.setUserName("houde");
        obj.setMessageID("007");
        obj.setMessageContent("Hello");
        obj.setLatitude("152");
        obj.setLongitude("123");
        obj.setLocation("Markham");
        Message entity = repo.save(obj);

		Long id = new Long(entity.getId()) ;

		Message resultObj = repo.findOne(id);

//		Assert.assertNotNull("failure --expecting list not null", obj);
		Assert.assertEquals(id, new Long(resultObj.getId()));

	}


	@Test
//    @DataSet("/datasets/SampleData.xml")
    public void testDelete() {
        Message obj = new Message();
//        obj.setId(4);
        obj.setUserName("houde");
        obj.setMessageID("007");
        obj.setMessageContent("Hello");
        obj.setLatitude("152");
        obj.setLongitude("123");
        obj.setLocation("Markham");
        Message entity = repo.save(obj);

        Long id = new Long(entity.getId()) ;
       // long id = 1;
        repo.delete(id);
        //repo.delete((long) 1);
        Assert.assertNull(repo.findOne(id));



    }


}
