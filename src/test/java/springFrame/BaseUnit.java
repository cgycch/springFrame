package springFrame;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:application-context.xml"})
//@Transactional(readOnly=true)
public class BaseUnit {
	@BeforeClass
	public static void beforeIoc() {
		System.out.println("BaseUnit is runing");
	}

}
