package com.dao;

import com.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivanbayousama on 14/10/2014.
 */
@Repository

public class PersonDaoImpl implements PersonDao
{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public Long count()
	{

		return (Long) this.sessionFactory.getCurrentSession()
				.createQuery("select count (*) from Person p").uniqueResult();
	}

	public void delete(Person person)
	{
		this.sessionFactory.getCurrentSession().delete(person);
	}

	public List<Person> getAll()
	{
		return this.sessionFactory.getCurrentSession().createQuery("from Person p").list();
	}

	public List<Person> getAll(int start, int num)
	{
		return this.sessionFactory.getCurrentSession().createQuery("from Person p")
				.setFirstResult(start).setFetchSize(num).list();
	}

	public Person getById(Long id)
	{
		return (Person) this.sessionFactory.getCurrentSession()
				.createQuery("from Person p where p.id = :id").setParameter("id", id)
				.uniqueResult();
	}

	public void save(Person person)
	{
		this.sessionFactory.getCurrentSession().save(person);
	}
}
