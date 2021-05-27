package com.example.dnd_char_creator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().show();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add((R.id.container),new start(), null).commit();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        getMenuInflater().inflate( R.menu.menu_topdf, menu );
        return true;
    }

}