package com.github.gabrielgouv.dr2td.bootstrap;

import com.github.gabrielgouv.dr2td.gui.Dashboard;
import com.github.gabrielgouv.dr2td.model.TelemetryData;
import com.github.gabrielgouv.dr2td.net.UDPClient;

import java.net.DatagramPacket;

public class Bootstrap {

    private static final Dashboard dashboard = new Dashboard();

    public static void main(String[] args) {
        // TODO: load config file

        final var udpClient = new UDPClient(10001); // FIXME: get port from config file
        udpClient.onPacketReceived((Bootstrap::updateDashboard));
        udpClient.listen();
    }

    private static void updateDashboard(DatagramPacket packet) {
        var data = packet.getData();
        dashboard.update(TelemetryData.fromByteArray(data));
    }

}
