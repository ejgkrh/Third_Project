package com.example.bwcho.alarm_function;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class TimePickerfragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getActivity(),android.R.style.Theme_Holo_Light_Panel,this,
                hour,minute, android.text.format.DateFormat.is24HourFormat(getActivity()));
        TextView tvTitle = new TextView(getActivity());
        tvTitle.setText("알람을 설정해 주세요!!");
        tvTitle.setBackgroundColor(Color.parseColor("#228B22"));
        tvTitle.setPadding(5,3,5,3);
        tvTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        tpd.setCustomTitle(tvTitle);

        return tpd;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        String aMpM = "AM";
        if(hourOfDay>11){
            aMpM ="PM";
        }
        int currentHour;
        if(hourOfDay > 11){
            currentHour = hourOfDay-12;

        }else{
            currentHour =hourOfDay;
        }
        tv.setText("설정된 시간은 ... ");
        tv.setText(tv.getText()+String.valueOf(hourOfDay)+"시"+String.valueOf(minute)+"분\n");
    }
}
