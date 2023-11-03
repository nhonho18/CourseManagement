package UI.UI_Item.textfield;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class SearchField extends JTextField {
    public SearchField() {
        //System.out.println("ádfadsf"+ClassLoader.getSystemResource("search").getPath());
        setBackground(new java.awt.Color(0,0,0,1));
        setFont(getFont().deriveFont((int) (getFont().getSize()+2f)));
        setForeground(Color.decode("#A6A6A6"));
        setBorder(new EmptyBorder(6,prefixIcon.getIconWidth() + 5,6, 5));
        
    }
    private final int radius = 8;
    private Icon prefixIcon = new javax.swing.ImageIcon("search.png");

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        
        
        Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 3, y, this);
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(Color.decode("#D9D9D9"));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(new java.awt.Color(255,255,255));
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        g2.drawImage(prefix, 3, y, this);
        
        super.paintComponent(grphcs);
    }
}
//#282936