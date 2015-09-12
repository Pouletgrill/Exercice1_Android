package com.example.utilisateur.zemagicbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class ZeMagicButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ze_magic_button);

        // récupération des widgets depuis le fichier XML
        List<Button> list_Bouton = new ArrayList<Button>();
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
        list_Bouton.get(0).setOnClickListener(new Jouer(list_Bouton.get(0)));
    }

    // la classe interne nommée est privée
    private class Jouer implements OnClickListener {
        private Button btn;

        public Jouer(Button BTN) {
            //this.couleur = couleur;
            //Toast.makeText(getApplicationContext(),"public Jouer(Button BTN)",
                    //Toast.LENGTH_SHORT).show();
            btn = BTN;
        }

        @Override
        public void onClick(View vue) {
            // fait appel à une méthode hors de la classe interne
            //Toast.makeText(getApplicationContext(),"public void onClick(View vue)",
                    //Toast.LENGTH_SHORT).show();
            btn.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ze_magic_button, menu);
        return true;
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
