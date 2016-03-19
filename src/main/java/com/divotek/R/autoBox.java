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
   //с единицами измерения
   public static String getBoxAttribute(String namespace, String attribute, String measurements)
   {
	return namespace + ":" + attribute + measurements + ";";
   }

}
