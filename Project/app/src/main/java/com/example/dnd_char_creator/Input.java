package com.example.dnd_char_creator;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.itextpdf.kernel.colors.ColorConstants;

public class Input extends Fragment {


    public EditText health;
    public EditText armourclass;
    public EditText speed;
    EditText equipmentText;
    ImageButton randomizeButton;

    EditText firstNmbr;
    EditText secondNmbr;
    EditText thirdNmbr;
    EditText fourthNmbr;
    EditText fifthNmbr;
    EditText sixtNmbr;

    EditText strengthNmbr;
    EditText wisdomNmbr;
    EditText dexterityNmbr;
    EditText constitutionNmbr;
    EditText intelligenceNmbr;
    EditText charmNmbr;
    EditText lastClickedText;

    ImageView portraitView;

    Spinner spinnerGender;
    Spinner spinnerClass;
    Spinner spinnerRace;
    Spinner spinnerBackground;

    EditText name;

    int portraitID;

    public Input() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        randomizeButton = view.findViewById(R.id.imageButton);


        name = view.findViewById(R.id.editTextTextName);
        armourclass = view.findViewById(R.id.editTextNumberArmor);
        health = view.findViewById(R.id.editTextNumberHP);
        speed = view.findViewById(R.id.editTextNumberSpeed);
        equipmentText = view.findViewById(R.id.editTextEquipments);


        firstNmbr =  (EditText) view.findViewById(R.id.editTextNumberdicevalue1);
        secondNmbr =  (EditText) view.findViewById(R.id.editTextNumberdicevalue2);
        thirdNmbr =  (EditText) view.findViewById(R.id.editTextNumberdicevalue3);
        fourthNmbr =  (EditText) view.findViewById(R.id.editTextNumberdicevalue4);
        fifthNmbr =  (EditText) view.findViewById(R.id.editTextNumberdicevalue5);
        sixtNmbr =  (EditText) view.findViewById(R.id.editTextNumberdicevalue6);

        strengthNmbr =  (EditText) view.findViewById(R.id.editTextNumberStrength);
        wisdomNmbr =  (EditText) view.findViewById(R.id.editTextNumberWisdom);
        dexterityNmbr =  (EditText) view.findViewById(R.id.editTextNumberDexterity);
        constitutionNmbr =  (EditText) view.findViewById(R.id.editTextNumberConstitution);
        intelligenceNmbr =  (EditText) view.findViewById(R.id.editTextNumberIntelligence);
        charmNmbr =  (EditText) view.findViewById(R.id.editTextNumberCharisma);

        portraitView = view.findViewById(R.id.imageViewportrait);


        spinnerGender = view.findViewById(R.id.spinnerGender);
        spinnerClass = view.findViewById(R.id.spinnerClass);
        spinnerRace = view.findViewById(R.id.spinnerRace);
        spinnerBackground = view.findViewById(R.id.spinnerBackground);

        setupListeners(view);

        return view;
    }

    private void setupListeners(View view){

        firstNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(firstNmbr);
            }
        });
        secondNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(secondNmbr);
            }
        });
        thirdNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(thirdNmbr);
            }
        });
        fourthNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(fourthNmbr);
            }
        });
        fifthNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(fifthNmbr);
            }
        });
        sixtNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(sixtNmbr);
            }
        });

        strengthNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(strengthNmbr);
            }
        });

        wisdomNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(wisdomNmbr);
            }
        });
        dexterityNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(dexterityNmbr);
            }
        });
        constitutionNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(constitutionNmbr);
            }
        });
        intelligenceNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(intelligenceNmbr);
            }
        });
        charmNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                exchange(charmNmbr);
            }
        });

        randomizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Dice(getActivity(), new DL(firstNmbr)).roll();
                new Dice(getActivity(), new DL(secondNmbr)).roll();
                new Dice(getActivity(), new DL(thirdNmbr)).roll();
                new Dice(getActivity(), new DL(fourthNmbr)).roll();
                new Dice(getActivity(), new DL(fifthNmbr)).roll();
                new Dice(getActivity(), new DL(sixtNmbr)).roll();

                 strengthNmbr.setText("");
                 wisdomNmbr.setText("");
                 dexterityNmbr.setText("");
                 constitutionNmbr.setText("");
                 intelligenceNmbr.setText("");
                 charmNmbr.setText("");
                 if(lastClickedText!=null){
                     lastClickedText.setBackgroundColor(getResources().getColor(R.color.white));
                     lastClickedText = null;
                 }

            }
        });

        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updatePortrait();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updatePortrait();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updatePortrait();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void exchange(EditText textToChange){
        if(lastClickedText != null){
            String temp = textToChange.getText().toString();
            textToChange.setText(lastClickedText.getText().toString());

            lastClickedText.setBackgroundColor(getResources().getColor(R.color.white));
            lastClickedText.setText(temp);
            lastClickedText = null;
        }
        else
        {
            lastClickedText = textToChange;
            lastClickedText.setBackgroundColor(getResources().getColor(R.color.highlight_light));
        }
    }

    public void updatePortrait(){
        String charclass = "";
        if(spinnerClass.getSelectedItem().toString().equals("rogue")){ //Spelled wrong for every image filename so we need to do this...
            charclass = "rouge";
        }else{
            charclass = spinnerClass.getSelectedItem().toString();
        }
        String filename = spinnerGender.getSelectedItem().toString() + "_" + spinnerRace.getSelectedItem().toString() + "_" + charclass;
        int id = getResources().getIdentifier(filename, "drawable", getActivity().getPackageName());
        portraitView.setImageResource(id);
        portraitID = id;
    }

    private class DL implements Dice.rollListener {
        EditText target;
        public DL(EditText target){
            this.target = target;
        }
        public void rollLoaded(int results) {
            target.setText(Integer.toString(results));
        }
    }



}