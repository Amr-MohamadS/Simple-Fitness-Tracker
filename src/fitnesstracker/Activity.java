package fitnesstracker;

public class Activity {
    private int calorieBurntPerMin;
    private int totalCalorieBurnt;
    private double HeartRate;
    private double heartRateIncreasePerMin;
    private double  totalheartRatePerSwimming;
    private double totalheartRatePerStrengthTraining;
    private double totalheartRatePerRunning;
    private double totalheartRatePerKickBoxing;
    private String heartRateIncrease;
    private int totalCalorieperRunning;
    private int totalCalorieperSwimming;
    private int totalCalorieperStrengthTraining;
    private int totalCalorieperKickBoxing;
    public Activity()
    {
        totalCalorieBurnt=0;
        HeartRate=80;
    }
    public String totalHeartrateIncrease()
    {
        heartRateIncrease=Double.toString(HeartRate-80);
        return heartRateIncrease;

    }
    public void Setter (int cal,double HR)
    {
        calorieBurntPerMin=cal;
        heartRateIncreasePerMin=HR;
    }
    public void calculateHR (int t )
    {
        HeartRate = HeartRate + (HeartRate * t * heartRateIncreasePerMin);
    }
    public void calculateTotalCalorie(int t)
    {
        totalCalorieBurnt=totalCalorieBurnt+(calorieBurntPerMin * t);
    }

    public int calorieBurntInRunning (int t)
    {
        totalCalorieperRunning=totalCalorieperRunning+(5 * t);
        return totalCalorieperRunning;
    }
    public int calorieBurntInSwimming (int t)
    {
        totalCalorieperSwimming=totalCalorieperSwimming+(4 * t);
        return totalCalorieperSwimming;
    }
    public int calorieBurntInStrengthTraining (int t)
    {
        totalCalorieperStrengthTraining=totalCalorieperStrengthTraining+(5 * t);
        return totalCalorieperStrengthTraining;
    }
    public int calorieBurntInKickBoxing (int t)
    {
        totalCalorieperKickBoxing=totalCalorieperKickBoxing+(3 * t);
        return totalCalorieperKickBoxing;
    }

    public double heartRatePerSwimming (int t)
    {
        totalheartRatePerSwimming=totalheartRatePerSwimming + (80 * t * 0.002);
        return totalheartRatePerSwimming;
    }
    public double heartRatePerStrengthTraining (int t)
    {
        totalheartRatePerStrengthTraining=totalheartRatePerStrengthTraining + (80 * t * 0.006);
        return totalheartRatePerStrengthTraining;
    }
    public double heartRatePerRunning (int t)
    {
        totalheartRatePerRunning=totalheartRatePerRunning + (80 * t * 0.003);
        return totalheartRatePerRunning;
    }
    public double heartRatePerKickBoxing (int t)
    {
        totalheartRatePerKickBoxing=totalheartRatePerKickBoxing + (80 * t * 0.005);
        return totalheartRatePerKickBoxing;
    }
    public String sportHR(int t)
    {
        String Heartrate=Double.toString(80.0+(80.0 * (double)t * heartRateIncreasePerMin));
        return Heartrate;
    }
    public String sportCalorie(int t)
    {
        String Calorie=Integer.toString(t * calorieBurntPerMin);
        return Calorie;
    }

    public String getHR ()
    {
        String HeartRate2=Double.toString(HeartRate);
        return HeartRate2;
    }
    public String getTotalCalorie ()
    {
        String totalCalorieBurnt2=Integer.toString(totalCalorieBurnt);
        return totalCalorieBurnt2;
    }
}
