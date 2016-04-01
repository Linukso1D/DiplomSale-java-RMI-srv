/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.R;

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
   /**
    * Упаковывает атрибут к готовому виду
    * @return готовый атрибут
    * @param namespace - название атрибута
    * @param attribute  - значение атрибута
    * @param measurements - единица измерения атрибута
    */
   @Deprecated
   public static String getBoxAttribute(String namespace, String attribute, String measurements)
   {
	return namespace + ":" + attribute + measurements + ";";
   }
   
   /** Необходим для получения и заполнения данных с лист
    * @param allstring  строка типа "Математика 5"
    @return Map key="Математика" value ="5" */
   public static Map getListElement(String allstring)
   {
	Map test = new LinkedHashMap<String, String>();
	if(allstring.contains(" "))
	{
	test.put(allstring.substring(0, allstring.lastIndexOf(' ')), allstring.substring(allstring.indexOf(' ')+1));
	}
	else 
	{
	test.put(allstring, allstring);
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

}
