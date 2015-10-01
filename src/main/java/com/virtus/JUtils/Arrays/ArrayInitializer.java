/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.JUtils.Arrays;

import com.virtus.JMath.Shuffler;
import com.virtus.JUtils.Rand;

/**
 *
 * @author jared
 */
public final class ArrayInitializer {
    public static int[] random(int pSize, int pMax, int pMin) {
        int array[] = new int[pSize];
        
        for(int i = 0; i < pSize; i++) {
            array[i] = Rand.Int(pMax, pMin);
        }
        return array;
    }
    
    public static double[] randomDouble(int pSize, double pMax, double pMin) {
        double array[] = new double[pSize];
        
        for(int i = 0; i < pSize; i++) {
            array[i] = Rand.Double(pMax, pMin);
        }
        return array;
    }
    
    public static int[] sequential(int pSize) { return sequential(pSize, 0); }
    public static int[] sequential(int pSize, int pStart) {
        int array[] = new int[pSize];
        
        for(int i = 0; i < pSize; i++) {
            array[i] = i + pStart;
        }
        return array;
    }
    
    public static int[] sequentialShuffled(int pSize) {
        return sequentialShuffled(pSize, 0);
    }
    public static int[] sequentialShuffled(int pSize, int pStart) {
        return Shuffler.FisherYates(sequential(pSize, pStart));
    }
}
