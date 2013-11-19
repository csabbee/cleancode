package com.clean.tablewithships;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.clean.ship.ShipFileReader;
import com.clean.ship.ShipLocations;

public class ShipImplementation {
	
    Random randomgenerator;
    private ShipLocations shipLocations;
    private ShipFileReader reader;
	List<String[][]> ships = new ArrayList<String[][]>();
	List<Integer> numberOfShips = new ArrayList<Integer>();
    private int boardSize;
    private int totalNumberOfTargets;
    private String filename;
	
	private void calculateNumberOfTargets () {
		totalNumberOfTargets = 0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (shipLocations.checkPoint(i, j)){
					totalNumberOfTargets++;
				}
			}
		}
	}
	
	public void initialisation() {
		reader.setFilename(filename);
		reader.read();
		ships = reader.getShips();
		numberOfShips = reader.getNumberOfShips();
		calculateNumberOfTargets();		
	}

    public void placeShips() {
    	for (int index = 0; index < ships.size(); index++) {
			String[][] shipShape = ships.get(index);
       	 	int randomInt = randomgenerator.nextInt(boardSize - 2);
       	 	int randomInt2 = randomgenerator.nextInt(boardSize - 1);
       	 	if (shipLocations.checkShip(randomInt, randomInt2, shipShape)){
       	 		index--;
       	 	} else {
       	 		shipLocations.addShipLocation(randomInt, randomInt2, shipShape);
       	 }
		}
    }

	public void setShipLocations(ShipLocations shipLocations) {
		this.shipLocations = shipLocations;
	}

	public void setReader(ShipFileReader reader) {
		this.reader = reader;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getTotalNumberOfTargets() {
		return totalNumberOfTargets;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

}
