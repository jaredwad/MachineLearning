/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.Data.Types;

import com.virtus.Data.TYPE;

/**
 *
 * @author jared
 */
public class Discrete  implements DataItem {

    String value;

	public Discrete(String pValue) {
		value = pValue;
	}

	public String getValue() {return value;}

	public void updateValue(String pValue) {
		value = pValue;
	}
    @Override
    public TYPE getType() {
		return TYPE.Discrete;
    }

    @Override
    public double distance(DataItem otherItem) throws Exception {
		return value.equalsIgnoreCase(((Discrete)otherItem).getValue()) ? 0 : 1;
    }
}
