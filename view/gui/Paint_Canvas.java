package view.gui;

import javax.swing.*;
import java.awt.*;

public class Paint_Canvas extends JComponent {

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
