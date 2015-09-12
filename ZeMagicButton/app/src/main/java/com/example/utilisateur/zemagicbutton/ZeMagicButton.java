package com.example.utilisateur.zemagicbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.widget.Toast;

public class ZeMagicButton extends AppCompatActivity {

    public List<Button> list_Bouton = new ArrayList<Button>();
    private int LastPigeBTN=0;
    private int LastPigeCLR=0;
    private Random rand = new Random();
    public int numLeft = 10;
    public int Niveau = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ze_magic_button);

        // récupération des widgets depuis le fichier XML

        //Row 0
        list_Bouton.add((Button) findViewById(R.id.bouton00));
        list_Bouton.add((Button) findViewById(R.id.bouton01));
        list_Bouton.add((Button) findViewById(R.id.bouton02));
        list_Bouton.add((Button) findViewById(R.id.bouton03));
        //Row 1
        list_Bouton.add((Button) findViewById(R.id.bouton10));
        list_Bouton.add((Button) findViewById(R.id.bouton11));
        list_Bouton.add((Button) findViewById(R.id.bouton12));
        list_Bouton.add((Button) findViewById(R.id.bouton13));
        //Row 2
        list_Bouton.add((Button) findViewById(R.id.bouton20));
        list_Bouton.add((Button) findViewById(R.id.bouton21));
        list_Bouton.add((Button) findViewById(R.id.bouton22));
        list_Bouton.add((Button) findViewById(R.id.bouton23));
        //Row 3
        list_Bouton.add((Button) findViewById(R.id.bouton30));
        list_Bouton.add((Button) findViewById(R.id.bouton31));
        list_Bouton.add((Button) findViewById(R.id.bouton32));
        list_Bouton.add((Button) findViewById(R.id.bouton33));

        for (int i=0;i<list_Bouton.size();i++)
        {
            list_Bouton.get(i).setOnClickListener(new Jouer(list_Bouton.get(i)));
        }
    }

    // la classe interne nommée est privée
    private class Jouer implements OnClickListener {
        private Button btn;

        public Jouer(Button BTN) {
            //this.couleur = couleur;
            btn = BTN;
        }

        @Override
        public void onClick(View vue) {
            // fait appel à une méthode hors de la classe interne
            btn.setVisibility(View.INVISIBLE);
            int nextPopNum = GetRandUnrepeatNumber(0, list_Bouton.size() - 1);
            if (numLeft<=1)
            {
                ResetGame();
                list_Bouton.get(nextPopNum).setText(String.valueOf(numLeft-1));
                int color = randColor();
                for (int i=0;i<list_Bouton.size();i++)
                {
                    list_Bouton.get(i).setBackgroundColor(color);
                }
                findViewById(R.id.BackgroundLayout).setBackgroundColor(randColor());
            }
            else
                list_Bouton.get(nextPopNum).setText(String.valueOf(numLeft-1));
            list_Bouton.get(nextPopNum).setVisibility(View.VISIBLE);
            numLeft -=1 ;

        }
    }

    public void Start_Click(View vue)
    {
        int hazardNum = GetRandUnrepeatNumber(0, list_Bouton.size() - 1);
        list_Bouton.get(hazardNum).setText(String.valueOf(numLeft));
        list_Bouton.get(hazardNum).setVisibility(View.VISIBLE);
        vue.setVisibility(View.INVISIBLE);
    }

    public int GetRandUnrepeatNumber(int min, int max)
    {
        int pige;
        if (min<max)
        {do
            {
                pige = rand.nextInt((max - min) + 1) + min;
            } while (pige == LastPigeBTN);
            LastPigeBTN = pige;
        }
        else
            pige = -1;
        return pige;
    }

    public int randColor()
    {
        int color = Color.argb(GetRandUnrepeatNumber(0,255),
                GetRandUnrepeatNumber(0,255),
                GetRandUnrepeatNumber(0,255),
                GetRandUnrepeatNumber(0,255));
        return color;
    }

    public void ResetGame()
    {
        Niveau++;
        Toast.makeText(getApplicationContext(),"Félicitation ! Niveau "+String.valueOf(Niveau),Toast.LENGTH_LONG).show();
        LastPigeCLR=0;
        numLeft=10 + (Niveau * 2)+1;
    }
}
