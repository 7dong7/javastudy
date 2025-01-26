package org.enumClassStudy.orderStatus;

public class HoldStockStrategy implements StockStrategy {

    // 재고 유지 로직
    @Override
    public void handleStock(String item) {
        System.out.println(item + "재고 유지");
    }
}
