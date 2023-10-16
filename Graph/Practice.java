package Graph;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
class customcmp implements Comparator<Integer>{
    @Override
    public int compare(Integer n1,Integer n2)
    {
        int value = n1.compareTo(n2);
        if(value>0) return -1;
        else if(value<0) return 1;
        else return 0;
    }
}

public class Practice {
    void display(){
        PriorityQueue<Integer> num= new PriorityQueue<>(new customcmp());//min queue -> max queue
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->(a[0]-b[0])); // min queue
        Deque<Integer> dq= new ArrayDeque<>(); // new LinkedList<>();
        dq.addFirst(2);
        dq.getFirst();
        dq.pollFirst();


        //string

        String s= new String("HelloWorld!");
        s.contains("Hello");
        s.substring(0, 2);
        String str = s.join("_", "hello");
        System.out.println(str);
        s.replace("hello", str);
        s.charAt(2);
        s.indexOf('a');
        StringBuilder str1= new StringBuilder();
        str1.append("new");
        str1.insert(2, "book");
        str1.delete(2, 4);
        str1.reverse();

    }
    public static void main(String[] args) {
        System.out.print("practicing String functions");
    }
}
