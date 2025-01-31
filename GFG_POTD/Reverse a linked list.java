// Given the head of a linked list, the task is 
// to reverse this list and return the reversed head.

/* linked list node class:*/

import java.util.ArrayList;

class Node 
{
    int data;
    Node next;
    Node(int value) 
    {
        this.data = value;
    }
}

class Solution 
{
    Node reverseList(Node head) 
    {
        Node temp = null;
        ArrayList<Integer> list = new ArrayList<>();
        temp = head;
        
        while(temp != null)
        {
            list.add(0,temp.data);
            temp = temp.next;
        }
        
        temp = head;
        int i=0;
        while(temp != null)
        {
            temp.data = list.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }
}