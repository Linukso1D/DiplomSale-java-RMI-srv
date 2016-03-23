/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.attribute.performMeasurement;

import com.divotek.R.R;

/**
 * Потомок единиц измерения атрибута ({@link com.divotek.attribute.performAttribute.AttributeBehavior})
 * @author maxxl
 */
public class PMeasureEm implements MeasurementBehavior
{
      /**@return единицы измерения ({@link com.divotek.attribute.performMeasurement.MeasurementBehavior})*/
   @Override
   public String getMesurament()
   {
	return R.AttributeMeasurement.em;
   }

}
