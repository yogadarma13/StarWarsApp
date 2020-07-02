package com.yogadarma.starwars.model.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PeopleResponse{

	@SerializedName("next")
	private String next;

	@SerializedName("previous")
	private Object previous;

	@SerializedName("count")
	private int count;

	@SerializedName("results")
	private List<PeopleResultsItem> results;

	public String getNext(){
		return next;
	}

	public Object getPrevious(){
		return previous;
	}

	public int getCount(){
		return count;
	}

	public List<PeopleResultsItem> getResults(){
		return results;
	}
}