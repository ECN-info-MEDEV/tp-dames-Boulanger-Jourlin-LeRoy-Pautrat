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
public abstract class Piece {
    private boolean couleur;
    
    private int posX;
    private int posY;

    public boolean isCouleur() {
        return couleur;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Piece(boolean couleur) {
        this.couleur = couleur;
    }

    public Piece(boolean couleur, int posX, int posY) {
        this.couleur = couleur;
        this.posX = posX;
        this.posY = posY;
    }
    
    public abstract ArrayList<int[]> deplacementsPossibles();
    
    public abstract boolean deplacer(int x, int y);
    
    public void capturer(int x, int y){
        
    }
}
