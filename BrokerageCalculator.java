import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;

class Main1 implements ActionListener {
    JFrame J1;
    JLabel JL1;
    JButton JB1;
    JButton JB2;

    Main1() {
        J1 = new JFrame("...Brokerage Calculator...");
        J1.setSize(1600, 800);

        JL1 = new JLabel("Choose Order Type");
        JL1.setBounds(500, 200, 500, 50);
        JL1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 30));
        JL1.setForeground(Color.BLACK);
        J1.add(JL1);

        JB1 = new JButton("Intraday");
        JB1.setBounds(500, 300, 100, 50);
        J1.add(JB1);

        JB1.addActionListener(this);

        JB2 = new JButton("Delivery");
        JB2.setBounds(700, 300, 100, 50);
        J1.add(JB2);

        JB2.addActionListener(this);

        J1.setLayout(null);
        J1.setVisible(true);
        J1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    Main2 M2 = new Main2();
    Main3 M3 = new Main3();

    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Intraday":
                M2.intraday();
                break;

            case "Delivery":
                M3.delivery();
                break;
        }
    }

}

class Main2 implements ActionListener {

    JFrame J1;

    JLabel JL, JL1, JL2, JL3, JL4, JL5, JL6, JL7, JL8, JL9, JL10, JL11;

    JButton JB1;

    JTextField JTF1, JTF2, JTF3, JTF4, JTF5, JTF6, JTF7, JTF8, JTF9, JTF10, JTF11;

