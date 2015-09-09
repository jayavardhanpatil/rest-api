package com.jay.Restful.Rest.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long id;
	private String profilename;
	private String firstname;
	private String lastname;
	private Date created;

	public Profile(){
		
	}

	public Profile(long id,String profilename,String firstname,String lastname){
		this.setId(id);
		this.profilename = profilename;
		this.firstname = firstname;
		this.lastname = lastname;
		this.created = new Date();
	}
	
	public String getProfilename() {
		return profilename;
	}

	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
