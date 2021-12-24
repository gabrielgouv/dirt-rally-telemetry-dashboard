package com.github.gabrielgouv.dr2td.net;

import javax.swing.*;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.function.Consumer;

public class UDPClient {

    private static final int BUFFER_SIZE = 256;

    private final int port;

    private Consumer<DatagramPacket> onPacketReceived;
    private boolean listening;

    public UDPClient(int port) {
        this.port = port;
    }

    public void listen() {
        try {
            listening = true;

            DatagramSocket datagramSocket = new DatagramSocket(port);

            byte[] buffer = new byte[BUFFER_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (listening) {
                datagramSocket.receive(packet);
                if (onPacketReceived != null) {
                    onPacketReceived.accept(packet);
                }
            }
        } catch (BindException bindException) {
            JOptionPane.showMessageDialog(null, String.format("Port %d is already in use by another application.\n" +
                    "Change the port in the settings.cfg file or close applications that are using this port.", port));
            System.exit(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, String.format("Unexpected error occurred:\n%s", e.getLocalizedMessage()));
            System.exit(2);
        }
    }

    public void onPacketReceived(Consumer<DatagramPacket> onPacketReceived) {
        this.onPacketReceived = onPacketReceived;
    }

    public void stop() {
        listening = false;
    }

}
