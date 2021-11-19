/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author phamv
 */
public class MulticastChatClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        int portnumber = 5000;
        if (args.length >= 1) 
        {
        portnumber = Integer.parseInt(args[0]);
        }
        // Create a MulticastSocket
        MulticastSocket chatMulticastSocket = new MulticastSocket(portnumber);
        InetAddress group = InetAddress.getByName("225.4.5.6");
        // Joins a multicast group
        chatMulticastSocket.joinGroup(group);
        String msg = "";
        System.out.println("Type a message for the Server:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        msg = br.readLine();
        // Send the message to Multicast address
        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0,
        msg.length(), group, portnumber);
        chatMulticastSocket.send(data);
        chatMulticastSocket.close();
    }
}
    
