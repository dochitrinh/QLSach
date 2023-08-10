/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poly.poly.app.helpers;

import java.awt.Color;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class DataValidator {
    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
        if(field.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
    }
    
    public static void validateEmpty(JTextArea area, StringBuilder sb, String errorMessage) {
        if(area.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            area.setBackground(Color.red);
            area.requestFocus();
        } else {
            area.setBackground(Color.white);
        }
    }
    
    
    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
        String passWord = new String(field.getPassword());
        if(passWord.equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
    }
}
