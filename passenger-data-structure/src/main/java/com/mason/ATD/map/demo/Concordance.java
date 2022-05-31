package com.mason.ATD.map.demo;

import com.mason.ATD.map.DictionaryInterface;
import com.mason.ATD.map.SortedLinkedDictionary;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Mason
 * @Description 查找单词的索引，即查找每个单词出现的行数。
 * @date 2022/4/25 14:02
 */
public class Concordance {

    private DictionaryInterface<String, ListWithIteratorInterface<Integer>> wordTable;

    public Concordance() {
        wordTable = new SortedLinkedDictionary<>();
    }
    //通过一个字典中同一个key的值用线性表来存储
    //该方式值得多去思考和学习
    public void readFile(Scanner data) {
        int linNumber = 1;
        while (data.hasNext()) {
            String line = data.nextLine();
            line = line.toLowerCase();
            Scanner lineProcessor = new Scanner(line);
            lineProcessor.useDelimiter("\\W+");
             while (lineProcessor.hasNext()) {
                String nextWord = lineProcessor.next();
                ListWithIteratorInterface<Integer> lineList = wordTable.getValue(nextWord);
                if (lineList == null) {
                    //Create new list for new word; add word and list to index
                    lineList = new LinkedListWithIterator<>();
                    wordTable.add(nextWord, lineList);
                }
                lineList.add(linNumber);
            }
            linNumber++;
        }
        data.close();
    }

    public void display() {
        Iterator<String> keyIterator = wordTable.getKeyIterator();
        Iterator<ListWithIteratorInterface<Integer>> valueIterator = wordTable.getValueIterator();
        while (keyIterator.hasNext()){
            //Display the word
            System.out.print(keyIterator.next() + " ");
            //Gets line numbers and iterator
            ListWithIteratorInterface<Integer> lineList = valueIterator.next();
            Iterator<Integer> listIterator = lineList.getIterator();
            //Display line numbers
            while (listIterator.hasNext()){
                System.out.print(listIterator.next()+ " ");
            }
            System.out.println();
        }
    }

    ;
}
