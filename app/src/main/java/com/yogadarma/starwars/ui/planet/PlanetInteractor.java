package com.yogadarma.starwars.ui.planet;

import com.yogadarma.starwars.model.responses.PlanetResponse;
import com.yogadarma.starwars.network.NetworkApi;
import com.yogadarma.starwars.network.UtilsApi;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PlanetInteractor implements PlanetContract.Interactor {

    private NetworkApi networkApi = UtilsApi.getApiService();
    private PlanetResponse response = null;

    @Override
    public void requestListPlanet(final PlanetContract.PlanetRequestCallback planetRequestCallback) {
        networkApi.getListPlanet().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PlanetResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PlanetResponse planetResponse) {
                response = planetResponse;
            }

            @Override
            public void onError(@NonNull Throwable e) {
                planetRequestCallback.onPlanetRequestFailure("Gagal mengambil data StarWars");
            }

            @Override
            public void onComplete() {
                if (response != null) {
                    planetRequestCallback.onPlanetRequestCompleted(response);
                } else {
                    planetRequestCallback.onPlanetRequestFailure("Data tidak ditemukan");
                }
            }
        });
    }
}
