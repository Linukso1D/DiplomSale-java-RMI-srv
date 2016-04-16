package com.divotek.print.preview;

import javax.swing.*;
import java.awt.print.*;
import java.awt.*;
import java.awt.event.*;

public class PageSetupPanel extends JPanel {
    Paper p=new Paper();
    
    Insets margins=new Insets(18,18,18,18);

    JSpinner spnrPaperWidth=new JSpinner();
    JSpinner spnrPaperHeight=new JSpinner();

    JSpinner spnrMarginTop=new JSpinner();
    JSpinner spnrMarginBottom=new JSpinner();
    JSpinner spnrMarginLeft=new JSpinner();
    JSpinner spnrMarginRight=new JSpinner();
    JButton btnRestoreDefault=new JButton(com.divotek.R.R.Text.BTNDEFAULT);
    JButton btnApply=new JButton(com.divotek.R.R.Text.BTNAPPLY);

    public PageSetupPanel() {
        initLayout();
        initListeners();
    }
/** Возврат к стандартным значениям*/
    protected void initListeners() {
        btnRestoreDefault.addActionListener((ActionEvent e) ->
	  {
	     p=new Paper();
	     p.setSize(842, 595);
	     spnrPaperWidth.setValue((int)p.getWidth());
	     spnrPaperHeight.setValue((int)p.getHeight());
	     
	     spnrMarginTop.setValue(0.25);
	     spnrMarginBottom.setValue(0.25);
	     spnrMarginLeft.setValue(0.25);
	     spnrMarginRight.setValue(0.25);
	  });
    }

    protected void initLayout() {
	   p.setSize(842, 595);
        spnrPaperWidth.setModel(new SpinnerNumberModel((int)p.getWidth(),100,2000,5));
        spnrPaperHeight.setModel(new SpinnerNumberModel((int)p.getHeight(),100,2000,5));

        spnrMarginTop.setModel(new SpinnerNumberModel(0.25,0.15,2,0.5));
        spnrMarginBottom.setModel(new SpinnerNumberModel(0.25,0.15,2,0.5));
        spnrMarginLeft.setModel(new SpinnerNumberModel(0.25,0.15,2,0.5));
        spnrMarginRight.setModel(new SpinnerNumberModel(0.25,0.15,2,0.5));

        setLayout(new GridBagLayout());

        add(new JLabel(com.divotek.R.R.Text.MARGDEFAULT), new GridBagConstraints(0,0,2,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));
        add(btnRestoreDefault, new GridBagConstraints(0,1,2,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),0,0));

        add(new JLabel(com.divotek.R.R.Text.PW), new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));
        add(spnrPaperWidth, new GridBagConstraints(1,2,1,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));

        add(new JLabel(com.divotek.R.R.Text.PH), new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,10,5),0,0));
        add(spnrPaperHeight, new GridBagConstraints(1,3,1,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,10,5),0,0));

        add(new JLabel(com.divotek.R.R.Text.MT), new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));
        add(spnrMarginTop, new GridBagConstraints(1,4,1,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));

        add(new JLabel(com.divotek.R.R.Text.ML), new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));
        add(spnrMarginLeft, new GridBagConstraints(1,5,1,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));

        add(new JLabel(com.divotek.R.R.Text.MB), new GridBagConstraints(0,6,1,1,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));
        add(spnrMarginBottom, new GridBagConstraints(1,6,1,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));

        add(new JLabel(com.divotek.R.R.Text.MR), new GridBagConstraints(0,7,1,1,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));
        add(spnrMarginRight, new GridBagConstraints(1,7,1,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(5,5,0,5),0,0));
        
        add(btnApply, new GridBagConstraints(0,8,2,1,1,0,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL, new Insets(15,5,5,5),0,0));

        add(new JLabel(""), new GridBagConstraints(0,10,2,1,1,1,GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH, new Insets(5,5,0,5),0,0));
    }

    public Paper getPaper() {
        p.setSize(((Number)spnrPaperWidth.getValue()).doubleValue(), ((Number)spnrPaperHeight.getValue()).doubleValue());

        return p;
    }
    
    public Insets getMargins() {
        margins.top=(int)(((Number)spnrMarginTop.getValue()).doubleValue()*72);
        margins.bottom=(int)(((Number)spnrMarginBottom.getValue()).doubleValue()*72);
        margins.left=(int)(((Number)spnrMarginLeft.getValue()).doubleValue()*72);
        margins.right=(int)(((Number)spnrMarginRight.getValue()).doubleValue()*72);
        
        return margins;
    }
}
