package com.epam.torpedo.net;

public class TorpedoProtocol {
    private static final int FIRING = 0;
    private static final int LISTENING = 1;
    
    private int state = FIRING;
    private GameWithShips gameWithShips;
    
    public TorpedoProtocol(GameWithShips gameWithShips, int state) {
        super();
        this.gameWithShips = gameWithShips;
        this.state = state;
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
                break;
            case MISS:
                outputLine = "miss";
                break;
            case SUNK:
                outputLine = "sunk";
                break;
            case WIN:
                outputLine = "win";
                break;
            default:
                outputLine = "not valid";
                break;
            }
            state = FIRING;
        } else {
            outputLine = "fire 2 2";
        }
        return outputLine;
    }

}
