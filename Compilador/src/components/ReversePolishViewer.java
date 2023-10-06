package components;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import objects.ConfigurationParams;

public class ReversePolishViewer extends JPanel{
    private static final Color BACKGROUND_PANEL = new Color(157,142,173,255), BACKGROUND_COMPONENTS = new Color(118,97,141,255);

    public ReversePolishViewer() {
        setLayout(new BorderLayout());
        setBackground(BACKGROUND_PANEL);
        setBorder(new LineBorder(BACKGROUND_PANEL, 5));
        setVisible(true);
        updateTable();
    }

    public void updateTable() {
        removeAll();

        JPanel verticalLayoutContainer = new JPanel();
        verticalLayoutContainer.setBackground(BACKGROUND_COMPONENTS);
        verticalLayoutContainer.setLayout(new BoxLayout(verticalLayoutContainer, BoxLayout.Y_AXIS));
        
        ConfigurationParams.reversePolishStructure.generateDataForMultipleTableInput().forEach(tableData -> {
            JTable table = new JTable(tableData,null);
            table.getTableHeader().setVisible(false);
            table.setFillsViewportHeight(true);
            table.setEnabled(false);
            table.setVisible(true);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setBackground(BACKGROUND_COMPONENTS);

            verticalLayoutContainer.add(table);
        });
        
        add(new JScrollPane(verticalLayoutContainer), BorderLayout.CENTER);
    }
}
