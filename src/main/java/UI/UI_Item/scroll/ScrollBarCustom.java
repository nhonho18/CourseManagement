package UI.UI_Item.scroll;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(Color.decode("#56B6EC"));
        setBackground(Color.WHITE);
        setUnitIncrement(20);
    }
}
