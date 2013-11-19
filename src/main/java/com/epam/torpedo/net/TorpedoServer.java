package com.epam.torpedo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.epam.api.strategy.GameStrategy;
import com.epam.api.strategy.random.RandomTargetStrategy;

public class TorpedoServer {

    private final int portNumber;
    
    public TorpedoServer(String string) {
        portNumber = Integer.parseInt(string);
    }

    public void initServer(GameWithShips gameWithShips){
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outputLine;
            while(!(inputLine = in.readLine()).contains("greeting")){
                gameWithShips.setBoardSize(Integer.parseInt(inputLine.split(" ")[1]));
                gameWithShips.initialise();
            }
            GameStrategy gameStrategy = new RandomTargetStrategy(Integer.parseInt(inputLine.split(" ")[1]));
            TorpedoProtocol torpedoProtocol = new TorpedoProtocol(gameWithShips, 1, gameStrategy);
            while((inputLine = in.readLine()) != null){
                outputLine = torpedoProtocol.processInput(inputLine);
                out.println(outputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
