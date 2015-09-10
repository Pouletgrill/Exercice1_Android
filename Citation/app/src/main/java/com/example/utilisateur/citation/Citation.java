package com.example.utilisateur.citation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Citation extends AppCompatActivity {

    private TextView mTextView;
    private int LastPige=0;
    private Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citation);
        mTextView = (TextView)findViewById(R.id.TV);
    }

    public void afficherInfosBoutonImage1(View bouton)
    {
        mTextView.setText(Integer.toString(GetRandUnrepeatNumber(5,0)));
    }

    public void afficherInfosBoutonImage2(View bouton)
    {
        mTextView.setText(this.getString(R.string.winstonC5));
    }

    public void afficherInfosBoutonImage3(View bouton)
    {

    }

    public int GetRandUnrepeatNumber(int min, int max)
    {
        int pige;
        if (min<max)
        {
            do
            {
                pige = rand.nextInt((max - min) + 1) + min;
            } while (pige == LastPige);
            LastPige = pige;
        }
        else
        {
            pige = -1;
        }
        return pige;
    }
}
