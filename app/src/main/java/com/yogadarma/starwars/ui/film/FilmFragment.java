package com.yogadarma.starwars.ui.film;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.FilmsResponse;

public class FilmFragment extends Fragment implements FilmContract.View {

    private FilmContract.Presenter mPresenter;
    private TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("ONVIEW", "MASUK");

        mPresenter = new FilmPresenter(this);
        mPresenter.getListFilm();

        text = view.findViewById(R.id.text_dashboard);
    }

    @Override
    public void populateListFilm(FilmsResponse filmsResponse) {
        Log.d("VIEW", String.valueOf(filmsResponse.getCount()));
//        Toast.makeText(getActivity(), filmsResponse.getCount(), Toast.LENGTH_LONG).show();
        text.setText(String.valueOf(filmsResponse.getCount()));
    }

    @Override
    public void listFilmFailure(String message) {

    }
}