package org.enumClass.enumClassStudy.orderStatus;

public class RestoreStockStrategy implements StockStrategy{
    
    // 재고 복원 로직
    @Override
    public void handleStock(String item) {
        System.out.println(item + "재고 복원");
    }
}
