package com.example.utilisateur.code_acces;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityDeux extends AppCompatActivity {
    private String motDePasse_Def = "1337";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_deux);
        Intent intent = getIntent();
        // extraction du message
        String utilisateur = intent.getStringExtra("Username");
        String motDePasse = intent.getStringExtra("Password");

        //Création du textbox pour afficher message
        TextView textView = new TextView(this);
        textView.setTextSize(20);

        if (motDePasse.equals(motDePasse_Def))//bon mot de passe
        {
            textView.setText(this.getString(R.string.helloMessage) + " " + utilisateur);
            textView.setBackgroundColor(Color.GREEN);
        }
        else //Mauvais mot de passe
        {
            textView.setText(this.getString(R.string.ErrorMessage));
            textView.setBackgroundColor(Color.RED);
        }
        setContentView(textView);
    }
}
