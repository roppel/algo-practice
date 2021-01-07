package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
//count number of islands, where islands are 1, water is 0
//islands are connected vertically or horizontally, but not diagonally

//takeaway - DFS is easier to read but can't handle large islands

//trying out memory stuff with DFS and BFS
//DFS will give stack overflow error if islands are substantial size, 100x100
//BFS solution was able to handle 10000x10000 matrix without heap exception locally
public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(numberOfIslands(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        }));

        //let's run out of memory
        int[][] ar = new int[10000][10000];
        for (int[] i : ar) {
            Arrays.fill(i, 1);
        }
        System.out.println(numberOfIslands(ar));
    }

    public static int numberOfIslands(int[][] islandGrid) {
        int rows = islandGrid.length;
        int cols = islandGrid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (islandGrid[r][c] == 1) {
                    count++;
                    //comment out one of these when you run
//                    DFS(islandGrid, r, c, rows, cols);
                    BFS(islandGrid, r, c, rows, cols);

                }
            }
        }
        return count;
    }

    public static void DFS(int[][] ar, int r, int c, int rows, int cols) {
        if (!validateAndReset(ar, r, c, rows, cols)) return;

        DFS(ar, r - 1, c, rows, cols);
        DFS(ar, r + 1, c, rows, cols);
        DFS(ar, r, c - 1, rows, cols);
        DFS(ar, r, c + 1, rows, cols);

    }


    public static void BFS(int[][] ar, int r, int c, int rows, int cols) {
        if (!validateAndReset(ar, r, c, rows, cols)) return;

        Deque<Tuple> queue = new ArrayDeque<Tuple>();
        queue.offer(new Tuple(r, c));
        while (!queue.isEmpty()) {
            Tuple next = queue.poll();
            r = next.row;
            c = next.col;
            if (validateAndReset(ar, r, c-1, rows, cols)) queue.offer(new Tuple(r, c-1));
            if (validateAndReset(ar, r, c+1, rows, cols)) queue.offer(new Tuple(r, c+1));
            if (validateAndReset(ar, r-1, c, rows, cols)) queue.offer(new Tuple(r-1, c));
            if (validateAndReset(ar, r+1, c, rows, cols)) queue.offer(new Tuple(r+1, c));
        }
    }

    static boolean validateAndReset(int[][] ar, int r, int c, int rows, int cols) {
        if (r >= 0 && c >= 0 && r < rows && c < cols && ar[r][c] == 1) {
            ar[r][c] = 0;
            return true;
        }
        return false;
    }

    static class Tuple {
        int row;
        int col;

        Tuple(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
