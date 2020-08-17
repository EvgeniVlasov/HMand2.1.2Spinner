package com.example.hmand212spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner mSpinnerCountry;
    Spinner mSpinnerCity;
    Spinner mSpinnerHouse;
    Button mButtonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSpinnerCountry = findViewById(R.id.spinnerContry);
        mSpinnerCity = findViewById(R.id.spinnerCity);
        mSpinnerHouse = findViewById(R.id.spinnerHouse);
        mButtonOk = findViewById(R.id.buttonOk);
        //initSpinnerCity();
        initSpinnerCountry();
        initSpinnerHouse();

        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this
                        , mSpinnerCountry.getSelectedItem().toString()
                                + " "
                                + mSpinnerCity.getSelectedItem().toString()
                                + " "
                                + mSpinnerHouse.getSelectedItem().toString()
                        , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    private void initSpinnerHouse() {
        Integer[] house = new Integer[50];
        for (int i = 1; i <= 50; i++){
            house[i-1] = i;}
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, house);
        mSpinnerHouse.setAdapter(adapter);
    }


    private void initSpinnerCountry() {
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this, R.array.spinnerCountry, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCountry.setAdapter(adapterCountry);
        mSpinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                String[] country = getResources().getStringArray(R.array.spinnerCountry);
                initSpinnerCity(country[i]);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initSpinnerCity(String country) {

        ArrayAdapter<CharSequence> adapter = null;
        switch (country) {
            case "Россия":
                adapter = ArrayAdapter.createFromResource(this, R.array.r_spinnerCity, android.R.layout.simple_spinner_item);
                break;
            case "Украина":
                adapter = ArrayAdapter.createFromResource(this, R.array.u_spinnerCity, android.R.layout.simple_spinner_item);
                break;
            case "Беларусь":
                adapter = ArrayAdapter.createFromResource(this, R.array.b_spinnerCity, android.R.layout.simple_spinner_item);
                break;
        }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinnerCity.setAdapter(adapter);

        }
    }
}


