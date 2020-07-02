package com.yogadarma.starwars.ui.film;

import com.yogadarma.starwars.model.responses.FilmsResponse;

public class FilmPresenter implements FilmContract.Presenter {

    private FilmContract.View mView;
    private FilmContract.Interactor mInteractor;

    public FilmPresenter(FilmContract.View view) {
        mView = view;
        mInteractor = new FilmInteractor();
    }

    @Override
    public void getListFilm() {
        mInteractor.requestListFilm(new FilmContract.FilmRequestCallback() {
            @Override
            public void onFilmRequestCompleted(FilmsResponse filmsResponse) {

            }

            @Override
            public void onFilmRequestFailure(String message) {

            }
        });
    }
}
