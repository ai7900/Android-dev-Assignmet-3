package com.example.dnd_char_creator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;
    static Input input;
    PdfSave pdfSave;
    private static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add((R.id.container),new start(), null);
        transaction.commit();
        pdfSave = new PdfSave(this);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.rpg);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        getMenuInflater().inflate( R.menu.menu_topdf, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_topdf:
                // User chose the "Settings" item, show the app settings UI...
                Log.d("Test", input.spinnerRace.getSelectedItem().toString());
                try {
                    String[] equipments = input.equipmentText.getText().toString().split("\n");
                    pdfSave.createPdf(input.portraitID,
                            input.name.getText().toString(),
                            input.spinnerClass.getSelectedItem().toString(),
                            input.spinnerRace.getSelectedItem().toString(),
                            input.spinnerGender.getSelectedItem().toString(),
                            input.spinnerBackground.getSelectedItem().toString(),
                            input.health.getText().toString(),
                            input.armourclass.getText().toString(),
                            input.speed.getText().toString(),
                            equipments,
                            input.strengthNmbr.getText().toString(),
                            input.constitutionNmbr.getText().toString(),
                            input.dexterityNmbr.getText().toString(),
                            input.intelligenceNmbr.getText().toString(),
                            input.wisdomNmbr.getText().toString(),
                            input.charmNmbr.getText().toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}