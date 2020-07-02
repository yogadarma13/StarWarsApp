package com.yogadarma.starwars.ui.film;

import com.yogadarma.starwars.model.responses.FilmsResponse;

public interface FilmContract {

    interface FilmRequestCallback {
        void onFilmRequestCompleted(FilmsResponse filmsResponse);

        void onFilmRequestFailure(String message);

    }

    interface View {
        void populateListFilm(FilmsResponse filmsResponse);

        void listFilmFailure(String message);
    }

    interface Interactor {
        void requestListFilm(FilmRequestCallback filmRequestCallback);
    }

    interface Presenter {
        void getListFilm();
    }
}
