/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.attribute.performMeasurement;

/**
 * @version 1.0
 * @author maxxl
 * Интерфейс описывает допустимые единици измерения для Атрибутов -  {@link com.divotek.attribute.performAttribute.AttributeBehavior}
 * которые находятся {@link com.divotek.attribute.performMeasurement.MeasurementBehavior }
 */
public interface MeasurementBehavior
{
   /** @return Константы из {@link com.divotek.R.R.AttributeMeasurement} */
   public String getMesurament();

}
