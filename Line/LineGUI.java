package week10;

import javafx.event.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import week10.DisplayLineInfo.InfoType;


public class LineGUI extends Application {

    private Pane pane;
    private BorderPane borderPane;
    private Circle startPoint, endPoint;
    private Line line;
    private Button startendButton, distanceButton, midpointButton, vertHorzButton;
    private Text startendText, distanceText, midpointText, vertHorzText;

    private static final int CIRCLE_RADIUS = 5;

    public void start(Stage primaryStage) {
        borderPane = new BorderPane();

        pane = new Pane();
        pane.setOnMouseClicked(this::handleMouseClicks);
        borderPane.setCenter(pane);
              
        //Extra credit: the action of startendButton
        startendText = new Text("");
        startendButton = new Button("Show StartEnd Point");
        startendButton.setOnAction(
        		 (ActionEvent event) -> {	
        		 if(InfoType.values() !=null) {
         			DisplayLineInfo displaystartendinfo= DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.STARTENDPOINT);
         			startendText.setText(displaystartendinfo.getInfo(line)); 
        		 }
        		 else 
        			startendText.setText("");
        		 
           		});
        TilePane startendPane = new TilePane(startendButton, startendText);
        startendPane.setAlignment(Pos.CENTER);
        
        //the action of distanceButton
        distanceText = new Text("");
        distanceButton = new Button("Calculate Distance");
        distanceButton.setOnAction(
        		 (ActionEvent event) -> {	
        		 if(InfoType.values() !=null) {
        			DisplayLineInfo displaylineinfo= DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.DISTANCE);
        			distanceText.setText(displaylineinfo.getInfo(line)); 
        		 }
        		 else
        			 distanceText.setText("ERROR");
          		});
        
        TilePane distancePane = new TilePane(distanceButton, distanceText);
        distancePane.setAlignment(Pos.CENTER);

        //the action of midpointButton
        midpointText = new Text("");
        midpointButton = new Button("Calculate Midpoint");
        midpointButton.setOnAction(
        		(ActionEvent event) -> {
        		if(InfoType.values() !=null) {
        			DisplayLineInfo displayMidpoint = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.MIDPOINT);
        			midpointText.setText(displayMidpoint.getInfo(line));
        		}
        		else
        			midpointText.setText("ERROR");
         		});   
        
        TilePane midpointPane = new TilePane(midpointButton, midpointText);
        midpointPane.setAlignment(Pos.CENTER);
        
        //the action of checking vertical of horizon
        vertHorzText = new Text("");
        vertHorzButton = new Button("Determine Vertical/Horizontal");
        vertHorzButton.setOnAction(
        		(ActionEvent event) -> {
        		if(InfoType.values()!=null) {
        			DisplayLineInfo displayverthorz = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.InfoType.VERTHORZ);
        			vertHorzText.setText(displayverthorz.getInfo(line));
        		}
        		else
        			vertHorzText.setText("ERROR");
        			
        		});   
        TilePane vertHorzPane = new TilePane(vertHorzButton, vertHorzText);
        vertHorzPane.setAlignment(Pos.CENTER);

        VBox controlBox = new VBox(startendPane, distancePane,midpointPane,vertHorzPane);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setSpacing(10);
        borderPane.setBottom(controlBox);

        Scene scene = new Scene(borderPane, 600, 600, Color.WHITE);
        primaryStage.setTitle("Line Characteristics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMouseClicks(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if(startPoint==null ) { // no start point yet
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);
            addCoordinateString(x,y);
            line = null;
        } else if(endPoint==null) { // start point, but not end point yet
            endPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(endPoint);
            addCoordinateString(x,y);
            
            line = new Line(startPoint.getCenterX(), startPoint.getCenterY(), endPoint.getCenterX(), endPoint.getCenterY());
            pane.getChildren().add(line);
            
        } else { // startPoint != null && endPoint !=null
            // both start and end are there, so this is starting a new line

            // clear out everything from the last line
            pane.getChildren().clear();
            endPoint = null;
            line = null;
            startendText.setText("");
            distanceText.setText("");
            midpointText.setText(""); 
            vertHorzText.setText("");
            
            // start the new line
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);        
            addCoordinateString(x,y);
        }

    }
    
    private void addCoordinateString(double x, double y) {
        String coordinateString = "(" + x + ", " + y + ")";
        Text coordinates = new Text(x-CIRCLE_RADIUS, y-CIRCLE_RADIUS-2, coordinateString);
        pane.getChildren().add(coordinates);
    }
  

    public static void main(String[] args) {
        launch(args);
    }

}

