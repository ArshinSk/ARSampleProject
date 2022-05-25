package com.autorabit.resuableUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectUtilities {

    public String getPresentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HHmmss");
        Date date = new Date();
        String presentDate = dateFormat.format(date);
        return presentDate;
    }

    public String[] toArrayString(Object testData){
        String data = String.valueOf(testData);
        data = data.substring(1,data.length()-1).trim();

        String[] dataString = data.split(",");

      return dataString;
    }

    /*public static void main(String[] args){
        String str = "[ApexTrigger1,ApexTrigger2]";

        String[] strArray = toArrayString(str);

        for(String s:strArray){
            System.out.println("--->"+s);
        }
    }*/
}
