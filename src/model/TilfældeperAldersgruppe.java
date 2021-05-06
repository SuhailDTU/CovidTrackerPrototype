package model;

public class TilfældeperAldersgruppe {

    String aldersGruppe;
    int tilfælde;
    public TilfældeperAldersgruppe(String aldersGruppe, int tilfælde){
        this.aldersGruppe = aldersGruppe;
        this.tilfælde = tilfælde;

    }

    public String getAldersGruppe() {
        return aldersGruppe;
    }

    public int getTilfælde() {
        return tilfælde;
    }


}
