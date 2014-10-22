package com.service;

import java.util.List;

import com.model.Person;

/**
 * Created by ivanbayousama on 14/10/2014.
 */
public interface PersonService
{
	Long count();
	
	void delete(Person person);
	
	Person getPerson(Long id);
	
	List<Person> getPersons();
	
	List<Person> getPersons(int start, int num);
	
	void save(Person person);
}
