package com.yogadarma.starwars.ui.film;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.FilmsResponse;
import com.yogadarma.starwars.model.responses.FilmsResultsItem;

import java.util.ArrayList;
import java.util.Objects;

public class FilmFragment extends Fragment implements FilmContract.View {

    private FilmContract.Presenter mPresenter;
    private RecyclerView rvFilm;
    private FilmAdapter filmAdapter;
    ArrayList<FilmsResultsItem> listFilm = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFilm = view.findViewById(R.id.rv_film);
        setupRecyclerView();

        mPresenter = new FilmPresenter(this);
        mPresenter.getListFilm();

    }

    private void setupRecyclerView() {
        rvFilm.setLayoutManager(new LinearLayoutManager(getActivity()));

        filmAdapter = new FilmAdapter(getActivity(), listFilm);
        rvFilm.setAdapter(filmAdapter);
    }

    @Override
    public void populateListFilm(FilmsResponse filmsResponse) {
        new Handler().postDelayed(() -> {
            listFilm.addAll(filmsResponse.getResults());

            FilmAdapter filmAdapter = (FilmAdapter) Objects.requireNonNull(rvFilm.getAdapter());
            filmAdapter.notifyDataSetChanged();

        }, 1500);
    }

    @Override
    public void listFilmFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}