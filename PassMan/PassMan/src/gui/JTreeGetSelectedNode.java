package gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;

public class JTreeGetSelectedNode extends JFrame implements TreeCellRenderer {
    public JTreeGetSelectedNode() throws HeadlessException {
        initializeUI();
    }
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
    {
    	if (leaf) {
    		
    	}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JTreeGetSelectedNode().setVisible(true));
    }

    private void initializeUI() {
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Countries");
        DefaultMutableTreeNode asia = new DefaultMutableTreeNode("Asia");
        String[] countries = new String[]{"India", "Singapore", "Indonesia", "Vietnam"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            asia.add(node);
        }

        DefaultMutableTreeNode northAmerica = new DefaultMutableTreeNode("North America");
        countries = new String[]{"United States", "Canada"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            northAmerica.add(node);
        }

        DefaultMutableTreeNode southAmerica = new DefaultMutableTreeNode("South America");
        countries = new String[]{"Brazil", "Argetina", "Uruguay"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            southAmerica.add(node);
        }

        DefaultMutableTreeNode europe = new DefaultMutableTreeNode("Europe");
        countries = new String[]{"United Kingdom", "Germany", "Spain", "France", "Italy"};
        for (String country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            europe.add(node);
        }

        root.add(asia);
        root.add(northAmerica);
        root.add(southAmerica);
        root.add(europe);

        final JTree tree = new JTree(root);
        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(500, 500));

        JButton button = new JButton("Get Selected");
        button.addActionListener(e -> {
            TreePath[] paths = tree.getSelectionPaths();
            for (TreePath path : paths != null ? paths : new TreePath[0]) {
                String seleccionado = path.getLastPathComponent().toString();
                //select * from organizador 
            }
        });
        DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)tree.getCellRenderer();
        render.setLeafIcon(new ImageIcon("C:\\Users\\mario\\Desktop\\PassMan\\src\\assets\\patoatras_preview_rev_1_preview_rev_1.png"));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
    }
}
