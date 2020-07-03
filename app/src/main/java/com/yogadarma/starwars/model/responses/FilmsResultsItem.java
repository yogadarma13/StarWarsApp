package com.yogadarma.starwars.model.responses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class FilmsResultsItem implements Parcelable {

    @SerializedName("edited")
    private String edited;

    @SerializedName("director")
    private String director;

    @SerializedName("created")
    private String created;

    @SerializedName("vehicles")
    private List<String> vehicles;

    @SerializedName("opening_crawl")
    private String openingCrawl;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("characters")
    private List<String> characters;

    @SerializedName("episode_id")
    private int episodeId;

    @SerializedName("planets")
    private List<String> planets;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("starships")
    private List<String> starships;

    @SerializedName("species")
    private List<String> species;

    @SerializedName("producer")
    private String producer;

    protected FilmsResultsItem(Parcel in) {
        edited = in.readString();
        director = in.readString();
        created = in.readString();
        vehicles = in.createStringArrayList();
        openingCrawl = in.readString();
        title = in.readString();
        url = in.readString();
        characters = in.createStringArrayList();
        episodeId = in.readInt();
        planets = in.createStringArrayList();
        releaseDate = in.readString();
        starships = in.createStringArrayList();
        species = in.createStringArrayList();
        producer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(edited);
        dest.writeString(director);
        dest.writeString(created);
        dest.writeStringList(vehicles);
        dest.writeString(openingCrawl);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeStringList(characters);
        dest.writeInt(episodeId);
        dest.writeStringList(planets);
        dest.writeString(releaseDate);
        dest.writeStringList(starships);
        dest.writeStringList(species);
        dest.writeString(producer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FilmsResultsItem> CREATOR = new Creator<FilmsResultsItem>() {
        @Override
        public FilmsResultsItem createFromParcel(Parcel in) {
            return new FilmsResultsItem(in);
        }

        @Override
        public FilmsResultsItem[] newArray(int size) {
            return new FilmsResultsItem[size];
        }
    };

    public String getEdited() {
        return edited;
    }

    public String getDirector() {
        return director;
    }

    public String getCreated() {
        return created;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<String> getStarships() {
        return starships;
    }

    public List<String> getSpecies() {
        return species;
    }

    public String getProducer() {
        return producer;
    }

}
