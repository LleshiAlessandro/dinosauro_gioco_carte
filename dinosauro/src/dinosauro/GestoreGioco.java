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
public class GestoreGioco {
    FileManager f= new FileManager();
    private Giocatore g1;
    private Giocatore g2;
    private Mazzo mazzo = f.readerFile();
    private Mazzo mazzoCentrale = new Mazzo(new ArrayList());
    
    
    public void giocaCarta(){
        g1.giocaCarta();
        g2.giocaCarta();
    }
    
    public void daiMazzo(){
        int x=0;
        Mazzo m1;
        Mazzo m2;
        ArrayList<String> c1 = new ArrayList();
        ArrayList<String> c2 = new ArrayList();

        for(Carta c: mazzo.carte){
            String ca = c.toString();
            if(x%2 == 0){
                c1.add(ca);
            }
            else{
                c2.add(ca);
            }
            x++;
        }
        m1=new Mazzo(c1);
        m2=new Mazzo(c2);
        g1 = new Giocatore(m1);
        g2 = new Giocatore(m2);
    }
    
    public String contaPunti(){
        if(g1.calcolaPunti() > g2.calcolaPunti()){
            return " il primo giocatore ha vinto";
        }
        else if(g1.calcolaPunti() < g2.calcolaPunti()){
            return " il secondo giocatore ha vinto";
        }
        else{
            return " il primo giocatore e il secondo giocatore hanno pareggiato";
        }
    }
    
    public void rimuoviCarta(Carta c){
        mazzo.removeCard(c);
    }
    public void aggiungiCarta(Carta c){
        mazzo.addCard(c);
    }
    
    public ArrayList<Carta> carteMazzoCentrale(){
        ArrayList<Carta> carte = new ArrayList();
        carte.clear();
        carte.addAll(mazzoCentrale.carte);
        return carte;
    }
    
    //mi dice quando i 2 giocatori giocano la loro mano chi vince
    public void manoVincente() {
        Carta c1 = g1.giocaCarta();
        Carta c2 = g2.giocaCarta();

        mazzoCentrale.addCard(c1);
        mazzoCentrale.addCard(c2);

        Giocatore vincitore = null;

        if (c1.getColore() == Colore.Rosso && (c2.getColore() == Colore.Giallo || c2.getColore() == Colore.Verde))
            vincitore = g1;
        else if (c1.getColore() == Colore.Giallo && c2.getColore() == Colore.Verde)
            vincitore = g1;
        else if (c1.getColore() == Colore.Giallo && c2.getColore() == Colore.Rosso)
            vincitore = g2;
        else if (c1.getColore() == Colore.Verde && (c2.getColore() == Colore.Rosso || c2.getColore() == Colore.Giallo))
            vincitore = g2;

        if (vincitore != null) {
            for (Carta c : mazzoCentrale.carte) {
                vincitore.punteggio.addCard(c);
            }
            mazzoCentrale.carte.clear();
        }
    }

        @Override
        public String toString() {
            return "Mazzo centrale: " + mazzoCentrale + "\n" +
                   "\nGiocatore 1:" +
                   "\nMazzo dei punti: " + g1.punteggio +
                   "\nCarte in mano: " + g1.mano +
                   "\n\nGiocatore 2:" +
                   "\nMazzo dei punti: " + g2.punteggio +
                   "\nCarte in mano: " + g2.mano +
                   "\n\nIl punteggio del giocatore 1 e': " + g1.punteggio.calcolaPunti() +
                   "\nIl punteggio del giocatore 2 e': " + g2.punteggio.calcolaPunti() +
                   "\nIl vincitore della partita e': " + this.contaPunti();
        }
        
    public void start(){
    this.daiMazzo();
    //gioca tutte le carte
        while(!g1.mano.carte.isEmpty() && !g2.mano.carte.isEmpty()){
            
            this.manoVincente();
        }
    }
}
