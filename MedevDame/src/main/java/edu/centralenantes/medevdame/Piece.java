/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.util.ArrayList;

/**
 * Classe abstraite pour les pièces, classe mère des Pions et des Dames
 * @author asjou
 */
public abstract class Piece {
    private boolean couleur;
    
    private int posX;
    private int posY;
    
    private boolean notCaptured;

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

    public boolean isNotCaptured() {
        return notCaptured;
    }

    public void setNotCaptured(boolean notCaptured) {
        this.notCaptured = notCaptured;
    }
    
    public Piece(boolean couleur) {
        this.couleur = couleur;
        this.notCaptured = true;
    }

    public Piece(boolean couleur, int posX, int posY) {
        this.couleur = couleur;
        this.posX = posX;
        this.posY = posY;
        this.notCaptured = true;
    }
    
    /**
     * Méthode abstraite qui renvoie les déplacements possibles sous forme d'une liste
     *
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
        while(tempPosX!=x&&tempPosY!=y){
            tempPosX += dirX;
            tempPosY += dirY;
            Piece pXY = Plateau.isPieceOnPos(tempPosX,tempPosY);

            //On regarde si la position est occupée par une pièce
            if(pXY!=null){
                if(pXY.isCouleur()==this.isCouleur()){
                    //Cas qui n'est pas censé arriver, le déplacement est interrompu
                    this.setPosX(tempPosX);
                    this.setPosY(tempPosY);
                    return false;
                }
                else{
                    this.setPosX(tempPosX+dirX);
                    this.setPosY(tempPosY+dirY);
                    capturer(tempPosX,tempPosY);
                    return this.capturePossible();
                }
            }
        }
        this.setPosX(x);
        this.setPosY(y);
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
        //La mémoire sera vidée par le GC
        Plateau.isPieceOnPos(x, y).setNotCaptured(false);
        System.out.println("Vous avez capturé la pièce en position " + x + "," + y + " au cours de votre rafle !");
    }
    
    /**
     * Méthode à lancer à chaque fin de tour sur la pièce jouée
     */
    public void finTourPiece(){
        if(this instanceof Pion pion){
            pion.getPromoted();
        }
        ArrayList<Piece> piecesRaflees = new ArrayList();
        for(int i = 0; i<Plateau.liste_de_cases.size();i++){
            if(!Plateau.liste_de_cases.get(i).isNotCaptured()){
                piecesRaflees.add(Plateau.liste_de_cases.get(i));
            }
        }
        for(int i=0; i<piecesRaflees.size();i++){
            Plateau.liste_de_cases.remove(piecesRaflees.get(i));
        }
    }
}