    void intraday() {
        J1 = new JFrame("Intraday Brokerage Calculator");
        J1.setSize(1600, 800);

        JL = new JLabel("Intraday Brokerage Calculator");
        JL.setBounds(400, 30, 700, 50);
        JL.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 30));
        JL.setForeground(Color.BLACK);
        J1.add(JL);

        JL1 = new JLabel("Buy Price:*-");
        JL1.setBounds(400, 150, 150, 50);
        JL1.setFont(new Font("Arial", Font.PLAIN, 15));
        JL1.setForeground(Color.black);
        J1.add(JL1);

        JTF1 = new JTextField();
        JTF1.setBounds(490, 160, 150, 30);
        J1.add(JTF1);

        JL2 = new JLabel("Sell Price:*-");
        JL2.setBounds(670, 150, 150, 50);
        JL2.setFont(new Font("Arial", Font.PLAIN, 15));
        JL2.setForeground(Color.black);
        J1.add(JL2);

        JTF2 = new JTextField();
        JTF2.setBounds(760, 160, 150, 30);
        J1.add(JTF2);

        JL3 = new JLabel("Quantity:*-");
        JL3.setBounds(550, 200, 150, 50);
        JL3.setFont(new Font("Arial", Font.PLAIN, 15));
        JL3.setForeground(Color.black);
        J1.add(JL3);

        JTF3 = new JTextField();
        JTF3.setBounds(630, 210, 150, 30);
        J1.add(JTF3);

        JB1 = new JButton("Calculate");
        JB1.setBounds(620, 250, 150, 30);
        J1.add(JB1);

        JL4 = new JLabel("Brokerage:-");
        JL4.setBounds(500, 365, 80, 15);
        JL4.setForeground(Color.black);
        J1.add(JL4);

        JTF5 = new JTextField();
        JTF5.setBounds(580, 365, 50, 20);
        J1.add(JTF5);

        JL5 = new JLabel("STT charge:-");
        JL5.setBounds(500, 395, 80, 15);
        JL5.setForeground(Color.black);
        J1.add(JL5);

        JTF6 = new JTextField();
        JTF6.setBounds(580, 395, 50, 20);
        J1.add(JTF6);

        JL6 = new JLabel("Transaction charge:-");
        JL6.setBounds(460, 425, 120, 15);
        JL6.setForeground(Color.black);
        J1.add(JL6);

        JTF7 = new JTextField();
        JTF7.setBounds(580, 425, 50, 20);
        J1.add(JTF7);

        JL7 = new JLabel("SEBI charge:- ");
        JL7.setBounds(500, 455, 120, 15);
        JL7.setForeground(Color.black);
        J1.add(JL7);

        JTF8 = new JTextField();
        JTF8.setBounds(580, 455, 50, 20);
        J1.add(JTF8);

        JL8 = new JLabel("Stamp Duty:- ");
        JL8.setBounds(500, 485, 120, 15);
        JL8.setForeground(Color.black);
        J1.add(JL8);

        JTF9 = new JTextField();
        JTF9.setBounds(580, 485, 50, 20);
        J1.add(JTF9);

        JL9 = new JLabel("GST:- ");
        JL9.setBounds(540, 515, 120, 15);
        JL9.setForeground(Color.black);
        J1.add(JL9);

        JTF10 = new JTextField();
        JTF10.setBounds(580, 515, 50, 20);
        J1.add(JTF10);

        JL10 = new JLabel("Total Tax and Charges:- ");
        JL10.setBounds(500, 600, 200, 20);
        JL10.setForeground(Color.red);
        J1.add(JL10);

        JTF11 = new JTextField();
        JTF11.setBounds(640, 600, 50, 20);
        J1.add(JTF11);

        JB1.addActionListener(this);
        J1.setLayout(null);
        J1.setVisible(true);
        // J1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static double buy_price, sell_price, quantity;
    static double total_turnover, total_buy_turnover, total_sell_turnover;
    static double brokerage, buy_brokerage, sell_brokerage;
    static double stt;
    static double tran_charge, buy_tran_charge, sell_tran_charge;
    static double sebi_charge;
    static double stamp_charge;
    static double gst;
    static double total_tax_charges;

    public void actionPerformed(ActionEvent ae) {
        DecimalFormat DF = new DecimalFormat("0.00");
        Main2 M2 = new Main2();

        if (JTF1.getText().isEmpty() && JTF2.getText().isEmpty() && JTF3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(J1, "Enter the mandatory Fields (*)");
        } else {
            if ((JTF1.getText()).isEmpty()) {
                JOptionPane.showMessageDialog(J1, "Enter the Buy Price");
            } else {
                buy_price = Double.parseDouble(JTF1.getText());
            }

            if (JTF2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(J1, "Enter the Sell Price ");
            } else {
                sell_price = Double.parseDouble(JTF2.getText());
            }

            if (JTF3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(J1, "Enter the Quatity");
            } else {
                quantity = Double.parseDouble(JTF3.getText());
            }

            if (quantity >= 1) {

                M2.calculationIntraday();

                JTF5.setText(String.valueOf(DF.format(brokerage)));
                JTF6.setText(String.valueOf(DF.format(stt)));
                JTF7.setText(String.valueOf(DF.format(tran_charge)));
                JTF8.setText(String.valueOf(DF.format(sebi_charge)));
                JTF9.setText(String.valueOf(DF.format(stamp_charge)));
                JTF10.setText(String.valueOf(DF.format(gst)));
                JTF11.setText(String.valueOf(DF.format(total_tax_charges)));
            }
        }
        // JTF4.setText(String.valueOf(DF.format(total_tax_charges)));
    }

    public void calculationIntraday() {

        total_turnover = (buy_price * quantity) + (sell_price * quantity);
        total_buy_turnover = buy_price * quantity;
        total_sell_turnover = sell_price * quantity;

        buy_brokerage = total_buy_turnover * 0.03 / 100;
        if (buy_brokerage > 20.00) {
            buy_brokerage = 20.00;
        }
        sell_brokerage = total_sell_turnover * 0.03 / 100;
        if (sell_brokerage > 20.00) {
            sell_brokerage = 20.00;
        }
        brokerage = (buy_brokerage + sell_brokerage);

        stt = (total_sell_turnover * 0.025 / 100);

        buy_tran_charge = (total_buy_turnover * 0.00325 / 100);
        sell_tran_charge = (total_sell_turnover * 0.00325 / 100);

        tran_charge = buy_tran_charge + sell_tran_charge;

        sebi_charge = (total_turnover * 0.0001 / 100);

        stamp_charge = (total_buy_turnover * 0.0003 / 100);

        gst = (brokerage + tran_charge + sebi_charge) * 18 / 100;

        total_tax_charges = (brokerage + stt + tran_charge + sebi_charge + stamp_charge + gst);

    }
}

