package com.yogadarma.starwars.ui.people;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.yogadarma.starwars.R;
import com.yogadarma.starwars.base.BaseAdapter;
import com.yogadarma.starwars.model.responses.PeopleResultsItem;

import java.util.ArrayList;

public class PeopleAdapter extends BaseAdapter {

    TextView tvPeopleName, tvPeopleBirthYear, tvPeopleGender;
    CardView cardView;
    private OnItemClickCallback onItemClickCallback;

    interface OnItemClickCallback {
        void onItemClicked(PeopleResultsItem people);
    }

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public PeopleAdapter(Context context, ArrayList<PeopleResultsItem> listPeople) {
        super(context);
        list = listPeople;
        layoutId = R.layout.layout_main_item;
    }

    @Override
    public void onBindView(int position, Object itemView) {
        PeopleResultsItem people = (PeopleResultsItem) itemView;
        tvPeopleName.setText(people.getName());
        tvPeopleBirthYear.setText(people.getBirthYear());
        tvPeopleGender.setText(people.getGender());

        cardView.setOnClickListener(v -> {
            onItemClickCallback.onItemClicked(people);
        });
    }

    @Override
    protected View getView(View itemView) {
        tvPeopleName = bind(R.id.tv_title);
        tvPeopleBirthYear = bind(R.id.tv_subtitle_1);
        tvPeopleGender = bind(R.id.tv_subtitle_2);
        cardView = bind(R.id.card_view);
        return itemView;
    }
}
