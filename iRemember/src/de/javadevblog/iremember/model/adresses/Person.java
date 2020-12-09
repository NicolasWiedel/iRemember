package de.javadevblog.iremember.model.adresses;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity
public class Person implements Serializable {
   
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private static final long serialVersionUID = 1L;

	public Person() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
   
	
}
