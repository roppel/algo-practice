package com.java;
/*
  https://www.algoexpert.io/assessments/Spin%20Rings
https://www.techiedelight.com/place-rotate-matrix-90-degrees-clock-wise-direction/
https://javabypatel.blogspot.com/2016/11/rotate-matrix-by-90-degree-java.html
https://www.devglan.com/java-programs/java-program-matrix-rotation
https://codereview.stackexchange.com/questions/120406/rotate-matrix-90-degrees-clockwise

  Write a function that takes in a square-shaped (n x n) two-dimensional array
          representing a set of rings. For instance, a 4 x 4 array is made up of the
          following two rings:
 input= [
  [ 1,  2,  3,  4],
  [ 5,  6,  7,  8],
  [ 9, 10, 11, 12],
  [13, 14, 15, 16]
]
returns
[
  [ 5,  1,  2,  3],
  [ 9, 10,  6,  4],
  [13, 11,  7,  8],
  [14, 15, 16, 12]
]

 */




public class SpinRings {
    public static void main(String[] args) {
        int[][] ar = new int[][] {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] arFive = new int[][] {
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
//        spinOne(ar, 0, 0, ar.length-1, ar[0].length-1);
//        spinOne(arFive, 0, 0, arFive.length-1, arFive[0].length-1);
        spinNinety(ar, 0, 0, ar.length-1, ar[0].length-1);

        for (int[] row : ar) {
            for (int i : row) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }

    //this could be done recursively, for iterative array is only input you need
    static void spinOne(int[][] ar, int startRow, int startCol, int endRow, int endCol) {

        while (startRow < endRow && startCol < endCol) {
            int temp = ar[startRow][endCol];
            //temp copy first row positions over one column
            for (int col = endCol; col > startCol; col--) {
                ar[startRow][col] = ar[startRow][col-1];
            }

            for (int row = startRow; row < endRow; row++) {
                ar[row][startCol] = ar[endRow][startCol];
            }

            for (int col = startCol; col < endCol; col++) {
                ar[endRow][col] = ar[endRow][col+1];
            }

            //startRow+1 because we need to fill in our temp
            for (int row = endRow; row >startRow+1; row--) {
                ar[row][endCol] = ar[row-1][endCol];
            }
            //populate temp
            ar[startRow+1][endCol] = temp;

            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }



    }

    //basically same but use whole ar[0] and lazily copy elements you need at end
    static void spinNinety(int[][] mat, int startRow, int startCol, int endRow, int endCol)  {
//        while (startRow < endRow && startCol < endCol) {
//            int[] temp = ar[startRow];

            int N = mat.length;

//             Transpose the matrix
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < i; j++) {
//                    int temp = mat[i][j];
//                    mat[i][j] = mat[j][i];
//                    mat[j][i] = temp;
//                }
//            }

        int temp;
        final int len = mat.length;
        // For each concentric square around the middle of the matrix to rotate...
        // This value will be used as (m, n) offset when moving in.
        // Integer division by 2 will skip center if odd length.
        for (int s = 0; s < len / 2; s++)
            // for the length of this ring
            for (int i = 0; i < len - 2 * s - 1; i++) {
                temp = mat[s][s + i];
                mat[s][s + i] = mat[len - s - i - 1][s];
                mat[len - s - i - 1][s] = mat[len - s - 1][len - s - i - 1];
                mat[len - s - 1][len - s - i - 1] = mat[s + i][len - s - 1];
                mat[s + i][len - s - 1] = temp;
            }
//            // swap columns
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N / 2; j++) {
//                    int temp = mat[i][j];
//                    mat[i][j] = mat[i][N - j - 1];
//                    mat[i][N - j - 1] = temp;
//                }
//            }

//            int col = endCol, row = startRow;
//            while (col >= startCol && row < endRow) {
//                ar[startRow][col--] = ar[startCol][row++];
//            }
//
//            row = startRow+1;
//            col = startCol+1;
//            while (col <= endCol && row <= endRow) {
//                ar[row++][startCol] = ar[endRow][col++];
//            }
//
//            row = endRow-1;
//            col = startCol+1;
//            while (col <= endCol && row > startRow) {
//                ar[endRow][col++] = ar[row--][endCol];
//            }
//
//            row = endRow;
//            for (col = endCol-1; col >= startCol; col--) {
//                ar[row--][endCol] = temp[col];
//            }
//            startCol++;
//            endCol--;
//            startRow++;
//            endRow--;
//        }


    }
}
