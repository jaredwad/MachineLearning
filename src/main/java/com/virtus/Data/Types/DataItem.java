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
public interface DataItem {
    TYPE getType();
    
    double distance(DataItem otherItem) throws InvalidTYPEException;
}
