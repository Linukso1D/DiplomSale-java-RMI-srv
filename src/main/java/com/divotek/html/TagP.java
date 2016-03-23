/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.html;

import com.divotek.R.R;

/**
 *
 * @author maxxl
 */
public class TagP extends HtmlObject
{
   /**
    * 
    * Обычный текст - параграф
    * @param valueText Значение параграфа
    */
   public TagP(String valueText)
   {
	super(R.TagName.p, valueText);
   }

}
