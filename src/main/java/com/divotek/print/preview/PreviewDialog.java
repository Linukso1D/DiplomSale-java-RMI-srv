package com.divotek.print.preview;

import javax.swing.*;
import java.awt.print.Paper;
import java.awt.*;

import java.awt.event.ActionEvent;


public class PreviewDialog extends JDialog {

    EditorPanePrinter pnlPreview;
    PageSetupPanel pnlPageSetupPanel;

    JButton btnPrint=new JButton(com.divotek.R.R.Text.PRINTER);
    String source;

    public PreviewDialog(JFrame parent, JEditorPane src) {
        super(parent, com.divotek.R.R.Text.PREVIEW);

        Paper p=new Paper(); //by default LETTER
	  p.setSize(842, 595);// set A4 LETTER
        p.setImageableArea(0,0,p.getWidth(), p.getHeight());
      
        pnlPreview=new EditorPanePrinter(src, p, new Insets(18,18,18,18));
        pnlPageSetupPanel=new PageSetupPanel();
	  
        getContentPane().add(new JScrollPane(pnlPreview), BorderLayout.CENTER);
        getContentPane().add(btnPrint, BorderLayout.NORTH);
        getContentPane().add(pnlPageSetupPanel, BorderLayout.EAST);

        initListeners();

        setSize(1210,800);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    protected void initListeners() {
        pnlPageSetupPanel.btnApply.addActionListener((ActionEvent e) ->
	  {
	     pnlPreview=new EditorPanePrinter(pnlPreview.sourcePane, pnlPageSetupPanel.getPaper(), pnlPageSetupPanel.getMargins());
	     getContentPane().removeAll();
	     getContentPane().add(new JScrollPane(pnlPreview), BorderLayout.CENTER);
	     getContentPane().add(btnPrint, BorderLayout.NORTH);
	     getContentPane().add(pnlPageSetupPanel, BorderLayout.EAST);
	     
	     SwingUtilities.invokeLater(() ->
	     {
		  getContentPane().invalidate();
		  getContentPane().validate();
		  getContentPane().repaint();
	     });
	  });
        
        btnPrint.addActionListener((ActionEvent e) ->
	  {
	     pnlPreview.print();
	  });
    }
}
