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
 * Общий объект описывающий Html Тег со своими свойствами
 * @author maxxl
 */
public abstract class HtmlObject
{
   protected Map<String, Attribute> htmlAttribute;
   private String allAttribute;
   private String name, userName, value;

   /**
    * @param name Имя Html тега пример: (@code "любой тег(p/a/b/strong)")
    * @param value Значение Html тега пример: (@code "любой текст")
    */
   public HtmlObject(String name, String value)
   {
	allAttribute = "";
	userName = "";
	htmlAttribute = new HashMap<String, Attribute>();
	this.name = name;
	this.value = value;
   }

   /**
    *	@param key   Ключ ({@link com.divotek.R.R.Text}) допустим только один ключ, во избежание коллизий 
    * @param attributeBehavior  Атрибут ({@link com.divotek.attribute.performAttribute.AttributeBehavior})
    * @param measurementBehavior  Единица измерения ({@link com.divotek.attribute.performMeasurement.MeasurementBehavior })
    * @param value Значание атрибута
    */
   public void addAttribute(String key, AttributeBehavior attributeBehavior, String value, MeasurementBehavior measurementBehavior)
   {
	htmlAttribute.put(key, new Attribute.Builder(value).setAttributeBehavior(attributeBehavior).setMeasurementBehavior(measurementBehavior).build());
   }

   /**
    * Удаления атрибута по ключу
    * @param key Ключ
    */
   public void delAttribute(String key)
   {
	htmlAttribute.remove(key);
   }

   /**
    *
    * @param s Установка полльзовательского имени для тега(Вроде бы не используется вообще в программе )
    */
   @Deprecated
   public void setName(String s)
   {
	userName = s;
   }

   /**
    * 
    * @return Возвращает пользовательское имя тега (Как и его брат близнец не испльзуется вообще вроде бы)
    */
   @Deprecated
   public String getName()
   {
	return userName;
   }

   /**
    * 
    * @return Формирует готовую строку тега со списком атрибутов.
    */
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
