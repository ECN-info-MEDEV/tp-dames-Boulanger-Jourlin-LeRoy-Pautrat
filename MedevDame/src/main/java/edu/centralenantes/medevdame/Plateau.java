/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.util.ArrayList;

/**
 * La classe symbolisant le plateau de jeu
 * @author Louis
 */
public class Plateau {
    
    /**
     * La liste des pièces présentes sur le plateau
     */
    public static ArrayList<Piece> liste_de_cases;
    /**
     * Le premier joueur
     */
    private Joueur joueur1;
    /**
     * Le deuxième joueur
     */
    private Joueur joueur2;
    
    /**
     * Le constructeur classique du plateau
     */
    public Plateau(){
        // On construit la liste de pièces
        liste_de_cases = new ArrayList<>();
        // On ajoute les pieces noires
        for(int i = 0; i < 4; i++){
            if(i%2==0){
                for(int j = 1; j < 10; j = j +2){
                    Piece piece = new Piece(false, i, j);
                    liste_de_cases.add(piece);
                }
            }
            else{
                for(int j = 0; j < 10; j = j +2){
                    Piece piece = new Piece(false, i, j);
                    liste_de_cases.add(piece);
                }
            }
        }
        // On ajoute les pieces blanches
        for(int i = 6; i < 10; i++){
            if(i%2==0){
                for(int j = 1; j < 10; j = j +2){
                    Piece piece = new Piece(true, i, j);
                    liste_de_cases.add(piece);
                }
            }
            else{
                for(int j = 0; j < 10; j = j +2){
                    Piece piece = new Piece(true, i, j);
                    liste_de_cases.add(piece);
                }
            }
        }
        
        // On ajoute les deux joueurs
        joueur1 = new Joueur(true, this);
        joueur2 = new Joueur(false, this);
    }    
    
    public void tourDeJeu(){
        joueur1.Jouer();
        
        joueur2.Jouer();
    }
    
    public void afficher(){
        String ligne_limite = "";
        for(int i = 0; i < 10; i++){
            ligne_limite += " -";
        }
    }
    
}
