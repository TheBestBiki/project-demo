package com.biki.project;

import com.biki.project.mapper.TestDbMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

	@Autowired
	private TestDbMapper testDbMapper;

	@Test
	public void contextLoads() {

		String aa = testDbMapper.finId();
		System.out.println(aa);

	}

}
