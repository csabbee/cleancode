package com.clean.ship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShipFileReader {
	
	@Autowired
	private List<String[][]> ships = new ArrayList<String[][]>();
	@Autowired
	private List<Integer> numberOfShips = new ArrayList<Integer>();
	
	@Autowired
	private String filename;
	
	private String[] convert(String string) {
		String[] answer = new String[4];
		answer[0] = string.substring(0, 1);
		answer[1] = string.substring(1, 2);
		answer[2] = string.substring(2, 3);
		answer[3] = string.substring(3, 4);
		return answer;
	}

	@PostConstruct
	public void read() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			System.out.format("filename=%s %n", filename);
		} catch (IOException e) {
			System.out.println("Could not locate your file");
		}
		
		String line = "";
		int checkForNewShip = 0;
		String[][] shipShape = new String[4][4];
		
		try {
			numberOfShips.add(Integer.valueOf(reader.readLine()));
			
			while ((line = reader.readLine()) != null){
				if (checkForNewShip == 4){
					numberOfShips.add(Integer.valueOf(line));
					checkForNewShip = 0;
					ships.add(shipShape);
					shipShape = new String[4][4];
				}
				else {
					shipShape[checkForNewShip] = convert(line);
					checkForNewShip++;
				}
			}
			ships.add(shipShape);
		} catch (IOException e) {
			System.out.println("Could not read from the file");
		}
	}

	public List<String[][]> getShips() {
		return ships;
	}

	public List<Integer> getNumberOfShips() {
		return numberOfShips;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


}
