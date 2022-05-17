package com.mason.fp.baseLambda;

/**
 * @author Mason
 * @Description 函数接口：
 * @date 2022/5/10 15:30
 */
public class LambdaExpressions {
    static Body bod = h -> h + "No Parens!"; //此处使用return关键字是违法的，这是Lambda表达式简化相应语法的另一种
    //方式

    static Body bod2 = (h) ->h+ "More details";

    static Description desc = () ->"Short info";

    static Multi mult = (h, n) ->h+n;

    static Description moreLines = ()->{
        //Lambda表达式需要多行，需要放在花括号里面，这时就需要使用return
        System.out.println("moreLines()");
        return "from moreLine()";
    };

    public static void main(String[] args) {
        //Lambda 表达式必须匹配接口中单一抽象方法的签名的参数类型和返回类型，这种称为与方法签名兼容
        //因此,Lambda表达式属于接口方法的实现，可以将其赋给该接口类型的引用。
        // lambda表达式通常比匿名内部类产生更易读的代码
        System.out.println(bod.detailed("Oh"));
        System.out.println(bod2.detailed("Hi"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi", 3.14159));
        System.out.println(moreLines.brief());
    }


}
