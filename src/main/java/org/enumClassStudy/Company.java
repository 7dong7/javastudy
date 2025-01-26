package org.enumClassStudy;

public enum Company {
    SK("에스케이"),
    LG("엘쥐"),
    KT("케이티"),
    SAMSUNG("samsung company"),
    APPLE("애플");

    private final String koreanName;

    Company(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
