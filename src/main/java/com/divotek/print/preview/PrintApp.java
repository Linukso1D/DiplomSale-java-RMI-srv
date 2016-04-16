package com.divotek.print.preview;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import javax.swing.text.html.*;
import java.awt.*;
import java.awt.print.Paper;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintApp extends JFrame {
    public static String htmlString="";
    Shape viewShape;
    JEditorPane editor=new JEditorPane();
    JTextArea editorSource=new JTextArea();
    JButton btnPreview=new JButton("Print Preview");
    JButton btnPrint=new JButton("Print");
    JButton btnApply=new JButton("Show changed sources");
    JTabbedPane tab=new JTabbedPane();

  

    public PrintApp() {
        super("Diplom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(5,5));

        getContentPane().add(tab, BorderLayout.NORTH);
        JPanel pnlButtons=new JPanel(new FlowLayout());
        pnlButtons.add(btnPrint);
        pnlButtons.add(btnPreview);
        pnlButtons.add(btnApply);
        getContentPane().add(pnlButtons, BorderLayout.SOUTH);

        HTMLEditorKit kit=new HTMLEditorKit();
        editor.setEditorKit(kit);
        editor.setContentType("text/html");
        editor.setText(htmlString);
        editor.setEditable(false);
        
        editorSource.setText(htmlString);

        JScrollPane scroll = new JScrollPane(editor);
        tab.add("HTML", scroll);
        scroll = new JScrollPane(editorSource);
        tab.add("Source", scroll);
        getContentPane().add(tab, BorderLayout.CENTER);
        ((JComponent)getContentPane()).setBorder(new EmptyBorder(5,5,5,5));

        initKeyStrokes();

        setSize(750, 750);
        setLocationRelativeTo(null);
    }

    private void initKeyStrokes() {
        InputMap im = ((JComponent)getContentPane()).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = ((JComponent)getContentPane()).getActionMap();

	  //обработчик просмотра превью печати
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "preview");
        AbstractAction lst=new AbstractAction() {
		@Override
            public void actionPerformed(ActionEvent e) {
                PreviewDialog dlg=new PreviewDialog(PrintApp.this, editor);
                dlg.setVisible(true);
            }
        };
        btnPreview.addActionListener(lst);
        am.put("preview", lst);
        lst=new AbstractAction() {
		@Override
            public void actionPerformed(ActionEvent e) {
                EditorPanePrinter pnl=new EditorPanePrinter(editor, new Paper(), new Insets(18,18,18,18));
                pnl.print();
            }
        };
        btnPrint.addActionListener(lst);

        lst=new AbstractAction() {
		@Override
            public void actionPerformed(ActionEvent e) {
                htmlString=editorSource.getText();
                editor.setText(htmlString);
                tab.setSelectedIndex(0);
            }
        };
        btnApply.addActionListener(lst);
    }

    protected static Shape getAllocation(View v, JEditorPane edit) {
        Insets ins=edit.getInsets();
        View root=edit.getUI().getRootView(edit);
        View vParent=v.getParent();
        int x=ins.left;
        int y=ins.top;
        while(vParent!=null) {
            int i=vParent.getViewIndex(v.getStartOffset(), Position.Bias.Forward);
            Shape alloc=vParent.getChildAllocation(i, new Rectangle(0,0, Short.MAX_VALUE, Short.MAX_VALUE));
            x+=alloc.getBounds().x;
            y+=alloc.getBounds().y;

            vParent=vParent.getParent();
        }

        return new Rectangle(x,y, (int)v.getPreferredSpan(View.X_AXIS), (int)v.getPreferredSpan(View.Y_AXIS));
    }

    public int getOffset(BoxView source, int axis, int childIndex) {
        try {
            Method m=BoxView.class.getDeclaredMethod("getOffset",new Class[] {int.class, int.class});
            m.setAccessible(true);
            return ((Number)m.invoke(source, new Object[] {axis, childIndex})).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public short getLeftInset(CompositeView source) {
        try {
            Method m=CompositeView.class.getDeclaredMethod("getLeftInset");
            m.setAccessible(true);
            return ((Number)m.invoke(source)).shortValue();
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        }

        return 0;
    }

    public short getTopInset(CompositeView source) {
        try {
            Method m=CompositeView.class.getDeclaredMethod("getTopInset");
            m.setAccessible(true);
            return ((Number)m.invoke(source)).shortValue();
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        }

        return 0;
    }
}
