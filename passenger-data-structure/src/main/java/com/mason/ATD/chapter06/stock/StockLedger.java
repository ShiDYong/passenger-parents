package com.mason.ATD.chapter06.stock;

import com.mason.ATD.chapter06.LinkedQueue;
import com.mason.ATD.chapter06.QueueInterface;

/**
 * 股票总账类
 * A class that records the purchase and sale of
 * stocks, and provides the capital gain or loss.
 *
 * @author ShiYong
 * @create 2022-04-11 16:34
 **/
public class StockLedger {
    private QueueInterface<StockPurchase> ledger;

    public StockLedger() {
        ledger = new LinkedQueue<>();
    }

    /**
     * Records a stock purchase in this ledger
     *
     * @param shareBought   The number of shares purchased
     * @param pricePerShare The price per share
     */
    public void buy(int shareBought, double pricePerShare) {
        while (shareBought > 0) {
            StockPurchase purchase = new StockPurchase(pricePerShare);
            ledger.enqueue(purchase);
            shareBought--;
        }

    }

    /**
     * Remove from this ledger any shares that were sole and computers
     * the capital gain or loss
     *  @param shareSold     The number of shares purchased
     * @param pricePerShare The price per share
     * @return
     */
    public double sell(int shareSold, double pricePerShare) {
        double saleAmount = shareSold * pricePerShare;
        double totalCost = 0;
        while (shareSold > 0) {
            StockPurchase share = ledger.dequeue();
            double shareCost = share.getPrice();
            totalCost = shareCost + totalCost;
            shareSold--;
        }

        return saleAmount - totalCost;

    }

}
