package com.yogadarma.starwars.ui.planet;

import com.yogadarma.starwars.model.responses.PlanetResponse;

public interface PlanetContract {

    interface PlanetRequestCallback {
        void onPlanetRequestCompleted(PlanetResponse planetResponse);

        void onPlanetRequestFailure(String message);

    }

    interface View {
        void populateListPlanet(PlanetResponse planetResponse);

        void listPlanetFailure(String message);
    }

    interface Interactor {
        void requestListPlanet(PlanetRequestCallback planetRequestCallback);
    }

    interface Presenter {
        void getListPlanet();
    }
}
