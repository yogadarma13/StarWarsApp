package com.yogadarma.starwars.ui.planet;

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
import com.yogadarma.starwars.model.responses.PlanetResponse;
import com.yogadarma.starwars.model.responses.PlanetResultsItem;

import java.util.ArrayList;
import java.util.Objects;

public class PlanetFragment extends Fragment implements PlanetContract.View {

    private PlanetContract.Presenter mPresenter;
    private RecyclerView rvPlanet;
    private PlanetAdapter planetAdapter;
    private ShimmerFrameLayout shimmerFrameLayout;
    ArrayList<PlanetResultsItem> listPlanet = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_planet);
        rvPlanet = view.findViewById(R.id.rv_planet);
        setupRecyclerView();

        mPresenter = new PlanetPresenter(this);
        mPresenter.getListPlanet();

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
        rvPlanet.setLayoutManager(new LinearLayoutManager(getActivity()));

        planetAdapter = new PlanetAdapter(getActivity(), listPlanet);
        rvPlanet.setAdapter(planetAdapter);
    }

    private void setupListener(View view) {

        planetAdapter.setOnItemClickCallback(new PlanetAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(PlanetResultsItem planet) {
                PlanetFragmentDirections.ActionNavigationPlanetToDetailPlanetActivity toPlanetDetail = PlanetFragmentDirections.actionNavigationPlanetToDetailPlanetActivity(planet);
                Navigation.findNavController(view).navigate(toPlanetDetail);
            }
        });
    }

    @Override
    public void populateListPlanet(PlanetResponse planetResponse) {
        new Handler().postDelayed(() -> {
            listPlanet.addAll(planetResponse.getResults());

            PlanetAdapter planetAdapter = (PlanetAdapter) Objects.requireNonNull(rvPlanet.getAdapter());
            planetAdapter.notifyDataSetChanged();

            hideShimmer();
        }, 1500);
    }

    @Override
    public void listPlanetFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

        hideShimmer();
    }
}
