package com.yogadarma.starwars.ui.detail_planet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.PlanetResultsItem;

public class DetailPlanetActivity extends AppCompatActivity {

    private TextView tvPlanetName, tvPlanetRotation, tvPlanetOrbital, tvPlanetDiameter, tvPlanetClimate, tvPlanetGravity, tvPlanetTerrain, tvPlanetPopulation;
    private PlanetResultsItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_planet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Planet");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        item = DetailPlanetActivityArgs.fromBundle(getIntent().getExtras()).getPlanet();

        initView();
        setupView();

    }

    private void initView() {
        tvPlanetName = findViewById(R.id.tv_planet_name);
        tvPlanetRotation = findViewById(R.id.tv_planet_rotation);
        tvPlanetOrbital = findViewById(R.id.tv_planet_orbital);
        tvPlanetDiameter = findViewById(R.id.tv_planet_diameter);
        tvPlanetClimate = findViewById(R.id.tv_planet_climate);
        tvPlanetGravity = findViewById(R.id.tv_planet_gravity);
        tvPlanetTerrain = findViewById(R.id.tv_planet_terrain);
        tvPlanetPopulation = findViewById(R.id.tv_planet_population);
    }

    private void setupView() {
        tvPlanetName.setText(item.getName());
        tvPlanetRotation.setText(item.getRotationPeriod());
        tvPlanetOrbital.setText(item.getOrbitalPeriod());
        tvPlanetDiameter.setText(item.getDiameter());
        tvPlanetClimate.setText(item.getClimate());
        tvPlanetGravity.setText(item.getGravity());
        tvPlanetTerrain.setText(item.getTerrain());
        tvPlanetPopulation.setText(item.getPopulation());
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
