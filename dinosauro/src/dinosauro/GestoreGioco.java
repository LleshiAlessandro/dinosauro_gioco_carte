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
    private Giocatore g1;
    private Giocatore g2;
    private Mazzo mazzo;
    
    
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
                c2.add(ca);
            }
            else{
                c1.add(ca);
            }
            x++;
        }
        g1 = new Giocatore(m1=new Mazzo(c1));
        g2 = new Giocatore(m2=new Mazzo(c2));
    }
    
    public void contaPunti(){
        if(g1.calcolaPunti() > g2.calcolaPunti()){
            System.out.println(" il primo giocatore ha vinto");
        }
        else if(g1.calcolaPunti() < g2.calcolaPunti()){
            System.out.println(" il secondo giocatore ha vinto");
        }
        else{
            System.out.println(" il primo giocatore e il secondo giocatore hanno pareggiato");
        }
    }
    
    public void rimuoviCarta(Carta c){
        mazzo.removeCard(c);
    }
    public void aggiungiCarta(Carta c){
        mazzo.addCard(c);
    }
    
    //mi dice quando i 2 giocatori giocano la loro mano chi vince
    public void manoVincente(){
        // serve fare un controllo del colore delle carte per capire (grazie all enum) quale prevale sull'altra
    }
    
    public void out(){
        System.out.println(" giocatore 1 " + g1 + " giocatore 2 " + g2 + " il mazzo: " + mazzo);
    }
        
}
