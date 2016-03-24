package messaging;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})


@Transactional
public class MessageTest extends abstractTestClass{

	@Autowired
	private MessageRepository repo;



	@Before
	public void setup() {
        Message obj = new Message();
        //obj.setId(9);
        obj.setUserName("William");
        obj.setParentMessageID("555");
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
        obj.setParentMessageID("007");
        obj.setMessageContent("Hello");
        obj.setLatitude("152");
        obj.setLongitude("123");
        obj.setLocation("Markham");
        repo.save(obj);
        Assert.assertNotNull("SUCESSS --expecting list not null", obj);
        Assert.assertEquals("SUCESSS --expecting Messages id to be 007", "007", obj.getParentMessageID());

    }


	@Test
 //   @DatabaseSetup("classpath:datasets/SampleData.xml")
    public void testFindAll() {


        Collection<Message> obj_list = (Collection<Message>) repo.findAll();
        Assert.assertNotNull("SUCESSS --expecting list not null", obj_list);

		Assert.assertEquals("SUCESSS -- expecting list size", 1, obj_list.size());
//        Assert.assertEquals("SUCESSS -- expecting list size", 3, obj_list.size());


    }




	@Test
//    @DataSet("/datasets/SampleData.xml")
	public void testFindOne() {
        Message obj = new Message();
//        obj.setId(4);
        obj.setUserName("houde");
        obj.setParentMessageID("007");
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
        obj.setParentMessageID("007");
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

    @Autowired
    private MessageService service;

    @Test
    public void testUpdate() throws Exception {
        Message obj = new Message();
        obj.setUserName("donny");
        obj.setParentMessageID("123");
        obj.setMessageContent("Hello houde");
        obj.setLatitude("999");
        obj.setLongitude("888");
        obj.setLocation("Markham");
        Message entity1 = service.create(obj);

        Long id = new Long(entity1.getId()) ;


        Message obj2 = new Message();
        obj2.setUserName("jin");
        obj2.setParentMessageID("456");
        obj2.setMessageContent("Hello Nesan");
        obj2.setLatitude("000");
        obj2.setLongitude("111");
        obj2.setLocation("Downtown");
        Message entity2 = service.create(obj2);

        //  Long id2 = new Long(entity2.getId()) ;


        service.update(id,entity2);
        //repo.delete((long) 1);
        Assert.assertTrue("jin".equals(service.goToIndividual(id).getUserName()));
    }

}

