package com.mason.ATD.chapter06.waitLine;

import com.mason.ATD.chapter06.LinkedQueue;
import com.mason.ATD.chapter06.QueueInterface;
import com.mason.ATD.chapter06.waitLine.Customer;

/**
 * 排队队列的实现
 *
 * @author ShiYong
 * @create 2022-04-11 14:24
 **/
public class WaitLine {

    private QueueInterface<Customer> line; // A queue of customes
    private int nubmerOfArrivals; //Number of customes
    private int numberOfServiced; // Number of customes actually served
    private int totalTimeWaited; // Total time customers have waited.

    public WaitLine() {
        line = new LinkedQueue<>();
        reset();

    }

    /**
     * Simulatea a waiting line with one serving agent.
     *
     * @param duration           The number of simulated minutes.
     * @param arrivalProbability A real number between 0 and 1, and the probability that a customer arrives at a given time.
     * @param maxTransactionTime The longest transaction time for a customer.
     */
    public void simulate(int duration, double arrivalProbability, int maxTransactionTime) {
        int transactionTimeLeft = 0;
        for (int clock = 0; clock < duration; clock++) {
            if (Math.random() < arrivalProbability) {
                nubmerOfArrivals++;
                int transactionTime = (int) (Math.random() * maxTransactionTime + 1);
                Customer nextArrival = new Customer(clock, transactionTime, numberOfServiced);
                line.enqueue(nextArrival);
                System.out.println("Customer " + nubmerOfArrivals + " enters line at time " + clock +
                        "  Transaction time is " + transactionTime);

            }
            //If present customer is still being served
            if (transactionTimeLeft > 0)
                transactionTimeLeft--;
            else if (!line.isEmpty()) {
                Customer nextCustomer = line.dequeue();
                transactionTimeLeft = nextCustomer.getTransctionTime() - 1;
                int timeWaited = clock - nextCustomer.getArrivalTime();
                totalTimeWaited = totalTimeWaited + timeWaited;
                numberOfServiced++;
                System.out.println("Customer " + nextCustomer.getCustomerNubmer() + " begins service at time " + clock + " Time waited is " + timeWaited);
            }

        }

    }

    /**
     * displays summary resutls of the simulation.
     */
    public void displayResults() {
        System.out.println();
        System.out.println("Number serverd = " + numberOfServiced);
        System.out.println("Total time waited = " + totalTimeWaited);
        double averageTimeWaited = ((double) totalTimeWaited) / numberOfServiced;
        System.out.println("Average time waited = " + averageTimeWaited);
        int leftInLine = nubmerOfArrivals - numberOfServiced;
        System.out.println("Number left in line = " + leftInLine);


    }

    /**
     * 重置队列中的数据
     */
    public final void reset() {
        line.clear();
        nubmerOfArrivals = 0;
        numberOfServiced = 0;
        totalTimeWaited = 0;
    }


}
