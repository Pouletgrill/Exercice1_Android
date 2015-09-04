package com.example.j.exercice1;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by 201354694 on 2015-09-04.
 */
public class Peintre implements OnClickListener {
    private int couleur;
    private Palette mMainActivity;

    // construit le gestionnaire et enregistre la couleur et
    // l'activité principale
    public Peintre(int couleur, Palette mainActivity) {
        this.couleur = couleur;
        this.mMainActivity = mainActivity;
    }

    // fait appel à une méthode de l'activité principale
    @Override
    public void onClick(View vue) {
        mMainActivity.peindreRegion(couleur);
    }
}
