/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.UI_Item.textfield;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author ASUS
 */
public class TextField extends JTextField {
    public TextField() {
        setBackground(new java.awt.Color(0,0,0,1));
        setFont(getFont().deriveFont(getFont().getSize()+2f));
        setForeground(Color.decode("#56b6ec"));
        setBorder(new CompoundBorder(new MatteBorder(0,0,1,0,
                Color.decode("#56b6ec")), 
                new EmptyBorder(6,15,6, 5)));
        
    }
}
