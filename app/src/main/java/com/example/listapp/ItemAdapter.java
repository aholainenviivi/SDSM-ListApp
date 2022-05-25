package com.example.listapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    String[] categories, descriptions;
    int icons[];
    LayoutInflater layoutInflater;

    public ItemAdapter(Context context, String[] categories, String[] descriptions, int icons[]) {
        this.categories = categories;
        this.descriptions = descriptions;
        this.icons = icons;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int i) {
        return categories[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.layout_item_in_ironmen_listview, null);
        TextView categoriesTextView = v.findViewById(R.id.categoryTextView);
        TextView descriptionTextView = v.findViewById(R.id.descriptionTextView);
        ImageView iconImageView = v.findViewById(R.id.iconImageView);

        categoriesTextView.setText(categories[i]);
        descriptionTextView.setText(descriptions[i]);
        iconImageView.setImageResource(icons[i]);

        return v;
    }

}
