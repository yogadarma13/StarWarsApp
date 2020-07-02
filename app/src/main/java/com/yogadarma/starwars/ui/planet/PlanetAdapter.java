package com.yogadarma.starwars.ui.planet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.base.BaseAdapter;
import com.yogadarma.starwars.model.responses.PlanetResultsItem;

import java.util.ArrayList;

public class PlanetAdapter extends BaseAdapter {

    TextView tvPlanetName, tvPlanetClimate, tvPlanetPopulation;

    public PlanetAdapter(Context context, ArrayList<PlanetResultsItem> listPlanet) {
        super(context);
        list = listPlanet;
        layoutId = R.layout.layout_main_film;
    }

    @Override
    public void onBindView(int position, Object itemView) {
        PlanetResultsItem planet = (PlanetResultsItem) itemView;
        tvPlanetName.setText(planet.getName());
        tvPlanetClimate.setText(planet.getClimate());
        tvPlanetPopulation.setText(planet.getPopulation());
    }

    @Override
    protected View getView(View itemView) {
        tvPlanetName = bind(R.id.tv_film_title);
        tvPlanetClimate = bind(R.id.tv_film_director);
        tvPlanetPopulation = bind(R.id.tv_film_release_date);

        return itemView;
    }
}
