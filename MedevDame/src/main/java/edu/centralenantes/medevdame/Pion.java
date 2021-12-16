/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.util.ArrayList;

/**
 * Classe pour les Pièces de type Pion, sous-classe de la classe abstraite Piece
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
        if(this.capturePossible()){
            if(Plateau.isPieceOnPos(this.getPosX()-1,this.getPosY()-1)!=null&&this.getPosX()-2>=0&&this.getPosY()-2>=0){
                System.out.println((this.getPosX()-2) +","+(this.getPosY()-2));
                result.add(new int[]{this.getPosX()-2,this.getPosY()-2});
            }
            if(Plateau.isPieceOnPos(this.getPosX()-1,this.getPosY()+1)!=null&&this.getPosX()-2>=0&&this.getPosY()+2<10){
                System.out.println((this.getPosX()-2) +","+(this.getPosY()+2));
                result.add(new int[]{this.getPosX()-2,this.getPosY()+2});
            }
            if(Plateau.isPieceOnPos(this.getPosX()+1,this.getPosY()+1)!=null&&this.getPosX()+2<10&&this.getPosY()+2<10){
                System.out.println((this.getPosX()+2) +","+(this.getPosY()+2));
                result.add(new int[]{this.getPosX()+2,this.getPosY()+2});
            }
            if(Plateau.isPieceOnPos(this.getPosX()+1,this.getPosY()-1)!=null&&this.getPosX()+2<10&&this.getPosY()-2>=0){
                System.out.println((this.getPosX()+2) +","+(this.getPosY()-2));
                result.add(new int[]{this.getPosX()+2,this.getPosY()-2});
            }
        }
        else{
            //On regarde la couleur pour savoir si on doit incrémenter ou décrémenter x
            if(this.isCouleur()){
                //Les blancs sont en bas donc i doit décroitre
                if(this.getPosX()-1>=0){
                    if(this.getPosY()-1>=0){
                        result.add(new int[]{this.getPosX()-1,this.getPosY()-1});
                        System.out.println((this.getPosX()-1) +","+(this.getPosY()-1));
                    }
                    if(this.getPosY()+1<10){
                        result.add(new int[]{this.getPosX()-1,this.getPosY()+1});
                        System.out.println((this.getPosX()-1) +","+(this.getPosY()+1));
                    }
                }
            }
            else{
                if(this.getPosX()+1<10){
                    if(this.getPosY()-1>=0){
                        result.add(new int[]{this.getPosX()+1,this.getPosY()-1});
                        System.out.println((this.getPosX()+1) +","+(this.getPosY()-1));
                    }
                    if(this.getPosY()+1<10){
                        result.add(new int[]{this.getPosX()+1,this.getPosY()+1});
                        System.out.println((this.getPosX()+1) +","+(this.getPosY()+1));
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean capturePossible() {
        return (Plateau.isPieceOnPos(this.getPosX()-1,this.getPosY()-1)!=null&&this.getPosX()-2>=0&&this.getPosY()-2>=0)||(Plateau.isPieceOnPos(this.getPosX()-1,this.getPosY()+1)!=null&&this.getPosX()-2>=0&&this.getPosY()+2<10)||(Plateau.isPieceOnPos(this.getPosX()+1,this.getPosY()-1)!=null&&this.getPosX()+2<10&&this.getPosY()-2>=0)||(Plateau.isPieceOnPos(this.getPosX()+1,this.getPosY()+1)!=null&&this.getPosX()+2<10&&this.getPosY()+2<10);
    }
    
    /**
     * Méthode pour transformer un pion en dame, à appeler après chaque dernier déplacement de pion (si on est en cours de rafle et qu'on repart en arrière, on n'est pas promu)
     */
    public void getPromoted(){
        if((this.isCouleur() && this.getPosX()==0)||(!this.isCouleur() && this.getPosX()==9)){
            Dame d = new Dame(this.isCouleur(), this.getPosX(), this.getPosY());
            Plateau.liste_de_cases.remove(Plateau.isPieceOnPos(this.getPosX(), this.getPosY()));
            Plateau.liste_de_cases.add(d);
        }
    }
}
