package org.enumClass.enumClassStudy;

public enum Day {
    MONDAY("월요일"){
        @Override
        public void doWork() {
            System.out.println("koreaDay = " + getKoreaDay());
            System.out.println("오늘 미팅");
        }
    },
    TUESDAY("화요일") {
        @Override
        public void doWork() {
            System.out.println("koreaDay = " + getKoreaDay());
            System.out.println("오늘 도 야근");
        }
    },
    WEDNESDAY("수요일") {
        @Override
        public void doWork() {
            System.out.println("koreaDay = " + getKoreaDay());
            System.out.println("오늘 야근");
        }
    },
    THURSDAY("목요일") {
        @Override
        public void doWork() {
            System.out.println("koreaDay = " + getKoreaDay());
            System.out.println("오늘 휴가");
        }
    },
    FRIDAY("금요일") {
        @Override
        public void doWork() {
            System.out.println("koreaDay = " + getKoreaDay());
            System.out.println("오늘 반차");
        }
    },
    SATURDAY("토요일") {
        @Override
        public void doWork() {
            System.out.println("koreaDay = " + getKoreaDay());
            System.out.println("주말 쉼");
        }
    },
    SUNDAY("일요일") {
        @Override
        public void doWork() {
            System.out.println("koreaDay = " + getKoreaDay());
            System.out.println("주말 또 쉼");
        }
    };

    private final String koreaDay;

    Day(String koreaDay) {
        this.koreaDay = koreaDay;
    }

    public String getKoreaDay() {
        return koreaDay;
    }

    // 추상 메소드
    public abstract void doWork();

}
