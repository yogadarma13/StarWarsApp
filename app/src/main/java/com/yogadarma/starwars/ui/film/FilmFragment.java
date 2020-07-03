package com.yogadarma.starwars.ui.film;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.FilmsResponse;
import com.yogadarma.starwars.model.responses.FilmsResultsItem;

import java.util.ArrayList;
import java.util.Objects;

public class FilmFragment extends Fragment implements FilmContract.View {

    private FilmContract.Presenter mPresenter;
    private RecyclerView rvFilm;
    private FilmAdapter filmAdapter;
    private ShimmerFrameLayout shimmerFrameLayout;
    ArrayList<FilmsResultsItem> listFilm = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_film, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_film);
        rvFilm = view.findViewById(R.id.rv_film);
        setupRecyclerView();

        mPresenter = new FilmPresenter(this);
        mPresenter.getListFilm();

        showShimmer();
        setupListener(view);

    }

    private void showShimmer() {
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        shimmerFrameLayout.startShimmer();
    }

    private void hideShimmer() {
        shimmerFrameLayout.setVisibility(View.GONE);
        shimmerFrameLayout.stopShimmer();
    }

    private void setupRecyclerView() {
        rvFilm.setLayoutManager(new LinearLayoutManager(getActivity()));

        filmAdapter = new FilmAdapter(getActivity(), listFilm);
        rvFilm.setAdapter(filmAdapter);
    }

    private void setupListener(View view) {
        filmAdapter.setOnItemClickCallback(film -> {
            FilmFragmentDirections.ActionNavigationFilmToDetailFilmActivity toDetailFilm = FilmFragmentDirections.actionNavigationFilmToDetailFilmActivity(film);
            Navigation.findNavController(view).navigate(toDetailFilm);
        });
    }

    @Override
    public void populateListFilm(FilmsResponse filmsResponse) {
        new Handler().postDelayed(() -> {
            listFilm.addAll(filmsResponse.getResults());

            FilmAdapter filmAdapter = (FilmAdapter) Objects.requireNonNull(rvFilm.getAdapter());
            filmAdapter.notifyDataSetChanged();
            hideShimmer();

        }, 1500);
    }

    @Override
    public void listFilmFailure(String message) {
        hideShimmer();
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
