/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data.Types;

import com.virtus.Data.TYPE;
import com.virtus.exception.InvalidTYPEException;

/**
 *
 * @author jared
 */
public class Binary implements DataItem{

    private Boolean value;

    public Binary(Boolean pValue) {
        value = pValue;
    }

    public Boolean getValue() {return value;}

    public void updateValue(Boolean pValue) {
        value = pValue;
    }

    @Override
    public TYPE getType() {
        return TYPE.Binary;
    }

    @Override
    public double distance(DataItem otherItem) throws InvalidTYPEException {
        if (otherItem.getType() != TYPE.Binary) {
            throw new InvalidTYPEException(getType(), otherItem.getType());
        }

        return value == ((Binary) otherItem).getValue() ? 0 : 1;
    }

    @Override
    public Boolean equals(DataItem item) {
        return value == ((Binary) item).getValue();
    }

    @Override
	public String toString() {
		return value.toString();
	}
}
