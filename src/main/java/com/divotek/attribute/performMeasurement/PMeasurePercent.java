/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.attribute.performMeasurement;

import com.divotek.R.R;

/**
 *
 * @author maxxl
 */
public class PMeasurePercent implements MeasurementBehavior
{
   @Override
   public String getMesurament()
   {
	return R.AttributeMeasurement.percent;
   }
   
}
