package com.epam.torpedo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TorpedoClient {

    private final int portNumber;
    private final String hostName;
    
    public TorpedoClient(String string) {
        hostName = string.split(":")[0];
        portNumber = Integer.parseInt(string.split(":")[1]);
    }

    public void initClient(GameWithShips gameWithShips){
        try (
            Socket clientSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
          ) {
            String fromServer;
            String fromUser;
            TorpedoProtocol torpedoProtocol = new TorpedoProtocol(gameWithShips, 0);
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye.")){
                    break;
                }
                fromUser = torpedoProtocol.processInput(fromServer);
                out.println(fromUser);
                System.out.println("Client: " + fromUser);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    
    }
}
