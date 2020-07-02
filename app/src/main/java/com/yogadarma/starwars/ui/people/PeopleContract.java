package com.yogadarma.starwars.ui.people;

import com.yogadarma.starwars.model.responses.PeopleResponse;

public interface PeopleContract {

    interface PeopleRequestCallback {
        void onPeopleRequestCompleted(PeopleResponse peopleResponse);

        void onPeopleRequestFailure(String message);

    }

    interface View {
        void populateListPeople(PeopleResponse peopleResponse);

        void listPeopleFailure(String message);
    }

    interface Interactor {
        void requestListPeople(PeopleRequestCallback peopleRequestCallback);
    }

    interface Presenter {
        void getListPeople();
    }
}
