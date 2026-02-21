/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauro;

/**
 *
 * @author lleshi.alessandro
 */
public class Carta {
    private int punteggio;
    private Colore colore;

    public Carta(String c) {
        if(c.equals("Rosso")){
            punteggio = 5;
            colore = Colore.Rosso;
        }
        else if (c.equals("Verde")){
            punteggio = 3;
            colore = Colore.Verde;
        }
        else if (c.equals("Giallo")){
            punteggio = 1;
            colore = Colore.Giallo;
        }
        else{
            System.out.println(" impossibile se non ritorna un valore piango ");
        }
    }

    public int getPunteggio() {
        return punteggio;
    }

    public Colore getColore() {
        return colore;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
    
    
    @Override
    public String toString() {
        return colore.toString();
    }
}
