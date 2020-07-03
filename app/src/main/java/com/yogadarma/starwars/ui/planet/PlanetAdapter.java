package com.yogadarma.starwars.ui.planet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.base.BaseAdapter;
import com.yogadarma.starwars.model.responses.PlanetResultsItem;

import java.util.ArrayList;

public class PlanetAdapter extends BaseAdapter {

    TextView tvPlanetName, tvPlanetClimate, tvPlanetPopulation;
    CardView cardView;
    private OnItemClickCallback onItemClickCallback;

    interface OnItemClickCallback {
        void onItemClicked(PlanetResultsItem planet);
    }

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public PlanetAdapter(Context context, ArrayList<PlanetResultsItem> listPlanet) {
        super(context);
        list = listPlanet;
        layoutId = R.layout.layout_main_item;
    }

    @Override
    public void onBindView(int position, Object itemView) {
        PlanetResultsItem planet = (PlanetResultsItem) itemView;
        tvPlanetName.setText(planet.getName());
        tvPlanetClimate.setText(planet.getClimate());
        tvPlanetPopulation.setText(planet.getPopulation());

        cardView.setOnClickListener(v -> {
            onItemClickCallback.onItemClicked(planet);
        });
    }

    @Override
    protected View getView(View itemView) {
        tvPlanetName = bind(R.id.tv_title);
        tvPlanetClimate = bind(R.id.tv_subtitle_1);
        tvPlanetPopulation = bind(R.id.tv_subtitle_2);
        cardView = bind(R.id.card_view);
        return itemView;
    }
}
