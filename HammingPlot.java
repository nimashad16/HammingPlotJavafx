import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import java.util.Scanner;


// Any JavaFX application must extend the Application class, which is abstract.
public class HammingPlot extends Application {

	public static void main(String[] args) {
		
	
		// Launch the JavaFX application. This method creates a 
		// LineChartExample object and calls its start method.
		launch(args);
	}
	
	// The start method is the entry point for any JavaFX application. It is 
	// the only abstract method of the Application class and must be 
	// overridden.
	//
	// The launch method passes the start method a reference to the primary 
	// Stage of the application. This Stage is the window that displays the 
	// application content.
	public void start(Stage stage) throws IOException {

		// Each data series shown in a LineChart is stored in an XYChart.Series 
		// object. The LineChart created by this code shows two data series, so 
		// two XYChart.Series objects are needed.
		// 
		// The type parameters in the declaration of an XYChart.Series specify 
		// the data types of the x-values and y-values. The possible types are 
		// String and Number. This LineChart shows a couple of trigonometric 
		// functions, so the x-values and y-values are both Numbers.
		//
		// Each XYChart.Series object has a name field. This field is used to 
		// label the data in the chart legend.
		XYChart.Series<Number, Number> circularSeries = new XYChart.Series<>();
		circularSeries.setName("circularBoundaryConditions");
		XYChart.Series<Number, Number> fixedSeries = new XYChart.Series<>();
		fixedSeries.setName("fixedBoundaryConditions");

		// Each XYChart.Series object stores a list of data points. The getData 
		// method returns a reference to this list.
		// 
		// Data is added to an XYChart.Series by adding it to its data list. 
		// The following lines simply store references to the data lists of 
		// sinSeries and cosSeries for use in the for-loop below.
		List<XYChart.Data<Number, Number>> circularData = circularSeries.getData();
		List<XYChart.Data<Number, Number>> fixedData = fixedSeries.getData();

		// Calculate some data to display in the LineChart. To create your 
		// automaton plots, replace this loop with code that reads your Hamming 
		// distance or subrule counts data files.
		
		//for (int idx = 0; idx <= 100; ++idx) {
		//	double x = 2 * Math.PI * idx / 100;
		//	double sinX = Math.sin(x);
		//	double cosX = Math.cos(x);

		Scanner circleReader = new Scanner(new FileReader("hamming-elementary90-circularbc.txt"));
		Scanner fixedReader = new Scanner(new FileReader("hamming-elementary90-fixedbc-off-off.txt"));
			// Each data point in an XYChart.Series must be wrapped in an 
			// XYChart.Data object. The following lines add a point to 
			// sinSeries and cosSeries by adding a point to their data lists.
		
		int idx = -1;
		while(circleReader.hasNextLine()) {
			//parse each line as an int and add it to the data
		int circlePoint = Integer.parseInt(circleReader.nextLine());
			idx++;
			XYChart.Data<Number, Number> circlePT = new XYChart.Data<>(idx, circlePoint);
			
			circularData.add(circlePT);
		}
			circleReader.close();
			
		int index = -1;
			while(fixedReader.hasNextLine()) {
			int fixedPoint = Integer.parseInt(circleReader.nextLine());
				index++;
				XYChart.Data<Number, Number> fixedPT = new XYChart.Data<>(index, fixedPoint);
				
				fixedData.add(fixedPT);
			}
				fixedReader.close();
			
		

		// Create the x-axis and y-axis for the LineChart. The NumberAxis class 
		// is used because the data points are pairs of Numbers. If either the 
		// x-values or y-values were Strings, the CategoryAxis class would need 
		// to be used instead.
		//
		// NumberAxis has an overloaded constructor. The version used here has 
		// four parameters: the label, lower bound, upper bound, and tick unit.
		NumberAxis xAxis = new NumberAxis("Step Number", 0, 100, 10);
		NumberAxis yAxis = new NumberAxis("Hamming Distance", 0, 100, 10);

		// Create the LineChart. The constructor takes references to both axes.
		//
		// Each LineChart object has a title field. If this field is set, the 
		// value will be shown at the top of the chart.
		//
		// By default, each data point is shown in the chart with a symbol, and 
		// the symbols are connected by lines. Setting the createSymbols field 
		// to false removes the symbols and only shows the lines.
		LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
		chart.setTitle("Elementary Rule 90 (Nima Shadaram ID 113463167)");
		chart.setCreateSymbols(false);

		// The data series shown in a LineChart are stored in a list. The 
		// getData method returns a reference to this list. (Note the 
		// similarity to the getData method of XYChart.Series.) The following 
		// lines add sinSeries and cosSeries to the LineChart.
		List<XYChart.Series<Number, Number>> seriesList = chart.getData();
		seriesList.add(circularSeries);
		seriesList.add(fixedSeries);

		// The graphical components of a JavaFX application are stored in 
		// Scenes. In order to display the LineChart, it must be added to a 
		// Scene. The constructor used below takes a reference to the LineChart 
		// and integers specifying the width and height of the Scene in pixels.
		Scene scene = new Scene(chart, 960, 600);

		// Add the Scene to the application Stage (i.e., window), and call the 
		// show method to display it. (Only one Scene can be displayed in a 
		// Stage at a time.) The setTitle method is used to define the text 
		// that appears in the title bar of the window.
		stage.setScene(scene);
		stage.setTitle("Elementary Rule 90 (Nima Shadaram 113463167)");
		stage.show();
		
		// Save a copy of the Scene as a PNG image.
		String filename = "plots" + File.separator + "hamming-elementary90-circularbc.txt";
		saveScene(scene, filename);
	}

	
	// Create a PNG of the given Scene.
	public static void saveScene(Scene scene, String filename) throws 
			IOException {
		
		// Convert the given Scene to an image that can be written to a file.
		WritableImage image = scene.snapshot(null);
		BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
		
		// Create a file with the given name and save the image as a PNG.
		File output = new File(filename);
		ImageIO.write(bufferedImage, "png", output);
	}
}
