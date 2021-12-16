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
    private ArrayList<Piece> liste_de_cases;
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
                    Pion pion = new Pion(false, i, j);
                    liste_de_cases.add(pion);
                }
            }
            else{
                for(int j = 0; j < 10; j = j +2){
                    Pion pion = new Pion(false, i, j);
                    liste_de_cases.add(pion);
                }
            }
        }
        // On ajoute les pieces blanches
        for(int i = 6; i < 10; i++){
            if(i%2==0){
                for(int j = 1; j < 10; j = j +2){
                    Pion pion = new Pion(true, i, j);
                    liste_de_cases.add(pion);
                }
            }
            else{
                for(int j = 0; j < 10; j = j +2){
                    Pion pion = new Pion(true, i, j);
                    liste_de_cases.add(pion);
                }
            }
        }
        
        // On ajoute les deux joueurs
        joueur1 = new Joueur(true, this);
        joueur2 = new Joueur(false, this);
    }    
    
    /**
     * Méthode qui simule un tour de jeu sur le plateau
     */
    public void tourDeJeu(){
        joueur1.Jouer();

        joueur2.Jouer();
    }
    
    /**
     * Fonction qui détermine si la partie est finie et renvoie le joueur qui gagne
     * @return true si la partie est finie et false sinon
     */
    public boolean partie_finie(){
        boolean partie_finie = false;
        
        boolean blancs_toujours_presents = false;
        boolean noirs_toujours_presents = false;
        
        for(Piece piece : liste_de_cases){
            if (piece.isCouleur()){
                blancs_toujours_presents = true;
            }
            else{
                noirs_toujours_presents = true;
            }
        }
        
        partie_finie = !blancs_toujours_presents || !noirs_toujours_presents;
        
        return partie_finie;
    }
    
    public void afficher(){
        // On créé une ligne de - - - pour délimiter les lignes du plateau
        String ligne_limite = "";
        for(int j = 0; j < 10; j++){
            ligne_limite += " -";
        }
        System.out.println(ligne_limite);
        
        // On va maintenant gérer toutes les lignes du plateau
        for(int i = 0; i < 10; i++){
            String ligne_contenu = "|";
            for(int j = 0; j < 10; j++){
                boolean case_libre = true;
                boolean case_utilise_par_blanc = true;
                boolean case_occupe_par_pion = true;
                for(Piece piece : liste_de_cases){
                    if(piece.getPosX()==i && piece.getPosY()==j){
                        case_libre = false;
                        case_utilise_par_blanc = piece.isCouleur();
                        case_occupe_par_pion = piece instanceof Pion;
                    }
                }
                if(case_libre){
                    ligne_contenu += " |";
                }
                else{
                    if(case_utilise_par_blanc){
                        if(case_occupe_par_pion){
                            ligne_contenu += "b|";
                        }
                        else{
                            ligne_contenu += "B|";
                        }
                    }
                    else{
                        if(case_occupe_par_pion){
                            ligne_contenu += "n|";
                        }
                        else{
                            ligne_contenu += "N|";
                        }                    
                    }
                }
            }
            System.out.println(ligne_contenu);
            System.out.println(ligne_limite);
        }          
    }
    
    /**
     * Méthode pour dire si une pièce est sur la position demandée
     * @param posX l'abscisse de la position demandée
     * @param posY l'ordonnée de la position demandée
     * @return null s'il n'y a pas de pièce et sinon renvoie la pièce
     */
    public Piece isPieceOnPos(int posX, int posY){
        Piece piece_presente = null;
        
        for(Piece piece : liste_de_cases){
            if(piece.getPosX()==posX && piece.getPosY()==posY){
                piece_presente = piece;
            }
        }
        
        return piece_presente;
    }

    public ArrayList<Piece> getListe_de_cases() {
        return liste_de_cases;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setListe_de_cases(ArrayList<Piece> liste_de_cases) {
        this.liste_de_cases = liste_de_cases;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }
    
    
    
}
