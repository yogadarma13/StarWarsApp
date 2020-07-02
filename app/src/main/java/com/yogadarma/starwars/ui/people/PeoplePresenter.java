package com.yogadarma.starwars.ui.people;

import com.yogadarma.starwars.model.responses.PeopleResponse;

public class PeoplePresenter implements PeopleContract.Presenter {

    private PeopleContract.View mView;
    private PeopleContract.Interactor mInteractor;

    public PeoplePresenter(PeopleContract.View view) {
        mView = view;
        mInteractor = new PeopleInteractor();
    }
    @Override
    public void getListPeople() {
        mInteractor.requestListPeople(new PeopleContract.PeopleRequestCallback() {
            @Override
            public void onPeopleRequestCompleted(PeopleResponse peopleResponse) {
                mView.populateListPeople(peopleResponse);
            }

            @Override
            public void onPeopleRequestFailure(String message) {
                mView.listPeopleFailure(message);
            }
        });
    }
}
