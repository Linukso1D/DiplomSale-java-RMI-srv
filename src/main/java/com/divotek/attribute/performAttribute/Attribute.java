/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.attribute.performAttribute;

import com.divotek.attribute.performMeasurement.MeasurementBehavior;
import static com.divotek.R.autoBox.getBoxAttribute;

/**
 *
 * @author maxxl
 */
public class Attribute
{

   private String value;
   private AttributeBehavior attributeBehavior;
   private MeasurementBehavior measurementBehavior;

   public AttributeBehavior getAttriButebehavior()
   {
	return attributeBehavior;
   }

   private Attribute()
   {

   }

   public void setAttributeBehavior(AttributeBehavior ab)
   {
	this.attributeBehavior = ab;
   }

   public MeasurementBehavior getMeasurementbehavior()
   {
	return measurementBehavior;
   }

   public void setMeasurementBehavior(MeasurementBehavior mb)
   {
	this.measurementBehavior = mb;
   }

   //Добавление аттрибута в Map
   @Override
   public String toString()
   {
	return getBoxAttribute(attributeBehavior.getAttribute(), value, measurementBehavior.getMesurament());
   }

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
	value=builder.value;
	attributeBehavior = builder.attributeBehavior;
	measurementBehavior = builder.measurementBehavior;
   }

}
