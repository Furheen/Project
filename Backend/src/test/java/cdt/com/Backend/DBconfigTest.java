package cdt.com.Backend;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBconfigTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("cdt.com.Backend");
		context.refresh();
	}
}

