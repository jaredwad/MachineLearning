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
public class Numeric  implements DataItem {

    double value;

	public Numeric(double pValue) {
		value = pValue;
	}

	public double getValue() {return value;}

	public void updateValue(double pValue) {
		value = pValue;
	}

    @Override
    public TYPE getType() {
		return TYPE.Numeric;
    }

    @Override
    public double distance(DataItem otherItem) throws Exception {
		return 1;
    }
    
}
