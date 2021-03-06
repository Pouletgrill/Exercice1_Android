package com.example.j.exercice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Palette extends AppCompatActivity {

    private View mZoneCouleur;
    private int fontColor = Color.BLACK;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        mZoneCouleur = findViewById(R.id.zone_couleur);
        peindreRegion(fontColor);
    }
    //Rouge
    public void afficherInfosBoutonBasculeR(View boutonBascule) {
        ToggleButton bouton = (ToggleButton)boutonBascule;
        if (bouton.isChecked()) {
            fontColor = fontColor | 0x00FF0000;
            peindreRegion(fontColor);
        }
        else
        {
            fontColor = fontColor & 0xFF00FFFF;
            peindreRegion(fontColor);
        }
    }
    //Vert
    public void afficherInfosBoutonBasculeV(View boutonBascule) {
        ToggleButton bouton = (ToggleButton)boutonBascule;
        if (bouton.isChecked()) {
            fontColor = fontColor | 0x0000FF00;
            peindreRegion(fontColor);
        }
        else
        {
            fontColor = fontColor & 0xFFFF00FF;
            peindreRegion(fontColor);
        }
    }
    //Bleu
    public void afficherInfosBoutonBasculeB(View boutonBascule) {
        ToggleButton bouton = (ToggleButton)boutonBascule;
        //Toast.makeText(getApplicationContext(),String.valueOf(fontColor),
        //        Toast.LENGTH_SHORT).show();
        if (bouton.isChecked()) {
            fontColor = fontColor | 0x000000FF;
            peindreRegion(fontColor);
        }
        else
        {
            fontColor = fontColor & 0xFFFFFF00;
            peindreRegion(fontColor);
        }
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
