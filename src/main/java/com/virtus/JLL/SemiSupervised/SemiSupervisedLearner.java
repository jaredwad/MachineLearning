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
public abstract class SemiSupervisedLearner {
    protected Set dataSet;
    
    protected ITest tester;
    protected ITest accuracyChecker;
    
    protected float targetAccuracy;
    
}
