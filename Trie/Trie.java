package Trie;

class Node{
    Node[] links=new Node[26];
    boolean flag=false;

    Node(){
        //there no need for initialiation.
    }

    boolean containsKey(char ch){
        if(links[ch-'a']==null){
            return false;
        }
        return true;
    }

    void put(char ch,Node node){
        links[ch-'a']=node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}

public class Trie {
    Node root;
    //constructor
    public Trie(){
        root=new Node();
    }

    //insert into trie data structure
    public void insert(String word){
        Node temp=root;
        for(int i=0;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))){
                //does not contains the put it there
                temp.put(word.charAt(i),new Node());
            }
            // move to referance node after i
            temp=temp.get(word.charAt(i));
        }
        //end of word
        temp.setEnd();
    }

    //search the word
    public boolean search(String word){
        //code of implementations
        Node temp= root;
        for(int i=0;i<word.length();i++){
            if(temp.containsKey(word.charAt(i))){
                temp=temp.get(word.charAt(i));
            }else{
                return false;
            }
        }
        if(temp.isEnd())
            return true;
        return false;
    }

    //start work with 
    public boolean prefix(String preword){
        //code of implementations
        Node temp=root;
        for(int i=0;i<preword.length();i++){
            if(!temp.containsKey(preword.charAt(i))){
                return false;
            }
            temp=temp.get(preword.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Trie data structure");
        Trie obj=new Trie();
        obj.insert("apple");
        obj.insert("apps");
        obj.insert("apnl");
        obj.insert("bac");
        obj.insert("bat");

        System.out.println(obj.search("apps"));
        System.out.println(obj.search("app"));
        System.out.println(obj.search("apples"));

        System.out.println(obj.prefix("app"));
        System.out.println(obj.prefix("apples"));
        System.out.println(obj.prefix("ba"));
    }
}
