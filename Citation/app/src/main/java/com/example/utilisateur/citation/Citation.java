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
        String text = null;
        switch (GetRandUnrepeatNumber(1,5))
        {
            case 1:
                text = this.getString(R.string.AlbertE1);
                break;
            case 2:
                text = this.getString(R.string.AlbertE2);
                break;
            case 3:
                text = this.getString(R.string.AlbertE3);
                break;
            case 4:
                text = this.getString(R.string.AlbertE4);
                break;
            case 5:
                text = this.getString(R.string.AlbertE5);
                break;
            case -1:
                text = "Shit's happen :(";
                break;
        }
        mTextView.setText(text);
    }

    public void afficherInfosBoutonImage2(View bouton)
    {
        String text = null;
        switch (GetRandUnrepeatNumber(1,5))
        {
            case 1:
                text = this.getString(R.string.bttf1);
                break;
            case 2:
                text = this.getString(R.string.bttf2);
                break;
            case 3:
                text = this.getString(R.string.bttf3);
                break;
            case 4:
                text = this.getString(R.string.bttf4);
                break;
            case 5:
                text = this.getString(R.string.bttf5);
                break;
            case -1:
                text = "Shit's happen :(";
                break;
        }
        mTextView.setText(text);
    }

    public void afficherInfosBoutonImage3(View bouton)
    {
        String text = null;
        switch (GetRandUnrepeatNumber(1,5))
        {
            case 1:
                text = this.getString(R.string.winstonC1);
                break;
            case 2:
                text = this.getString(R.string.winstonC2);
                break;
            case 3:
                text = this.getString(R.string.winstonC3);
                break;
            case 4:
                text = this.getString(R.string.winstonC4);
                break;
            case 5:
                text = this.getString(R.string.winstonC5);
                break;
            case -1:
                text = "Shit's happen :(";
                break;
        }
        mTextView.setText(text);
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
