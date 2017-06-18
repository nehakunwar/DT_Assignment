package backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDao;
import com.niit.backend.model.User;

public class Testprocedure {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static User user;
	
	@Autowired
	static UserDao userDAO;
	
	
	@BeforeClass
	static public void initalize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		user=context.getBean(User.class);
		
		userDAO=(UserDao)context.getBean("userDAO");
		
	}
	
	@Test
	public void insertPositiveTestCase()
	{
		// positive testing for insert user
		user.setId(0);
		user.setUsername("mercedes");
		user.setEmail("mercedes@gmail.com");
		user.setPassword("mercedes");
		userDAO.registerUser(user);
		assertEquals("Record Inserted!!","Sangram",user.getUsername());		
		
	}

}
