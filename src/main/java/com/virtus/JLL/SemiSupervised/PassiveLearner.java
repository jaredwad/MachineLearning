/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.JLL.SemiSupervised;

import com.virtus.Data.Set;

/**
 *
 * @author jared
 */
public class PassiveLearner extends SemiSupervisedLearner {
    int[] testOrder;
    
    public PassiveLearner(Set pDataSet, ITest pTester, ITest pAccuracyChecker
            , float pTargetAccuracy) {
        dataSet = pDataSet;
        tester = pTester;
        accuracyChecker = pAccuracyChecker;
        targetAccuracy = pTargetAccuracy;
        
        initializeTestOrder();        
    }
    
    private void initializeTestOrder() {
        testOrder = new int[dataSet.NumRows()];
    }

    @Override
    public void run() {
        
    }
}
