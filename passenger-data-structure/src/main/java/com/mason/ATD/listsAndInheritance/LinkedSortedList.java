package com.mason.ATD.listsAndInheritance;

/**
 * 实现有序列表
 *
 * @author ShiYong
 * @create 2022-04-22 16:35
 **/
public class LinkedSortedList<T extends Comparable<? super T>>
        extends LinkedChainBase<T> implements SortedListInterface<T> {

    public LinkedSortedList() {
        //Initializes the linked chain
        super();
    }

    public LinkedSortedList(ListInterface<T> list) {
        this();
        for (int i = 0; i <= list.getLength(); i++) {
            add(list.getEntry(i));

        }


    }


    /**
     * Adds a new entry to the end of this list.
     * Entries currency in the list are unaffected.
     * The list's size if increased by 1.
     *
     * @param newEntry An object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        Node nodeBefore = getNodeBefore(newEntry);
        if (nodeBefore == null)
            //属于头节点，直接插入
            addFirstNode(newNode);
        else
            addAfterNode(nodeBefore, newNode);
    }

    /**
     * Finds the node that is before the node that should or does contain
     * a given entry.
     *
     * @param anEntry
     * @return either a reference to the node that is before the node
     * that does or should contain anEntry, or null if no prior node existes
     */
    private Node getNodeBefore(T anEntry) {
        Node currentNode = getFirstNode();
        Node nodeBefore = null;
        while ((currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0)) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return nodeBefore;
    }


    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        int position = getPosition(anEntry);
        if (position > 0) {
            remove(position);
            result = true;
        }
        return result;
    }

    /**
     * Gets the position of an entry in this sorted list.
     *
     * @param anEntry The object to be found.
     * @return The position of the first or only occurrence of anEntry
     * if it occurs in the list; otherwise returns the position
     * where anEntry would  occur in the list ,but as a negative
     * integer.
     */
    @Override
    public int getPosition(T anEntry) {
        int numberOfEntries = getlength();
        int position = -1;
        //Find position of an entry
        while ((position <= numberOfEntries) && (anEntry.compareTo(getEntry(position)) > 0)) {
            position++;
        }
        //see whether anEntry is in list
        if ((position > numberOfEntries) || (anEntry.compareTo(getEntry(position)) != 0)) {
            //anEntry is not in list
            position = -position;
        }
        return position;
    }

    @Override
    public T getEntry(int givenPosition) {
        int numberOfEntries = getlength();
        if ((givenPosition >= 1) && (numberOfEntries >= givenPosition)) {
            assert !isEmpty();
            return getNodeAt(givenPosition).getData();
        } else
            throw new IndexOutOfBoundsException("" +
                    "Illegal position given to getEntry operation.");
    }


    @Override
    public boolean contains(T anEntry) {
        Node currentNode = getFirstNode();
        boolean found = false;
        int where = -1;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else if (anEntry.compareTo(currentNode.getData()) > 0)
                currentNode = currentNode.getNextNode();
            else
                break;
        }
        return found;
    }

    @Override
    public T remove(int givenPosition) {
        int numberOfEntries = getLength();
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            if (givenPosition == 1) {
                removeFirstNode();
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                result = removeAfterNode(nodeBefore);

            }

        }
        return result;
    }

    @Override
    public int getLength() {
        return getlength();
    }
}
