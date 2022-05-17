package com.mason.fp.baseLambda;


/**
 * @author Mason
 * @Description 函数编程的运用
 * @date 2022/5/10 14:52
 */
public class Strategize {
    Strategy strategy;
    String msg;

    public Strategize(String msg) {
        strategy = new Soft();
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {

       // 函数式接口是一种单一抽象方法的接口
       // 类通过为接口中的所有方法提供实现来实现任何接口，
     // 这可以通过顶级类、内部类、甚至匿名内部类完成

        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0, 5),  //Lambda函数的使用
                Unrelated::twice  // 方法引用
                // 我们可以将Lambda表达式视为实现接口的匿名内部类的主体，这就是Lambda表达式与抽象方法兼容的原因
                // 其参数类型和返回蕾西必须匹配该方法的签名。Lambda表达式属于函数式接口中单一抽象方法的实现和将Lambda
                //表达式赋给函数式接口表示相同的含义。
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();

        for (Strategy newStrategy : strategies) {
            s.changeStrategy(newStrategy);
            s.communicate();


        }
    }
}
