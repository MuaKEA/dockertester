package com.kea.dk.demo.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class minetester {

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd-yyyy");


        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));


    }

}
