package com.ducks.vai_pra_onde.Geral.TelasFront;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AppCompatActivity;

import com.ducks.vai_pra_onde.R;

public class FragmentManagerHelper {

    public static void replaceFragment(AppCompatActivity activity, Fragment fragment) {

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.fragContCadasPJ, fragment);


        transaction.addToBackStack(null);


        transaction.commit();
    }
}
