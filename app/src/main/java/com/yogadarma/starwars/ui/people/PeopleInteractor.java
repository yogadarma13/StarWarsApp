package com.yogadarma.starwars.ui.people;

import com.yogadarma.starwars.model.responses.PeopleResponse;
import com.yogadarma.starwars.network.NetworkApi;
import com.yogadarma.starwars.network.UtilsApi;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PeopleInteractor implements PeopleContract.Interactor {

    private NetworkApi networkApi = UtilsApi.getApiService();
    private PeopleResponse response = null;

    @Override
    public void requestListPeople(final PeopleContract.PeopleRequestCallback peopleRequestCallback) {
        networkApi.getListPeople().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PeopleResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PeopleResponse peopleResponse) {
                response = peopleResponse;
            }

            @Override
            public void onError(@NonNull Throwable e) {
                peopleRequestCallback.onPeopleRequestFailure("Gagal mengambil data StarWars");
            }

            @Override
            public void onComplete() {
                if (response != null) {
                    peopleRequestCallback.onPeopleRequestCompleted(response);
                } else {
                    peopleRequestCallback.onPeopleRequestFailure("Data tidak ditemukan");
                }
            }
        });
    }
}
