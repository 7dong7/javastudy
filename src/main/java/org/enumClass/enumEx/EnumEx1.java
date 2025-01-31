package org.enumClass.enumEx;

// enum 정의
enum Direction {EAST, SOUTH, WEST, NORTH;}

public class EnumEx1 {
    public static void main(String[] args) {
        // enum 사용
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        // 값 확인
        System.out.println("d1 = " + d1); // d1 = EAST
        System.out.println("d2 = " + d2); // d2 = WEST
        System.out.println("d3 = " + d3); // d3 = EAST

        System.out.println("\nd1 == d2 ? " + (d1 == d2));   // d1 == d2 ? false
        System.out.println("d1 == d3 ? " + (d1 == d3));     // d1 == d3 ? true
        System.out.println("d1.equals(d3) ? = " + d1.equals(d3)); // d1.equals(d3) ? = true
//        System.out.println("d2 > d3 = " + (d2 > d3)); // 에러
        System.out.println("(d1.compareTo(d3)) = " + (d1.compareTo(d3))); // (d1.compareTo(d3)) = 0
        System.out.println("(d1.compareTo(d2)) = " + (d1.compareTo(d2)) +"\n"); // (d1.compareTo(d2)) = -2

        switch (d1) { 
            // EAST 를 Direction.EAST 라고 쓸 수 없음
            case EAST -> System.out.println("The direction is EAST");
            case SOUTH -> System.out.println("The direction is SOUTH");
            case WEST -> System.out.println("The direction is WEST");
            case NORTH -> System.out.println("The direction is NORTH");
        }

        Direction[] arr = Direction.values();

        System.out.println();
        for (Direction direction : arr) {
            System.out.printf("%s = %d%n", direction.name(), direction.ordinal());
        }

        Direction east = Direction.EAST;
        System.out.println("east = " + east);
    }
}
