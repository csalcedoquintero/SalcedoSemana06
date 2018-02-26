package com.uninorte.salcedosemana06;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Visitante on 26/02/2018.
 */

public class CustomAdapter extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Player> items;

    public CustomAdapter (Activity activity, ArrayList<Player> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (view == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_category, null);
        }

        Player player = items.get(i);

        TextView name = (TextView) v.findViewById(R.id.name);
        name.setText(player.name);

        TextView lastname = (TextView) v.findViewById(R.id.lastname);
        lastname.setText(player.lastname);

        TextView position = (TextView) v.findViewById(R.id.position);
        position.setText(player.position);

        TextView selected = (TextView) v.findViewById(R.id.selected);
        selected.setText(player.selected? "Sí":"No");

        Button edit = v.findViewById(R.id.edit);
        edit.setText("Editar");
        edit.setTag(i);
        edit.setFocusable(false);
        edit.setFocusableInTouchMode(false);
        return v;
    }
}
