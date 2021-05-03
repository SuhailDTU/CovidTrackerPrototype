package model;

public class CovidChecker {
    public static void main(String[] args) {

        //Regioner
        Region hovedstaden = new Region("Hovedstaden");
        Region midtjylland = new Region("Midtjylland");
        Region nordjylland = new Region("Nordjylland");
        Region sjælland = new Region("Sjælland");
        Region syddanmark = new Region("Syddanmark");

        RegionHandler regionHandler = new RegionHandler();

        //files
        String indlagtePerAldersGruppeFilename = "C:\\Users\\suhai\\Desktop\\Object oriented programming\\Regionalt_DB\\04_indlagte_pr_alders_grp_pr_region.csv";
        String indlagtePerDagFilename = "C:\\Users\\suhai\\Desktop\\Object oriented programming\\Regionalt_DB\\15_indlagte_pr_region_pr_dag.csv";
        String noegletalfilename = "C:\\Users\\suhai\\Desktop\\Object oriented programming\\Regionalt_DB\\01_noegle_tal.csv";


        //read in indlagte per aldersgruppe
        regionHandler.readInDataSet_IndlagtePerAldersgruppe(hovedstaden,indlagtePerAldersGruppeFilename );
        regionHandler.readInDataSet_IndlagtePerAldersgruppe(midtjylland,indlagtePerAldersGruppeFilename);
        regionHandler.readInDataSet_IndlagtePerAldersgruppe(nordjylland,indlagtePerAldersGruppeFilename );
        regionHandler.readInDataSet_IndlagtePerAldersgruppe(sjælland,indlagtePerAldersGruppeFilename);
        regionHandler.readInDataSet_IndlagtePerAldersgruppe(syddanmark,indlagtePerAldersGruppeFilename );

        //read in indlagte per dag
        regionHandler.readInDataSet_IndlagtPerDag(hovedstaden,indlagtePerDagFilename);
        regionHandler.readInDataSet_IndlagtPerDag(midtjylland,indlagtePerDagFilename);
        regionHandler.readInDataSet_IndlagtPerDag(nordjylland,indlagtePerDagFilename);
        regionHandler.readInDataSet_IndlagtPerDag(sjælland,indlagtePerDagFilename);
        regionHandler.readInDataSet_IndlagtPerDag(syddanmark,indlagtePerDagFilename);

        //read in nøgletal
        regionHandler.readInDataset_Nøgletal(sjælland, noegletalfilename);


        //print data
        //hovedstaden.printIndlagtePerAldersGruppe();
        //midtjylland.printIndlagtePerAldersGruppe();

        //hovedstaden.printIndlagtePerDag();
        //hovedstaden.printIndlagtePerAldersGruppe();
        //sjælland.printIndlagtePerAldersGruppe();
        //nordjylland.printIndlagtePerAldersGruppe();
        sjælland.printNøgleTal();

    }
}
