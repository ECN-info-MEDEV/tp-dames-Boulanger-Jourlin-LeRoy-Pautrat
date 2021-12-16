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
    public boolean deplacer(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<int[]> deplacementsPossibles() {
        ArrayList<int[]> result = new ArrayList<>();
        //if()
        return result;
    }
    
}
