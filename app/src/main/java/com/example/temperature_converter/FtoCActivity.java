package com.example.temperature_converter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.temperature_converter.Utils.Converters;
import com.example.temperature_converter.databinding.ActivityFtoCactivityBinding;
import com.example.temperature_converter.databinding.ActivityMainBinding;

import java.util.Locale;

public class FtoCActivity extends AppCompatActivity {

    private static final String CONVERTED_VALUE_EXTRA_KEY = "FtoCActivity_Received_value";
    ActivityFtoCactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityFtoCactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        double fahrenheit = getIntent().getDoubleExtra(CONVERTED_VALUE_EXTRA_KEY, 0.0);
        binding.FtoCEditText.setText(String.format(Locale.ENGLISH,"%.2f",fahrenheit));

        // THIS LET ME SWAP BACK TO MAIN
        binding.fahrenheitConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = MainActivity.MainActivityIntentFactory(getApplicationContext(),4);
                startActivity(intent);
                return false;
            }
        });
    }


//    double convertValue_celsius(){
//        String enteredValue = binding.fahrenheitToCelsius.getText().toString();
//        double valueToConvert = 0.0;
//        if(!enteredValue.isEmpty()){
//            valueToConvert = Double.parseDouble(enteredValue);
//        }
//        valueToConvert = Converters.fahrenheitToCelsius(valueToConvert);
//        return valueToConvert;
//  }

//    public void displayConvertedValue_celsius(View v){
//        binding.fahrenheitToCelsius.setText(
//                getString(R.string.degrees_celsius, convertValue()));
//
//   }

    public static Intent fToCIntentFactory(Context context, double fahrenheitValue){
        Intent intent = new Intent(context, FtoCActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY,fahrenheitValue);
        return intent;
    }
}