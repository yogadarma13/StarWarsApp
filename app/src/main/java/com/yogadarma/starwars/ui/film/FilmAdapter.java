package com.yogadarma.starwars.ui.film;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.base.BaseAdapter;
import com.yogadarma.starwars.model.responses.FilmsResultsItem;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    TextView tvFilmTitle, tvFilmDirector, tvReleaseDate;
    CardView cardView;
    private OnItemClickCallback onItemClickCallback;

    interface OnItemClickCallback {
        void onItemClicked(FilmsResultsItem film);
    }

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public FilmAdapter(Context context, ArrayList<FilmsResultsItem> listFilm) {
        super(context);
        list = listFilm;
        layoutId = R.layout.layout_main_item;
    }

    @Override
    public void onBindView(int position, Object itemView) {
        FilmsResultsItem film = (FilmsResultsItem) itemView;
        tvFilmTitle.setText(film.getTitle());
        tvFilmDirector.setText(film.getDirector());
        tvReleaseDate.setText(film.getReleaseDate());

        cardView.setOnClickListener(v -> {
            onItemClickCallback.onItemClicked(film);
        });

    }

    @Override
    protected View getView(View itemView) {
        tvFilmTitle = bind(R.id.tv_title);
        tvFilmDirector = bind(R.id.tv_subtitle_1);
        tvReleaseDate = bind(R.id.tv_subtitle_2);
        cardView = bind(R.id.card_view);
        return itemView;
    }
}
