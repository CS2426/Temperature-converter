package com.example.temperature_converter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.temperature_converter.Utils.Converters;
import com.example.temperature_converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String CONVERTED_VALUE_EXTRA_KEY = "MainActivity_converted_Value_double";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //popup
        binding.CtoFtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "It worked", Toast.LENGTH_SHORT).show();
            }
        });
        // makes button C to F work
        binding.celsiusConvertButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Intent intent = FtoCActivity.fToCIntentFactory(getApplicationContext(),convertValue());
                startActivity(intent);
                return false;
            }
        });
    }
    
    private double convertValue(){
        String enteredValue = binding.CelsiusValueEditTextNumberSigned.getText().toString();
        double valueToConvert = 0.0;
        if(!enteredValue.isEmpty()){
            valueToConvert = Double.parseDouble(enteredValue);
        }
        valueToConvert = Converters.celsiusToFahrenheit(valueToConvert);
        return valueToConvert;
    }

    public void displayConvertedValue(View v){
        binding.celsiusConvertedValueTextView.setText(
                getString(R.string.degrees_fahrenheit, convertValue()));
    }
    public static Intent MainActivityIntentFactory(Context context,double receivedValue){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY, receivedValue);
        return intent;
    }
}