class Main3 implements ActionListener {

    JFrame J1;

    JLabel JL, JL1, JL2, JL3, JL4, JL5, JL6, JL7, JL8, JL9, JL10, JL11;

    JButton JB1;

    JTextField JTF1, JTF2, JTF3, JTF4, JTF5, JTF6, JTF7, JTF8, JTF9, JTF10, JTF11, JTF12;

    void delivery() {
        J1 = new JFrame("Delivery Brokerage Calculator");
        J1.setSize(1600, 800);

        JL = new JLabel("Delivery Brokerage Calculator");
        JL.setBounds(400, 30, 700, 50);
        JL.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 30));
        JL.setForeground(Color.BLACK);
        J1.add(JL);

        JL1 = new JLabel("Buy Price:*- ");
        JL1.setBounds(400, 150, 150, 50);
        JL1.setFont(new Font("Arial", Font.PLAIN, 15));
        JL1.setForeground(Color.black);
        J1.add(JL1);

        JTF1 = new JTextField();
        JTF1.setBounds(480, 160, 150, 30);
        J1.add(JTF1);

        JL2 = new JLabel("Sell Price:*- ");
        JL2.setBounds(670, 150, 150, 50);
        JL2.setFont(new Font("Arial", Font.PLAIN, 15));
        JL2.setForeground(Color.black);
        J1.add(JL2);

        JTF2 = new JTextField();
        JTF2.setBounds(750, 160, 150, 30);
        J1.add(JTF2);

        JL3 = new JLabel("Quantity:*- ");
        JL3.setBounds(550, 200, 150, 50);
        JL3.setFont(new Font("Arial", Font.PLAIN, 15));
        JL3.setForeground(Color.black);
        J1.add(JL3);

        JTF3 = new JTextField();
        JTF3.setBounds(620, 210, 150, 30);
        J1.add(JTF3);

        JB1 = new JButton("Calculate");
        JB1.setBounds(620, 250, 150, 30);
        J1.add(JB1);

        JL4 = new JLabel("Brokerage:-");
        JL4.setBounds(500, 365, 80, 15);
        JL4.setForeground(Color.black);
        J1.add(JL4);

        JTF5 = new JTextField();
        JTF5.setBounds(580, 365, 50, 20);
        J1.add(JTF5);

        JL5 = new JLabel("STT charge:-");
        JL5.setBounds(500, 395, 80, 15);
        JL5.setForeground(Color.black);
        J1.add(JL5);

        JTF6 = new JTextField();
        JTF6.setBounds(580, 395, 50, 20);
        J1.add(JTF6);

        JL6 = new JLabel("Transaction charge:-");
        JL6.setBounds(460, 425, 120, 15);
        JL6.setForeground(Color.black);
        J1.add(JL6);

        JTF7 = new JTextField();
        JTF7.setBounds(580, 425, 50, 20);
        J1.add(JTF7);

        JL7 = new JLabel("SEBI charge:- ");
        JL7.setBounds(500, 455, 120, 15);
        JL7.setForeground(Color.black);
        J1.add(JL7);

        JTF8 = new JTextField();
        JTF8.setBounds(580, 455, 50, 20);
        J1.add(JTF8);

        JL8 = new JLabel("Stamp Duty:- ");
        JL8.setBounds(500, 485, 120, 15);
        JL8.setForeground(Color.black);
        J1.add(JL8);

        JTF9 = new JTextField();
        JTF9.setBounds(580, 485, 50, 20);
        J1.add(JTF9);

        JL9 = new JLabel("GST:- ");
        JL9.setBounds(540, 515, 120, 15);
        JL9.setForeground(Color.black);
        J1.add(JL9);

        JTF10 = new JTextField();
        JTF10.setBounds(580, 515, 50, 20);
        J1.add(JTF10);

        JL10 = new JLabel("DP charge:- ");
        JL10.setBounds(510, 545, 120, 15);
        JL10.setForeground(Color.black);
        J1.add(JL10);

        JTF12 = new JTextField();
        JTF12.setBounds(580, 545, 50, 20);
        J1.add(JTF12);

        JL10 = new JLabel("Total Tax and Charges:- ");
        JL10.setBounds(500, 630, 200, 20);
        JL10.setForeground(Color.red);
        J1.add(JL10);

        JTF11 = new JTextField();
        JTF11.setBounds(640, 630, 50, 20);
        J1.add(JTF11);

        JB1.addActionListener(this);

        J1.setLayout(null);
        J1.setVisible(true);
        // J1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    static double buy_price, sell_price, quantity;

    static double total_turnover, total_buy_turnover, total_sell_turnover;
    final static double brokerage = 0.00;// Brokerage for delivery in zerodha is 0.
    // static double buy_brokerage, sell_brokerage;
    static double stt, buy_stt, sell_stt;
    static double tran_charge, buy_tran_charge, sell_tran_charge;
    static double sebi_charge;
    static double stamp_charge;
    static double gst;
    final static double dp_charge = 15.93;// 13.5 is the DP charge and 18% GST on the DP charge so total is 15.93.
    static double total_tax_charges;

    public void actionPerformed(ActionEvent ae) {
        DecimalFormat DF = new DecimalFormat("0.00");
        Main3 M3 = new Main3();

        if (JTF1.getText().isEmpty() && JTF2.getText().isEmpty() && JTF3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(J1, "Enter the mandatory Fields (*)");
        } else {
            if (JTF1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(J1, "Enter Buy Price");
            } else {
                buy_price = Double.parseDouble(JTF1.getText());
            }

            if (JTF2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(J1, "Enter Sell Price");
            } else {
                sell_price = Double.parseDouble(JTF2.getText());
            }

            if (JTF3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(J1, "Enter the quantity");
            } else {
                quantity = Double.parseDouble(JTF3.getText());
            }
            if (quantity >= 1) {

                M3.calculationDelivery();

                JTF5.setText(String.valueOf(DF.format(brokerage)));
                JTF6.setText(String.valueOf(DF.format(stt)));
                JTF7.setText(String.valueOf(DF.format(tran_charge)));
                JTF8.setText(String.valueOf(DF.format(sebi_charge)));
                JTF9.setText(String.valueOf(DF.format(stamp_charge)));
                JTF10.setText(String.valueOf(DF.format(gst)));
                JTF12.setText(String.valueOf(DF.format(dp_charge)));
                JTF11.setText(String.valueOf(DF.format(total_tax_charges)));

            }
        }
    }

    void calculationDelivery() {
        total_turnover = (buy_price * quantity) + (sell_price * quantity);
        total_buy_turnover = buy_price * quantity;
        total_sell_turnover = sell_price * quantity;

        buy_stt = (total_buy_turnover * 0.1 / 100);
        sell_stt = (total_sell_turnover * 0.1 / 100);
        stt = buy_stt + sell_stt;

        buy_tran_charge = (total_buy_turnover * 0.00325 / 100);
        sell_tran_charge = (total_sell_turnover * 0.00325 / 100);
        tran_charge = buy_tran_charge + sell_tran_charge;

        sebi_charge = (total_turnover * 0.0001 / 100);

        stamp_charge = (total_buy_turnover * 0.015 / 100);

        gst = (brokerage + tran_charge + sebi_charge) * 18 / 100;

        total_tax_charges = (brokerage + stt + tran_charge + sebi_charge + stamp_charge + gst + dp_charge);

    }
}

class BrokerageCalculator {

    public static void main(String[] args) {
        Main1 M1 = new Main1();
    }
}