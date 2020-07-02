package com.yogadarma.starwars.ui.film;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.FilmsResponse;

public class FilmFragment extends Fragment implements FilmContract.View{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false);
    }

    @Override
    public void populateListFilm(FilmsResponse filmsResponse) {

    }

    @Override
    public void listFilmFailure(String message) {

    }
}