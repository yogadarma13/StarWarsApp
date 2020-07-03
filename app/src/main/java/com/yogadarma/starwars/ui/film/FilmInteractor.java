package com.yogadarma.starwars.ui.film;

import com.yogadarma.starwars.model.responses.FilmsResponse;
import com.yogadarma.starwars.network.NetworkApi;
import com.yogadarma.starwars.network.UtilsApi;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FilmInteractor implements FilmContract.Interactor {

    private NetworkApi networkApi = UtilsApi.getApiService();
    private FilmsResponse response = null;

    @Override
    public void requestListFilm(final FilmContract.FilmRequestCallback filmRequestCallback) {
        networkApi.getListFilms().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<FilmsResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull FilmsResponse filmsResponse) {
                response = filmsResponse;
            }

            @Override
            public void onError(@NonNull Throwable e) {
                filmRequestCallback.onFilmRequestFailure("Gagal mengambil data film StarWars");
            }

            @Override
            public void onComplete() {
                if (response != null) {
                    filmRequestCallback.onFilmRequestCompleted(response);
                } else {
                    filmRequestCallback.onFilmRequestFailure("Data tidak ditemukan");
                }
            }
        });
    }
}
