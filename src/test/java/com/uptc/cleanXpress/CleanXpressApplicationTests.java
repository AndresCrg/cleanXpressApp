package com.uptc.cleanXpress;

import com.uptc.cleanXpress.dao.person.PersonDao;
import com.uptc.cleanXpress.models.Person;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CleanXpressApplicationTests {

	PersonDao personDao;

	void testCreatePerson(){
		Person p = new Person();
		p.setId("105462");
		p.setName("John Cardenas");
		p.setAddress("cll falsa # 1 2 3");
		p.setPhoneNumber("7622103");
		p.setEmail("Jhcar@gmail.com");
		personDao.registerPerson(p);
	}

}
