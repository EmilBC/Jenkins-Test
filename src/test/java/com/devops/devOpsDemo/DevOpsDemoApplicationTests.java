package com.devops.devOpsDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevOpsDemoApplicationTests {

	@Test
	public void contextLoads() {
		assertTrue(1==2);
	}

}
