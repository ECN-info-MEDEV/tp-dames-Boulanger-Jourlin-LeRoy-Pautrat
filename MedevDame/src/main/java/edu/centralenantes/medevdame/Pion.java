/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.util.ArrayList;

/**
 *
 * @author asjou
 */
public class Pion extends Piece {
    
    public Pion(boolean couleur) {
        super(couleur);
    }

    public Pion(boolean couleur, int posX, int posY) {
        super(couleur, posX, posY);
    }

    @Override
    public ArrayList<int[]> deplacementsPossibles() {
        ArrayList<int[]> result = new ArrayList<>();
        if(this.getPosX()-1>=0){
            if(this.getPosY()-1>=0){
                result.add(new int[]{this.getPosX()-1,this.getPosY()-1});
                System.out.println((this.getPosX()-1) +","+(this.getPosX()-1));
            }
            if(this.getPosY()+1<10){
                result.add(new int[]{this.getPosX()-1,this.getPosY()+1});
                System.out.println((this.getPosX()-1) +","+(this.getPosX()+1));
            }
        }
        if(this.getPosX()+1<10){
            if(this.getPosY()-1>=0){
                result.add(new int[]{this.getPosX()+1,this.getPosY()-1});
                System.out.println((this.getPosX()+1) +","+(this.getPosX()-1));
            }
            if(this.getPosY()+1<10){
                result.add(new int[]{this.getPosX()+1,this.getPosY()+1});
                System.out.println((this.getPosX()+1) +","+(this.getPosX()+1));
            }
        }
        return result;
    }
    
}
