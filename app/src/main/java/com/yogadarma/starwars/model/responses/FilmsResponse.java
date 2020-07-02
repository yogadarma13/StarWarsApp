package com.yogadarma.starwars.model.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FilmsResponse{

	@SerializedName("next")
	private Object next;

	@SerializedName("previous")
	private Object previous;

	@SerializedName("count")
	private int count;

	@SerializedName("results")
	private List<FilmsResultsItem> results;

	public Object getNext(){
		return next;
	}

	public Object getPrevious(){
		return previous;
	}

	public int getCount(){
		return count;
	}

	public List<FilmsResultsItem> getResults(){
		return results;
	}
}