package com.epam;

import com.epam.impl.RandomTorpedo;

public class Main {

    public static void main(String[] args){
       RandomTorpedo randomtorpedo = new RandomTorpedo();
       
       while(randomtorpedo.getScore() < 20){
           if (randomtorpedo.fire((int)(Math.random()*255), (int)(Math.random()*255))){
               randomtorpedo.incrementScore();
           }
       }
       System.out.format("You get 20 hits out of %d tries%n", randomtorpedo.getTries());
    }
}
