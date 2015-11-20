package com.project.se137.androidlab.mortgagecalculator;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;

public class MortgageActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Get MenuInflater to inflate the desired menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_mortgage, menu);
        return true;
    }


}
