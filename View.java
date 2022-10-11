
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame {
    public Color MyColor = new Color(0x469BD8);

    double[][] data1; // vector one
    double[][] data2; // vector two

    JTextField[][] disFields1;
    JTextField[][] disFields2;

    JFrame frame = new JFrame();

    JFrame xFrame;
    JFrame yFrame;

    JTextField col1 = new JTextField(15);
    JTextField row1 = new JTextField(15);
    JTextField col2 = new JTextField(15);
    JTextField row2 = new JTextField(15);

    JButton create = new JButton("Create");
    JButton execute = new JButton("Execute");
    JButton quit = new JButton("QUIT");
    JButton reset = new JButton("Reset");
    String[] s1 = { "Select", "Multiplication", "Addition", "Subtraction" };
    JComboBox box1 = new JComboBox(s1);

    JLabel label1 = new JLabel("First Matrix rows/cols", JLabel.CENTER);
    JLabel label2 = new JLabel("Second Matrix rows/cols", JLabel.CENTER);

    JPanel xPanel;
    JPanel yPanel;

    JTextField remarks = new JTextField(100);

    int numRow1;
    int numRow2;
    int numCol1;
    int numCol2;

    // for saving and reading files
    JPanel x1panel;
    public JButton save1 = new JButton("Save");
    public JButton open1 = new JButton("Open");
    public JButton read1 = new JButton("Read");
    public JTextField tfFile1 = new JTextField(15);

    JPanel y1panel;
    public JButton save2 = new JButton("Save");
    public JButton open2 = new JButton("Open");
    public JButton read2 = new JButton("Read");
    public JTextField tfFile2 = new JTextField(15);

    JPanel z1panel;
    public JButton save3 = new JButton("Save");
    public JButton open3 = new JButton("Open");
    public JButton clear3 = new JButton("Clear");
    public JButton read3 = new JButton("Read");
    public JTextField tfFile3 = new JTextField(15);
    public JTextArea ta = new JTextArea(5, 20);

    public static void main(String[] args) {
        new View();
    }

    View() {
        remarks.setText(" Feedback to the user ");
        remarks.setFont(new Font("Helvetica", Font.BOLD, 16));
        remarks.setEditable(false);

        label1.setForeground(Color.white);
        label1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label2.setForeground(Color.white);
        label2.setFont(new Font("MV Boli", Font.PLAIN, 20));

        frame.setLayout(new GridLayout(6, 2, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.getContentPane().setBackground(MyColor);

        frame.add(label1);
        frame.add(label2);
        frame.add(row1);
        frame.add(row2);
        frame.add(col1);
        frame.add(col2);
        // frame.add(ta);
        // ta.setVisible(false);
        frame.add(create);
        frame.add(box1);
        frame.add(execute);
        frame.add(reset);
        frame.add(quit);
        frame.add(remarks);

        frame.setTitle("Peter Ho's Matrix");
        frame.setVisible(true);

    }

}
