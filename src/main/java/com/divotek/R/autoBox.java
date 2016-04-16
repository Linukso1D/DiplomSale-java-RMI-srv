/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author maxxl
 */
public class autoBox
{
   
   
   /** Необходим для получения и заполнения данных с лист
    * @param allstring  строка типа "Математика 5"
    @return Map key="Математика" value ="5" */
   public static Map getListElement(String allstring)
   {
	Map test = new LinkedHashMap<String, String>();
	if(allstring.contains(" "))
	{
	test.put(allstring.substring(0, allstring.lastIndexOf(' ')), allstring.substring(allstring.lastIndexOf(' ')+1));
	}
	else 
	{
	test.put(allstring, " ");
	}
	return test;
   }
   
   
   /** @return Возвращает ответ от выплывающего окна в виде строки 
    *  @param question Вопрос который будет задан пользователю перед вводом
    */
   public static String setListElement(String question)
   {
     JFrame frame = new JFrame(R.Text.TITLEBOX);

    return JOptionPane.showInputDialog(frame, question);
   }
   
   public static ArrayList cutter(String input)
   {
	ArrayList str = new ArrayList<String>();
	if(input.length()>32)
	{
	String tm=input.substring(0,32);
	str.add(input.substring(0, tm.lastIndexOf(' ')));
	
	   if(input.length()>64+32)
	   {
		String tm2=input.substring(tm.lastIndexOf(' '),64+32);
		
		str.add(input.substring(tm.lastIndexOf(' '),tm2.lastIndexOf(' '))); // 3 строчки
		str.add(input.substring(tm2.lastIndexOf(' ')));
	   }
	   else
	   {
		str.add(input.substring(tm.lastIndexOf(' ')));
		str.add("&nbsp;");
	   }
	}
	else 
	{
	   str.add(input);
	      str.add(" ");
		   str.add(" ");
	}
   return str;
   }

}
