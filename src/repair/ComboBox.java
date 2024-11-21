package repair;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ComboBox<E> extends JComboBox<E> {

    private Color backgroundColor = Color.WHITE;
    private Color hoverColor = new Color(220, 220, 220);
    private Color selectionColor = new Color(3, 155, 216);
    private int hoveredIndex = -1; // Track the hovered index

    public ComboBox() {
        setUI(new CustomComboBoxUI());
        setOpaque(false);
        setBackground(backgroundColor);
        setForeground(Color.BLACK);
        setBorder(new EmptyBorder(5, 10, 5, 10));

        // Add mouse listener for hover effect
        addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                JList<?> list = getPopupList();
                if (list != null) {
                    list.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseMoved(MouseEvent e) {
                            Point point = e.getPoint();
                            hoveredIndex = list.locationToIndex(point);
                            list.repaint();
                        }
                    });
                    list.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseExited(MouseEvent e) {
                            hoveredIndex = -1; // Reset hover index
                            list.repaint();
                        }
                    });
                }
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                hoveredIndex = -1; // Reset hover index
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
                hoveredIndex = -1; // Reset hover index
            }
        });

        setRenderer(new CustomListCellRenderer());
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
        repaint();
    }

    private JList<?> getPopupList() {
        Component popup = (Component) getUI().getAccessibleChild(this, 0);
        if (popup instanceof JPopupMenu) {
            JPopupMenu jPopup = (JPopupMenu) popup;
            if (jPopup.getComponent(0) instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) jPopup.getComponent(0);
                if (scrollPane.getViewport().getView() instanceof JList) {
                    return (JList<?>) scrollPane.getViewport().getView();
                }
            }
        }
        return null;
    }

    private class CustomComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton arrowButton = new JButton();
            arrowButton.setBorder(new EmptyBorder(0, 0, 0, 0));
            arrowButton.setContentAreaFilled(false);
            arrowButton.setBackground(backgroundColor);
            arrowButton.setFocusable(false);
            arrowButton.setIcon(new ArrowIcon());
            return arrowButton;
        }
    }

    private class ArrowIcon implements Icon {
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            int[] xPoints = {x, x + getIconWidth() / 2, x + getIconWidth()};
            int[] yPoints = {y, y + getIconHeight(), y};
            g2.fillPolygon(xPoints, yPoints, 3);
        }

        @Override
        public int getIconWidth() {
            return 10;
        }

        @Override
        public int getIconHeight() {
            return 6;
        }
    }

    private class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setOpaque(true);

            // Apply hover effect
            if (index == hoveredIndex && !isSelected) {
                label.setBackground(hoverColor);
                label.setForeground(Color.BLACK);
            } else if (isSelected) {
                label.setBackground(selectionColor);
                label.setForeground(Color.WHITE);
            } else {
                label.setBackground(backgroundColor);
                label.setForeground(Color.BLACK);
            }

            label.setBorder(new EmptyBorder(5, 10, 5, 10));
            return label;
        }
    }
}
