package com.mason.ATD.List;

/**
 * 空数组异常类
 *
 * @author ShiYong
 * @create 2022-04-13 15:30
 **/
public class EmptyArrayException extends RuntimeException{


    public EmptyArrayException(){
        this(null);
    }
    public EmptyArrayException(String message){
        super(message);
    }
}
