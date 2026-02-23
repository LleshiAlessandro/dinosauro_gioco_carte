/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauro;
import java.util.*;
import java.io.*;
/**
 *
 * @author lleshi.alessandro
 */
public class FileManager {
    private String file = "mazzo.txt";
    
    /**
     * legge l contenuto del file e dentro al while inserisce ogni riga del file dento al mio ArrayList di string, che poi successivamente mi servirà per la creazione del mazzo
     * @return mi returna il mazzo riempito con i valori del mio file mazzo.txt
     */
    public Mazzo readerFile(){
        ArrayList<String> cartine = new ArrayList();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                cartine.add(line);
            }
        }
        catch(IOException e){
            
        }
        Mazzo m = new Mazzo(cartine);
        return m;
    }
}
