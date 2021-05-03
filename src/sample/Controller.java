package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Callback;
import model.IndlagtePerAldersGruppe;
import model.Nøgletal;
import model.Region;
import model.RegionHandler;

import java.util.ArrayList;
import java.util.EventListener;

public class Controller {
//files
String indlagtePerAldersGruppeFilename = "C:\\Users\\suhai\\Desktop\\Object oriented programming\\Regionalt_DB\\04_indlagte_pr_alders_grp_pr_region.csv";
String indlagtePerDagFilename = "C:\\Users\\suhai\\Desktop\\Object oriented programming\\Regionalt_DB\\15_indlagte_pr_region_pr_dag.csv";
String noegletalfilename = "C:\\Users\\suhai\\Desktop\\Object oriented programming\\Regionalt_DB\\01_noegle_tal.csv";
@FXML
private BorderPane borderPane;
@FXML
private BorderPane innerborderpane;
@FXML
private ListView<Region> listView;

@FXML
private GridPane gridpane;

@FXML
private GridPane datapane;

@FXML
private Button b1;

@FXML
private Button b2;


private RegionHandler regionHandler = new RegionHandler();


private ObservableList<Region> regionObservableList;

Region hovedstaden;
Region midtjylland;
Region nordjylland;
Region sjælland;
Region syddanmark;

private int show = 2;//start med nøgletal

public Controller(){
    //Regioner
    hovedstaden = new Region("Hovedstaden");
    midtjylland = new Region("Midtjylland");
    nordjylland = new Region("Nordjylland");
    sjælland = new Region("Sjælland");
    syddanmark = new Region("Syddanmark");

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

    //read in nogletal per dag
    regionHandler.readInDataset_Nøgletal(hovedstaden,noegletalfilename);
    regionHandler.readInDataset_Nøgletal(midtjylland,noegletalfilename);
    regionHandler.readInDataset_Nøgletal(nordjylland,noegletalfilename);
    regionHandler.readInDataset_Nøgletal(sjælland,noegletalfilename);
    regionHandler.readInDataset_Nøgletal(syddanmark,noegletalfilename);


    regionObservableList = FXCollections.observableArrayList(hovedstaden, midtjylland, nordjylland, sjælland, syddanmark );
}


public void initialize(){
    int[] values = new int[] {1, 2, 3};
    String[] keys = new String[] {"one", "two", "three"};

    setGridPaneData(values, keys);

    setListView();
    listView.getSelectionModel().select(0);//select first item
    //showdata(hovedstaden);//show initial data, not needed if initial is already selected



}



public void setGridPaneData(int[] values, String[] Keys){

    for (int i= 0; i < values.length; i++){
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100/values.length);
        columnConstraints.setHalignment(HPos.CENTER);
        gridpane.getColumnConstraints().add(columnConstraints);
        gridpane.add(new Label(Keys[i]), i, 0);
        gridpane.add(new Label(Integer.toString(values[i])), i, 1);
    }


}

