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
public class Dame extends Piece {
    
    public Dame(boolean couleur) {
        super(couleur);
    }
    
    public Dame(boolean couleur, int posX, int posY) {
        super(couleur, posX, posY);
    }

    @Override
    public ArrayList<int[]> deplacementsPossibles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
