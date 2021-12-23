package com.github.gabrielgouv.dr2td.net;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPacketReceived(Consumer<DatagramPacket> onPacketReceived) {
        this.onPacketReceived = onPacketReceived;
    }

    public void stop() {
        listening = false;
    }

}
