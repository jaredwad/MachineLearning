/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.JMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jared
 */
public final class Shuffler {
    public static int[] FisherYates(int pArray[]) {
        Random rnd = new Random();
        for (int i = pArray.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          int a = pArray[index];
          pArray[index] = pArray[i];
          pArray[i] = a;
        }
        return pArray;
    }
    
    public static int[] Classic(int pArray[]) {
        List<Integer> list = new ArrayList<>();
        for (int i : pArray) {
          list.add(i);
        }

        Collections.shuffle(list);
        
        for (int i = 0; i < list.size(); i++) {
          pArray[i] = list.get(i);
        }
        
        return pArray;
    }
    
    
}
