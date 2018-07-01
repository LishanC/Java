/** MODULE 7 HOMEWORK : Collections and Big Data
*
* @author Jacquelyn Cheng
* @author Lishan Chan
* @author Jamie Stash
*/

import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

/* Homework for M7:

The model will be:
[ Lishan ] - Write a class to represent your data. 
[ Lishan ] - In a separate class, read in your data file and create objects of your class. 
[ Jackie ] - Create at least one list and at least one map of your data
[ Jamie  ] - Answer at least two interesting queries/questions about your data

*/

public class SalaryAnalysis extends Application  {

    private Stage primaryStage;
    private Text statusText, resultText;
    private Button uploadButton;

    private final static Font RESULT_FONT = Font.font("Helvetica", 16);
    private final static Font INPUT_FONT = Font.font("Helvetica", 20);

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        VBox uploadBox = new VBox();
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setSpacing(20);
        Text uploadLabel = new Text("Upload .csv of Salary Data:");
        uploadLabel.setFont(INPUT_FONT);
        uploadButton = new Button("Select file");
        uploadButton.setOnAction(this::processDataUpload);
	       
        uploadBox.getChildren().add(uploadLabel);
        uploadBox.getChildren().add(uploadButton);
        primaryBox.getChildren().add(uploadBox);
        

        VBox resultsBox = new VBox();
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setSpacing(20);
        statusText = new Text("");
        statusText.setVisible(false);
        statusText.setFont(RESULT_FONT);
        statusText.setFill(Color.BLUE);
        statusText.setTextAlignment(TextAlignment.CENTER);
        resultText = new Text("");
        resultText.setVisible(false);
        resultText.setFont(RESULT_FONT);
        resultsBox.getChildren().add(statusText);
        resultsBox.getChildren().add(resultText);
        primaryBox.getChildren().add(resultsBox);

        Scene scene = new Scene(primaryBox, 500, 500, Color.TRANSPARENT);
        primaryStage.setTitle("Salary Data Processor");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // read the salary data file and create object
    private void processDataUpload(ActionEvent event){
        statusText.setVisible(false);
        resultText.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        parseFile(file);

    }

    private void parseFile(File file) {
    
    	int salariesInList = 0;
    	int salariesInMap = 0;
    	String topDept = "";
    	ArrayList<Salary> salaryList = new ArrayList<>();
    	HashMap<Integer,Salary> salaryMap = new HashMap<>();
        salariesInList = fillList(salaryList, file);
        salariesInMap = fillMap(salaryMap, file);
        topDept = findTopDept(salaryList);  // Finds dept with highest total compensation payout
        Salary[] top5OTEarners = findTop5OTEarners(salaryList); // Finds top 5 highest overtime earners
    	uploadButton.setDisable(true);
		statusText.setVisible(true);
        statusText.setText("Upload successful:\n" + salariesInList + " salaries added to list\n" +
                salariesInMap + " salaries added to map\n\n" + "Top Earning Department: " + topDept +
                "\n\nTop 5 overtime earners: \n" + printTop5OTEarners(top5OTEarners));
			
    }

    /**
     * fillList creates a list Salary objects and returns the size of the list
     * @param list list of Salary objects
     * @param file the file with data from which Salary objects are created
     * @return int size of the list
     */

    private static int fillList(List<Salary> list, File file) {
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(new FileReader(file));

            while(fileScan.hasNext()) {
                String oneLine = fileScan.nextLine();
                Scanner lineScan = new Scanner(oneLine);
                lineScan.useDelimiter(",");

                String name=lineScan.next();
                String department=lineScan.next();
                String title=lineScan.next();

                String basepay=lineScan.next();
                double base_pay=Double.parseDouble(basepay);

                String otpay=lineScan.next();
                double overtime_pay=Double.parseDouble(otpay);

                String totalpay=lineScan.next();
                double total_pay=Double.parseDouble(totalpay);

                Salary salary=new Salary(name,department, title, base_pay, overtime_pay, total_pay);
                list.add(salary);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            fileScan.close();
            return list.size();
        }
    }

    private String findTopDept(List <Salary> list){  // Finds the department with the highest total compensation payout
        HashMap<String, Double> deptMap = new HashMap<>();
        Double topDeptPay = new Double(0);
        String topEarningDept = new String("");
        for (Salary salary : list) {
            String dept = salary.getDepartment();
            Double totalPay = salary.getTotalpay();
            if (!deptMap.containsKey(dept)) {
                deptMap.put(dept, totalPay);
            } else {
                deptMap.replace(dept, deptMap.get(dept) + totalPay);  //there's probably a more elegant way to do this
            }
            if (deptMap.get(dept) > topDeptPay){
                topDeptPay = deptMap.get(dept);
                topEarningDept = dept;
            }
        }
        return topEarningDept;
    }

    private Salary[] findTop5OTEarners(List <Salary> list){  // Finds 5 highest paid employees
        Salary[] top5OTArray = new Salary[5];
        list.sort(Salary::compareByOT);
        for (int i = 0; i < 5; i++){
            top5OTArray[i] = list.get(i);
        }
        return top5OTArray;
    }

    //Creates a single string with names and OT pay for top 5 OT earners
    private String printTop5OTEarners(Salary[] top5OTArray){
        String top5PrintString = "";
        for (int i = 0; i < 5; i++){
            String name = top5OTArray[i].getName();
            Double OTPay = top5OTArray[i].getOverTimePay();
            top5PrintString += "\n" + name + ", Overtime earned: $" + OTPay.toString();
        }
        return top5PrintString;
    }


    /**
     * fillMap creates a map Salary objects using the Salary class hashCode method for the key
     * @param map list of Salary objects with integer hashCode key
     * @param file the file with data from which Salary objects are created
     * @return int number of Salary objects in map
     */

    private static int fillMap(Map<Integer,Salary> map, File file) {
        Scanner fileScan = null;
        int salariesProcessed = 0;
        try {
            fileScan = new Scanner(new FileReader(file));

            while(fileScan.hasNext()) {
                String oneLine = fileScan.nextLine();
                Scanner lineScan = new Scanner(oneLine);
                lineScan.useDelimiter(",");

                String name = lineScan.next();
                String department = lineScan.next();
                String title = lineScan.next();

                String basepay = lineScan.next();
                double base_pay = Double.parseDouble(basepay);

                String otpay = lineScan.next();
                double overtime_pay = Double.parseDouble(otpay);

                String totalpay = lineScan.next();
                double total_pay = Double.parseDouble(totalpay);

                Salary salary = new Salary(name, department, title, base_pay, overtime_pay, total_pay);

                map.put(salary.hashCode(), salary);
                salariesProcessed++;
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            fileScan.close();
            return salariesProcessed;
        }
    }

    public static void main(String[] args)  {
        launch(args);
    }

}
