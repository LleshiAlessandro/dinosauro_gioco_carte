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
    protected ArrayList<Carta> carte = new ArrayList();
    private int punt = 0;

    public Mazzo(ArrayList<String> e) {
        for(String a : e){
            Carta c = new Carta(a);
            carte.add(c);
        }
    }
    
    //calcola punti
    public int calcolaPunti(){
        punt = 0;
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
        if(carte.isEmpty()) return null;
        Carta c = carte.get(0);
        carte.remove(c);
        return c;
    }
    @Override
    public String toString(){
        String s = "";
    for(Carta a: carte){
        s += a + " ";
    }
    return s;
    }
}
