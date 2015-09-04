package com.example.j.exercice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

public class Palette extends AppCompatActivity {

    private View mZoneCouleur;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        mZoneCouleur = findViewById(R.id.zone_couleur);

        ToggleButton b1 = (ToggleButton)findViewById(R.id.ToggleButton1);
        ToggleButton b2 = (ToggleButton)findViewById(R.id.ToggleButton2);
        ToggleButton b3 = (ToggleButton)findViewById(R.id.ToggleButton3);

        // même gestionnaire pour boutons ordinaires et boutons radio,
        // on passe la couleur et une référence à l'activité principale
        b1.setOnClickListener(new Peintre(Color.RED, this));
        b2.setOnClickListener(new Peintre(Color.GREEN, this));
        b3.setOnClickListener(new Peintre(Color.BLUE, this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_palette, menu);
        return true;
    }

    public void peindreRegion(int couleur) {
        mZoneCouleur.setBackgroundColor(couleur);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
