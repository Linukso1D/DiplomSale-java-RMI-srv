/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.attribute.performAttribute;

import com.divotek.attribute.performMeasurement.MeasurementBehavior;
import static com.divotek.R.autoBox.getBoxAttribute;

/**
 * Класс описывающий атрибут в целом
 * @author maxxl
 */
public class Attribute
{
   /** Значение атрибута */
   private String value;
   /** Композиция атрибутов */
   private AttributeBehavior attributeBehavior;
   /** Композиция единиц измерения для атрибутов */
   private MeasurementBehavior measurementBehavior;

   /** @return ссылку на интерфейс Атрибутов*/
   public AttributeBehavior getAttriButebehavior()
   {
	return attributeBehavior;
   }
   private Attribute()
   {
   }
   /** Установка атрибутов 
    *@param ab пример: {@link com.divotek.attribute.performAttribute.PBorderB} */
   public void setAttributeBehavior(AttributeBehavior ab)
   {
	this.attributeBehavior = ab;
   }
      /** @return ссылку на интерфейс Единиц измерения*/
   public MeasurementBehavior getMeasurementbehavior()
   {
	return measurementBehavior;
   }
   /** Установка единиц измерения 
    *@param mb пример: {@link com.divotek.attribute.performMeasurement.PMeasureEm} */
   public void setMeasurementBehavior(MeasurementBehavior mb)
   {
	this.measurementBehavior = mb;
   }
   /**
    * @return Упакованый атрибут в виде строки
    */
   @Override
   public String toString()
   {
	return getBoxAttribute(attributeBehavior.getAttribute(), value, measurementBehavior.getMesurament());
   }
   /**
    * @version 1.0
    * Статический метод инициализации атрибутов (Именной конструктор) - инициализатор класса Attribute
    */
   public static class Builder
   {
	private String value;
	private AttributeBehavior attributeBehavior;
	private MeasurementBehavior measurementBehavior;
	public Builder(String value)
	{
	   this.value = value;
	}

	public Builder setAttributeBehavior(AttributeBehavior attributeBehavior)
	{
	   this.attributeBehavior = attributeBehavior;
	   return this;
	}

	public Builder setMeasurementBehavior(MeasurementBehavior measurementBehavior)
	{
	   this.measurementBehavior = measurementBehavior;
	   return this;
	}

	public Attribute build()
	{
	   return new Attribute(this);
	}

   }
   
   private Attribute(Builder builder)
   {
	value = builder.value;
	attributeBehavior = builder.attributeBehavior;
	measurementBehavior = builder.measurementBehavior;
   }

}
