/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.JLL.SemiSupervised;

import com.virtus.Data.Row;
import com.virtus.Data.Set;
import com.virtus.Data.TYPE;
import com.virtus.JUtils.Rand;
import java.util.List;

/**
 *
 * @author jared
 */
public abstract class ITest implements Runnable {
    protected Set training;
    protected Set test;
    
    protected ITest(double pPercentTest, Set pData) {
        splitData(pPercentTest, pData);
    }

    protected void initializeDataSets(Set pData) {
        training = new Set();
        test     = new Set();
        
        List<TYPE> types = pData.Types();
        List<String> names = pData.ColNames();
        
        int numCols = pData.NumColumns();
        
        for(int i = 0; i < numCols; ++i) {
            training.addColumn(names.get(i), types.get(i));
            test    .addColumn(names.get(i), types.get(i));
        }
    }

    private void splitData(double pPercentTest, Set pData) {
        initializeDataSets(pData);

        int numRows = pData.NumRows();
        
        for(int i = 0; i < numRows; ++i) {
            Row row = pData.getRow(i);
            
            if(Rand.Bool(pPercentTest)) {
                test.addRow(row);
            } else {
                training.addRow(row);
            }
        }
    }
    
    
}
