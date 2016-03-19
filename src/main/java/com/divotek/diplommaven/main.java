/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.diplommaven;

import com.divotek.R.R;
import com.divotek.attribute.performAttribute.PMarginB;
import com.divotek.attribute.performMeasurement.PMeasurePercent;
import com.divotek.html.HtmlObject;
import com.divotek.html.TagBorderP;
import com.divotek.html.TagP;

/**
 *
 * @author maxxl
 */
public class main
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
	HtmlObject p = new TagBorderP("Какой то текст");
	p.setName(R.Text.border_light);
	p.addAttribute("Отступ вниз", new PMarginB(), "27", new PMeasurePercent());
	System.out.println("Ключ " + p.getName() + " " + p.generatedTag());

   }

}
