using System.Diagnostics;

namespace c_sharp.Week_1;

using System.IO;
using System;

class Solution {

    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void InsertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static void PrintSinglyLinkedList(SinglyLinkedListNode node, string sep, TextWriter textWriter) {
        while (node != null) {
            textWriter.Write(node.data);

            node = node.next;

            if (node != null) {
                textWriter.Write(sep);
            }
        }
    }

    // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static bool hasCycle(SinglyLinkedListNode head)
    {
        HashSet<SinglyLinkedListNode> visited = new HashSet<SinglyLinkedListNode>();
        while (head.next != null) {
            if (visited.Contains(head.next)) {
                return true;
            }
            visited.Add(head.next);
            head = head.next;
        }
        return false;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int tests = Convert.ToInt32(Console.ReadLine());

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = Convert.ToInt32(Console.ReadLine());

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = Convert.ToInt32(Console.ReadLine());

            for (int i = 0; i < llistCount; i++) {
                int llistItem = Convert.ToInt32(Console.ReadLine());
                llist.InsertNode(llistItem);
            }
          
          	SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
            SinglyLinkedListNode temp = llist.head;

            for (int i = 0; i < llistCount; i++) {
                if (i == index) {
                    extra = temp;
                }

                if (i != llistCount-1) {
                    temp = temp.next;
                }
            }
      
      		temp.next = extra;

            bool result = hasCycle(llist.head);

            textWriter.WriteLine((result ? 1 : 0));
        }

        textWriter.Flush();
        textWriter.Close();
    }
}
