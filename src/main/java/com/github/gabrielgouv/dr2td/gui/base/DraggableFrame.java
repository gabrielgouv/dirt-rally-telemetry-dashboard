package com.github.gabrielgouv.dr2td.gui.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DraggableFrame extends JFrame {

    private final JFrame parent;

    private Point initialClick;

    public DraggableFrame() {
        parent = this;
        setupMouseListener();
        setupMouseMotionListener();
    }

    private void setupMouseListener() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });
    }

    private void setupMouseMotionListener() {
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int thisX = parent.getLocation().x;
                int thisY = parent.getLocation().y;

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int x = thisX + xMoved;
                int y = thisY + yMoved;
                parent.setLocation(x, y);
            }
        });
    }

}
