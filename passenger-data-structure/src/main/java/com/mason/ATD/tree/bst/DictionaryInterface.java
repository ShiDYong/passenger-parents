package com.mason.ATD.tree.bst;

import java.util.Iterator;

/**
 * @author Mason
 * @Description An interface for a dictionary with distinct search keys.
 * Search keys and associated values are not null.
 * @date 2022/4/24 09:09
 */
public interface DictionaryInterface<K,V> {

    /**
     * 任务：将(key,value)对添加到字典中
     * @param key  key是查找键对象，value是对应到对象
     * @param value 无
     */
    public V add(K key, V value);


    /**
     * 任务：从字典中删除对应于给定查找键到项
     * @param key  是查找键对象
     * @return 返回对应于查找键到值；或者，如果这样到对象不存在，则返回null。
     */
    public V remove(K key);

    /**
     * 从字典中获取与给定查找键对应的值
     * @param key 查找键对象
     * @return 如果字典中的一个项有与所给查找键一样的键，则返回真
     */
    public V getValue(K key);

    /**
     * 任务：查看字典是否存在有给定查找键的项
     * @param key  是查找键对象
     * @return 如果字典中的一个项有与所给查找键一样的键，则返回真
     */
    public boolean contains(K key);


    /**
     * 任务：创建遍历字典中所有查找键的迭代器
     * @return 返回一个迭代器，能顺序访问字典的查找键
     */
    public Iterator<K> getKeyIterator();

    /**
     * 任务：遍历字典中所有值的迭代器
     * @return  返回一个迭代器，能顺序访问字典中的值
     */
    public Iterator<V> getValueIterator();


    /**
     * 查看字典是否为空
     * @return 如果字典为空，则返回真
     */
    public boolean isEmpty();


    /**
     * 任务：得到字典的大小
     * @return  返回字典中当前项的个数
     */
    public int getSize();


    /**
     * 任务：删除字典中的所有项
     */
    public void clear();

}
