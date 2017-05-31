package xyz.redworkout.exception;

import xyz.redworkout.exception.NoDataException;

/**
 * Created by bartw on 15-May-17.
 */
public class NoDataExceptionSource {
    public double possibleWeightExceptionSource () throws NoDataException {
        //getting data from db
        Double weight = null;
        if (weight == null) {
            throw new NoDataException("Field is empty...");
        }
        return weight;
    }
}
