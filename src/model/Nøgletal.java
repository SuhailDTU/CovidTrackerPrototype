package model;

import java.util.Arrays;

public class Nøgletal {

    private int bekræftedeTilfælde;
    private int døde;
    private int overstået;
    private int indlæggelser;
    private int testedePersoner;
    private int antalletAfprøver;

    private int ændringer_BekræftedeTilfælde;
    private int ændringer_Døde;
    private int ændringer_Overstået;
    private int ændringer_indlæggelser;
    private int ændringer_testedePersoner;
    private int ændringer_antalletAfprøver;

    private int[] nøgletalsarray;
    private String[] headers = {"Bekræftede tilfælde", "Døde", "Overstået", "Indlæggelser", "Testede Personer", "AntalletAfprøver"};

    public Nøgletal(int[] nøgletalsarray) {

        this.bekræftedeTilfælde = nøgletalsarray[0];
        this.døde = nøgletalsarray[1];
        this.overstået = nøgletalsarray[2];
        this.indlæggelser = nøgletalsarray[3];
        this.testedePersoner = nøgletalsarray[4];

        this.ændringer_BekræftedeTilfælde = nøgletalsarray[5];
        this.ændringer_Døde = nøgletalsarray[6];
        this.ændringer_Overstået = nøgletalsarray[7];
        this.ændringer_indlæggelser = nøgletalsarray[8];
        this.ændringer_testedePersoner = nøgletalsarray[9];

        this.antalletAfprøver = nøgletalsarray[10];
        this.ændringer_antalletAfprøver = nøgletalsarray[11];

        this.nøgletalsarray = nøgletalsarray.clone();
    }

    public int getBekræftedeTilfælde() {
        return bekræftedeTilfælde;
    }

    public int getDøde() {
        return døde;
    }

    public int getOverstået() {
        return overstået;
    }

    public int getIndlæggelser() {
        return indlæggelser;
    }

    public int getTestedePersoner() {
        return testedePersoner;
    }

    public int getAntalletAfprøver() {
        return antalletAfprøver;
    }

    public int getÆndringer_BekræftedeTilfælde() {
        return ændringer_BekræftedeTilfælde;
    }

    public int getÆndringer_Døde() {
        return ændringer_Døde;
    }

    public int getÆndringer_Overstået() {
        return ændringer_Overstået;
    }

    public int getÆndringer_indlæggelser() {
        return ændringer_indlæggelser;
    }

    public int getÆndringer_testedePersoner() {
        return ændringer_testedePersoner;
    }

    public int getÆndringer_antalletAfprøver() {
        return ændringer_antalletAfprøver;
    }

    public int[] getNøgletalsarray() {
        return nøgletalsarray;
    }

    public String[] getHeaders() {
        return headers;
    }

}
