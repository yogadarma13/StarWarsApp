package com.yogadarma.starwars.ui.people;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.base.BaseAdapter;
import com.yogadarma.starwars.model.responses.PeopleResultsItem;

import java.util.ArrayList;

public class PeopleAdapter extends BaseAdapter {

    TextView tvPeopleName, tvPeopleBirthYear, tvPeopleGender;

    public PeopleAdapter(Context context, ArrayList<PeopleResultsItem> listPeople) {
        super(context);
        list = listPeople;
        layoutId = R.layout.layout_main_film;
    }

    @Override
    public void onBindView(int position, Object itemView) {
        PeopleResultsItem people = (PeopleResultsItem) itemView;
        tvPeopleName.setText(people.getName());
        tvPeopleBirthYear.setText(people.getBirthYear());
        tvPeopleGender.setText(people.getGender());
    }

    @Override
    protected View getView(View itemView) {
        tvPeopleName = bind(R.id.tv_film_title);
        tvPeopleBirthYear = bind(R.id.tv_film_director);
        tvPeopleGender = bind(R.id.tv_film_release_date);

        return itemView;
    }
}
