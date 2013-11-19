package com.epam;

import com.epam.impl.RandomTorpedo;
import com.epam.impl.RandomTorpedoWithShips;
import com.epam.torpedo.NextTarget;
import com.epam.torpedo.PopulateTorpedoTable;
import com.epam.torpedo.Status;
import com.epam.torpedo.ship.SimpleShip;
import com.epam.torpedo.table.TorpedoTable;

public class Main {

    public static void main(String[] args){       
       NextTarget nexttarget = new NextTarget();
       runRandomTorpedo(nexttarget);
       runRandomTorpedoWithShips(nexttarget);
    }

    public static void runRandomTorpedo(NextTarget nexttarget) {
        RandomTorpedo randomtorpedo = new RandomTorpedo();
           
           while(randomtorpedo.getScore() < 20){
               SimpleShip nexttargetship = nexttarget.newTarget();
               if (randomtorpedo.fire(nexttargetship.getXpositon(), nexttargetship.getYpositon())==Status.HIT_AND_SINK){
                   randomtorpedo.incrementScore();
               }
           }
           System.out.format("You get 20 hits out of %d tries%n", randomtorpedo.getTries());
    }

    public static void runRandomTorpedoWithShips(NextTarget nexttarget) {
       TorpedoTable torpedotable = new TorpedoTable();
       PopulateTorpedoTable populatetorpedotable = new PopulateTorpedoTable(torpedotable);
       populatetorpedotable.populateTable();
       RandomTorpedoWithShips randomtorpedowithships = new RandomTorpedoWithShips(torpedotable);
       while(randomtorpedowithships.getScore() < 25){
          SimpleShip nexttargetship = nexttarget.newTarget();
          if(randomtorpedowithships.fire(nexttargetship.getXpositon(), nexttargetship.getYpositon())==Status.HIT_AND_SINK){
              randomtorpedowithships.incrementScore();
          }
       }
       System.out.format("You get 25 hits out of %d tries%n", randomtorpedowithships.getTries());
    }
}
