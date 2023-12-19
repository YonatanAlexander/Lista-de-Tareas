import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        FlatSolarizedLightIJTheme.setup();
        UIManager.put("Button.foreground", Color.BLACK);
        Tareas.display();
    }
}