package com.github.gabrielgouv.dr2td.bootstrap;

import com.github.gabrielgouv.dr2td.config.Configuration;
import com.github.gabrielgouv.dr2td.config.ConfigurationLoader;
import com.github.gabrielgouv.dr2td.factory.TelemetryDataFactory;
import com.github.gabrielgouv.dr2td.gui.Dashboard;
import com.github.gabrielgouv.dr2td.net.UDPClient;

import javax.swing.*;
import java.net.DatagramPacket;

public class Bootstrap {

    private static Dashboard dashboard;

    public static void main(String[] args) {
        setupLookAndFeel();

        dashboard = new Dashboard(loadConfiguration());

        startUdpClient(10001);
    }

    private static Configuration loadConfiguration() {
        return ConfigurationLoader.loadConfiguration();
    }

    private static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Cannot apply look and feel");
        }
    }

    private static void startUdpClient(int port) {
        final var udpClient = new UDPClient(port);
        udpClient.onPacketReceived((Bootstrap::updateDashboard));
        udpClient.listen();
    }

    private static void updateDashboard(DatagramPacket packet) {
        var data = packet.getData();
        dashboard.update(TelemetryDataFactory.fromByteArray(data));
    }

}
