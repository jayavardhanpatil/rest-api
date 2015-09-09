package com.jay.Restful.Rest.resources.beans;

import javax.ws.rs.QueryParam;

public class BeanParamDemo {

	private @QueryParam("year") int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
}
