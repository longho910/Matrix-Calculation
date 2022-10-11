import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Model {
    Control c;
    double[][] data;
    double[][] data3;
    double[][] data4;
    double[][] data5;

    public Model(Control fromC) {
        c = fromC;

    }

    public void saveFile(String file, double[][] dataStored) {
        try { // System.out.println(" file to write "+ file );
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(dataStored);
            oo.close();
            fo.close();
            System.out.println("file " + file + " saved as object");
            System.out.println(dataStored + "Save");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public double[][] openFile(String file) {
        try { // System.out.println(" file to read "+ file );
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            double[][] data = (double[][]) oi.readObject();
            oi.close();
            fi.close();
            System.out.println("file " + file + " opened as an object");
            System.out.println(data);
            return data;
        }

        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        return data;

    }

    public void openFileDisplay(double[][] data) {
        JTextField[][] disFields3 = new JTextField[data.length][data[0].length];
        JPanel zPanel = new JPanel(new GridLayout(data.length, data[0].length, 2, 2));

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {

                disFields3[i][j] = new JTextField();
                disFields3[i][j].setText("" + data[i][j]);
                zPanel.add(disFields3[i][j]);
            }
        }
        c.zFrame.setTitle("Open file");
        c.zFrame.setLayout(new BorderLayout());
        c.zFrame.add(zPanel, BorderLayout.CENTER);

        zPanel.setBackground(c.MyColor);
        c.zFrame.setBackground(c.MyColor);
        c.zFrame.setBounds(500, 600, 300, 200);
        c.zFrame.setVisible(true);

    }

    public void procReadV(int opt) {
        if (opt == 1) {
            c.data1 = new double[c.numRow1][c.numCol1];
            c.read1.setEnabled(false);

            for (int i = 0; i < c.numRow1; i++) {
                for (int j = 0; j < c.numCol1; j++) {

                    c.data1[i][j] = Double.parseDouble(c.disFields1[i][j].getText());
                }

            }
        }
        if (opt == 2) {
            c.data2 = new double[c.numRow2][c.numCol2];
            c.read2.setEnabled(false);
            for (int i = 0; i < c.numRow2; i++) {
                for (int j = 0; j < c.numCol2; j++) {

                    c.data2[i][j] = Double.parseDouble(c.disFields2[i][j].getText());
                }

            }
        }
    }

    public void procOper(int opt) {
        // read matrix1

        // read matrix 2

        switch (opt) {
            case 1:
                // read data1

                // Execute

                JTextField[][] disFields3 = new JTextField[c.numRow1][c.numCol1];
                JPanel zPanel = new JPanel(new GridLayout(c.numRow1, c.numCol1, 2, 2));
                data3 = new double[c.numRow1][c.numCol1];

                for (int i = 0; i < c.numRow1; i++) {
                    for (int j = 0; j < c.numCol1; j++) {
                        data3[i][j] = c.data1[i][j] + c.data2[i][j];
                        disFields3[i][j] = new JTextField();
                        disFields3[i][j].setText("" + data3[i][j]);
                        zPanel.add(disFields3[i][j]);
                    }
                }
                c.z1panel = new JPanel(new GridLayout(1, 4));
                c.z1panel.add(c.clear3);
                c.z1panel.add(c.tfFile3);
                c.z1panel.add(c.save3);
                c.z1panel.add(c.open3);
                c.tfFile3.setForeground(Color.DARK_GRAY);

                c.zFrame = new JFrame("Addition Matrix");
                c.zFrame.setLayout(new BorderLayout());
                c.zFrame.add(zPanel, BorderLayout.CENTER);
                c.zFrame.add(c.z1panel, BorderLayout.SOUTH);
                zPanel.setBackground(c.MyColor);
                c.zFrame.setBackground(c.MyColor);
                c.zFrame.setBounds(500, 600, 300, 200);
                c.zFrame.setVisible(true);
                break;

            case 2:
                // read data 2

                // execute
                JTextField[][] disFields4 = new JTextField[c.numRow1][c.numCol1];
                JPanel kPanel = new JPanel(new GridLayout(c.numRow1, c.numCol1, 2, 2));
                data4 = new double[c.numRow1][c.numCol1];

                for (int i = 0; i < c.numRow1; i++) {
                    for (int j = 0; j < c.numCol1; j++) {
                        data4[i][j] = c.data1[i][j] - c.data2[i][j];
                        disFields4[i][j] = new JTextField();
                        disFields4[i][j].setText("" + data4[i][j]);
                        kPanel.add(disFields4[i][j]);
                    }
                }

                c.z1panel = new JPanel(new GridLayout(1, 4));
                c.z1panel.add(c.clear3);
                c.z1panel.add(c.tfFile3);
                c.z1panel.add(c.save3);
                c.z1panel.add(c.open3);
                c.tfFile3.setForeground(Color.DARK_GRAY);

                c.zFrame = new JFrame("Subtraction Matrix");
                c.zFrame.setLayout(new BorderLayout());
                c.zFrame.add(kPanel, BorderLayout.CENTER);
                c.zFrame.add(c.z1panel, BorderLayout.SOUTH);
                kPanel.setBackground(c.MyColor);
                c.zFrame.setBackground(c.MyColor);
                c.zFrame.setBounds(850, 600, 300, 200);
                c.zFrame.setVisible(true);
                break;

            case 3:
                JTextField[][] disFields5 = new JTextField[c.numRow1][c.numCol2];
                JPanel ePanel = new JPanel(new GridLayout(c.numRow1, c.numCol2, 2, 2));
                data5 = new double[c.numRow1][c.numCol2];

                for (int i = 0; i < c.numRow1; i++) {
                    for (int j = 0; j < c.numCol2; j++) {

                        for (int k = 0; k < c.numRow2; k++) {
                            data5[i][j] += c.data1[i][k] * c.data2[k][j];

                        }
                        disFields5[i][j] = new JTextField();
                        disFields5[i][j].setText("" + data5[i][j]);
                        ePanel.add(disFields5[i][j]);

                    }
                }

                c.z1panel = new JPanel(new GridLayout(1, 4));
                c.z1panel.add(c.clear3);
                c.z1panel.add(c.tfFile3);
                c.z1panel.add(c.save3);
                c.z1panel.add(c.open3);
                c.tfFile3.setForeground(Color.DARK_GRAY);

                c.zFrame = new JFrame("Multiplication Matrix");
                c.zFrame.setLayout(new BorderLayout());
                c.zFrame.add(ePanel, BorderLayout.CENTER);
                c.zFrame.add(c.z1panel, BorderLayout.SOUTH);
                ePanel.setBackground(c.MyColor);
                c.zFrame.setBackground(c.MyColor);
                c.zFrame.setBounds(850, 600, 300, 200);
                c.zFrame.setVisible(true);
                break;

        }
    }

    public boolean validateRead() {
        if (c.data1 != null && c.data2 != null)
            return true;
        else
            return false;
    }

    public boolean validateDouble(JTextField datum) {
        try {
            double d = Double.parseDouble(datum.getText());
            return true;
        }

        catch (NumberFormatException e) {
            System.out.println("invalid number ");
            c.remarks.setText("Invalid number retype");
            return false;
        }

    }
}
