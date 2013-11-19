package com.epam.torpedo.net;

import com.epam.api.strategy.GameStrategy;

public class TorpedoProtocol {
    private static final int FIRING = 0;
    private static final int LISTENING = 1;
    
    private int state = FIRING;
    private GameWithShips gameWithShips;
    private GameStrategy gameStrategy;
    
    public TorpedoProtocol(GameWithShips gameWithShips, int state, GameStrategy gameStrategy) {
        super();
        this.gameWithShips = gameWithShips;
        this.state = state;
        this.gameStrategy = gameStrategy;
    }

    public String processInput(String theInput) {
        String outputLine;
        if(state == LISTENING){
            if(theInput.split(" ").length < 3){
                throw new IllegalArgumentException("Not enough parameter");
            }
            int x = Integer.parseInt(theInput.split(" ")[1]);
            int y = Integer.parseInt(theInput.split(" ")[2]);
            switch (gameWithShips.fire(x, y)) {
            case HIT: 
                outputLine = "hit";
                state = FIRING;
                break;
            case MISS:
                outputLine = "miss";
                state = FIRING;
                break;
            case SUNK:
                outputLine = "sunk";
                state = FIRING;
                break;
            case WIN:
                outputLine = "win";
                state = FIRING;
                break;
            default:
                outputLine = "not valid";
                break;
            }
        } else {            
            outputLine = gameStrategy.nextTarget(theInput);
            if(!theInput.equals("not valid")){
                state = LISTENING;
            }
        }
        return outputLine;
    }

}
