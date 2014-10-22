package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA. User: ivanbayousama Date: 14/10/14 Time: 1:42 To change
 * this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "T_PERSON")
public class Person implements Serializable

{
	private static final long	serialVersionUID	= -2007216703025368994L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long				id;
	@Column(name = "NAME", unique = true, length = 50)
	private String				name;
	@Column(name = "PASSWORD", unique = false, length = 16)
	private String				password;
	
	public Long getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}
