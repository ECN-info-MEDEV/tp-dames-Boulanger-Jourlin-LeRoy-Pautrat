/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

/**
 *
 * @author asjou
 */
public class Piece {
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
    
    public void deplacementsPossibles(){
        
    }
    
    public boolean deplacer(int x, int y){
        //Return true si on a mangé qqun ou si la position n'est pas possible
        return true;
    }
    
    public void capturer(int x, int y){
        
    }
}
