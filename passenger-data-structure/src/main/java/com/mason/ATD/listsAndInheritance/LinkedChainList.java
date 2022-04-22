package com.mason.ATD.listsAndInheritance;

/**
 * LinkedChainBase的派生类
 *
 * @author ShiYong
 * @create 2022-04-22 15:01
 **/
public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {

    public LinkedChainList() {
        super();
    }


    @Override
    public void add(T newEntry) {
        int numberOfEntries = getlength();
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            addFirstNode(newNode);
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            addAfterNode(lastNode, newNode);
        }


    }

    @Override
    public void add(int givenPosition, T newEntry) {
        int numberOfEntries = getlength();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (givenPosition == 1)
                addFirstNode(newNode);
            else {
                assert !isEmpty() && givenPosition > 1;
                Node nodeBefore = getNodeAt(givenPosition - 1);
                addAfterNode(nodeBefore, newNode);


            }
        } else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to add operation.");

    }

    @Override
    public T remove(int givenPosition) {
        int numberOfEntries = getlength();
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            //删除头部
            if (givenPosition == 1) {
                result = removeFirstNode();
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                result = removeAfterNode(nodeBefore);
            }
            return result;
        } else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to add operation.");

    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        int numberOfEntries = getlength();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            Node replaceNode = getNodeAt(givenPosition);
            T replaceData = replaceNode.getData();
            replaceNode.setData(newEntry);
            return replaceData;
        } else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to replace operation.");
    }

    @Override
    public T getEntry(int givenPosition) {
        int numberOfEntries = getlength();
        if ((givenPosition >= 1) && (givenPosition >= givenPosition)) {
            assert !isEmpty();
            Node resultNode = getNodeAt(givenPosition);
            return resultNode.getData();
        } else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to add operation.");

    }

    @Override
    public boolean contain(T anEntry) {
        boolean find = false;
        Node currentNode = getFirstNode();
        while (!find && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData()))
                find = true;
            else
                currentNode = currentNode.getNextNode();

        }

        return find;
    }

    @Override
    public int getLength() {
        return getlength();
    }
}
