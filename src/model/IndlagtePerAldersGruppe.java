package model;

public class IndlagtePerAldersGruppe {
    String aldersGruppe;
    int indlagte;
    public IndlagtePerAldersGruppe(String aldersGruppe, int indlagte){
        this.aldersGruppe = aldersGruppe;
        this.indlagte = indlagte;

    }

    public String getAldersGruppe() {
        return aldersGruppe;
    }

    public int getIndlagte() {
        return indlagte;
    }
}
