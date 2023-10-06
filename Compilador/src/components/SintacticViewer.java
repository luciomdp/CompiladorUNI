package components;
import java.awt.*;

public class SintacticViewer extends AbstractPanelViewer {

    private static final Color BACKGROUND_PANEL = new Color(109,128,214,255), BACKGROUND_COMPONENTS = new Color(81,105,206,255);

    public SintacticViewer() {
        super(BACKGROUND_PANEL,BACKGROUND_COMPONENTS);
        appendData("--------------------------- << Comienzo del análisis semántico >> ---------------------------\n");
    }
}