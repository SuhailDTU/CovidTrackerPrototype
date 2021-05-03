package model;

import java.util.ArrayList;

public class Region {
    String navn;
    ArrayList<IndlagtePerAldersGruppe> indlagtePerAldersGruppe = new ArrayList<IndlagtePerAldersGruppe>();
    ArrayList<IndlagtPerDag> indlagtPerDag = new ArrayList<IndlagtPerDag>();
    Nøgletal nøgletal;

    public Region(String navn){
        this.navn = navn;
    }

    public void printIndlagtePerAldersGruppe(){
        System.out.println("##### "+navn+"  IndlagtePerAldersGruppe"+" #####");
        for (int i = 0; i < indlagtePerAldersGruppe.size(); i++){
            System.out.print(indlagtePerAldersGruppe.get(i).aldersGruppe);
            System.out.println(" : " + indlagtePerAldersGruppe.get(i).indlagte);
        }

    }

    public void printIndlagtePerDag(){
        System.out.println("##### "+navn+"  IndlagtePerDag"+" #####");
        for (int i = 0; i < indlagtPerDag.size(); i++){
            System.out.print(indlagtPerDag.get(i).dato);
            System.out.println(" : " + indlagtPerDag.get(i).indlagte);
        }

    }




    public void printNøgleTal(){
        System.out.println("##### "+navn+"noegletal#######");

        System.out.println(nøgletal.getBekræftedeTilfælde());
        System.out.println(nøgletal.getDøde());
        System.out.println(nøgletal.getOverstået());
        System.out.println(nøgletal.getIndlæggelser());
        System.out.println(nøgletal.getTestedePersoner());


        System.out.println(nøgletal.getÆndringer_BekræftedeTilfælde());
        System.out.println(nøgletal.getÆndringer_Døde());
        System.out.println(nøgletal.getÆndringer_Overstået());
        System.out.println(nøgletal.getÆndringer_indlæggelser());
        System.out.println(nøgletal.getÆndringer_testedePersoner());

        System.out.println(nøgletal.getAntalletAfprøver());
        System.out.println(nøgletal.getÆndringer_antalletAfprøver());



    }

    public void setNøgletal(Nøgletal nøgletal) {
        this.nøgletal = nøgletal;
    }

    public ArrayList<IndlagtePerAldersGruppe> getIndlagtePerAldersGruppe() {
        return indlagtePerAldersGruppe;
    }


    public String getName() {
        return navn;
    }

    public Nøgletal getNøgletal() {
        return nøgletal;
    }
}
