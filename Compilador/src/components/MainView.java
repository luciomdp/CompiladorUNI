package components;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import objects.ConfigurationParams;

public class MainView  extends JFrame{

    private JTabbedPane tab;
    private TokenViewer panelTokenViewer; 
    private SemanticViewer semanticViewer;
    private ReversePolishViewer reversePolishViewer;
    private SymbolTableViewer symbolTableViewer;
    
    public MainView() {
        tab = new JTabbedPane(JTabbedPane.TOP);
        panelTokenViewer = new TokenViewer();   
        semanticViewer = new SemanticViewer();
        reversePolishViewer = new ReversePolishViewer();
        symbolTableViewer = new SymbolTableViewer();
       
        tab.addTab("Visualizador de Tokens", generateIcon("Compilador/src/images/token.png"), panelTokenViewer, null);
        tab.addTab("Visualizador sintáctico", generateIcon("Compilador/src/images/semantica.png"), semanticViewer, null);
        tab.addTab("Polaca inversa", generateIcon("Compilador/src/images/semantica.png"), reversePolishViewer, null);
        tab.addTab("Tabla de símbolos", generateIcon("Compilador/src/images/tablasimbolo.png"), symbolTableViewer, null);

        this.setIconImage(new ImageIcon("Compilador/src/images/logo.png").getImage());
		setTitle("FasTALC (FASTA Language Compiler)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(tab);
		setContentPane(contentPane);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    private Icon generateIcon(String path) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(path));
            Image scaledImage = originalImage.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
           return null;
        }
    }

    public TokenViewer getPanelTokenViewer() {
        return panelTokenViewer;
    }

    public void setPanelTokenViewer(TokenViewer panelTokenViewer) {
        this.panelTokenViewer = panelTokenViewer;
    }

    public SemanticViewer getSemanticViewer() {
        return semanticViewer;
    }

    public void setSemanticViewer(SemanticViewer semanticViewer) {
        this.semanticViewer = semanticViewer;
    }

    public SymbolTableViewer getSymbolTableViewer() {
        return symbolTableViewer;
    }

    public void setSymbolTableViewer(SymbolTableViewer symbolTableViewer) {
        this.symbolTableViewer = symbolTableViewer;
    }
    
}
