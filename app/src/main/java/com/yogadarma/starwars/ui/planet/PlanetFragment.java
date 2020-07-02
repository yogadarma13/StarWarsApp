package com.yogadarma.starwars.ui.planet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.PlanetResponse;

public class PlanetFragment extends Fragment implements PlanetContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planet, container, false);
    }

    @Override
    public void populateListPlanet(PlanetResponse planetResponse) {

    }

    @Override
    public void listPlanetFailure(String message) {

    }
}