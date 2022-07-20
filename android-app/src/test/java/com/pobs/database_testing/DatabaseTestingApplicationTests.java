package com.pobs.database_testing;

import com.pobs.database_testing.model.PollDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Console;

@SpringBootTest
class DatabaseTestingApplicationTests {

	@Autowired private PollDao pollDao;

	@Test
	void contextLoads() {


		pollDao.increment_col_a();
		pollDao.increment_col_a();

	}




}
