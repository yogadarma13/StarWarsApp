package com.yogadarma.starwars.model.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PlanetResponse{

	@SerializedName("next")
	private String next;

	@SerializedName("previous")
	private Object previous;

	@SerializedName("count")
	private int count;

	@SerializedName("results")
	private List<PlanetResultsItem> results;

	public String getNext(){
		return next;
	}

	public Object getPrevious(){
		return previous;
	}

	public int getCount(){
		return count;
	}

	public List<PlanetResultsItem> getResults(){
		return results;
	}
}