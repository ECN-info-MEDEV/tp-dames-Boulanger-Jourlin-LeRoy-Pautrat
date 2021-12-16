/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
        
        return plateau;
        
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
    
    
    
}





