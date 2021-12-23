package com.github.gabrielgouv.dr2td.gui.font;

import java.awt.*;
import java.io.InputStream;

public class FontFactory {

    private final static String name = "FiraCode.ttf";
    private static Font cache;

    public static Font getDefaultFont(float size) {

        Font font;
        String fontName = "/fonts/" + name;

        try {
            if (cache == null) {
                InputStream inputStream = FontFactory.class.getResourceAsStream(fontName);
                cache = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            }

            font = cache.deriveFont(size);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Cannot load " + fontName + ".  Using Arial font.");
            font = new Font("Arial", Font.PLAIN, (int) size);
        }

        return font;
    }

}
