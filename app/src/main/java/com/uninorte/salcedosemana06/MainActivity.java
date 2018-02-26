package com.uninorte.salcedosemana06;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    public ArrayList<Player> players;
    int modif_player = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        players = new ArrayList<Player>();
        players.add(new Player("James", "Rodríguez", "Volante", true, 26 ));
        players.add(new Player("Juan Guillermo", "Cuadrado", "Volante", false, 29 ));
        players.add(new Player("Carlos", "Bacca", "Centro", true, 31 ));

        lv = (ListView) findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(this, players);

        lv.setAdapter(adapter);
        final Context con = lv.getContext();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(con, InfoActivity.class);
                intent.putExtra("Player", players.get(i));
                startActivityForResult(intent,2);
            }
        });

    }

    public void onClickEdit(View view) {
        Intent i = new Intent(this, EditActivity.class);
        modif_player = (Integer)view.getTag();
        i.putExtra("Player", players.get(modif_player));
        startActivityForResult(i,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            Player newPlayer = (Player) data.getSerializableExtra("Player");
            players.set(modif_player, newPlayer);
            CustomAdapter adapter = new CustomAdapter(this, players);
            lv.setAdapter(adapter);
        }
        /*if(requestCode == 2 && resultCode == Activity.RESULT_OK){
        }*/
    }

}
