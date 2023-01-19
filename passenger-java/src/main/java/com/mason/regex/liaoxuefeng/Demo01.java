package com.mason.regex.liaoxuefeng;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yongshi
 * @date 2023/1/19 12:38
 * @Description 正则表达式的基本入门学习：
 */
public class Demo01 {
    public static void main(String[] args) {
        /**
         * 简述：正则表达式是一种标准，可以用于任何语言，一个正则表达式就是描述规则的字符串.通过使用
         * 正则表达式可以通过正则表达式引擎去判断目标字符串是否符合规则，在工作中使用非常多，极大提高效率
         *Java标准库的java.util.regex包内置了正则表达式引擎
         */

        //1.案例1：要判断用户输入的年份是否是20##年，我们先写出规则如下：
        //一共有4个字符，分别是：2，0，0~9任意数字，0~9任意数字。
        //对应的正则表达式就是：20\d\d，其中\d表示任意一个数字。
        //把正则表达式转换为Java字符串就变成了20\\d\\d，注意Java字符串用\\表示\。
        String regex = "20\\d\\d";
        System.out.println("2019".matches(regex));
        System.out.println("2100".matches(regex));


        /**
         * 案例2：常用的匹配规则
         * 正则表达式的匹配规则是从左到右按照规则匹配
         * 对于正则表达式abc来说，它只能精确地匹配字符串"abc"，不能匹配"ab"，"Abc"，"abcd"等其他任何字符串。
         * 如果正则表达式有特殊字符，那就需要用\转义。例如，正则表达式a\&c，其中\&是用来匹配特殊字符&的，它能精确匹配字符串"a&c"，但不能匹配"ac"、"a-c"、"a&&c"等。
         * 要注意正则表达式在Java代码中也是一个字符串，所以，对于正则表达式a\&c来说，对应的Java字符串是"a\\&c"，因为\也是Java字符串的转义字符，两个\\实际上表示的是一个\：
         *
         */

        String rel = "abc";
        System.out.println("abc".matches(rel));
        System.out.println("Abc".matches(rel));
        System.out.println("abcd".matches(rel));

        String re2 = "a\\&c"; //对应的正则是：a\&c
        System.out.println("a&c".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));

        /**
         * 如果想匹配非ASCII字符，例如中文，那就用\####的十六进制表示，例如：a\u548cc匹配字符串"a和c"，
         * 中文字符和的Unicode编码是548c。
         *匹配任意字符精确匹配实际上用处不大，因为我们直接用String.equals()就可以做到。
         * 大多数情况下，我们想要的匹配规则更多的是模糊匹配。我们可以用.匹配一个任意字符。
         * 例如，正则表达式a.c中间的.可以匹配一个任意字符，例如，下面的字符串都可以被匹配：
         * "abc"，因为.可以匹配字符b；
         * "a&c"，因为.可以匹配字符&；
         * "acc"，因为.可以匹配字符c。
         * 但它不能匹配"ac"、"a&&c"，因为.匹配一个字符且仅限一个字符。
         */
        System.out.println("正则表达式..................");
        String re3 = "a.c";
        System.out.println("abc".matches(re3));
        System.out.println("a&c".matches(re3));
        System.out.println("acc".matches(re3));
        System.out.println("a&&c".matches(re3));
        System.out.println("ac".matches(re3));

