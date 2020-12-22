package com.company;

import java.util.*;

public class WordsInPhoneNumber {
    public static void main(String[] args) {
        String[] str = new String[] { "foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"};

        List<String> list = wordsInPhoneNumber("3662277", str);
        list.forEach(System.out::println);
    }
    public static List<String> wordsInPhoneNumber(String phoneNumber, String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> set = new HashSet();
        for (int i = 0; i < phoneNumber.length(); i++) {
            dfs(trie.root, set, phoneNumber, i, buildMap());
        }

        List<String> list = new ArrayList(set);
        return list;


    }

    static void dfs(TrieNode trie,
                    Set<String> wordSet,
                    String phoneNumber,
                    int position,
                    Map<Character, Set<Character>> dictionary) {
        if (trie.isWord) wordSet.add(trie.word);
        if (position >= phoneNumber.length()) return;


        Set<Character> set = dictionary.getOrDefault((phoneNumber.charAt(position)),
                new HashSet<Character>());

        for (Character ch : set) {
            if (trie.children.containsKey(ch)) {
                dfs(trie.children.get(ch), wordSet, phoneNumber, position+1, dictionary);
            }

        }



    }

    static Map<Character, Set<Character>> buildMap() {
        Map<Character, Set<Character>> map = new HashMap();
        map.put('2', new HashSet(Set.of('a','b','c')));
        map.put('3', new HashSet(Set.of('d','e','f')));
        map.put('4', new HashSet(Set.of('g','h','i')));
        map.put('5', new HashSet(Set.of('j','k','l')));
        map.put('6', new HashSet(Set.of('m','n','o')));
        map.put('7', new HashSet(Set.of('p','q','r','s')));
        map.put('8', new HashSet(Set.of('t','u','v')));
        map.put('9', new HashSet(Set.of('w','x','y')));
        return map;

    }

    static class Trie {
        TrieNode root = new TrieNode();

        public Trie() {

        }

        void insert(String word) {
            TrieNode trie = root;

            for (char ch : word.toCharArray()) {
                trie = trie.children.computeIfAbsent(ch, t -> new TrieNode());
            }
            trie.isWord = true;
            trie.word = word;
        }
    }

    static class TrieNode {
        public Map<Character, TrieNode> children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
            word = "";
        }

    }
}

