package com.swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2018/3/14
 */
public class ArrayMinValue extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel label;
    private JLabel label1;

    public ArrayMinValue() {
        setTitle("获取一维数组最小值");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设定GUI的坐标和大小
        setBounds(100, 100, 500, 500);
        // 初始化一个面板
        contentPane = new JPanel();
        // contentPane内部边框为空，有五个像素的厚度
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 文本框
        textField = new JTextField();
        textField.setBounds(6, 36, 414, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("计算");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 执行按钮对应的操作
                doButtonActionPerformed(e);
            }
        });
        button.setBounds(16, 76, 90, 30);
        contentPane.add(button);

        label = new JLabel("数组中最小的数是");
        label.setBounds(116, 82, 304, 18);
        contentPane.add(label);

        label1 = new JLabel("请在下方文本框中输入一组一维数组");
        label1.setBounds(6, 6, 422, 18);
        contentPane.add(label1);
    }

    public void doButtonActionPerformed(ActionEvent e) {
        // 返回字符串的副本，忽略前导空白和尾部空白。
        String arrayStr = textField.getText().trim();

        // 过滤非法输入
        for (int i = 0; i < arrayStr.length(); i++) {
            // 返回指定索引处的char值
            char charAt = arrayStr.charAt(i);
            if (!Character.isDigit(charAt) && charAt != ' ') {
                JOptionPane.showMessageDialog(null, "输入包含非数字内容");
                textField.setText("");
                return;
            }
        }

        // 根据正则表达式分割字符串
        String[] numStrs = arrayStr.split(" {1,}");
        // String数组转换为int型
        int[] numArray = new int[numStrs.length];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.valueOf(numStrs[i]);
        }
        int min = numArray[0];
        for (int j = 0; j < numArray.length; j++) {
            if (min > numArray[j]) {
                min = numArray[j];
            }
        }
        label.setText("数组中最小的数为：" + min);
    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ArrayMinValue frame = new ArrayMinValue();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
