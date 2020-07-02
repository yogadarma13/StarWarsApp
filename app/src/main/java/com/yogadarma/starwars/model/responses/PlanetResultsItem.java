package com.yogadarma.starwars.model.responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PlanetResultsItem {

	@SerializedName("films")
	private List<String> films;

	@SerializedName("edited")
	private String edited;

	@SerializedName("created")
	private String created;

	@SerializedName("climate")
	private String climate;

	@SerializedName("rotation_period")
	private String rotationPeriod;

	@SerializedName("url")
	private String url;

	@SerializedName("population")
	private String population;

	@SerializedName("orbital_period")
	private String orbitalPeriod;

	@SerializedName("surface_water")
	private String surfaceWater;

	@SerializedName("diameter")
	private String diameter;

	@SerializedName("gravity")
	private String gravity;

	@SerializedName("name")
	private String name;

	@SerializedName("residents")
	private List<String> residents;

	@SerializedName("terrain")
	private String terrain;

	public List<String> getFilms(){
		return films;
	}

	public String getEdited(){
		return edited;
	}

	public String getCreated(){
		return created;
	}

	public String getClimate(){
		return climate;
	}

	public String getRotationPeriod(){
		return rotationPeriod;
	}

	public String getUrl(){
		return url;
	}

	public String getPopulation(){
		return population;
	}

	public String getOrbitalPeriod(){
		return orbitalPeriod;
	}

	public String getSurfaceWater(){
		return surfaceWater;
	}

	public String getDiameter(){
		return diameter;
	}

	public String getGravity(){
		return gravity;
	}

	public String getName(){
		return name;
	}

	public List<String> getResidents(){
		return residents;
	}

	public String getTerrain(){
		return terrain;
	}
}