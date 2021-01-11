package com.java;
/*

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
//        int[][] ar = new int[][] {
//                { 1,  2,  3,  4},
//                { 5,  6,  7,  8},
//                { 9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
        int[][] ar = new int[][] {
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
        //        int[][] ar = new int[][] {
//                { 1,  2,  3},
//                { 4,  5,  6},
//                { 7  , 8, 9},
//        };
//        spinOne(ar, 0, 0, ar.length-1, ar[0].length-1);
//        spinOne(arFive, 0, 0, arFive.length-1, arFive[0].length-1);
//        spinNinety(ar, 0, 0, ar.length-1, ar[0].length-1);
        spinNinety(ar);
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

    //this method uses transpose to rotate 90 degrees;
    //first for loop swaps positions of rows to columns,
    //second swaps over columns to get everything in place
    //still O(MN) time as it's 2*MN
    static void rotateWithTranspose(int[][] ar)  {
        for (int r = 0; r < ar.length; r++) {
            //starting from c=r keeps us going at a diagonal
            //since it's nxn, could be ar.length, but this gives better understanding
            for (int c = r; c < ar[0].length; c++) {
                int temp = ar[r][c];
                ar[r][c] = ar[c][r];
                ar[c][r] = temp;
            }
        }

        //same note for using length here as above
        for (int c = 0, endC = ar[0].length-1; c < ar[0].length/2; c++, endC--) {
            for (int r = 0; r < ar.length; r++) {
                int temp = ar[r][c];
                ar[r][c] = ar[r][endC];
                ar[r][endC] = temp;
            }
        }

        //swap columns





    }

    //same end result as transpose, but with more intuitive approach
    //harder logic to follow than transpose
    static void spinNinety(int[][] ar) {
        int N = ar.length;

        for (int i = 0; i < N/2; i++) {
            for (int j = i; j < N-1-i; j++) {
                int temp = ar[i][j];
                ar[i][j] = ar[N-1-j][i];
                ar[N-1-j][i] = ar[N-1-i][N-1-j];
                ar[N-1-i][N-1-j] = ar[j][N-1-i];
                ar[j][N-1-i] = temp;
            }
        }


    }
}
