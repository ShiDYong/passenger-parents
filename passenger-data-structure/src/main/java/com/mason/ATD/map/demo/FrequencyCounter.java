package com.mason.ATD.map.demo;

import com.mason.ATD.map.DictionaryInterface;
import com.mason.ATD.map.SortedLinkedDictionary;

import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mason
 * @Description 记录单词出现的次数和
 * @date 2022/4/25 10:47
 */
public class FrequencyCounter {

    private DictionaryInterface<String, Integer> wordTable;

    public FrequencyCounter() {
        wordTable = new SortedLinkedDictionary<>();
    }


    /**
     * Reads a text file of words and counts their frequencies of occurrence
     *
     * @param data A text scanner for the text file of data.
     */
    public void readFile(Scanner data) {
        data.useDelimiter("\\W+");
        while (data.hasNext()) {
            String nextWord = data.next();
            nextWord = nextWord.toLowerCase();
            Integer frequency = wordTable.getValue(nextWord);
            if (frequency == null)
                wordTable.add(nextWord, Integer.valueOf(1));
            else {
                frequency++;
                wordTable.add(nextWord, frequency);

            }
        }

    }


    public void display() {
        Iterator<String> keyIterator = wordTable.getKeyIterator();
        Iterator<Integer> valueIterator = wordTable.getValueIterator();
        while (keyIterator.hasNext())
            System.out.println(keyIterator.next() + "," + valueIterator.next());

    }

    /**
     * Displays only the words that occur with a given frequency.
     *
     * @param frequency An integer count of the desired frequency.
     */
    public void display(int frequency) {
        Iterator<String> keyIterator = wordTable.getKeyIterator();
        Iterator<Integer> valueIterator = wordTable.getValueIterator();
        System.out.println("Words that occur " + frequency + " times:");
        boolean atLeastOneWord = false;
        while (keyIterator.hasNext()) {
            String word = keyIterator.next();
            Integer count = valueIterator.next();
            if (count.equals(frequency)) {
                atLeastOneWord = true;
                System.out.println(word);
            } // end if
        } // end while
        if (atLeastOneWord == false)
            System.out.println("(There are none.)");
    }

}
