package com.dao;

import java.util.List;

import com.model.Person;

/**
 * Created by ivanbayousama on 14/10/2014.
 */
public interface PersonDao
{
	Long count();
	
	void delete(Person person);
	
	List<Person> getAll();
	
	List<Person> getAll(int start, int num);
	
	Person getById(Long id);
	
	void save(Person person);

	void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
