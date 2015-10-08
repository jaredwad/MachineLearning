/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtus.JLL.Supervised;

import com.virtus.Data.IColumn;
import com.virtus.Data.Row;
import com.virtus.Data.Set;
import com.virtus.Data.Types.DataItem;
import com.virtus.JLL.SemiSupervised.ITest;
import com.virtus.exception.InvalidTYPEException;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jared
 */
public class KNN extends ITest {

    private int numNeighbors;

    KNN (Set pData) { this(pData, 3, .7); }
    KNN (Set pData, int pNumNeighbors) { this(pData, pNumNeighbors, .7); }
    KNN (Set pData, int pNumNeighbors, double pPercentTest) {
        super(pPercentTest, pData);
        numNeighbors = pNumNeighbors;
    }
    
    @Override
    public void run() {
        
    }

    public List<DataItem> getNeighbors(Row row) throws InvalidTYPEException {
        IColumn classifications = training.getClassCol();
        int numRows = training.NumRows();


        if(numNeighbors > numRows)
            return classifications.getItems();

        ArrayList<Score> neighbors = new ArrayList<>(numRows);

        for(int i = 0; i < numRows; ++i) {
            neighbors.add(new Score(row.distance(training.getRow(i)), i));
        }

        Collections.sort(neighbors);

        ArrayList<DataItem> kNeighbors = new ArrayList<>(numNeighbors);

        for(int i = 0; i < numNeighbors; ++i) {
            kNeighbors.add(training.getClassification(neighbors.get(i).row));
        }

        return kNeighbors;
    }

    public DataItem getClass(List<DataItem> pItems) {
        return null;
    }

    class Score implements Comparable<Score> {
        double distance;
        int row;

        public Score(double score, int pRow) {
            this.distance = score;
            this.row = pRow;
        }

        @Override
        public int compareTo(Score o) {
            return distance < o.distance ? -1 : distance > o.distance ? 1 : 0;
        }
    }
}
