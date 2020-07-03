package com.yogadarma.starwars.ui.detail_people;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.model.responses.PeopleResultsItem;

public class DetailPeopleActivity extends AppCompatActivity {

    private TextView tvPeopleName, tvPeopleHeight, tvPeopleMass, tvPeopleHairColor, tvPeopleSkinColor, tvPeopleEyeColor, tvPeopleGender;
    private PeopleResultsItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_people);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail People");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        item = DetailPeopleActivityArgs.fromBundle(getIntent().getExtras()).getPeople();

        initView();
        setupView();
    }

    private void initView() {
        tvPeopleName = findViewById(R.id.tv_people_name);
        tvPeopleHeight = findViewById(R.id.tv_people_height);
        tvPeopleMass = findViewById(R.id.tv_people_mass);
        tvPeopleHairColor = findViewById(R.id.tv_people_hair_color);
        tvPeopleSkinColor = findViewById(R.id.tv_people_skin_color);
        tvPeopleEyeColor = findViewById(R.id.tv_people_eye_color);
        tvPeopleGender = findViewById(R.id.tv_people_gender);
    }

    private void setupView() {
        tvPeopleName.setText(item.getName());
        tvPeopleHeight.setText(item.getHeight());
        tvPeopleMass.setText(item.getMass());
        tvPeopleHairColor.setText(item.getHairColor());
        tvPeopleSkinColor.setText(item.getSkinColor());
        tvPeopleEyeColor.setText(item.getEyeColor());
        tvPeopleGender.setText(item.getGender());
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
