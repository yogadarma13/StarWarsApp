package com.yogadarma.starwars.ui.film;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.base.BaseAdapter;
import com.yogadarma.starwars.model.responses.FilmsResultsItem;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    TextView tvFilmTitle, tvFilmDirector, tvReleaseDate;

    public FilmAdapter(Context context, ArrayList<FilmsResultsItem> listFilm) {
        super(context);
        list = listFilm;
        layoutId = R.layout.layout_main_film;
    }

    @Override
    public void onBindView(int position, Object itemView) {
        FilmsResultsItem film = (FilmsResultsItem) itemView;
        tvFilmTitle.setText(film.getTitle());
        tvFilmDirector.setText(film.getDirector());
        tvReleaseDate.setText(film.getReleaseDate());
    }

    @Override
    protected View getView(View itemView) {
        tvFilmTitle = bind(R.id.tv_film_title);
        tvFilmDirector = bind(R.id.tv_film_director);
        tvReleaseDate = bind(R.id.tv_film_release_date);

        return itemView;
    }
}
