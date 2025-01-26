package org.enumClassStudy;

import org.enumClassStudy.orderStatus.DecreaseStockStrategy;
import org.enumClassStudy.orderStatus.HoldStockStrategy;
import org.enumClassStudy.orderStatus.RestoreStockStrategy;
import org.enumClassStudy.orderStatus.StockStrategy;

public enum OrderStatus {
    ORDERED(new DecreaseStockStrategy()),   // 주문 완료, 재고 감소
    CANCELED(new RestoreStockStrategy()),   // 주문 취소, 재고 복원
    DELIVERED(new HoldStockStrategy());     // 배송 완료, 재고 변경 없음

    private final StockStrategy stockStrategy;

    OrderStatus(StockStrategy stockStrategy) {
        this.stockStrategy = stockStrategy;
    }

    public void handleStock(String item) {
        stockStrategy.handleStock(item);
    }

}
