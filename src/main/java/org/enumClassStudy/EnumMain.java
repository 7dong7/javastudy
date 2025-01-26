package org.enumClassStudy;

public class EnumMain {

    public static void main(String[] args) {

        System.out.println("============ values ============");
        Company[] values = Company.values();
        for (Company value : values) {
            System.out.println("value = " + value +", index = " + value.ordinal());
        }

        System.out.println("============= valueOf ==============");
        Company company = Company.valueOf("LG");
        System.out.println("company = " + company + ", company.ordinal() = " + company.ordinal());

        Company company2= Company.LG;
        System.out.println("company2 = " + company2 + ", company2.ordinal() = " + company2.ordinal());

        System.out.println("============= name, getKoreaName ==============");
        String name = Company.KT.name();
        String koreanName = Company.KT.getKoreanName();
        System.out.println("name = " + name + ", koreanName = " + koreanName);

        Company company1 = Company.LG;
        System.out.println("company1.name() = " + company1.name());
        System.out.println("company1.getKoreanName() = " + company1.getKoreanName());

        System.out.println("============ ordinal ==============");
        Company lg = Company.LG;
        System.out.println("lg = " + lg + ", lg.ordinal() = " + lg.ordinal());

        System.out.println("============= toString ==============");
        String stringLg = Company.LG.toString();
        System.out.println("Company.LG.toString() = " + stringLg);

        System.out.println("==========================================");
        System.out.println("============= enum & switch ==============");
        System.out.println("==========================================");
        Company lg1 = Company.LG;

        switch (lg1) {
            case LG -> System.out.println("LG 입니다.");
            case KT -> System.out.println("KT 입니다.");
            case SK -> System.out.println("SK 입니다.");
            case APPLE -> System.out.println("APPLE 입니다.");
            case SAMSUNG -> System.out.println("SAMSUNG 입니다.");
        }

        System.out.println();

        Company apple = Company.APPLE;
        switch (apple) {
            case LG, KT, SK, SAMSUNG -> System.out.println("국내기업 입니다.");
            case APPLE -> System.out.println("해외기업 입니다.");
        }

        System.out.println("==========================================");
        System.out.println("============= override ==============");
        System.out.println("==========================================");

        Day.FRIDAY.doWork();
        Day.MONDAY.doWork();

        System.out.println("==========================================");
        System.out.println("============= strategy pattern ==============");
        System.out.println("==========================================");

        OrderStatus ordered = OrderStatus.ORDERED;
        ordered.handleStock("노트북");

        OrderStatus canceled = OrderStatus.CANCELED;
        canceled.handleStock("노트북");
    }
}
