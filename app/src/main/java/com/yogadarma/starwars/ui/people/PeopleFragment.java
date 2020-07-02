package com.yogadarma.starwars.ui.people;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.PeopleResponse;
import com.yogadarma.starwars.model.responses.PeopleResultsItem;
import com.yogadarma.starwars.ui.film.FilmAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class PeopleFragment extends Fragment implements PeopleContract.View {

    private PeopleContract.Presenter mPresenter;
    private RecyclerView rvPeople;
    private PeopleAdapter peopleAdapter;
    ArrayList<PeopleResultsItem> listPeople = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPeople = view.findViewById(R.id.rv_people);
        setupRecyclerView();
        mPresenter = new PeoplePresenter(this);
        mPresenter.getListPeople();

    }

    private void setupRecyclerView() {
        rvPeople.setLayoutManager(new LinearLayoutManager(getActivity()));

        peopleAdapter = new PeopleAdapter(getActivity(), listPeople);
        rvPeople.setAdapter(peopleAdapter);
    }

    @Override
    public void populateListPeople(PeopleResponse peopleResponse) {
        new Handler().postDelayed(() -> {
            listPeople.addAll(peopleResponse.getResults());

            PeopleAdapter peopleAdapter = (PeopleAdapter) Objects.requireNonNull(rvPeople.getAdapter());
            peopleAdapter.notifyDataSetChanged();

        }, 1500);
    }

    @Override
    public void listPeopleFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}