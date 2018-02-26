package com.uninorte.salcedosemana06;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {


    EditText nameE, lastnameE, positionE, ageE;
    CheckBox selectedE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        Player h = (Player) intent.getSerializableExtra("Player");

        nameE = (EditText)findViewById(R.id.name);
        lastnameE = (EditText)findViewById(R.id.lastname);
        positionE = (EditText)findViewById(R.id.position);
        ageE = (EditText)findViewById(R.id.age);
        selectedE = (CheckBox)findViewById(R.id.selected);

        nameE.setText(h.name);
        lastnameE.setText(h.lastname);
        positionE.setText(h.position);
        ageE.setText(h.age+"");
        selectedE.setChecked(h.selected);
    }

    public Player getNewPlayer(){
        String name = nameE.getText().toString();
        String lastname = lastnameE.getText().toString();
        String position = positionE.getText().toString();
        int age = Integer.parseInt(ageE.getText().toString());
        boolean selected = selectedE.isChecked();

        return new Player(name, lastname, position, selected, age);
    }

    public void onClickSave(View view) {
        Intent intent = new Intent();
        Player newPlayer = getNewPlayer();
        intent.putExtra("Player",newPlayer);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
