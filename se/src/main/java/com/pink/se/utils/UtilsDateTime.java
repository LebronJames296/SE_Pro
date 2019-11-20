package com.pink.se.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsDateTime {
    public static String getTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String f = sdf.format(date);
        return f;
    }



}
