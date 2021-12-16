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
    
    /**
     * Méthode abstraite qui renvoie les déplacements possibles sous forme d'une liste
     * @return
     */
    public abstract ArrayList<int[]> deplacementsPossibles();
    
    /**
     * Méthode qui déplace une pièce à la position indiquée et renvoie true si le joueur peut continuer à se déplacer, c'est-à-dire si il y a une pièce mangeable à portée
     * @param x
     * @param y
     * @return
     */
    public boolean deplacer(int x, int y){
        //return true si on a mangé qqun ou si le déplacement est interrompu
        //On suppose qu'on a vérifié que le déplacement est possible avant de lancer cette méthode
        int tempPosX = this.getPosX();
        int tempPosY = this.getPosY();
        int dirX = (x-tempPosX)/Math.abs(x-tempPosX);
        int dirY = (y-tempPosY)/Math.abs(y-tempPosY);
        while(tempPosX+dirX!=x&&tempPosY+dirY!=y){
            tempPosX += dirX;
            tempPosY += dirY;
            Piece pXY = Plateau.isPieceOnPos(tempPosX,tempPosY);
            //On regarde si la position est occupée par une pièce
            if(pXY==null){
                this.setPosX(tempPosX);
                this.setPosX(tempPosY);
            }
            else{
                if(pXY.isCouleur()==this.isCouleur()){
                    //Cas qui n'est pas censé arriver, le déplacement est interrompu
                    return false;
                }
                else{
                    this.setPosX(tempPosX+dirX);
                    this.setPosX(tempPosY+dirY);
                    capturer(tempPosX,tempPosY);
                    return this.capturePossible();
                }
            }
        }
        this.setPosX(x);
        this.setPosX(y);
        return false;
    };
    
    /**
     * Méthode qui indique s'il y a des pièces possibles à manger sur le plateau (renvoie true dans ce cas)
     * @return
     */
    public abstract boolean capturePossible();
    
    /**
     * Méthode qui mange la pièce à la case considérée
     * @param x
     * @param y
     */
    public void capturer(int x, int y){
        //Supprime la case du plateau
    }
}
