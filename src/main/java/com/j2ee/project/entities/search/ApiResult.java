package com.j2ee.project.entities.search;

import java.util.List;

public class ApiResult<T> {
	String success;
	List<T> results;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
		
}
