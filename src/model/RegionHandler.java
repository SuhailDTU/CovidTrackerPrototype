package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class RegionHandler {

    public RegionHandler(){

    }

    public void readInDataSet_IndlagtePerAldersgruppe(Region region, String filename){
        String line;
        String[] tokens;
        String regionname = region.navn.replaceAll("æ", ".");//replace æ with wildcard

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            while ((line = bufferedReader.readLine()) != null){
                tokens = line.split(";");
                if(tokens[0].matches(regionname) ){
                    region.indlagtePerAldersGruppe.add(new IndlagtePerAldersGruppe(tokens[1], Integer.parseInt(tokens[2])));
                }

            }

        }catch ( IOException exception){
            exception.printStackTrace();
        }


    }

    public void readInDataSet_IndlagtPerDag(Region region, String filename){
        String line;
        String[] tokens;
        ArrayList<IndlagtPerDag> indlagtPerDag = new ArrayList<IndlagtPerDag>();
        String regionname = region.navn.replaceAll("æ", ".");//replace æ with wildcard

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            while ((line = bufferedReader.readLine()) != null){
                tokens = line.split(";");
                if(tokens[1].matches(regionname) ){
                    region.indlagtPerDag.add(new IndlagtPerDag(tokens[0], Integer.parseInt(tokens[2])));
                }

            }

        }catch ( IOException exception){
            exception.printStackTrace();
        }



    }
    public void readInDataset_Nøgletal(Region region, String filename){
        String line1;
        String[] tokens1;
        String line2;
        String[] tokens2;
        String regionname = region.navn.replaceAll("æ", ".");//replace æ with wildcard
        int[] constructorArray1 = new int[12];
        //int[] constructorArray2 = new int[12];//use a second array if you want to divide male and female

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            line1 = bufferedReader.readLine();//read past header

            while ((line1 = bufferedReader.readLine()) != null){
                tokens1 = line1.split(";");
                if (tokens1[1].matches(regionname)){
                    line2 = bufferedReader.readLine();
                    tokens2 = line2.split(";");
                    //fill array to contruct object
                    for (int i = 3; i < 15; i++){
                        constructorArray1[i-3] = Integer.parseInt(tokens1[i])+Integer.parseInt(tokens2[i]);
                    }
                    //add object to list in region
                    region.setNøgletal(new Nøgletal(constructorArray1));

                }



            }



        }catch (IOException exception){
            exception.printStackTrace();
        }


    }
}
