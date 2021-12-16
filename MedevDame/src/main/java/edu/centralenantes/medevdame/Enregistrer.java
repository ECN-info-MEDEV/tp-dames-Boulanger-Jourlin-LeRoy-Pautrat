/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.medevdame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lénaëlle
 */
public class Enregistrer {
        /**
     * Le nom du fichier de sauvegarde
     */
    private String nomFichier;
    
    /**
     * Le BufferedWriter nécessaire pour l'écriture du fichier
     */
    private BufferedWriter writer;

    public Enregistrer(String nomFichier) {
        this.nomFichier = nomFichier;
        
        try{
            writer = new BufferedWriter(new FileWriter(nomFichier));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     /**
     * Fonction qui permet de demander le nom d'un fichier de sauvegarde déjà existant ou de choisir un nouveau nom
     */
    public void demandeNom(){
        System.out.println("Voulez-vous choisir un nom pour le fichier de sauvegarde ? (oui/non)");
        Scanner scanner = new Scanner( System.in );
        String choix = scanner.nextLine();
        switch(choix){
            case "oui":
                System.out.println("Entrez alors ce nom sans extension de fichier");
                String nom = "";
                // On utilise cette boucle while pour éviter que le nextLine() ne passe à la trappe parce qu'on a appuyé sur entrée pour la question précédente et 
                // que l'ordinateur considère qu'on appuye toujours sur entrée pour cette question
                while (nom == ""){
                    nom = scanner.nextLine();
                }
                this.nomFichier = nom + ".txt";
                break;
            case "non":
                File dossier = new File(System.getProperty("user.dir"));
                File[] liste_de_fichiers = dossier.listFiles();
                this.nomFichier = System.getProperty("user.dir") + "\\save" + liste_de_fichiers.length + ".txt";
                break;
            default:
                System.out.println("Veuillez entrer une réponse valide");
                break;
        }
        try{
        writer = new BufferedWriter(new FileWriter(nomFichier));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void enregistrePlateau(Plateau plateau){
        //on demande le nom du fichier pour enregistrer le plateau 
        
        demandeNom();
        
        try {
            //On écrit les caractéristiques et la position de chaque pièce 
            
            for(Piece piece : plateau.liste_de_cases){
                String ligne = "";
                if(piece instanceof Dame){
                    ligne += "Dame,";
                }
                else{
                    ligne += "Pion,";
                }
                if(piece.isCouleur()){
                    ligne += "Blanc,";
                }
                else{
                    ligne += "Noir,";
                }
                ligne += piece.getPosX()+",";
                ligne += piece.getPosY();
                writer.write(ligne);
                writer.newLine();
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Enregistrer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(writer != null){
                    writer.flush();
                    writer.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
       
    
    }
    
}
