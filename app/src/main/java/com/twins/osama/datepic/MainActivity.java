package com.twins.osama.datepic;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText showPopup;
    private TextView eventDate;
    private Button buCalculate;
    private TextView fajr;
    private TextView shoroqe;
    private TextView thor;
    private TextView aser;
    private TextView magreb;
    private TextView asha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        showPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
        eventDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                      getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String myTime = year + "-" + (month + 1) + "-" + dayOfMonth;
                        eventDate.setText(myTime);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }
    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.popup1:
                        showPopup.setText(item.getTitle());
                        return true;
                    case R.id.popup2:
                        showPopup.setText(item.getTitle());
                        return true;
                    case R.id.popup3:
                        showPopup.setText(item.getTitle());
                        return true;
                    default:
                        return false;
                }
            }

        });

        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());

        popup.show();
    }


    private void findViews() {
        showPopup = (EditText)findViewById( R.id.showPopup );
        eventDate = (TextView)findViewById( R.id.event_date );
        buCalculate = (Button)findViewById( R.id.bu_calculate );
        fajr = (TextView)findViewById( R.id.fajr );
        shoroqe = (TextView)findViewById( R.id.shoroqe );
        thor = (TextView)findViewById( R.id.thor );
        aser = (TextView)findViewById( R.id.aser );
        magreb = (TextView)findViewById( R.id.magreb );
        asha = (TextView)findViewById( R.id.asha );

        buCalculate.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == buCalculate ) {
            // Handle clicks for buCalculate
        }
    }

}
