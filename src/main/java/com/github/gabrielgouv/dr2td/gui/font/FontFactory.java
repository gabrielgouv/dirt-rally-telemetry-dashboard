package com.github.gabrielgouv.dr2td.gui.font;

import java.awt.*;
import java.io.InputStream;

public class FontFactory {

    private final static String name = "FiraCode.ttf";
    private static InputStream cache;

    public static Font getDefaultFont(float size) {

        Font font;
        String fontName = "/fonts/" + name;

        try {
            InputStream inputStream = FontFactory.class.getResourceAsStream(fontName);

            if (cache == null) {
                cache = inputStream;
            }

            assert inputStream != null;

            font = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(size);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Cannot load " + fontName + ".  Using Arial font.");
            font = new Font("Arial", Font.PLAIN, (int) size);
        }

        return font;
    }

}
