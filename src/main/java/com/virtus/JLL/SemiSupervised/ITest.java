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
public interface ITest {
    public ITestResult runTest(Set testData);
public abstract class ITest implements Runnable {
    
    
}
