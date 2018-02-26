package com.uninorte.salcedosemana06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView nameE, lastnameE, positionE, ageE, selectedE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        Player h = (Player) intent.getSerializableExtra("Player");

        nameE = (TextView)findViewById(R.id.name);
        lastnameE = (TextView)findViewById(R.id.lastname);
        positionE = (TextView)findViewById(R.id.position);
        ageE = (TextView)findViewById(R.id.age);
        selectedE = (TextView)findViewById(R.id.selected);

        nameE.setText(h.name);
        lastnameE.setText(h.lastname);
        positionE.setText(h.position);
        ageE.setText(h.age+"");
        selectedE.setText(h.selected? "Sí" : "No");

    }

    public void onClickOK(View view) {
        finish();
    }
}
