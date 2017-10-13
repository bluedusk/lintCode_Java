package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Lenovo on 2017/10/11.
 * http://www.lintcode.com/en/problem/add-and-search-word/
 * http://www.jiuzhang.com/solution/add-and-search-word/
 *
 * 用字典树实现，有几种实现方式，参见九章。
 * 参见 implement trie
 *
 */
public class AddSearchWord {

    // version1 : array //////////////////////////////////////////////////////////////

    /**
     * 实现上和implement trie不太一样，implement trie是用递归insert
     * 这里是循环；
     */
    class TrieNode {
        // 下一个字母
        public TrieNode[] children;
        // 是否有字母
        public boolean hasWord;

        public TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; ++i)
                children[i] = null;
            hasWord = false;
        }
    }

    class WordDictionary {
        private TrieNode root;

        public WordDictionary(){
            root = new TrieNode();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            // Write your code here
            TrieNode now = root;
            for(int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (now.children[c - 'a'] == null) {
                    now.children[c - 'a'] = new TrieNode();
                }
                // 移动到末端
                now = now.children[c - 'a'];
            }
            now.hasWord = true;
        }

        boolean find(String word, int index, TrieNode now) {
            if(index == word.length()) {
                return now.hasWord;
            }

            Character c = word.charAt(index);
            if (c == '.') {
                // 如果是.则搜索26个字母
                for(int i = 0; i < 26; ++i)
                    if (now.children[i] != null) {
                        if (find(word, index+1, now.children[i]))
                            return true;
                    }
                return false;
            } else if (now.children[c - 'a'] != null) {
                return find(word, index+1, now.children[c - 'a']);
            } else {
                return false;
            }
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            // Write your code here
            return find(word, 0, root);
        }
    }


    // Version 2 use HashMap and dfs //////////////////////////////////////////
    class Solution2{

        class TrieNode {
            // Initialize your data structure here.
            public HashMap<Character, TrieNode> children;
            public boolean hasWord;

            // Initialize your data structure here.
            public TrieNode() {
                children = new HashMap<Character, TrieNode>();
                hasWord = false;
            }
        }
        class WordDictionary {
            private TrieNode root;

            public WordDictionary(){
                root = new TrieNode();
            }

            // Adds a word into the data structure.
            public void addWord(String word) {
                // Write your code here
                TrieNode now = root;
                for(int i = 0; i < word.length(); i++) {
                    Character c = word.charAt(i);
                    if (!now.children.containsKey(c)) {
                        now.children.put(c, new TrieNode());
                    }
                    now = now.children.get(c);
                }
                now.hasWord = true;
            }

            boolean find(String word, int index, TrieNode now) {
                if(index == word.length()){
                    if(now.children.size()==0)
                        return true;
                    else
                        return false;
                }

                Character c = word.charAt(index);
                if (now.children.containsKey(c)) {
                    if(index == word.length()-1 && now.children.get(c).hasWord){
                        return true;
                    }
                    return find(word, index+1, now.children.get(c)) ;
                }else if(c == '.'){
                    boolean result = false;
                    for(Map.Entry<Character, TrieNode> child: now.children.entrySet()){
                        if(index == word.length()-1 && child.getValue().hasWord){
                            return true;
                        }

                        //if any path is true, set result to be true;
                        if(find(word, index+1, child.getValue()) ){
                            result = true;
                        }
                    }

                    return result;
                }else{
                    return false;
                }
            }

            // Returns if the word is in the data structure. A word could
            // contain the dot character '.' to represent any one letter.
            public boolean search(String word) {
                // Write your code here
                return find(word, 0, root);
            }
        }
    }


    //version 3: use HashMap and bfs
    class Solution3{
        class TrieNode{
            public Map<Character,TrieNode> children;
            public boolean hasWord;
            public TrieNode(){
                children=new HashMap<>();
                hasWord=false;
            }
        }

        public class WordDictionary {
            TrieNode root;
            public WordDictionary(){
                root=new TrieNode();
            }

            // Adds a word into the data structure.
            public void addWord(String word) {
                // Write your code here
                TrieNode cur=root;
                for(int i=0;i<word.length();++i){
                    char c=word.charAt(i);
                    TrieNode nextNode=cur.children.get(c);
                    if(nextNode==null){
                        nextNode=new TrieNode();
                        cur.children.put(c,nextNode);
                    }
                    cur=nextNode;
                }
                cur.hasWord=true;
            }

            // Returns if the word is in the data structure. A word could
            // contain the dot character '.' to represent any one letter.
            public boolean search(String word) {
                // Write your code here
                Queue<TrieNode> nexts=new LinkedList<>();
                nexts.add(root);
                int index=0;
                while(!nexts.isEmpty()){
                    int size=nexts.size();
                    char c=word.charAt(index);
                    boolean flag=false;
                    for(int i=0;i<size;++i){
                        TrieNode cur=nexts.poll();
                        if(c=='.'){
                            for(TrieNode tempNode:cur.children.values()){
                                nexts.add(tempNode);
                                flag|=tempNode.hasWord;
                            }
                        } else if(cur.children.containsKey(c)){
                            TrieNode nextNode=cur.children.get(c);
                            flag|=nextNode.hasWord;
                            nexts.add(nextNode);
                        }
                    }
                    index++;
                    if(index>=word.length()) return flag;
                }
                return false;
            }
        }
    }




}
