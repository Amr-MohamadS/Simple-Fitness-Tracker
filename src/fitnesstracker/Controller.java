package fitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Controller {

    @FXML
        TextField textfield;
    @FXML
        Label calories;
    @FXML
        Label HR;
    @FXML
         Label activity1;
    @FXML
         Label done;
    @FXML
         SplitMenuButton Activities;

    Activity activity = new Activity();
    String sport;
    String time;
    int rCalorie=0,kbCalorie=0,sCalorie=0,stCalorie=0;
    double rHR=0,kbHR=0,sHR=0,stHR=0;
    int t ;
    double heartRate;
    int calorie;
    int a=0;
    public void calculate(ActionEvent actionEvent) {

        time= textfield.getText();

        try
        {
            t= Integer.parseInt(time.trim());
            activity.calculateHR(t);
            activity.calculateTotalCalorie(t);
            HR.setText(activity.sportHR(t) + " Beat/Min");
            calories.setText(activity.sportCalorie(t) + " Calorie");
            done.setText("Activity added successfully");
            if (a==1)
            {
                activity.calorieBurntInKickBoxing(t);
                activity.heartRatePerKickBoxing(t);
            }
            else if(a==2)
            {
                activity.calorieBurntInSwimming(t);
                activity.heartRatePerSwimming(t);
            }
            else if(a==3)
            {
                activity.calorieBurntInRunning(t);
                activity.heartRatePerRunning(t);
            }
            else if (a==4)
            {
                activity.calorieBurntInStrengthTraining(t);
                activity.heartRatePerStrengthTraining(t);
            }
        }
        catch (NumberFormatException nfe)
        {
           done.setText("Enter Time in Minutes!!");
        }

    }

    public void setKickBoxing(ActionEvent actionEvent) {

        activity.Setter(3, 0.005);
        activity1.setText("Kick Boxing");
        done.setText("");
        textfield.setText("");
        a=1;
        HR.setText("80" + " Beat/Min");
        calories.setText("0" + " Calorie");
    }

    public void setSwimming(ActionEvent actionEvent) {
        activity.Setter(4, 0.002);
        activity1.setText("Swimming");
        done.setText("");
        textfield.setText("");
        a=2;
        HR.setText("80" + " Beat/Min");
        calories.setText("0" + " Calorie");
    }

    public void setRunning(ActionEvent actionEvent) {
        activity.Setter(5, 0.003);
        activity1.setText("Running");
        done.setText("");
        textfield.setText("");
        a=3;
        HR.setText("80" + " Beat/Min");
        calories.setText("0" + " Calorie");
    }


    public void setStrengthTraining(ActionEvent actionEvent) {
        activity.Setter(5, 0.006);
        activity1.setText("Strength Training");
        done.setText("");
        textfield.setText("");
        a=4;
        HR.setText("80" + " Beat/Min");
        calories.setText("0" + " Calorie");
    }


    public void setResults(ActionEvent actionEvent) {
        Stage stage = new Stage();
        GridPane root=new GridPane();

        stage.setTitle("Fitness tracker");

        root.setHgap(120);
        root.setVgap(50);

        Label label1 = new Label("Total Calories Burnt = " + activity.getTotalCalorie() + " Calorie");
        Label label2 = new Label("Heart Rate = " + activity.getHR() + " Beat/Min");
        Label label3 = new Label("Heart rate increase = "+ activity.totalHeartrateIncrease() + " Beat/Min");


        root.add(label1,0,0);
        root.add(label2,0,1);
        root.add(label3,0,2);
        stage.setScene(new Scene(root,350,160));

        stage.show();

    }
    public void setRanking(ActionEvent actionEvent) {
        int temp;
        double temp2;
        rCalorie=activity.calorieBurntInRunning(0);
        kbCalorie= activity.calorieBurntInKickBoxing(0);
        stCalorie=activity.calorieBurntInStrengthTraining(0);
        sCalorie=activity.calorieBurntInSwimming(0);
        rHR= activity.heartRatePerRunning(0);
        kbHR=  activity.heartRatePerKickBoxing(0);
        stHR= activity.heartRatePerStrengthTraining(0);
        sHR= activity.heartRatePerSwimming(0);

        int ar[]=new int[4];
        ar[0]=rCalorie;ar[1]=sCalorie;ar[2]=kbCalorie;ar[3]=stCalorie;
        double arr[]= new double[4];
        arr[0]=rHR;arr[1]=sHR;arr[2]=kbHR;arr[3]=stHR;
        for (int i = 0; i < 4; i++)
        {
            for (int j = i + 1; j < 4; j++)
            {
                if (ar[i] < ar[j])
                {
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                    temp2 = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp2;
                }
                else if (ar[i]==ar[j])
                {
                    if(arr[i]<arr[j])
                    {
                        temp = ar[i];
                        ar[i] = ar[j];
                        ar[j] = temp;
                        temp2 = arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp2;
                    }
                }
            }
        }

        Stage stage = new Stage();
        GridPane root=new GridPane();

        stage.setTitle("Fitness tracker");

        root.setHgap(120);
        root.setVgap(50);

        Label b1 = new Label();
        Label b2 = new Label();
        Label b3 = new Label();
        Label b4 = new Label();

        if(ar[0]==sCalorie && arr[0]==sHR)
            b1.setText("Rank 1: Swimming-> "+sCalorie +" Calorie, "+sHR +" Beat/Min");
       else if(ar[0]==stCalorie && arr[0]==stHR)
            b1.setText("Rank 1: Strength Training-> "+stCalorie +" Calorie, "+stHR +" Beat/Min");
        else if(ar[0]==rCalorie && arr[0]==rHR)
            b1.setText("Rank 1: Running-> "+rCalorie +" Calorie, "+rHR +" Beat/Min");
        else if(ar[0]==kbCalorie && arr[0]==kbHR)
            b1.setText("Rank 1: Kick Boxing-> "+kbCalorie +" Calorie, "+kbHR +" Beat/Min");

        if(ar[1]==sCalorie && arr[1]==sHR)
            b2.setText("Rank 2: Swimming-> "+sCalorie +" Calorie, "+sHR +" Beat/Min");
        else if(ar[1]==stCalorie && arr[1]==stHR)
            b2.setText("Rank 2: Strength Training-> "+stCalorie +" Calorie, "+stHR +" Beat/Min");
        else if(ar[1]==rCalorie && arr[1]==rHR)
            b2.setText("Rank 2: Running-> "+rCalorie +" Calorie, "+rHR +" Beat/Min");
        else if(ar[1]==kbCalorie && arr[1]==kbHR)
            b2.setText("Rank 2: Kick Boxing-> "+kbCalorie +" Calorie, "+kbHR +" Beat/Min");

        if(ar[2]==sCalorie && arr[2]==sHR)
            b3.setText("Rank 3: Swimming-> "+sCalorie +" Calorie, "+sHR +" Beat/Min");
        else if(ar[2]==stCalorie && arr[2]==stHR )
            b3.setText("Rank 3: Strength Training-> "+stCalorie +" Calorie, "+stHR +" Beat/Min");
        else if(ar[2]==rCalorie && arr[2]==rHR)
            b3.setText("Rank 3: Running-> "+rCalorie +" Calorie, "+rHR +" Beat/Min");
        else if(ar[2]==kbCalorie && arr[2]==kbHR)
            b3.setText("Rank 3: Kick Boxing-> "+kbCalorie +" Calorie, "+kbHR +" Beat/Min");

        if(ar[3]==sCalorie && arr[3]==sHR)
            b4.setText("Rank 4: Swimming-> "+sCalorie +" Calorie, "+sHR +" Beat/Min");
        else if(ar[3]==stCalorie && arr[3]==stHR)
            b4.setText("Rank 4: Strength Training-> "+stCalorie +" Calorie, "+stHR +" Beat/Min");
        else if(ar[3]==rCalorie && arr[3]==rHR)
            b4.setText("Rank 4: Running-> "+rCalorie +" Calorie, "+rHR +" Beat/Min");
        else if(ar[3]==kbCalorie && arr[3]==kbHR)
            b4.setText("Rank 4: Kick Boxing-> "+kbCalorie +" Calorie, "+kbHR +" Beat/Min");

        root.add(b1,0,0);
        root.add(b2,0,1);
        root.add(b3,0,2);
        root.add(b4,0,3);


        stage.setScene(new Scene(root,400,250));

        stage.show();
    }

    }

