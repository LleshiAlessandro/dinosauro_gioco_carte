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
public class Giocatore {
    protected Mazzo mano;
    protected Mazzo punteggio = new Mazzo(new ArrayList());

    
    
    public Giocatore(Mazzo m1) {
        mano = m1;
    }
    
    public void pescaCarta(Carta c){
        mano.addCard(c);        
    }
    /**
     * richiama il metodo calcolaPunti sul mazzo punteggio, quidi calcola il punteggio delle carte vinte dal giocatore
     */
    public int calcolaPunti(){
        return punteggio.calcolaPunti();
    }
    /**
     * richiama il metodo pescaPrimaCarta sul mazzo dov'è contenuta la mano
     * @return returna la prima carta di mano
     */
    public Carta giocaCarta(){
        return mano.pescaPrimaCarta();
    }
    @Override
    public String toString(){
        return "la mano del giocatore e': " + mano + " il punteggio del giocatore e': " + punteggio;
    }
}