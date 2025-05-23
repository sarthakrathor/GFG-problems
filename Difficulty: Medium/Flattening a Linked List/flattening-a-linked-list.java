//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java
// import java.util.*;
class Solution {
    // Function to flatten a linked list
    Node convertToLL(ArrayList<Integer> arr){
        if(arr.size()==0) return null;
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        for(int i =0;i<arr.size();i++){
            temp.bottom = new Node(arr.get(i));
            temp = temp.bottom;
        }
        
        return dummy.bottom;
    }
    Node flatten(Node root) {
        if(root==null || root.next == null) return root;
        // code here
        Node temp = root;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp!=null){
            Node t2 = temp;
            while(t2!=null){
                arr.add(t2.data);
                t2 = t2.bottom;
            }
            temp = temp.next;
        }
        
        Collections.sort(arr);
        return convertToLL(arr);
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends