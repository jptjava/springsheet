package com.jpt.restservice.entity;

public class User {

	private long id;
	private String firstName;
	private String lastName;
	private int age;

	public User() {
	}

	public User(long id, String fname, String lname, int age) {

		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	  @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (id ^ (id >>> 32));
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        User other = (User) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }

}
