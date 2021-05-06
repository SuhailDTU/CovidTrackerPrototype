package model;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KommuneHandler {

    public KommuneHandler(){

    }

    public void readinInTilfældePeraldersgruppe(Kommune kommune, String file){
        String line;
        String[] tokens;
        ArrayList<TilfældeperAldersgruppe> tilfældeperAldersgruppeArrayList = new ArrayList<TilfældeperAldersgruppe>();


        try(BufferedReader bufferedReader = new BufferedReader( new FileReader(file))) {
            while((line = bufferedReader.readLine())!= null){
                tokens = line.split(";");
                if(kommune.Kommunekode.equals(tokens[0])){
                    tilfældeperAldersgruppeArrayList.add(new TilfældeperAldersgruppe(tokens[1], Integer.parseInt(tokens[2])));
                }

            }
            kommune.setTilfældeperAldersgruppe(tilfældeperAldersgruppeArrayList);
        }catch (IOException e){
            e.printStackTrace();
        }




    }
}
