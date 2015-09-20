package com.example.utilisateur.code_acces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CodeAcces extends AppCompatActivity {
    public List<Button> list_Bouton = new ArrayList<Button>();
    String codeEntrer="";
    EditText TB_name;
    EditText TB_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_acces);
        TB_name = (EditText) findViewById(R.id.username);
        TB_Password = (EditText) findViewById(R.id.passcode);
        // récupération des widgets depuis le fichier XML
        //Row 0
        list_Bouton.add((Button) findViewById(R.id.Num0));//0
        list_Bouton.add((Button) findViewById(R.id.Num1));
        list_Bouton.add((Button) findViewById(R.id.Num2));
        list_Bouton.add((Button) findViewById(R.id.Num3));
        list_Bouton.add((Button) findViewById(R.id.Num4));
        list_Bouton.add((Button) findViewById(R.id.Num5));
        list_Bouton.add((Button) findViewById(R.id.Num6));
        list_Bouton.add((Button) findViewById(R.id.Num7));
        list_Bouton.add((Button) findViewById(R.id.Num8));
        list_Bouton.add((Button) findViewById(R.id.Num9));//9
        list_Bouton.add((Button) findViewById(R.id.Effacer));//10
        list_Bouton.add((Button) findViewById(R.id.Valider));//11
        //Creation du gestionnaire d'évênement pour chaque boutons
        for (int i = 0;i<list_Bouton.size();i++)
        {
            list_Bouton.get(i).setOnClickListener(new GestButton(i));
        }
    }
    private class GestButton implements View.OnClickListener{
        private int btn;

        public GestButton(int BTN){
            btn=BTN;
        }

        @Override
        public void onClick(View vue) {
            if (btn < 10)//Pavé numérique
            {
                if (codeEntrer.length()<4)
                {
                    TB_Password.setText(TB_Password.getText() + "*");
                    codeEntrer += String.valueOf(btn);
                }

                if (codeEntrer.length()==4 && TB_name.length()>0)
                    list_Bouton.get(11).setEnabled(true);
                else
                    list_Bouton.get(11).setEnabled(false);
            }
            else if (btn == 10)//Effacer
            {
                if (codeEntrer.length()>0)
                {
                    String tempoStar="";
                    codeEntrer = codeEntrer.substring(0,codeEntrer.length()-1);
                    for (int i=0;i<codeEntrer.length();i++)
                    {
                        tempoStar += "*";
                    }
                    TB_Password.setText(tempoStar);

                    if (codeEntrer.length()==4 && TB_name.length()>0)
                        list_Bouton.get(11).setEnabled(true);
                    else
                        list_Bouton.get(11).setEnabled(false);
                }
            }
            else if (btn == 11)//Valider
            {
                if (codeEntrer.length()==4 && TB_name.length()>0)
                {
                    Intent intent = new Intent(vue.getContext(),ActivityDeux.class);
                    intent.putExtra("Username", String.valueOf(TB_name.getText()));
                    intent.putExtra("Password", codeEntrer);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "un problème est survenue au\nniveau du nom d'utilisateur", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}
