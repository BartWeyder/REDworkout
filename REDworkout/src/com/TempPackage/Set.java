package com.TempPackage;

public class Set {

    private Time work_time;

    private Time relax_time;

    private int reps;

    private double weight;
    
    public Set() {
        
    }

    public void setWorkTime() {
    }

    public void setRelaxTime() {
    }

    public Time getWorkTime() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Time getRelaxTime() {
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
    }
}
