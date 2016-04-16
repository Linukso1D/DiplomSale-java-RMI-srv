/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.date;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author maxxl
 */
public class Gettoday
{
   
   
   private static final DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){

        @Override
        public String[] getMonths() {
            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        }
        
    };
   
 public static String getDate()
 {
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy",myDateFormatSymbols);
    return dateFormat.format( currentDate ) ;
 }
  
   
}
