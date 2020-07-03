package com.yogadarma.starwars.model.responses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PlanetResultsItem implements Parcelable {

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

    protected PlanetResultsItem(Parcel in) {
        films = in.createStringArrayList();
        edited = in.readString();
        created = in.readString();
        climate = in.readString();
        rotationPeriod = in.readString();
        url = in.readString();
        population = in.readString();
        orbitalPeriod = in.readString();
        surfaceWater = in.readString();
        diameter = in.readString();
        gravity = in.readString();
        name = in.readString();
        residents = in.createStringArrayList();
        terrain = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(films);
        dest.writeString(edited);
        dest.writeString(created);
        dest.writeString(climate);
        dest.writeString(rotationPeriod);
        dest.writeString(url);
        dest.writeString(population);
        dest.writeString(orbitalPeriod);
        dest.writeString(surfaceWater);
        dest.writeString(diameter);
        dest.writeString(gravity);
        dest.writeString(name);
        dest.writeStringList(residents);
        dest.writeString(terrain);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlanetResultsItem> CREATOR = new Creator<PlanetResultsItem>() {
        @Override
        public PlanetResultsItem createFromParcel(Parcel in) {
            return new PlanetResultsItem(in);
        }

        @Override
        public PlanetResultsItem[] newArray(int size) {
            return new PlanetResultsItem[size];
        }
    };

    public List<String> getFilms() {
        return films;
    }

    public String getEdited() {
        return edited;
    }

    public String getCreated() {
        return created;
    }

    public String getClimate() {
        return climate;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public String getUrl() {
        return url;
    }

    public String getPopulation() {
        return population;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public String getName() {
        return name;
    }

    public List<String> getResidents() {
        return residents;
    }

    public String getTerrain() {
        return terrain;
    }
}
