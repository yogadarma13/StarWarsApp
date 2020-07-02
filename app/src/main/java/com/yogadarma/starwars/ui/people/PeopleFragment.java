package com.yogadarma.starwars.ui.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.PeopleResponse;

public class PeopleFragment extends Fragment implements PeopleContract.View {

    private PeopleContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new PeoplePresenter(this);
        mPresenter.getListPeople();

    }

    @Override
    public void populateListPeople(PeopleResponse peopleResponse) {

    }

    @Override
    public void listPeopleFailure(String message) {

    }
}