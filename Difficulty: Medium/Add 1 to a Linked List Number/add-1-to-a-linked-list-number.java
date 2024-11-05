//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node nn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nn;
        }
        return prev;
    } 
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while(temp!=null){
            temp.data = temp.data+carry;
            if(temp.data<10){
                carry = 0;
                break;
            }else{
                temp.data=0;
            }
            temp=temp.next;
        }
        
        if(carry>0){
            Node a = new Node(1);
            head = reverse(head);
            a.next = head;
            return a;
        }
        
        return reverse(head);
    }
}
