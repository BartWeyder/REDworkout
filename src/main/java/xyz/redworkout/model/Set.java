package xyz.redworkout.model;

import xyz.redworkout.exception.NoDataException;
import xyz.redworkout.exception.NoDataExceptionSource;

public class Set {

    private long work_time;

    private long relax_time;

    private int reps;

    private double weight;
    
    public Set() {
        
    }

    public void setWorkTime(long work_time) {
        this.work_time = work_time;
    }

    public void setRelaxTime(long relax_time) {
        this.relax_time = relax_time;
    }

    public String getWorkTime() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getRelaxTime() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setWeight(String weight) throws NumberFormatException {
        try {
            Double doubleWeight = Double.parseDouble(weight);
            if (doubleWeight < 0 || doubleWeight > 2000)
                throw new NumberFormatException("Invalid data");
        } catch (NumberFormatException e) {
            System.out.println("//error");
        }
    }

    public double getWeight() throws NoDataException {
        NoDataExceptionSource exceptionSource = new NoDataExceptionSource();
        try {
            Double weight = exceptionSource.possibleWeightExceptionSource();
        } catch (NoDataException exception)
        {
            //code to send message to user
        }
        //change later
        return 0.0;
    }
}
