package gui;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;

import java.io.File;
import java.util.Random;
import java.util.Arrays;

public class NotesController {

    @FXML
    HBox fff;

    public void doSomething() throws Exception {
        System.out.println("Sure, I'm doing it!");

        //zapisywanie
        String doZapisu = "Trump claims he took himself out of the running for Time's 'Person of the Year'";
        File file = new File("test.txt");
        Files.write(doZapisu, file, Charsets.UTF_8);

        //wczytywanie
        String result = Files.toString(file, Charsets.UTF_8);



        //Defining the axes
        CategoryAxis xAxis = new CategoryAxis() ;
        xAxis.setCategories(FXCollections.<String>
                observableArrayList(Arrays.asList("Speed", "User rating" , "Milage" , "Safety") ));
        xAxis.setLabel("category") ;

        NumberAxis yAxis = new NumberAxis() ;
        yAxis.setLabel("score") ;

        //Creating the Bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis) ;
        barChart.setTitle("Comparison between various cars") ;

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<String, Number> series1 = new XYChart.Series<>() ;
        series1.setName("Fiat") ;
        series1.getData() .add(new XYChart.Data<>("Speed", 1.0) );
        series1.getData() .add(new XYChart.Data<>("User rating", 3.0) );
        series1.getData() .add(new XYChart.Data<>("Milage", 5.0) );
        series1.getData() .add(new XYChart.Data<>("Safety", 5.0) );

        XYChart.Series<String, Number> series2 = new XYChart.Series<>() ;
        series2.setName("Audi") ;
        series2.getData() .add(new XYChart.Data<>("Speed", 5.0) );
        series2.getData() .add(new XYChart.Data<>("User rating", 6.0) );
        series2.getData() .add(new XYChart.Data<>("Milage", 10.0) );
        series2.getData() .add(new XYChart.Data<>("Safety", 4.0) );

        XYChart.Series<String, Number> series3 = new XYChart.Series<>() ;
        series3.setName("Ford") ;
        series3.getData() .add(new XYChart.Data<>("Speed", 4.0) );
        series3.getData() .add(new XYChart.Data<>("User rating", 2.0) );
        series3.getData() .add(new XYChart.Data<>("Milage", 3.0) );
        series3.getData() .add(new XYChart.Data<>("Safety", 6.0) );

        //Setting the data to bar chart
        barChart.getData() .addAll(series1, series2, series3);

        fff.getChildren().add(barChart);


    }

    public double[] generateRandomNumbers(int n) {
        Random r = new Random();
        double[] aaa = new double[n];
        for (int i = 0; i < n; i++) {
            aaa[i] = r.nextGaussian();
        }
        return aaa;
    }
    
}
