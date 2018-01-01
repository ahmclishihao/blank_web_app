package com.lshao.demo;

import com.lshao.demo.domain.DbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

		DbUser dbUser = new DbUser();
		dbUser.setId(1);
		dbUser.setName("小明");
		dbUser.setSexType(true);
		dbUser.setIsDelete(false);
		dbUser.setIsEffect(true);
		dbUser.setCreateTime(new Date(System.currentTimeMillis()));

		DbUser dbUser1 = new DbUser();


		BeanUtils.copyProperties(dbUser,dbUser1);

		System.out.println(dbUser1);

	}

}
