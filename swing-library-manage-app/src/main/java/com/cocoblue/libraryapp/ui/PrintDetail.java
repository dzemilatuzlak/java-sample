package com.cocoblue.libraryapp.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintDetail extends JFrame {
    private JLabel txt_ISBN, txt_name, txt_author, txt_status, txt_location, txt_borrowedID;
    private JPanel contentPane;

    public PrintDetail(Book book) {
        setTitle("\uB3C4\uC11C\uC0C1\uC138\uC815\uBCF4");
        setBounds(100, 100, 463, 456);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 10, 447, 397);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel Text_Panel = new JPanel();
        Text_Panel.setBackground(Color.WHITE);
        Text_Panel.setBounds(12, 10, 58, 344);
        panel.add(Text_Panel);
        Text_Panel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel label_ISBN = new JLabel("ISBN");
        Text_Panel.add(label_ISBN);

        JLabel label_name = new JLabel("\uC81C\uBAA9");
        Text_Panel.add(label_name);

        JLabel label_author = new JLabel("\uC800\uC790");
        Text_Panel.add(label_author);

        JLabel label_status = new JLabel("\uC0C1\uD0DC");
        Text_Panel.add(label_status);

        JLabel label_location = new JLabel("\uC704\uCE58");
        Text_Panel.add(label_location);

        JLabel label_borrowedID = new JLabel("\uB300\uCD9C ID");
        Text_Panel.add(label_borrowedID);

        JLabel label_borrow_count = new JLabel("\uB300\uCD9C \uD69F\uC218");
        Text_Panel.add(label_borrow_count);


        JPanel imformation_panel = new JPanel();
        imformation_panel.setBackground(Color.WHITE);
        imformation_panel.setBounds(78, 10, 356, 344);
        panel.add(imformation_panel);
        imformation_panel.setLayout(new GridLayout(0, 1, 0, 0));

        txt_ISBN = new JLabel();
        imformation_panel.add(txt_ISBN);
        txt_ISBN.setText(book.convert_ISBN(book.ISBN));

        txt_name = new JLabel();
        txt_name.setText("\uC81C\uBAA9");
        GridBagConstraints gbc_txt_name = new GridBagConstraints();
        gbc_txt_name.fill = GridBagConstraints.BOTH;
        gbc_txt_name.insets = new Insets(0, 0, 0, 5);
        gbc_txt_name.gridx = 0;
        gbc_txt_name.gridy = 0;
        txt_name.setText(book.name);
        imformation_panel.add(txt_name, gbc_txt_name);

        txt_author = new JLabel();
        txt_author.setText("\uC800\uC790");
        GridBagConstraints gbc_txt_author = new GridBagConstraints();
        gbc_txt_author.fill = GridBagConstraints.BOTH;
        gbc_txt_author.insets = new Insets(0, 0, 0, 5);
        gbc_txt_author.gridx = 1;
        gbc_txt_author.gridy = 0;
        txt_author.setText(book.author);
        imformation_panel.add(txt_author, gbc_txt_author);

        txt_status = new JLabel();
        txt_status.setText("\uC0C1\uD0DC");
        GridBagConstraints gbc_txt_status = new GridBagConstraints();
        gbc_txt_status.fill = GridBagConstraints.BOTH;
        gbc_txt_status.insets = new Insets(0, 0, 0, 5);
        gbc_txt_status.gridx = 2;
        gbc_txt_status.gridy = 0;
        txt_status.setText(book.convert_status(book.status));
        imformation_panel.add(txt_status, gbc_txt_status);

        txt_location = new JLabel();
        txt_location.setText("\uC704\uCE58");
        GridBagConstraints gbc_txt_location = new GridBagConstraints();
        gbc_txt_location.fill = GridBagConstraints.BOTH;
        gbc_txt_location.insets = new Insets(0, 0, 0, 5);
        gbc_txt_location.gridx = 3;
        gbc_txt_location.gridy = 0;
        txt_location.setText(book.location);

        imformation_panel.add(txt_location, gbc_txt_location);

        txt_borrowedID = new JLabel();
        txt_borrowedID.setText("\uB300\uCD9C\uD55C ID");
        GridBagConstraints gbc_txt_borrowedID = new GridBagConstraints();
        gbc_txt_borrowedID.fill = GridBagConstraints.BOTH;
        gbc_txt_borrowedID.gridx = 4;
        gbc_txt_borrowedID.gridy = 0;
        if (book.borrowed_id != null) {
            txt_borrowedID.setText(book.borrowed_id.substring(0, 3) + "****");
        } else {
            txt_borrowedID.setText("");
        }
        imformation_panel.add(txt_borrowedID, gbc_txt_borrowedID);

        JLabel txt_count = new JLabel("\uB300\uCD9C \uD69F\uC218");
        txt_count.setText(Integer.toString(book.borrow_count));
        imformation_panel.add(txt_count);

        SimpleDateFormat nowtime_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime_string = nowtime_date.format(new Date());

        JLabel label_nowtime = new JLabel("\uD604\uC7AC \uC2DC\uAC04");
        label_nowtime.setBounds(12, 364, 422, 15);
        label_nowtime.setText("�μ� �ð�: " + nowtime_string);
        panel.add(label_nowtime);

        this.setVisible(true);
        print();
        this.setVisible(false);
        dispose();
    }

    //����: https://annehouse.tistory.com/?page=234
    public void print() {
        PrintJob pjb = getToolkit().getPrintJob(this, "������ �μ�", null);

        if (pjb != null) {
            Graphics pg = pjb.getGraphics();

            if (pg != null) {
                paint(pg);
                pg.dispose();
            }
            pjb.end();
        }
    }
}
