package com.monthlychallengemay.day14;

class Trie {

	class Node {
		char val;
		boolean isWord;
		Node[] children;

		public Node(char val) {
			this.val = val;
			this.children = new Node[26];
		}
	}

	Node root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node(' ');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new Node(c);
			}
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				return false;
			}
			node = node.children[c - 'a'];
		}
		return node.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node node = root;
		for (char c : prefix.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				return false;
			}
			node = node.children[c - 'a'];
		}
		return true;
	}

	public static void main(String[] args) {
		/**
		 * Your Trie object will be instantiated and called as such: Trie obj = new
		 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
		 * = obj.startsWith(prefix);
		 */

		Trie trie = new Trie();

		trie.insert("apple");
		trie.search("apple"); // returns true
		trie.search("app"); // returns false
		trie.startsWith("app"); // returns true
		trie.insert("app");
		trie.search("app"); // returns true

	}
}
