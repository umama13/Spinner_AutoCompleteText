package com.example.spinner_autocompletetext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String[] COUNTRIES= new String[]{
            "Afghanistan", "Albania", "Andorra", "Angola" ,"Bangladesh","Belgium" , "Brazil","Canada" , "China", "Colombia","Finland", "France"
    };
    TextView text_view_countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView actv=(AutoCompleteTextView) findViewById(R.id.actv);
        final Spinner spinner_country=(Spinner) findViewById(R.id.spinner_country);
        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

                Toast.makeText(getApplicationContext(),COUNTRIES[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,COUNTRIES);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_country.setAdapter(arrayAdapter);
        ArrayAdapter arrayAdapterAC=new ArrayAdapter(this,android.R.layout.simple_list_item_1,COUNTRIES);
        actv.setAdapter(arrayAdapterAC);
        actv.setThreshold(1);

        /*String[] countries=getResources().getStringArray(R.array.countries);

        AutoCompleteTextView editText= findViewById(R.id.actv);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                R.layout.activity_custom_list_item, R.id.text_view_list_item,countries);
        editText.setAdapter(adapter);
        editText.setThreshold(1);

        String input=editText.getText().toString();
*/
    }
}
