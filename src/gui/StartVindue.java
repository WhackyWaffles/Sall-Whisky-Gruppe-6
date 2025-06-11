package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartVindue extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Sall Whisky Lagerstyring");
        BorderPane pane = new BorderPane();

        this.initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(720);
        primaryStage.setMaxWidth(550);
        primaryStage.show();

    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {

        Tab tabStart = new Tab("");
        Tab tabDestillering = new Tab("Opret Destillering");
        Tab tabFad = new Tab("Opret Fad");
        Tab tabPåfyldning = new Tab("Opret Påfyldning");
        Tab tabLager = new Tab("Opret lager");
        Tab tabWhisky = new Tab("Opret Whisky");


        OpretDestilleringPane opretDestilleringPane = new OpretDestilleringPane();
        tabDestillering.setContent(opretDestilleringPane);
        OpretFadPane opretFadPane = new OpretFadPane();
        tabFad.setContent(opretFadPane);
        OpretPåfyldningPane opretPåfyldningPane = new OpretPåfyldningPane();
        tabPåfyldning.setContent(opretPåfyldningPane);
        OpretLagerPane opretLagerPane = new OpretLagerPane();
        tabLager.setContent(opretLagerPane);
        OpretWhiskyPane opretWhiskyPane = new OpretWhiskyPane();
        tabWhisky.setContent(opretWhiskyPane);

        tabPane.getTabs().add(tabDestillering);
        tabPane.getTabs().add(tabFad);
        tabPane.getTabs().add(tabPåfyldning);
        tabPane.getTabs().add(tabLager);
        tabPane.getTabs().add(tabWhisky);


    }


}
