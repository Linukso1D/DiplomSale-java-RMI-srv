/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.html;

import com.divotek.R.R;
import com.divotek.attribute.performAttribute.PBorderB;
import com.divotek.attribute.performAttribute.PPaddingB;
import com.divotek.attribute.performMeasurement.PMeasureBlight;
import com.divotek.attribute.performMeasurement.PMeasurePx;

/**
 * Потомок Html объекта, текстовый елемент с подчекиванием снизу
 * @author maxxl
 * @version 1.0
 */
public final class TagBorderP extends HtmlObject
{

   
   public TagBorderP(String valueText)
   {
	super(R.TagName.p, valueText);
	setBorderLight();
   }

   /**
    * Инициализация подчеркушки
    */
   public void setBorderLight()
   {
	super.setName(R.Text.border_light);
	addAttribute(
		   R.Text.border_light,
		   new PBorderB(),
		   R.AttributeMeasurement.not_measurement,
		   new PMeasureBlight());

	addAttribute(
		   R.Text.def_padding,
		   new PPaddingB(),
		   R.AttributeMeasurement.def_padding,
		   new PMeasurePx());
   }

}
