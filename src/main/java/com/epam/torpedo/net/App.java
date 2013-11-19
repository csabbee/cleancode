package com.clean.main;


public class App 
{
    public static void main( String[] args ) {
    	if (args.length != 3) {
    		throw new IllegalArgumentException("You need to specify a file, port or host:port and boardsize");
    	}
    	ShipFileReader shipFileReader = new ShipFileReader();
        ShipLocations shipLocations = new ShipLocations();
        ShipImplementation impl = new ShipImplementation();
        GameWithShips game = new GameWithShips();
        game.setImpl(impl);
        game.setFilename(args[0]);
        game.setShipFileReader(shipFileReader);
        game.setShipLocations(shipLocations);
    	if(args[1].contains(":")){
            TorpedoClient torpedoClient = new TorpedoClient(args[1]);
            game.setBoardSize(Integer.parseInt(args[2]));
            torpedoClient.initClient(game);
    	} else {
            TorpedoServer torpedoServer = new TorpedoServer(args[1]);
            torpedoServer.initServer(game);

    	}
    }
}
