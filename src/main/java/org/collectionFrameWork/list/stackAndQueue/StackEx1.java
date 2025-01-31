package org.collectionFrameWork.list.stackAndQueue;

import java.util.Stack;

// 스택 활용
public class StackEx1 {
    public static Stack back = new Stack(); // 사이트를 방문할 때마다 이전페이지를 기록하는 스택
    public static Stack forward = new Stack(); // '뒤로' 버튼을 눌렀을 경우 생기는 스택

    public static void main(String[] args) {
        goURL("1.네이트"); // '네이트' 페이지 방문
        goURL("2.야후");
        goURL("3.네이버");
        goURL("4.다음");

        printStatus();

        goBack();
        System.out.println("= '뒤로' 버튼을 누른후 =");
        printStatus();

        goBack();
        System.out.println("= '뒤로' 버튼을 누른후 =");
        printStatus();

        goForward();
        System.out.println("= '앞으로' 버튼을 누른후 =");
        printStatus();

        goForward();
        System.out.println("= '앞으로' 버튼을 누른후 =");
        printStatus();

        goURL("codechobo.com");
        System.out.println("= 새로운 주소로 이동 후 =");
        printStatus();

        goBack();
        printStatus();
    }

    public static void printStatus() {
        System.out.println("back: " + back);
        System.out.println("forward: " + forward);
        System.out.println("현재화면은 '" + back.peek()+"' 입니다");
        System.out.println();
    }

    public static void goURL(String url) { // 페이지에 방문하는 메소드
        back.push(url); // 현재 방문한 페이지를 스택에 쌓는다
        if(!forward.isEmpty()) { // 새로운 사이트를 방문했기 때문에 현재 페이지가 스택의 가장 위에 있다  
            forward.clear(); // '앞으로'버튼으로 방문할 페이지는 없다
        }
    }

    public static void goForward() { // '앞으로'
        if(!back.isEmpty()) {
            back.push(forward.pop());
            /*
                '앞으로' 버튼을 누르면 
                forward 에서 현재 페이지를 제거하고
                제거한 값을 back 에 다시 넣는다
             */
        }
    }

    public static void goBack() { // '뒤로'
        if(!back.isEmpty()) {
            forward.push(back.pop());
        }
    }
}
