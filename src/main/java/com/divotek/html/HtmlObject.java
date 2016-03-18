/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.html;

import com.divotek.attribute.performAttribute.Attribute;
import java.util.HashMap;
import java.util.Map;
import com.divotek.attribute.performAttribute.AttributeBehavior;
import com.divotek.attribute.performMeasurement.MeasurementBehavior;

/**
 *
 * @author maxxl
 */
public class HtmlObject
{
   protected Map<String, Attribute> htmlAttribute;
   private String allAttribute;
   private String name, userName, value;

   public HtmlObject(String name, String value)
   {
	allAttribute = "";
	userName = "";
	htmlAttribute = new HashMap<String, Attribute>();
	this.name = name;
	this.value = value;
   }

   //добавить атрибут
   public void addAttribute(String key, AttributeBehavior attributeBehavior, String value, MeasurementBehavior measurementBehavior)
   {
	htmlAttribute.put(key, new Attribute.Builder(value).setAttributeBehavior(attributeBehavior).setMeasurementBehavior(measurementBehavior).build());
   }

   //удалить атрибут
   public void delAttribute(String key)
   {
	htmlAttribute.remove(key);
   }

   //задать пользовательское имя
   public void setName(String s)
   {
	userName = s;
   }

   //взять пользовательское имя
   public String getName()
   {
	return userName;
   }

   //возвращает тег
   public String generatedTag()
   {
	allAttribute = "";
	if(!htmlAttribute.isEmpty())
	{
	   htmlAttribute.forEach((k, v) -> allAttribute += v.toString());
	}
	return htmlAttribute.isEmpty() ? "<" + name + ">" + value + "</" + name + ">" : "<" + name + " style='" + allAttribute + "'>" + value + "</" + name + ">";
   }

}
