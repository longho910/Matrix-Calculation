import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Fall 2022 COSC 20203
 * @author: Peter Ho
 * Lab 1 
 * @credit: some codes are take from Dr Sanchez. 
 */
public class Control extends View implements ActionListener {
    Model m;
    JFrame zFrame = new JFrame();

    public static void main(String args[]) {
        new Control();
    }

    public Control() {
        m = new Model(this);
        setButtons();
    }

    public void setButtons() {
        create.addActionListener(this); // register
        execute.addActionListener(this); // Register the button
        quit.addActionListener(this); // Register the button
        reset.addActionListener(this); // Register the button
        box1.addActionListener(this);
        save1.addActionListener(this);
        open1.addActionListener(this);
        save2.addActionListener(this);
        open2.addActionListener(this);
        save3.addActionListener(this);
        open3.addActionListener(this);
        read1.addActionListener(this);
        read2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String whichWidget = e.getActionCommand();
        String s = (String) box1.getSelectedItem();
        System.out.println("calling action perform " + " " + whichWidget + " " + s);

        if (whichWidget.equals("Create"))
            addPanel();
        if (whichWidget.equals("Execute") && s.equals("Addition"))
            m.procOper(1);
        if (whichWidget.equals("Execute") && s.equals("Subtraction"))
            m.procOper(2);
        if (whichWidget.equals("Execute") && s.equals("Multiplication"))
            m.procOper(3);
        // save
        if (e.getSource() == save1)
            m.saveFile(tfFile1.getText(), data1);
        if (e.getSource() == save2)
            m.saveFile(tfFile2.getText(), data2);
        if ((e.getSource() == save3) && (s.equals("Addition")))
            m.saveFile(tfFile3.getText(), m.data3);
        if ((e.getSource() == save3) && (s.equals("Subtraction")))
            m.saveFile(tfFile3.getText(), m.data4);
        if ((e.getSource() == save3) && (s.equals("Multiplication")))
            m.saveFile(tfFile3.getText(), m.data5);
        // open
        if (e.getSource() == open1)
            m.openFileDisplay(m.openFile(tfFile1.getText()));
        if (e.getSource() == open2)
            m.openFileDisplay(m.openFile(tfFile2.getText()));
        if (e.getSource() == open3)
            m.openFileDisplay(m.openFile(tfFile3.getText()));

        if (e.getSource() == read1)
            m.procReadV(1);
        if (e.getSource() == read2)
            m.procReadV(2);

        // validate();
        // repaint();
    }

    public void addPanel() {
        if (validateInteger(row1) && validateInteger(col1) && validateInteger(row2) && validateInteger(col2)) {
            remarks.setText("");
            numRow1 = Integer.parseInt(row1.getText());
            numRow2 = Integer.parseInt(row2.getText());
            numCol1 = Integer.parseInt(col1.getText());
            numCol2 = Integer.parseInt(col2.getText());

            xFrame = new JFrame("X Matrix");
            xFrame.setLayout(new BorderLayout());
            yFrame = new JFrame("Y Matrix");
            yFrame.setLayout(new BorderLayout());
            xPanel = new JPanel(new GridLayout(numRow1, numCol1, 2, 2));
            yPanel = new JPanel(new GridLayout(numRow2, numCol2, 2, 2));
            disFields1 = new JTextField[numRow1][numCol1];
            disFields2 = new JTextField[numRow2][numCol2];

            // for saving and reading files
            x1panel = new JPanel(new GridLayout(1, 4));
            x1panel.setPreferredSize(new Dimension(300, 30));
            xFrame.add(x1panel, BorderLayout.SOUTH);
            x1panel.add(read1);
            x1panel.add(tfFile1);
            x1panel.add(save1);
            x1panel.add(open1);

            y1panel = new JPanel(new GridLayout(1, 4));
            y1panel.setPreferredSize(new Dimension(300, 30));
            yFrame.add(y1panel, BorderLayout.SOUTH);
            y1panel.add(read2);
            y1panel.add(tfFile2);
            y1panel.add(save2);
            y1panel.add(open2);

            xPanel.setBackground(MyColor);
            yPanel.setBackground(MyColor);
            yFrame.add(yPanel, BorderLayout.CENTER);
            xFrame.add(xPanel, BorderLayout.CENTER);

            // add textField to xFrame and yFrame
            for (int i = 0; i < numRow1; ++i) {
                for (int j = 0; j < numCol1; ++j) {
                    disFields1[i][j] = new JTextField(10);
                    xPanel.add(disFields1[i][j]);
                }
            }
            for (int i = 0; i < numRow2; ++i) {
                for (int j = 0; j < numCol2; ++j) {
                    disFields2[i][j] = new JTextField(10);
                    yPanel.add(disFields2[i][j]);
                }
            }
            xFrame.setBounds(500, 400, 300, 200);
            yFrame.setBounds(850, 400, 300, 200);
            xFrame.setVisible(true);
            yFrame.setVisible(true);

        }
    }

    public boolean validateInteger(JTextField datum) {
        try {
            int d = Integer.parseInt(datum.getText());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("invalid Integer ");
            remarks.setText("Invalid integer, retype");
            return false;
        }
    }

}