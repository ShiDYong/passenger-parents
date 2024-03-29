package com.mason.ATD.chapter03;

import com.mason.ATD.chapter02.BagInterface;

/**
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public class LinkedBag04<T> implements BagInterface<T>
{
    private Node<T> firstNode;       // Reference to first node
    private int numberOfEntries;

    public LinkedBag04()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    /** Adds a new entry to this bag.
        @param newEntry  The object to be added as a new entry.
        @return  True. */
    @Override
    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node<T> newNode = new Node<T>(newEntry);
        newNode.setNextNode(firstNode);  // Make new node reference rest of chain
                                         // (firstNode is null if chain is empty)
        firstNode = newNode;    // New node is at beginning of chain
        numberOfEntries++;
      
        return true;
    } // end add

    /** Retrieves all entries that are in this bag.
        @return  A newly allocated array of all the entries in this bag. */
    @Override
    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        } // end while
      
        return result;
        // Note: The body of this method could consist of one return statement,
        // if you call Arrays.copyOf
    } // end toArray
   
    /** Sees whether this bag is empty.
        @return  True if the bag is empty, or false if not. */
    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty
   
    /** Gets the number of entries currently in this bag.
        @return  The integer number of entries currently in the bag. */
    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    } // end getCurrentSize

    /** Removes one unspecified entry from this bag, if possible.
        @return  Either the removed entry, if the removal
                 was successful, or null. */
    @Override
    public T remove()
    {
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode(); // Remove first node from chain
            numberOfEntries--;
        } // end if
        return result;
    } // end remove
   
    /** Removes one occurrence of a given entry from this bag.
        @param anEntry  The entry to be removed.
        @return  True if the removal was successful, or false otherwise. */
    @Override
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);
        if (nodeN != null)
        {
            nodeN.setData(firstNode.getData());    // Replace located entry with entry
                                            // in first node
            firstNode = firstNode.getNextNode();     // Remove the first node
            numberOfEntries--;
            result = true;
        } // end if
        return result;
    } // end remove
    
    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located, 
    // or null otherwise.
    private Node<T> getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) 
        {
            if (anEntry.equals(currentNode.getData())) 
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while
        return currentNode; 
    } // end getReferenceTo
	
    /** Removes all entries from this bag. */
    @Override
    public void clear()
    {
        while(!isEmpty())
            remove();
        //or firstNode = null;
    } // end clear
	
    /** Counts the number of times a given entry appears in this bag.
        @param anEntry  The entry to be counted.
        @return  The number of times anEntry appears in the bag. */
    @Override
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int loopCounter = 0;
        Node<T> currentNode = firstNode;
        while((loopCounter < numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                frequency++;
            loopCounter++;
            currentNode = currentNode.getNextNode();
        } // end while
        return frequency; 
    } // end getFrequencyOf
	
    /** Tests whether this bag contains a given entry.
        @param anEntry  The entry to locate.
        @return  True if the bag contains anEntry, or false otherwise. */
    @Override
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while
        return found;
    } // end contains
    
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0    
    private class Node<S>
    {
        private S       data;
        private Node<S> next;

        private Node(S dataPortion) // The constructor’s name is Node, not Node<S>
        {
           this(dataPortion, null);
        } // end constructor

        private Node(S dataPortion, Node<S> nextNode)
        {
           data = dataPortion;
           next = nextNode;
        } // end constructor

        private S getData()
        {
           return data;
        } // end getData

        private void setData(S newData)
        {
           data = newData;
        } // end setData

        private Node<S> getNextNode()
        {
           return next;
        } // end getNextNode

        private void setNextNode(Node<S> nextNode)
        {
           next = nextNode;
        } // end setNextNode
    } // end Node

} // end LinkedBag1



