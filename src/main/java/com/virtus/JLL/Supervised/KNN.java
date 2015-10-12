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
import com.virtus.Data.Types.Discrete;
import com.virtus.JLL.SemiSupervised.ITest;
import com.virtus.exception.InvalidTYPEException;
import javafx.util.Pair;

import java.util.*;

/**
 *
 * @author jared
 */
public class KNN extends ITest {

    private int numNeighbors;
	private int numCorrect;
	private int numFalse;


	KNN (Set pData) { this(pData, 3, .7); }
    KNN (Set pData, int pNumNeighbors) { this(pData, pNumNeighbors, .7); }
    KNN (Set pData, int pNumNeighbors, double pPercentTest) {
        super(pPercentTest, pData);
        numNeighbors = pNumNeighbors;
		numCorrect = 0;
		numFalse = 0;
    }
    
    @Override
    public void run() {
		List<Row> rows = test.getRows();
		int len = rows.size();


        for(int i = 0; i < len; ++i) {
			try {
				DataItem pred = mostCommon(getNeighbors(rows.get(i)));
				DataItem act  = test.getClassification(i);

				if(pred.equals(act)) { numCorrect++; }
				else                 { numFalse  ++; }
			} catch (InvalidTYPEException e) {
				e.printStackTrace();
			}
		}
    }

	public int getCorrect() { return numCorrect; }
	public int getFalse()   { return numFalse;   }

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

        //TODO erase this
        for(int i = 0; i < numRows; ++i) {
            System.out.println(neighbors.get(i));
        }

        ArrayList<DataItem> kNeighbors = new ArrayList<>(numNeighbors);

        for(int i = 0; i < numNeighbors; ++i) {
            kNeighbors.add(training.getClassification(neighbors.get(i).row));
        }

        return kNeighbors;
    }

	public static DataItem mostCommon(List<DataItem> list) {
		Map<DataItem, Integer> map = new HashMap<>();

		System.out.println("The list contains the values: ");

		for (DataItem t : list) {
			System.out.println("\t" + ((Discrete)t).getValue());

			Integer val = map.get(t);
			map.put(t, val == null ? 1 : val + 1);
		}

		Map.Entry<DataItem, Integer> max = null;

		for (Map.Entry<DataItem, Integer> e : map.entrySet()) {
			if (max == null || e.getValue() > max.getValue())
				max = e;
		}

		System.out.print  ("The most common value was: ");
		System.out.println(((Discrete)max.getKey()).getValue() + "\n");
		return max.getKey();
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
