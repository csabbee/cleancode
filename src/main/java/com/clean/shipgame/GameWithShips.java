package com.clean.shipgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clean.interfaces.Torpedo;
import com.clean.printer.ConsolePrinter;
import com.clean.ship.ShipFileReader;
import com.clean.ship.ShipLocations;
import com.clean.tablewithships.ShipImplementation;

@Component
public class GameWithShips implements Torpedo {
	
	@Autowired
	private ShipLocations shipLocations;
	@Autowired
    private ShipImplementation impl;
	private int loseCondition = 0;
	@Autowired
	private int numberOfTargets;
	@Autowired
	private int boardSize;
	@Autowired
	private String filename;
	@Autowired
	private ShipFileReader shipFileReader;
	private ConsolePrinter printer;
	
    public Status fire(int x, int y) {
        Status status = Status.MISS;
        if(shipLocations.hit(x, y)){
            status = Status.HIT;
            loseCondition++;
            System.out.format("LoseCondition=%s %n", loseCondition);
            //printer.printBoard();
            if(checkIfSunken()){
                status = Status.SUNK;
                System.out.format("SUNK!%n");
                if(loseCondition == numberOfTargets){
                    status = Status.WIN;
                }
            }
        }
    	return status;
    }
    
    public boolean checkIfSunken() {
		return shipLocations.checkSunken();
    }
    
    public void initialise() {
        printer = new ConsolePrinter(shipLocations, boardSize);
    	System.out.format("numberOfTargets=%s %n", numberOfTargets);
    }

	public void setShipLocations(ShipLocations shipLocations) {
		this.shipLocations = shipLocations;
	}

	public void setImpl(ShipImplementation impl) {
		this.impl = impl;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setShipFileReader(ShipFileReader shipFileReader) {
		this.shipFileReader = shipFileReader;
		
	}

	public void setNumberOfTargets(int numberOfTargets) {
		this.numberOfTargets = numberOfTargets;
	}

}
