package com.virtus.exception;

import com.virtus.Data.TYPE;

/**
 * Created by jared on 10/13/15.
 */
public class InvalidColumnException extends Exception{
	public InvalidColumnException(int s1, int s2) {
		super("Column of size " + s1 + " expected size " + s2);
	}


}
