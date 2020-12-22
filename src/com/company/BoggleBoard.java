package com.company;


import java.util.*;

public class BoggleBoard {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        };
        String[] words = new String[] {
                "this",
                "is",
                "not",
                "a",
                "simple",
                "boggle",
                "board",
                "test",
                "REPEATED",
                "NOTRE-PEATED"
        };

        boggleBoard(board, words);

    }

    public static List<String> boggleBoard(char[][] board, String[] words) { //bat, banana, cat b 0,1 c 2

        //build map char, word.charat(0)
        Map<Character, Set<Integer>> map = new HashMap();

        for (int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i].charAt(0), e -> new HashSet()).add(i);
        }
        Set<String> set = new HashSet();
        //for each m, n in board
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                char ch = board[row][col];
                if (map.containsKey(ch)) {
                    Set<Integer> nums = map.get(ch);

                    for (int n : nums) {
                        if (!set.contains(words[n]) && dfs(words[n].toCharArray(), row, col, board, new boolean[rows][cols], 1)) {

                            //if we found word, remove pos from map
                            //if map get char list size is zero, remove key
                            //if map.size is empty, return our list of words
                            set.add(words[n]);


                        }
                    }
                }

            }
        }
        set.forEach(System.out::println);
        return new ArrayList<>(set);
    }

    static boolean dfs(char word[], int row, int col, char[][] board, boolean[][] visited, int depth) {
        if (depth == word.length) return true;
        visited[row][col] = true;

        Set<Pair> nextToVisit = checkNeighbors(word[depth], row, col, board, visited);
        for (Pair coords : nextToVisit) {
            if (dfs(word, coords.row, coords.col, board, visited, depth + 1)) return true;
        }
        //backtrack visited for next check
        visited[row][col] = false;
        return false;
    }

    static boolean isValidNeighbor(char ch, int row, int col, char[][] board, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;
        return (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col] && board[row][col] == ch);
    }

    static Set<Pair> checkNeighbors(char ch, int row, int col, char[][] board, boolean[][] visited) {
        //check each l,r,u,d,diag
        Set<Pair> pairs = new HashSet();
        if (isValidNeighbor(ch, row - 1, col, board, visited)) pairs.add(new Pair(row - 1, col));
        if (isValidNeighbor(ch, row - 1, col - 1, board, visited)) pairs.add(new Pair(row - 1, col - 1));
        if (isValidNeighbor(ch, row - 1, col + 1, board, visited)) pairs.add(new Pair(row - 1, col + 1));

        if (isValidNeighbor(ch, row + 1, col, board, visited)) pairs.add(new Pair(row + 1, col));
        if (isValidNeighbor(ch, row + 1, col - 1, board, visited)) pairs.add(new Pair(row + 1, col - 1));
        if (isValidNeighbor(ch, row + 1, col + 1, board, visited)) pairs.add(new Pair(row + 1, col + 1));

        if (isValidNeighbor(ch, row, col - 1, board, visited)) pairs.add(new Pair(row, col - 1));
        if (isValidNeighbor(ch, row, col + 1, board, visited)) pairs.add(new Pair(row, col + 1));
        return pairs;
    }


    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}