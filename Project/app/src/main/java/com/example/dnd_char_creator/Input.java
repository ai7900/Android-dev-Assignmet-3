package com.example.dnd_char_creator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Input extends Fragment {

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
        lastClickedText = (EditText) view.findViewById(R.id.editTextNumberdicevalue1);
        setupListeners(view);

        return view;
    }

    private void setupListeners(View view){
        firstNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = firstNmbr.getText().toString();
                firstNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = firstNmbr;
            }
        });
        secondNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = secondNmbr.getText().toString();
                secondNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = secondNmbr;

            }
        });
        thirdNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = thirdNmbr.getText().toString();
                thirdNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = thirdNmbr;

            }
        });
        fourthNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = fourthNmbr.getText().toString();
                fourthNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = fourthNmbr;

            }
        });
        fifthNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = fifthNmbr.getText().toString();
                fifthNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = fifthNmbr;

            }
        });
        sixtNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = sixtNmbr.getText().toString();
                sixtNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = sixtNmbr;

            }
        });

        strengthNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = strengthNmbr.getText().toString();
                strengthNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = strengthNmbr;
            }
        });

        wisdomNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = wisdomNmbr.getText().toString();
                wisdomNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = wisdomNmbr;

            }
        });
        dexterityNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = dexterityNmbr.getText().toString();
                dexterityNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = dexterityNmbr;

            }
        });
        constitutionNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = constitutionNmbr.getText().toString();
                constitutionNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = constitutionNmbr;

            }
        });
        intelligenceNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = intelligenceNmbr.getText().toString();
                intelligenceNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = intelligenceNmbr;

            }
        });
        charmNmbr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String temp = charmNmbr.getText().toString();
                charmNmbr.setText(lastClickedText.getText().toString());
                lastClickedText.setText(temp);
                lastClickedText = charmNmbr;

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
            }
        });

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