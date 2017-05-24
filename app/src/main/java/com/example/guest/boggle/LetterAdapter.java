package com.example.guest.boggle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LetterAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mLetters;

    public LetterAdapter (Context context, ArrayList<String> letters){
        this.mContext = context;
        this.mLetters = letters;
    }

    @Override
    public int getCount() {
        return mLetters.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if(convertView == null){
            gridView = inflater.inflate(R.layout.letter_grid_item, null);
            TextView letterView = (TextView) gridView.findViewById(R.id.letterInGridItem);
            letterView.setText(mLetters.get(position));
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