public void setDataset1(Region region){


    ArrayList<IndlagtePerAldersGruppe> aldersGruppeliste = region.getIndlagtePerAldersGruppe();
    if (aldersGruppeliste.size() != 0) {
        //setting up a new gridpane
        GridPane gridPane = new GridPane();
        innerborderpane.setCenter(gridPane);
        gridPane.setGridLinesVisible(true);

        //row constraint setup
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100 / aldersGruppeliste.size() + 1);
        rowConstraints.setValignment(VPos.CENTER);
        //column contraint setup
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        columnConstraints.setHalignment(HPos.CENTER);

        //Add header
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.add(new Label("Age range:"), 0, 0);
        gridPane.add(new Label("Hospitalizations:"), 1, 0);

        //adds columns
        for (int i = 0; i < 2; i++) {
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        //adds rows and data to those rows
        for (int i = 0; i < aldersGruppeliste.size(); i++) {
            //making rows
            gridPane.getRowConstraints().add(rowConstraints);


            //put label in anchorpane
            AnchorPane anchorPane1 = new AnchorPane();
            Label labelAldersgruppe = new Label(aldersGruppeliste.get(i).getAldersGruppe());
            labelAldersgruppe.setAlignment(Pos.CENTER);
            labelAldersgruppe.setStyle("-fx-background-color: white;");
            anchorPane1.getChildren().add(labelAldersgruppe);

            //use anchorpane to fill container
            AnchorPane.setBottomAnchor(labelAldersgruppe, 1.0);
            AnchorPane.setLeftAnchor(labelAldersgruppe, 1.0);
            AnchorPane.setRightAnchor(labelAldersgruppe, 1.0);
            AnchorPane.setTopAnchor(labelAldersgruppe, 1.0);


            //put label in anchorpane
            AnchorPane anchorPane2 = new AnchorPane();
            Label labelIndlagte = new Label(Integer.toString(aldersGruppeliste.get(i).getIndlagte()));
            labelIndlagte.setAlignment(Pos.CENTER);
            anchorPane2.getChildren().add(labelIndlagte);
            labelIndlagte.setStyle("-fx-background-color: white;");

            //use anchorpane to fill container
            AnchorPane.setBottomAnchor(labelIndlagte, 1.0);
            AnchorPane.setLeftAnchor(labelIndlagte, 1.0);
            AnchorPane.setRightAnchor(labelIndlagte, 1.0);
            AnchorPane.setTopAnchor(labelIndlagte, 1.0);

            //adding anchorpane nodes to gridpane
            gridPane.add(anchorPane2, 1, i + 1);
            gridPane.add(anchorPane1, 0, i + 1);

        }

    }else{
        GridPane gridPane = new GridPane();
        innerborderpane.setCenter(gridPane);
        //row constrainst setup
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100);
        rowConstraints.setValignment(VPos.CENTER);

        //column constraint setup
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100);
        columnConstraints.setHalignment(HPos.CENTER);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.add(new Label("No data"), 0, 0);



    }


}
public void setDataset2(Region region) {
    Nøgletal nøgletal = region.getNøgletal();


    if (nøgletal != null) {
        String[] nøgletalheaders = nøgletal.getHeaders();
        int [] nøgletarray = nøgletal.getNøgletalsarray();

        //setting up a new gridpane
        GridPane gridPane = new GridPane();
        innerborderpane.setCenter(gridPane);
        gridPane.setGridLinesVisible(true);

        //row constraint setup
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100 / nøgletalheaders.length);
        rowConstraints.setValignment(VPos.CENTER);
        //column contraint setup
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        columnConstraints.setHalignment(HPos.CENTER);

        //make columns
        for(int i = 0; i < 2; i++){
            gridPane.getColumnConstraints().add(columnConstraints);
        }
        //make rows
        for(int i = 0; i < 6; i++){
            gridPane.getRowConstraints().add(rowConstraints);

            AnchorPane anchorPane1 = new AnchorPane();
            AnchorPane anchorPane2 = new AnchorPane();
            Label label1 = new Label(nøgletalheaders[i]);
            Label label2 = new Label(Integer.toString(nøgletarray[i]));

            label1.setAlignment(Pos.CENTER);
            label1.setStyle("-fx-background-color: white;");
            label2.setAlignment(Pos.CENTER);
            label2.setStyle("-fx-background-color: white;");


            anchorPane1.getChildren().add(label1);
            anchorPane2.getChildren().add(label2);

            AnchorPane.setBottomAnchor(label1, 1.0);
            AnchorPane.setLeftAnchor(label1, 1.0);
            AnchorPane.setRightAnchor(label1, 1.0);
            AnchorPane.setTopAnchor(label1, 1.0);

            AnchorPane.setBottomAnchor(label2, 1.0);
            AnchorPane.setLeftAnchor(label2, 1.0);
            AnchorPane.setRightAnchor(label2, 1.0);
            AnchorPane.setTopAnchor(label2, 1.0);


            gridPane.add(anchorPane1, 0, i);
            gridPane.add(anchorPane2, 1, i);


        }




    } else {
        GridPane gridPane = new GridPane();
        innerborderpane.setCenter(gridPane);
        //row constrainst setup
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100);
        rowConstraints.setValignment(VPos.CENTER);

        //column constraint setup
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100);
        columnConstraints.setHalignment(HPos.CENTER);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.add(new Label("No data"), 0, 0);


    }
}
public void setListView(){
    listView.setItems(regionObservableList);

    listView.setCellFactory(new Callback<ListView<Region>, ListCell<Region>>() {
        @Override
        public ListCell<Region> call(ListView<Region> regionListView) {
            ListCell<Region> regionListCell = new ListCell<Region>() {
                @Override
                public void updateItem(Region region, boolean empty){
                    if (region != null){
                        super.updateItem(region, empty);
                            setText(region.getName());
                    }
                }
            };

            return regionListCell;

        }


    });


    listView.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Region>() {
        @Override
        public void changed(ObservableValue<? extends Region> observableValue, Region oldregion, Region newRegion) {
            if (newRegion != null) {
                showdata(newRegion);
            }
        }
    });
}

public void showdata(Region region){
    if (show == 1){
        setDataset1(region);
    }
    else if(show == 2){
        setDataset2(region);
    }

}

    public void b1Handle(ActionEvent actionEvent) {
        show = 1;
        if(listView.getSelectionModel().getSelectedItem() != null){
            showdata(listView.getSelectionModel().getSelectedItem());
        }

    }

    public void b2Handle(ActionEvent actionEvent) {
        show = 2;
        if(listView.getSelectionModel().getSelectedItem() != null){
            showdata(listView.getSelectionModel().getSelectedItem());
        }

    }

}
