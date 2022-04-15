package com.mason.ATD.chapter06.stock;

import com.mason.ATD.chapter06.DequeInterface;
import com.mason.ATD.chapter06.LinkedDeque;

/**
 * 使用双端队列进行优化
 *
 * @author ShiYong
 * @create 2022-04-11 17:27
 **/
public class StockLedger02 {
    private DequeInterface<StockPurchase02> ledger;

    public StockLedger02() {
        ledger = new LinkedDeque<>();
    }

    /**
     * Records a stock purchase in this ledger
     *
     * @param shareBought  The number of shares purchased
     * @param costPerShare The price per share
     */
    public void buy(int shareBought, double costPerShare) {
        if (shareBought > 0) {
            StockPurchase02 stockPurchase = new StockPurchase02(shareBought, costPerShare);
            ledger.addToBack(stockPurchase);
        }


    }

    /**
     * Remove from this ledger any shares that were sole and computers
     * the capital gain or loss
     *
     * @param shareSold    The number of shares purchased
     * @param costPerShare The price per share
     * @return
     */
    public double sell(int shareSold, double costPerShare) {
        //销售费用
        double saleAmount = shareSold * costPerShare;
        double totalCost = 0;

        while (shareSold > 0) {
            StockPurchase02 transaction = ledger.removeFront();
            double shareCost = transaction.getCost();
            int numberOfShare = transaction.getShare();

            //比较这次出售数量买入的数量是否相等,小于则要将剩余的重新放入头结点
            if (numberOfShare > shareSold) {
                totalCost = totalCost + shareCost * shareSold;
                int numberOfPutBack = numberOfShare - shareSold;
                StockPurchase02 leftOver = new StockPurchase02(numberOfPutBack, shareCost);
                ledger.addToFront(leftOver);

            } else
                totalCost = totalCost + shareCost * numberOfShare;
            shareSold = shareSold - numberOfShare;


        }
        return saleAmount - totalCost;

    }


}
