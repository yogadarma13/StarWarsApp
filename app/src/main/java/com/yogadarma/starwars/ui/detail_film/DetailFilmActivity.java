package com.yogadarma.starwars.ui.detail_film;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.FilmsResultsItem;

public class DetailFilmActivity extends AppCompatActivity {

    private TextView tvFilmTitle, tvFilmEpisode, tvFilmDirector, tvFilmProducer, tvFilmRelease, tvFilmOpening;
    private FilmsResultsItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Film");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        item = DetailFilmActivityArgs.fromBundle(getIntent().getExtras()).getFilm();

        initView();
        setupView();
    }

    private void initView() {
        tvFilmTitle = findViewById(R.id.tv_film_title);
        tvFilmEpisode = findViewById(R.id.tv_film_episode);
        tvFilmDirector = findViewById(R.id.tv_film_director);
        tvFilmProducer = findViewById(R.id.tv_film_producer);
        tvFilmRelease = findViewById(R.id.tv_film_release);
        tvFilmOpening = findViewById(R.id.tv_film_opening);
    }

    private void setupView() {
        tvFilmTitle.setText(item.getTitle());
        tvFilmEpisode.setText(String.valueOf(item.getEpisodeId()));
        tvFilmDirector.setText(item.getDirector());
        tvFilmProducer.setText(item.getProducer());
        tvFilmRelease.setText(item.getReleaseDate());
        tvFilmOpening.setText(item.getOpeningCrawl());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
