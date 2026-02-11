/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauro;

/**
 *
 * @author lleshi.alessandro
 */
public class Giocatore {
    private Mazzo mano;
    private Mazzo punteggio;

    
    //m1 e m2 sono i 2 mazzi che passo quando costuisco il giocatore ovvero il numero di carte che ha in mano
    //e il punteggio che all'inizio saranno 0 
    public Giocatore(Mazzo m1, Mazzo m2) {
        mano = m1;
        punteggio = m2;
    }
    
    public void pescaCarta(Carta c){
        mano.addCard(c);        
    }
    
    public int calcolaPunti(){
        return punteggio.calcolaPunti();
    }
    
    public Carta giocaCarta(){
        return mano.pescaPrimaCarta();
    }
}