/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauro;

import java.util.ArrayList;

/**
 *
 * @author lleshi.alessandro
 */
public class Mazzo {
    ArrayList<Carta> carte = new ArrayList();

    public Mazzo(ArrayList<String> e) {
        for(String a : e){
            Carta c = new Carta(a);
            carte.add(c);
        }
    }
    
    //calcola punti
    public int calcolaPunti(){
        int punt = 0;
        for(Carta c :carte){
            punt += c.getPunteggio();
        }
        return punt;
    }
    
    public void addCard(Carta c){
        carte.add(c);
    }
    public void removeCard(Carta c){
        carte.remove(c);
    }
    
    public Carta pescaPrimaCarta(){
        return carte.remove(0);
    }
 
    //serve un get carta
}
