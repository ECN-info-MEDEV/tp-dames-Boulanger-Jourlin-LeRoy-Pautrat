/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe qui s'occupe de charger un fichier de sauvegarde et de générer un plateau correspondant 
 * @author lénaëlle
 */
public class Charger {
     /**
     * Nom du fichier où la sauvegarde se trouve
     */
    private String nomFichier;
    
    /**
     * Le BufferedReader pour lire le fichier de sauvegarde
     */
    private BufferedReader lecteur;

    /**
     *
     * @param nomFichier
     */
    public Charger(String nomFichier) {
        this.nomFichier = nomFichier;
        
        try{
            lecteur = new BufferedReader(new FileReader(nomFichier));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Cette fonction renvoie une instance de la classe Plateau avec les éléments rentrés dans le fichier de sauvegarde
     * @return le plateau généré
     */
    public Plateau chargePartie(){
        Plateau plateau = new Plateau();
        
        ArrayList<String> liste_lignes = chargeListeLignes();
        ArrayList<Piece> liste_pieces = null;
        for(int i = 0; i < liste_lignes.size(); i++){
            //On crée une liste de tous les mots contenus dans chaque ligne
            ArrayList<String> liste_mots = chargeListeMot(liste_lignes.get(i));
            //On ajoute la pièce crée avec ces mots à la liste des pièces
            liste_pieces.add(creePiece(liste_mots));
        }
        plateau.liste_de_cases= liste_pieces;
        return plateau;
        
    }
    
 /**
     * Cette fonction renvoie une instance de la classe pièce avec les éléments rentrés dans une liste de chaînes de caractères
     * @return la pièce générée
     */
    private Piece creePiece(ArrayList<String> liste_mots){
        Piece piece;
        int posx = Integer.parseInt(liste_mots.get(2));
        int posy = Integer.parseInt(liste_mots.get(3));

        switch(liste_mots.get(0)){
            case "Dame":
                switch(liste_mots.get(1)){
                    case "Blanc":

                        piece = new Dame(true,posx,posy);
                        break;
                    case "Noir":
                        piece = new Dame(false,posx,posy);
                        break;
                }
            case "Pion":
                switch(liste_mots.get(1)){
                    case "Blanc":
                        piece = new Pion(true,posx,posy);
                        break;
                    case "Noir":
                        piece = new Pion(false,posx,posy);
                        break;
                }
            default:
                // On fait un choix arbitraire, normalement ce cas n'arrive pas
                System.out.println("On a un problème de type, par défaut on a un pion blanc");
                piece = new Pion(true);

        }   
        return piece;
    
    }
    
    
     /**
     * Fonction qui retourne une liste de string correspondant à la liste des lignes d'un fichier donné
     * @return La liste de lignes du fichier
     */
    private ArrayList<String> chargeListeLignes(){
        ArrayList<String> liste_de_lignes = new ArrayList<>();
        
        try{
        String ligne;
        ligne = lecteur.readLine();

        while(ligne != null){
            liste_de_lignes.add(ligne);
            ligne = lecteur.readLine();
        }
        
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return liste_de_lignes;
    }
     
    /**
     * Fonction qui retourne une liste de string correspondant à la liste des mots dans une ligne donnée
     * @return la liste des mots de la ligne 
     */
    private ArrayList<String> chargeListeMot(String ligne){
        ArrayList<String> liste_de_mots = new ArrayList<>();
        
        String delimiteurs = " .,;";
        
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
        
        while(tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            liste_de_mots.add(mot);
        }
        return liste_de_mots;
    }
    
}





