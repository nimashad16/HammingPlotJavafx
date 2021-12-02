import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

// Any JavaFX application must extend the Application class, which is abstract.
public class SubrulesPlot extends Application {

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
		
		int IDNum = 113463167;
		int ruleNumber = (IDNum % 43);
		System.out.println(ruleNumber);
		System.out.println("My rule number is 90");

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
		XYChart.Series<Number, Number> sub0 = new XYChart.Series<>();
		sub0.setName("SubRule 0");
		XYChart.Series<Number, Number> sub1 = new XYChart.Series<>();
		sub1.setName("SubRule1");
		XYChart.Series<Number, Number> sub2 = new XYChart.Series<>();
		sub2.setName("SubRule 2");
		XYChart.Series<Number, Number> sub3 = new XYChart.Series<>();
		sub3.setName("SubRule 3");
		XYChart.Series<Number, Number> sub4 = new XYChart.Series<>();
		sub4.setName("SubRule 4");
		XYChart.Series<Number, Number> sub5 = new XYChart.Series<>();
		sub5.setName("SubRule 5");
		XYChart.Series<Number, Number> sub6 = new XYChart.Series<>();
		sub6.setName("SubRule 6");
		XYChart.Series<Number, Number> sub7 = new XYChart.Series<>();
		sub7.setName("SubRule 7");

		// Each XYChart.Series object stores a list of data points. The getData 
		// method returns a reference to this list.
		// 
		// Data is added to an XYChart.Series by adding it to its data list. 
		// The following lines simply store references to the data lists of 
		// sinSeries and cosSeries for use in the for-loop below.
		List<XYChart.Data<Number, Number>> sub0Data = sub0.getData();
		List<XYChart.Data<Number, Number>> sub1Data = sub1.getData();
		List<XYChart.Data<Number, Number>> sub2Data = sub2.getData();
		List<XYChart.Data<Number, Number>> sub3Data = sub3.getData();
		List<XYChart.Data<Number, Number>> sub4Data = sub4.getData();
		List<XYChart.Data<Number, Number>> sub5Data = sub5.getData();
		List<XYChart.Data<Number, Number>> sub6Data = sub6.getData();
		List<XYChart.Data<Number, Number>> sub7Data = sub7.getData();

		// Calculate some data to display in the LineChart. To create your 
		// automaton plots, replace this loop with code that reads your Hamming 
		// distance or subrule counts data files.
		//for (int idx = 0; idx <= 100; ++idx) {
		//	double x = 2 * Math.PI * idx / 100;
		//	double sinX = Math.sin(x);
		//	double cosX = Math.cos(x);

		Scanner keyboard = new Scanner(new FileReader("subrules-elementary90-circularbc.txt"));
		
		ArrayList<String[]> nums = new ArrayList<String[]>();
		
		while(keyboard.hasNext()){
			nums.add(keyboard.nextLine().split(","));
		}
		keyboard.close();
		
		for(int x =0;x < 100; x++) {
			int subpart0 = Integer.parseInt(nums.get(x)[7]);
			XYChart.Data<Number, Number> point0 = new XYChart.Data<>(x, subpart0);
			sub0Data.add(point0);
		}
		
		for(int i =0;i < 100; i++) {
			int subpart1 = Integer.parseInt(nums.get(i)[6]);
			XYChart.Data<Number, Number> point1 = new XYChart.Data<>(i, subpart1);
			sub1Data.add(point1);
		}
		
		for(int a =0;a < 100; a++) {
			int subpart2 = Integer.parseInt(nums.get(a)[5]);
			XYChart.Data<Number, Number> point2 = new XYChart.Data<>(a, subpart2);
			sub2Data.add(point2);
		}
		
		for(int b =0;b < 100; b++) {
			int subpart3 = Integer.parseInt(nums.get(b)[4]);
			XYChart.Data<Number, Number> point3 = new XYChart.Data<>(b, subpart3);
			sub3Data.add(point3);
		}
		
		for(int c =0;c < 100; c++) {
			int subpart4 = Integer.parseInt(nums.get(c)[3]);
			XYChart.Data<Number, Number> point4 = new XYChart.Data<>(c, subpart4);
			sub4Data.add(point4);
		}
		
		
		for(int d =0;d < 100; d++) {
			int subpart5 = Integer.parseInt(nums.get(d)[2]);
			XYChart.Data<Number, Number> point5 = new XYChart.Data<>(d, subpart5);
			sub5Data.add(point5);
		}
		
		for(int e =0;e < 100; e++) {
			int subpart6 = Integer.parseInt(nums.get(e)[1]);
			XYChart.Data<Number, Number> point6 = new XYChart.Data<>(e, subpart6);
			sub6Data.add(point6);
		}
		
		for(int f =0;f < 100; f++) {
			int subpart7 = Integer.parseInt(nums.get(f)[0]);
			XYChart.Data<Number, Number> point7 = new XYChart.Data<>(f, subpart7);
			sub7Data.add(point7);
		}
		
		
			// Each data point in an XYChart.Series must be wrapped in an 
			// XYChart.Data object. The following lines add a point to 
			// sinSeries and cosSeries by adding a point to their data lists.
			
			
			
		

		// Create the x-axis and y-axis for the LineChart. The NumberAxis class 
		// is used because the data points are pairs of Numbers. If either the 
		// x-values or y-values were Strings, the CategoryAxis class would need 
		// to be used instead.
		//
		// NumberAxis has an overloaded constructor. The version used here has 
		// four parameters: the label, lower bound, upper bound, and tick unit.
		NumberAxis xAxis = new NumberAxis("Step Number", 0,100,10);
		NumberAxis yAxis = new NumberAxis("SubRule Count", 0, 100, 10);

		// Create the LineChart. The constructor takes references to both axes.
		//
		// Each LineChart object has a title field. If this field is set, the 
		// value will be shown at the top of the chart.
		//
		// By default, each data point is shown in the chart with a symbol, and 
		// the symbols are connected by lines. Setting the createSymbols field 
		// to false removes the symbols and only shows the lines.
		LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
		chart.setTitle("Elementary Rule 90 (Nima Shadaram, ID 113463167)");
		chart.setCreateSymbols(false);

		// The data series shown in a LineChart are stored in a list. The 
		// getData method returns a reference to this list. (Note the 
		// similarity to the getData method of XYChart.Series.) The following 
		// lines add sinSeries and cosSeries to the LineChart.
		List<XYChart.Series<Number, Number>> seriesList = chart.getData();
		seriesList.add(sub0);
		seriesList.add(sub1);
		seriesList.add(sub2);
		seriesList.add(sub3);
		seriesList.add(sub4);
		seriesList.add(sub5);
		seriesList.add(sub6);
		seriesList.add(sub7);

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
		stage.setTitle("Elementary Rule 90 (Nima Shadaram, ID 113463167)");
		stage.show();
		
		// Save a copy of the Scene as a PNG image.
		String filename = "plots" + File.separator + "subrules-elementary90-circularbc.png";
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
