/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.R;

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

}
