package model;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Kommune extends Region {
    String Kommunekode;
    ArrayList<TilfældeperAldersgruppe> tilfældeperAldersgruppe = new ArrayList<TilfældeperAldersgruppe>();

    public Kommune(String navn){
        super(navn);
        findKommunekode();
    }

    private void findKommunekode(){
        String line;
        String[] tokens;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/data/kommunekoder.csv"))) {

            while((line = bufferedReader.readLine()) != null){
                tokens = line.split(":");
                if(this.navn.equals(tokens[1])){
                    Kommunekode = tokens[0];
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void setTilfældeperAldersgruppe(ArrayList<TilfældeperAldersgruppe> tilfældeperAldersgruppe) {
        this.tilfældeperAldersgruppe = tilfældeperAldersgruppe;
    }
    public void printTilfældePerAldersGruppe(){
        System.out.println("##### "+this.getName()+"  TilfældePerAldersGruppe"+" #####");
        for (int i = 0; i < tilfældeperAldersgruppe.size(); i++){
            System.out.print(tilfældeperAldersgruppe.get(i).aldersGruppe);
            System.out.println(" : " + tilfældeperAldersgruppe.get(i).tilfælde);
        }

    }

    public ArrayList<TilfældeperAldersgruppe> getTilfældeperAldersgruppe() {
        return tilfældeperAldersgruppe;
    }
}
