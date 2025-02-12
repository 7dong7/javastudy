package org.collectionFrameWork.list.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue q = new LinkedList(); // queue 의 구현체 LinkedList 를 사용해서 구현

        st.push("0");
        st.push("1");
        st.push("2");

        q.offer("0");
        q.offer("1");
        q.offer("2");

        System.out.println("=== stack ===");
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }

        System.out.println("=== queue ===");
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
