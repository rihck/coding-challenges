package main.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        int listCount = 0;

        while(currentNode != null){
            listCount++;

            currentNode = currentNode.next;
        }

        System.out.println("listCount = " + listCount);

        int loopUntil;
//        if(listCount % 2 == 0)
            loopUntil = listCount / 2;
//        else
//            loopUntil = listCount / 2;

        float y = (float) listCount/2;
        System.out.println(y);
        System.out.println(Math.round(y));
        System.out.println(Math.floor(y));

        System.out.println("loopUntil = " + loopUntil);
        currentNode = head;
        for(int i = 1; i <= loopUntil; i++){
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    @Test
    public void evenCase(){
        ListNode six = new ListNode(6);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode tree = new ListNode(3, four);
        ListNode two = new ListNode(2, tree);
        ListNode one = new ListNode(1, two);

        Assert.assertEquals(four, middleNode(one));
    }

    @Test
    public void oddCase(){
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode tree = new ListNode(3, four);
        ListNode two = new ListNode(2, tree);
        ListNode one = new ListNode(1, two);

        Assert.assertEquals(tree, middleNode(one));
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
