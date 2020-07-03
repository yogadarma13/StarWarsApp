package com.yogadarma.starwars.network;

import com.yogadarma.starwars.model.responses.FilmsResponse;
import com.yogadarma.starwars.model.responses.PeopleResponse;
import com.yogadarma.starwars.model.responses.PlanetResponse;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface NetworkApi {

    @GET("films")
    Observable<FilmsResponse> getListFilms();

    @GET("planets")
    Observable<PlanetResponse> getListPlanet();

    @GET("people")
    Observable<PeopleResponse> getListPeople();

}