        /**
         *匹配数字
         * 用.可以匹配任意字符，这个口子开得有点大。如果我们只想匹配0~9这样的数字，可以用\d匹配。
         * 例如，正则表达式00\d可以匹配："007"，因为\d可以匹配字符7；
         * "008"，因为\d可以匹配字符8。它不能匹配"00A"，"0077"，因为\d仅限单个数字字符。
         * 匹配常用字符用\w可以匹配一个字母、数字或下划线，w的意思是word。例如，java\w可以匹配：
         *"javac"，因为\w可以匹配英文字符c；
         * "java9"，因为\w可以匹配数字字符9；。
         * "java_"，因为\w可以匹配下划线_。
         * 它不能匹配"java#"，"java "，因为\w不能匹配#、空格等字符。
         */
        System.out.println("========匹配规则之匹配数字和常用字符=====");
        String re4 = "java\\d";//对应的匹配规则：java\d
        System.out.println("java9".matches(re4));
        System.out.println("java10".matches(re4)); //对应的规则:java\d\d
        System.out.println("javac".matches(re4));
        /**
         *匹配常用的字符：
         * 用\w可以匹配一个字母、数字或下划线，w的意思是word。例如，java\w可以匹配：
         * "javac"，因为\w可以匹配英文字符c；
         * "java9"，因为\w可以匹配数字字符9；。
         * "java_"，因为\w可以匹配下划线_。
         * 它不能匹配"java#"，"java "，因为\w不能匹配#、空格等字符。
         */
        String re5 = "java\\w"; //对应正则表达式规则: java\w
        System.out.println("javac".matches(re5));
        System.out.println("java9".matches(re5));
        System.out.println("java_".matches(re5));
        System.out.println("java#".matches(re5));

