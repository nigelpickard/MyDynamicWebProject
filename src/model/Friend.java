package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FRIEND database table.
 * 
 */
@Entity
@Table(name="FRIEND")
public class Friend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private int age;

	public Friend() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}