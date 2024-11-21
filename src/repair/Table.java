package repair;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class Table extends JTable {

    public Table(TableModel model) {
        super(model);
        init();
    }

    public Table() {
        init();
    }

    private void init() {
        // Table settings
        setRowHeight(30);
        setFont(new Font("Arial", Font.PLAIN, 14));
        setGridColor(new Color(200, 200, 200));
        setSelectionBackground(new Color(76, 204, 255));
        setSelectionForeground(Color.BLACK);
        setShowGrid(true);
        setIntercellSpacing(new java.awt.Dimension(1, 1));
        setBorder(new EmptyBorder(5, 5, 5, 5));

        // Custom renderer for header
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(new Font("Arial", Font.BOLD, 16));
                c.setBackground(new Color(3, 155, 216));
                c.setForeground(Color.WHITE);
                setHorizontalAlignment(CENTER);
                return c;
            }
        });

        // Custom cell renderer
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    c.setBackground(new Color(76, 204, 255));
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }
                setBorder(new EmptyBorder(5, 5, 5, 5));
                return c;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
    }
}
