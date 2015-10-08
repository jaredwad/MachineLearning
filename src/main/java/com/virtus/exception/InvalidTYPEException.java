package com.virtus.exception;

import com.virtus.Data.TYPE;

/**
 * Created by jared on 10/6/15.
 */
public class InvalidTYPEException extends Exception{
    public InvalidTYPEException(TYPE t1, TYPE t2) {
        super("TYPE Mismatch " + t1.toString() + " != " + t2.toString());
    }


}
