package com.e.expensesmanager;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class IncomeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Spinner spinner;
    TextView tvDate,tvTime;

    int day,month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH );

                DatePickerDialog datePickerDialog = new DatePickerDialog(IncomeActivity.this, IncomeActivity.this, year, month, day);
                datePickerDialog.show();

            }
        });

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);


                TimePickerDialog timePickerDialog = new TimePickerDialog(IncomeActivity.this, IncomeActivity.this, hour, minute, android.text.format.DateFormat.is24HourFormat(IncomeActivity.this));
                timePickerDialog.show();

            }
        });

        addItemsOnSpinner();
        addListenerOnButton();
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinner = findViewById(R.id.spinner);
        List<String> list = new ArrayList<>();
        list.add("Business");
        list.add("Salary");
        list.add("Loan");
        list.add("Others");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnButton() {

        spinner = (Spinner) findViewById(R.id.spinner);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        yearFinal = i;
        monthFinal = i1+1;
        dayFinal = i2;

        tvDate.setText( yearFinal + "/" +
                monthFinal + "/" +
                + dayFinal);

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

        hourFinal = i;
        minuteFinal = i1;

        tvTime.setText( hourFinal + ":" +
                + minuteFinal);

    }
}
