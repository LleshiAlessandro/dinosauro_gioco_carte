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

    private ArrayList<Carta> carte = new ArrayList();

    
    
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
        g1 = new Giocatore(m1=new Mazzo(c1));
        g2 = new Giocatore(m2=new Mazzo(c2));
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
    
    // mi serve per convertire il mazzo centrale da mazzo ad array list di carta
    public ArrayList<Carta> carteMazzoCentrale(){
        for(Carta c: mazzoCentrale.carte){
            carte.add(c);
        }
        return carte;
    }
    
    //mi dice quando i 2 giocatori giocano la loro mano chi vince
    public void manoVincente(){
        //devo fare in modo di mettere tutte le carte giocate nel mazzo centrale e poi controllare se qualcuno ha vinto, in caso si aggiungo le carte al vincente
        Carta c1 = g1.mano.pescaPrimaCarta();
        Carta c2 = g2.mano.pescaPrimaCarta();
        mazzoCentrale.addCard(c1);
        mazzoCentrale.addCard(c2);
        
       if(c1.getColore().equals("Rosso") && c2.getColore().equals("Giallo")){
           //un idea possibile sarebbe fare un metodo che mi controlla il colore della carta e che poi mi returna un giocatore, così facendo poi su questo metodo aggiungo al giocatore (che mi returna il metodo) tutte le carte del mazzo centrale
           for(Carta c : this.carteMazzoCentrale()){
               g1.punteggio.addCard(c);
           }
       }
       else if(c1.getColore().equals("Giallo") && c2.getColore().equals("Rosso")){
           // non è giusto perché aggiungo solo le carte della mano e non quelle del mazzo centrale
           for(Carta c : this.carteMazzoCentrale()){
               g2.punteggio.addCard(c);
           }
       }
       else if (c1.getColore().equals("Giallo") && c2.getColore().equals("Verde")){
           // non è giusto perché aggiungo solo le carte della mano e non quelle del mazzo centrale
           for(Carta c : this.carteMazzoCentrale()){
               g1.punteggio.addCard(c);
           }
       }
       else if(c1.getColore().equals("Verde") && c2.getColore().equals("Giallo")){
           // non è giusto perché aggiungo solo le carte della mano e non quelle del mazzo centrale
           for(Carta c : this.carteMazzoCentrale()){
               g2.punteggio.addCard(c);
           }
       }
       else{
            if(c1.getColore() == c2.getColore()){
                mazzoCentrale.addCard(c1);
                mazzoCentrale.addCard(c2);
            }
       }
            
        
    }
    
    

    
    public void out(){
        System.out.println(" giocatore 1 " + g1 + " giocatore 2 " + g2 + " il mazzo: " + mazzo);
    }
        @Override
        public String toString(){
            return "giocatore 1: " + g1 + "\n" +
                   "giocatore 2: " + g2 + "\n" +
                   "il punteggio del giocatore 1 e': " + g1.punteggio.calcolaPunti()+ "\n" +
                   "il punteggio del giocatore 2 e': " + g1.punteggio.calcolaPunti() + "\n" +
                    "il vioncitore della partita e': " + this.contaPunti();
        }
    public void start(){
        mazzo = f.readerFile();
        this.daiMazzo();
        g1.giocaCarta();
        g2.giocaCarta();
        this.carteMazzoCentrale();
        this.manoVincente();
        g1.punteggio.calcolaPunti();
        g2.punteggio.calcolaPunti();
        this.contaPunti();
    }
}
