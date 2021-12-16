/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Boulanger
 */
public class Joueur {
    private boolean couleur;
    private Plateau plt;
    
    /**
     * Constructeur de la classe Joueur, le bool défini la couleur du Joueur true = blanc, false = noir
     * @param coul 
     */
    public Joueur(boolean coul, Plateau plt){
        this.couleur=coul;
        this.plt=plt;
    }

    public boolean isCouleur() {
        return couleur;
    }
    
    
    /**
     * Méthode Jouer qui permet au Joueur d'effectuer un tour entier
     */
    public void Jouer(){
        //Affiche le plateau au Joueur
        Scanner sc = new Scanner(System.in);
        ArrayList<Piece> cases= Plateau.liste_de_cases;
        Piece pieceJoue;
        pieceJoue=null;
        boolean isCouleur=false;
        int posX=0;
        int posY=0;
        String coul="Blanc";
        if(!couleur){
            coul="Noir";
        }
        System.out.println("Voici le plateau, vous êtes de couleur:"+ coul);
        plt.afficher();
        
        
        //Demande au joueur quelle pièce il veut bouger(position)
        while(!isCouleur  ){
            System.out.println("Veuillez choisir une pièce à bouger:");
            
            System.out.println("Abscisses:");
            posX=sc.nextInt();
            
            System.out.println("Ordonnées:");
            posY=sc.nextInt();
            
            //On vérifie parmis toutes les pièces si c'est bien une pièce et qu'elle est de la même couleur que le joueur
            for(Piece p : cases){
                if(p.getPosX()==posX && p.getPosY()==posY){
                    if(p.isCouleur()==this.couleur){
                        isCouleur=true;
                        pieceJoue=p;
                        break;
                    }
                    else{
                        System.out.println("Mauvaise couleur");
                        break;
                    }
                }
                System.out.println("La pièce n'existe pas");
            }
        }
        //Demande au joueur où il veut bouger la pièce
        
        System.out.println("Voici les déplacements possibles:");
        ArrayList<int[]> result=pieceJoue.deplacementsPossibles();
        boolean isDeplacement=false;
        while(!isDeplacement){
            System.out.println("Quel déplacement choisissez vous?");

            System.out.println("Abscisses");
            posX=sc.nextInt();

            System.out.println("Ordonnées");
            posY=sc.nextInt();
            for( int[] t : result){
                if(t[0]==posX &&t[1]==posY){
                    isDeplacement=true;
                    break;
                }
            }
        }
        if(pieceJoue.deplacer(posX,posY)){
            System.out.println("Vous avez le droit de rejouer");
            Jouer();
        }
    }  
}
