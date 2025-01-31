// You are given a special linked list with n nodes where 
// each node has two pointers a next pointer that points 
// to the next node of the singly linked list, and a random 
// pointer that points to the random node of the linked list.

// Construct a copy of this linked list. The copy should 
// consist of the same number of new nodes, where each new 
// node has the value corresponding to its original node. 
// Both the next and random pointer of the new nodes should 
// point to new nodes in the copied list, such that it also 
// represent the same list state. None of the pointers in the 
// new list should point to nodes in the original list.

// Return the head of the copied linked list.

// NOTE : Original linked list should remain unchanged.


class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

class Solution {
    public Node cloneLinkedList(Node head) 
    {
        if(head == null)
        {
            return head;
        }
        
        Node temp = head;
        while(temp != null)
        {
            Node newn = new Node(temp.data);
            newn.next = temp.next;
            temp.next = newn;
            temp = newn.next;
        }
        
        temp = head;
        Node head2 = temp.next;
        
        while(temp != null)
        {
            if(temp.random != null)
            {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;          
        }
        
        Node temp2 = null;
        temp = head;
        
        while(temp != null)
        {
            temp2 = temp.next;
            temp.next = temp2.next;
            if(temp.next != null)
            {
                temp2.next = temp2.next.next;
            }
            temp = temp.next;
        }
        
        return head2;
    }
}