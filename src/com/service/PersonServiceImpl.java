package com.service;

import com.dao.PersonDao;
import com.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivanbayousama on 14/10/2014.
 */

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService
{
	@Autowired
	protected PersonDao personDao;

	public void setPersonDao(PersonDao personDao)
	{
		this.personDao = personDao;
	}

	@Transactional
	public Long count()
	{
		return this.personDao.count();
	}

	@Transactional(readOnly = false)
	public void delete(Person person)
	{
		this.personDao.delete(person);
	}

	public Person getPerson(final Long id)
	{
		return this.personDao.getById(id);
	}

	public List<Person> getPersons()
	{
		return this.personDao.getAll();
	}

	public List<Person> getPersons(final int start, final int num)
	{
		return this.personDao.getAll(start, num);
	}

	@Transactional(readOnly = false)
	public void save(Person person)
	{
		this.personDao.save(person);
	}

}
