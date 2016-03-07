package messaging;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//------------------------------------------------------------------------------------

/*
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

@RunWith(UnitilsJUnit4TestClassRunner.class)
@org.unitils.database.annotations.Transactional(TransactionMode.ROLLBACK)
@SpringApplicationContext({ "classpath:spring-context-test.xml" })
*/

//------------------------------------------------------------------------------------
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)



public abstract class abstractTestClass {



}
