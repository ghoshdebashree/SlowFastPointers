class ListNode{
    int value;
    ListNode next;
    ListNode(int value){
        this.value = value;
        this.next = null;
    }
}

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null) return true;    //1. CHECK WHETHER THE LIST IS EMPTY
        while (fast != null && fast.next != null) {            //2. FIND OUT THE MIDDLE OF THE LINKEDLIST
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHalfList = reverseList(slow);
        while(reverseHalfList != null){                         //3.AFTER REVERSE THE LINKEDLIST, CHECK THE VALUES
            if(head.value != reverseHalfList.value){
                return false;
            }
            head = head.next;
            reverseHalfList = reverseHalfList.next;
        }
        return true;
    }


    private static ListNode  reverseList(ListNode head) {     //HELPER METHOD TO FIND THE REVERSE OF THE LINKEDLIST
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(5);
        head.next = new ListNode(10);
        head.next.next = new ListNode(20);
        head.next.next.next = new ListNode(20);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(7);
        System.out.println("Is the linked list a palindrome? " + isPalindrome(head));
    }

}
