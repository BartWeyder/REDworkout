package com.TempPackage;

/**
 * Created by bartw on 15-May-17.
 */
public class NoDataException extends Exception {
    public  NoDataException(String msg)
    {
        super(msg);
        System.out.println("Field is empty.");
    }
}
