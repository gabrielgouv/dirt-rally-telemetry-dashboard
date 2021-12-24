package com.github.gabrielgouv.dr2td.bootstrap;

import com.github.gabrielgouv.dr2td.config.Configuration;
import com.github.gabrielgouv.dr2td.factory.TelemetryDataFactory;
import com.github.gabrielgouv.dr2td.gui.Dashboard;
import com.github.gabrielgouv.dr2td.net.UDPClient;

import javax.swing.*;
import java.net.DatagramPacket;

public class Bootstrap {

    private static final Dashboard dashboard = new Dashboard(new Configuration());

    public static void main(String[] args) {
        // TODO: load config file

        setupLookAndFeel();

        final var udpClient = new UDPClient(10001); // FIXME: get port from config file
        udpClient.onPacketReceived((Bootstrap::updateDashboard));
        udpClient.listen();
    }

    private static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Cannot apply look and feel");
        }
    }

    private static void updateDashboard(DatagramPacket packet) {
        var data = packet.getData();
        dashboard.update(TelemetryDataFactory.fromByteArray(data));
    }

}
