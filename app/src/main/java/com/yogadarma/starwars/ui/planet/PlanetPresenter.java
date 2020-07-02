package com.yogadarma.starwars.ui.planet;

import com.yogadarma.starwars.model.responses.PlanetResponse;

public class PlanetPresenter implements PlanetContract.Presenter {

    private PlanetContract.View mView;
    private PlanetContract.Interactor mInteractor;

    public PlanetPresenter(PlanetContract.View view) {
        mView = view;
        mInteractor = new PlanetInteractor();
    }

    @Override
    public void getListPlanet() {
        mInteractor.requestListPlanet(new PlanetContract.PlanetRequestCallback() {
            @Override
            public void onPlanetRequestCompleted(PlanetResponse planetResponse) {
                mView.populateListPlanet(planetResponse);
            }

            @Override
            public void onPlanetRequestFailure(String message) {
                mView.listPlanetFailure(message);
            }
        });
    }
}
