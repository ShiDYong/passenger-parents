package com.mason.fp.baseLambda;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/5/10 14:47
 */
public class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}