        /**
         * 匹配空格字符用\s可以匹配一个空格字符，注意空格字符不但包括空格，还包括tab字符（在Java中用\t表示）。
         * 例如，a\sc可以匹配："a c"，因为\s可以匹配空格字符；"a c"，因为\s可以匹配tab字符\t。
         * 它不能匹配"ac"，"abc"等。
         * 匹配非数字
         * 用\d可以匹配一个数字，而\D则匹配一个非数字。例如，00\D可以匹配：
         * "00A"，因为\D可以匹配非数字字符A；"00#"，因为\D可以匹配非数字字符#。00\d可以匹配的字符串"007"，"008"等，
         * 00\D是不能匹配的。类似的，\W可以匹配\w不能匹配的字符，\S可以匹配\s不能匹配的字符，这几个正好是反着来的。
         *
         *重复的匹配：
         * 我们用\d可以匹配一个数字，例如，A\d可以匹配"A0"，"A1"，如果要匹配多个数字，比如"A380"，怎么办？
         * 修饰符*可以匹配任意个字符，包括0个字符。我们用A\d*可以匹配：
         * A：因为\d*可以匹配0个数字；
         * A0：因为\d*可以匹配1个数字0；
         * A380：因为\d*可以匹配多个数字380。
         * 修饰符+可以匹配至少一个字符。我们用A\d+可以匹配：
         * A0：因为\d+可以匹配1个数字0；
         * A380：因为\d+可以匹配多个数字380。
         * 但它无法匹配"A"，因为修饰符+要求至少一个字符。
         * 修饰符?可以匹配0个或一个字符。我们用A\d?可以匹配：
         * A：因为\d?可以匹配0个数字；
         * A0：因为\d?可以匹配1个数字0。
         * 但它无法匹配"A33"，因为修饰符?超过1个字符就不能匹配了。
         * 如果我们想精确指定n个字符怎么办？用修饰符{n}就可以。A\d{3}可以精确匹配：
         * A380：因为\d{3}可以匹配3个数字380。
         * 如果我们想指定匹配n~m个字符怎么办？用修饰符{n,m}就可以。A\d{3,5}可以精确匹配：
         * A380：因为\d{3,5}可以匹配3个数字380；
         * A3800：因为\d{3,5}可以匹配4个数字3800；
         * A38000：因为\d{3,5}可以匹配5个数字38000。
         * 如果没有上限，那么修饰符{n,}就可以匹配至少n个字符。
         *
         正则表达式	规则 	    可以匹配
         ^	        开头
         $	        结尾	        字符串结束
         [ABC]	 […]内任意字符	A，B，C
         [A-F0-9xy]	指定范围的字符	A，……，F，0，……，9，x，y
         [^A-F]	 指定范围外的任意字符	非A~F
         AB|CD|EF	AB或CD或EF	AB，CD，EF
         */
        /**
         * 我们前面讲到的(...)可以用来把一个子规则括起来，这样写learn\s(java|php|go)就可以更方便地匹配长字符串了。
         * 实际上(...)还有一个重要作用，就是分组匹配。
         * 我们来看一下如何用正则匹配区号-电话号码这个规则。利用前面讲到的匹配规则，写出来很容易：
         * \d{3,4}\-\d{6,8}
         * 虽然这个正则匹配规则很简单，但是往往匹配成功后，下一步是提取区号和电话号码，分别存入数据库。于是问题来了：
         * 如何提取匹配的子串？
         * 当然可以用String提供的indexOf()和substring()这些方法，但它们从正则匹配的字符串中提取子串没有通用性，
         * 下一次要提取learn\s(java|php)还得改代码。
         * 正确的方法是用(...)先把要提取的规则分组，把上述正则表达式变为(\d{3,4})\-(\d{6,8})。
         * 现在问题又来了：匹配后，如何按括号提取子串？
         * 现在我们没办法用String.matches()这样简单的判断方法了，必须引入java.util.regex包，用Pattern对象匹配，
         * 匹配后获得一个Matcher对象，如果匹配成功，就可以直接从Matcher.group(index)返回子串：
         *
         */

        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String go = m.group(0);
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(go);
            System.out.println(g1);
            System.out.println(g2);
            //要特别注意，Matcher.group(index)方法的参数用1表示第一个子串，2表示第二个子串。
            // 如果我们传入0会得到什么呢？答案是010-12345678，即整个正则匹配到的字符串

        } else {
            System.out.println("匹配失败！");
        }


        /**
         * 给定一个字符串表示的数字，判断该数字末尾0的个数。例如：
         * "123000"：3个0
         * "10100"：2个0
         * "1001"：0个0
         * 1.先写出正确的正则表达式：(\d)(0*)
         * 2.根据分组进行匹配
         *这是因为正则表达式默认使用贪婪匹配：任何一个规则，它总是尽可能多地向后匹配，因此，\d+总是会把后面的0包含进来。
         * 要让\d+尽量少匹配，让0*尽量多匹配，我们就必须让\d+使用非贪婪匹配。
         * 在规则\d+后面加个?即可表示非贪婪匹配。我们改写正则表达式如下：
         *因此，给定一个匹配规则，加上?后就变成了非贪婪匹配。
         * 我们再来看这个正则表达式(\d??)(9*)，注意\d?表示匹配0个或1个数字，后面第二个?表示非贪婪匹配，
         * 因此，给定字符串"9999"，匹配到的两个子串分别是""和"9999"，因为对于\d?来说，
         * 可以匹配1个9，也可以匹配0个9，但是因为后面的?表示非贪婪匹配，它就会尽可能少的匹配，结果是匹配了0个9
         */
        final Pattern p2 = Pattern.compile("(\\d+?)(0*)");
        final Matcher result = p2.matcher("123000");
        if (result.matches()) {
            System.out.println("group1 =" + result.group(1));
            System.out.println("group2 =" + result.group(2));
        }

        /**
         * 分割字符串：如果我们想让用户输入一组标签，然后把标签提取出来，因为用户的输入往往是不规范的，
         * 这时，使用合适的正则表达式，就可以消除多个空格、混合,和;这些不规范的输入，直接提取出规范的字符串。
         */
        final String[] split = "a b c".split("\\s");
        final String[] split1 = "a, b ;; c".split("[\\,\\;\\s]+");//{ "a", "b", "c" }

        /**
         * 搜索字符串
         * 我们获取到Matcher对象后，不需要调用matches()方法（因为匹配整个串肯定返回false），
         * 而是反复调用find()方法，在整个串中搜索能匹配上\\wo\\w规则的子串，并打印出来。这种方式比String.indexOf()要灵活得多
         * 因为我们搜索的规则是3个字符：中间必须是o，前后两个必须是字符[A-Za-z0-9_]。
         */

        /**
         * 替换字符串
         * 使用正则表达式替换字符串可以直接调用String.replaceAll()，它的第一个参数是正则表达式，
         * 第二个参数是待替换的字符串。我们还是来看例子：
         */
        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."

    }



}
