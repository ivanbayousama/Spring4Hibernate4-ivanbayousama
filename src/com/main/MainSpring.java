package com.main;

import com.model.Person;
import com.service.PersonService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ivanbayousama on 20/10/2014.
 */

public class MainSpring
{
	public static void main(String[] args)
	{
		MainSpring mainSpring = new MainSpring();
		mainSpring.springOn();
		try
		{
			mainSpring.finalize();
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();
		}
	}
	
	public void springOn()
	{
		ApplicationContext applicationContext = null;
		
		try
		{
			applicationContext = new ClassPathXmlApplicationContext(
					"classpath*:META-INF/spring-config.xml");
			
			PersonService personService = (PersonService) applicationContext
					.getBean("personServiceImpl");
			
			final Person person = new Person();
			person.setName("Ivan Bayousama");
			person.setPassword("h3rlamb4ng");
			personService.save(person);
			
			final List<Person> personList = personService.getPersons();
			for (final Person persons : personList)
			{
				System.out.println("name:" + persons.getName() + ", password:"
						+ persons.getPassword());
			}
		}
		catch (final Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			applicationContext = null;
		}
	}
}
