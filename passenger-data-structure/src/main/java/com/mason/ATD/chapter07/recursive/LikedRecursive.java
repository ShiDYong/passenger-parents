package com.mason.ATD.chapter07.recursive;
/**
 * 链表常用的递归
 *
 * @author ShiYong
 * @create 2022-04-13 9:52
 **/
public class LikedRecursive<S> {
    private Node firstNode;

    /**
     * 通过递归实现对链表结点的数据的访问
     *
     * @param nodeOne
     */
    public void display(Node nodeOne) {
        display(firstNode);

    }

    /**
     * 当写一个方法递归处理结点链表时，可以通过以下工作：
     * 1.使用链表指向链表中首结点的引用作为方法的参数；
     * 2.处理首结点，然后处理链表中的其余结点；
     * 3.当参数是null时停止
     *
     * @param nodeOne
     */
    private void displayChain(Node nodeOne) {
        if (nodeOne != null) {
            //正常顺序显示链表数据
            System.out.println(nodeOne.getData());
            display(nodeOne.getNextNode());

        }


    }

    /**
     * 反向显示链表。假定你想以反序遍历结点链表。具体来说,假定你想显示最后一个结点中的对象,
     * 然后是倒数第二个结点中的对象,等等,即向链头方向前进。因为每个结点指向下一个结点但没有指向前一个结点，
     * 故使用选代来完成这个任务是困难的。可以遍历到最后一个结点,显示它的内容,
     * 然后回到开头再遍历到倒数第二个结点,等等。但是,很明显,这是一个乏味且耗时的方法。换一种做法,
     * 可以仅遍历一次链表并保存指向每个结点的引用,然后用这些引用以反序来显示链表的结点中的对象。递归方法就可以这样做
     */
    public void displayBack(){
        displayBackChain(firstNode);
    }

    private void displayBackChain(Node nodeOne) {
        if (nodeOne != null) {
            displayBackChain(nodeOne.getNextNode());
            //反序遍历结点链表，注意和上面对比，程序语句放在程序的位置
            System.out.println(nodeOne.getData());

        }


    }

    /**
     * 对含有3个结点的链表,跟踪前一个方法displayBackward的执行过程如下：
     *      事件次序如下：
     *      displayBackward()
     *      displayChainBackward(firstNode)
     *      displayChainBackward(指向第二个结点的引用)
     *      displayChainBackward(指向第三个结点的引用)
     *      displayChainBackward(null)
     *      打印第三个结点中的数据
     *      打印第二个结点中的数据
     *      打印第一个结点中的数据
     *
     *      每次调用displayChainBackward的活动记录出现在栈中,
     *      如下所示(dCB 是displayChainBackward 的缩写;栈的内容从栈顶到栈底):
     *     dCB (firstNode)
     *     dCB(指向第二个结点的引用) dCB(firstNode)
     *     dCB(指向第三个结点的引用) dCB (指向第二个结点的引用) dCB(firstNode)
     *     dCB(nul1) dCB(指向第三个结点的引用) dCB (指向第二个结点的引用) dCB(firstNode)
     *     dCB(指向第三个结点的引用) dCB (指向第二个结点的引用) dCB(firstNode)
     *     打印第三个结点中的数据
     *     dCB (指向第二个结点的引用)dCB(firstNode)
     *     打印第二个结点中的数据dCB(firstNode)
     *     打印第一个结点中的数据
     */




}
