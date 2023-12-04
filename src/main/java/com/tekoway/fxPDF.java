package com.tekoway;

import com.tekoway.nodes.viewer.AppearanceType;
import com.tekoway.nodes.viewer.SampleViewer;
import com.tekoway.fxpdf.PDF;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class fxPDF extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException {
        //FileChooser to open PDF
        var f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF (.pdf)", "*.pdf"));
        var selected = f.showOpenDialog(primaryStage);
        if (selected != null) {
            //Create PDF
            var pdf = new PDF(selected);
            var sv = new SampleViewer(pdf);
            sv.setTheme(AppearanceType.DARK);
            //Scene and add PDFViewer
            var s = new Scene(sv);
            //Stage settings
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
            primaryStage.setTitle("fxPDF");
            primaryStage.show();
        } else {
            System.exit(0);
        }
    }
}
