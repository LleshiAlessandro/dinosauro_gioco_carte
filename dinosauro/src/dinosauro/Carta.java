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
        colore = Colore.valueOf(c);
        if(colore.equals("Rosso")){
            punteggio = 5;
        }
        else if (colore.equals("Verde")){
            punteggio = 3;
        }
        else if (colore.equals("Giallo")){
            punteggio = 1;
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
