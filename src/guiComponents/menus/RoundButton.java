package guiComponents.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

class RoundButton extends JButton {
    protected Shape shape;
    protected Shape base;
//     protected RoundButton() {
//         super();
//     }
//     protected RoundButton(Icon icon) {
//         super(icon);
//     }
//     protected RoundButton(String text) {
//         super(text);
//     }
//     protected RoundButton(Action a) {
//         super(a);
//         //setAction(a);
//     }
//     protected RoundButton(String text, Icon icon) {
//         super(text, icon);
//         //setModel(new DefaultButtonModel());
//         //init(text, icon);
//     }
    protected RoundButton(Icon icon, String i2, String i3) {
        super(icon);
        setPressedIcon(new ImageIcon(getClass().getResource(i2)));
        setRolloverIcon(new ImageIcon(getClass().getResource(i3)));
    }
    @Override public void updateUI() {
        super.updateUI();
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setBackground(Color.BLACK);
        setContentAreaFilled(false);
        setFocusPainted(false);
        //setVerticalAlignment(SwingConstants.TOP);
        setAlignmentY(Component.TOP_ALIGNMENT);
        initShape();
    }
    @Override public Dimension getPreferredSize() {
        Icon icon = getIcon();
        Insets i = getInsets();
        int iw = Math.max(icon.getIconWidth(), icon.getIconHeight());
        return new Dimension(iw + i.right + i.left, iw + i.top + i.bottom);
    }
    protected void initShape() {
        if (!getBounds().equals(base)) {
            Dimension s = getPreferredSize();
            base = getBounds();
            shape = new Ellipse2D.Double(0, 0, s.width - 1, s.height - 1);
        }
    }
    @Override protected void paintBorder(Graphics g) {
        initShape();
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(getBackground());
        //g2.setStroke(new BasicStroke(1f));
        g2.draw(shape);
        g2.dispose();
    }
    @Override public boolean contains(int x, int y) {
        initShape();
        return Objects.nonNull(shape) && shape.contains(x, y);
    }
}