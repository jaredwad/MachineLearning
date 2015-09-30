/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.JUtils;

import java.util.Random;

/**
 *
 * @author jared
 */
public final class Rand {
    private static final Random rand = new Random();

    public static int Int() { return Int(100,0); }
    public static int Int(int pMax) { return Int(pMax, 0); }
    
    public static int Int(int pMax, int pMin) {
	return rand.nextInt(pMax) + pMin;
        
    }

    
    public static double Double() { return Double(1,0); }
    public static double Double(double pMax) { return Double(pMax, 0); }
    public static double Double(double pMax, double pMin) {
        return pMin + (rand.nextDouble() * (pMax - pMin));
    }

    public static Boolean Bool() {
        return rand.nextBoolean();
    }
    
    public static Boolean Bool(double pProbabilityTrue) {
        return Double() < pProbabilityTrue;
    }
}
