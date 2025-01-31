package org.enumClass.enumClassStudy.orderStatus;

public class DecreaseStockStrategy implements StockStrategy{
    
    // 재고 감소 로직
    @Override
    public void handleStock(String item) {
        System.out.println(item + "재고 감소");    
    }
}
