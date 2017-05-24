package com.j2ee.project.entities.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.j2ee.project.entities.Sach;;

public class SearchingBookResults {
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<BookData> getResults() {
		return results;
	}

	public void setResults(List<BookData> results) {
		this.results = results;
	}

	@JsonView(Views.Show.class)
	String msg;
	
	@JsonView(Views.Show.class)
	List<BookData> results;
}