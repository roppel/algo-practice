package com.company;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        List<Integer> list = spiralTraverse(new int[][]{
                {1,   2,  3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10,  9,  8, 7},
        });

        list.forEach(i -> System.out.print(i + ","));
    }
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> list = new ArrayList();
        int startCol = 0, startRow = 0;
        int endCol = array[0].length-1, endRow = array.length-1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int col = startCol; col <= endCol; col++) {
                list.add(array[startRow][col]);
            }

            for (int row = startRow+1; row <= endRow; row++) {
                list.add(array[row][endCol]);
            }

            for (int col = endCol-1; col >= startCol; col--) {
                //would have handled this row in loop 1
                if (startRow == endRow) break;

                list.add(array[endRow][col]);
            }

            //we stop before row == startRow, which equals
            //our start position in loop 1
            for (int row = endRow-1; row > startRow; row--) {
                //would have handled this column in loop 2
                if (startCol == endCol) break;

                list.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return list;
    }
}
