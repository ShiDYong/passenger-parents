package com.mason.ATD;

/**
 * 扑满的类
 * A class that implements a piggy bank
 * by using a bag.
 * @author ShiYong
 * @create 2022-03-28 15:44
 **/
public class PiggyBank {
    private BagInterface<Coin> conis;

    public PiggyBank(){
        conis = new Bag();
    }

    //add end
    public boolean add(Coin aCoin){
       return conis.add(aCoin);
    }

    //remoce end
    public Coin remove(){
        return conis.remove();
    }

    //isEmpty

    public boolean isEmpty(){
        return conis.isEmpty();
    }

}
