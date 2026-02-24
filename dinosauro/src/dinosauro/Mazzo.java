/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauro;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lleshi.alessandro
 */

public class Mazzo {

    protected ArrayList<Carta> carte = new ArrayList();
    private int punt = 0;
    
    /** 
     * @param e gli passo un array di string perché nel file manager io uso un array di string per la sua costruzione
     */
    public Mazzo(ArrayList<String> e) {
        for(String a : e){
            Carta c = new Carta(a);
            carte.add(c);
        }
    }
    
    /**
     * prende il punteggio di ogni carta e lo somma a punt
     * @return i punti
     */
    public int calcolaPunti(){
        punt = 0;
        for(Carta c :carte){
            punt += c.getPunteggio();
        }
        return punt;
    }
    /**
     * 
     * @param c è la carta che aggiungo all ArrayList di carte
     */
    public void addCard(Carta c){
        carte.add(c);
    }
    /**
     * 
     * @param c è la carta che rimovo all ArrayList di carte
     */
    public void removeCard(Carta c){
        carte.remove(c);
    }
    /**
     * presca prima carta mi controlla che l'ArrayList di carte non sia vuoto, e in caso non lo è pesca la prima carta e la returna
     * @return mi returna la prima carta
     */
    public Carta pescaPrimaCarta(){
        if(carte.isEmpty()) return null;
        Carta c = carte.get(0);
        carte.remove(c);
        return c;
    }
    public void mischia(){
        Collections.shuffle(carte);
    }
    @Override
    public String toString(){
        String s = "";
    for(Carta a: carte){
        s += a + "-";
    }
    return s;
    }
}
