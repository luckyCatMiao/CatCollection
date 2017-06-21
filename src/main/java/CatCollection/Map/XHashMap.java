package CatCollection.Map;

import java.io.Serializable;
import java.util.LinkedList;

import org.junit.internal.Classes;

import CatCollection.XArrayList;
import CatCollection.XLinkedList;

public class XHashMap<K,V> extends BaseMap<K, V> {

	
	private class KeyValue implements Serializable
	{
		public K key;
		public V value;
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
	}
	
	//内部使用array来保存数据 使用链地址法保存重复数据
	private XArrayList<XLinkedList<KeyValue>> list=new XArrayList<>();
	//初始的哈希余数值
	private int hash=49;
	
	private int size=0;
	
	public XHashMap() {
		//初始化list
		for(int i=0;i<hash;i++)
		{
			list.add(new XLinkedList<>());
		}
		
	}
	
	@Override
	public V get(K key) {
		int hashValue=hash(key);
		XLinkedList<KeyValue> linkedList=list.get(hashValue);
		for(KeyValue keyValue:linkedList)
		{
			if(keyValue.key.equals(key))
			{
				return keyValue.value;
			}
			
		
		}
		
		return null;
	}

	@Override
	public BaseMap<K, V> put(K key, V value) {
		
		int hashValue=hash(key);
		//获取hash值对应的链表
		XLinkedList<KeyValue> linkedList=list.get(hashValue);
		//如果有重复值则覆盖
		for(KeyValue keyValue:linkedList)
		{
			if(keyValue.key.equals(key))
			{
				keyValue.value=value;
				return this;
			}
			
		
		}
		//没有重复值则添加
		KeyValue keyValue=new KeyValue();
		keyValue.key=key;
		keyValue.value=value;
		linkedList.add(keyValue);
		size++;
		checkSize();
		
		return this;
	}

	
	/**
	 * 每次添加数据后检查大小 如果大于1/2满 则扩充数组 否则效率会下降
	 */
	private void checkSize() {
		
		if(size>list.size()/2)
		{
			//重新哈希化
			reHash();
		}
	}

	private void reHash() {
		//倍增当前哈希余数 
		hash=hash*2+1;
		XArrayList<XLinkedList<KeyValue>> newList=(XArrayList<XLinkedList<XHashMap<K, V>.KeyValue>>) list.shallowClone();
		list.clear();
		for(int i=0;i<hash;i++)
		{
			list.add(new XLinkedList<>());
		}
		
		//把所有的键值对重新哈希化
		for(XLinkedList<KeyValue> linkedList:newList)
		{
			for(KeyValue keyValue:linkedList)
			{
				put(keyValue.key, keyValue.value);
			}
		}
		
	}

	private int hash(K key) {
		
		int hashCode=key.hashCode()%hash;
		
		//哈希化
		return hashCode;
	}

	@Override
	public BaseMap<K, V> remove(K key) {
		int hashValue=hash(key);
		//获取hash值对应的链表
		XLinkedList<KeyValue> linkedList=list.get(hashValue);
		XLinkedList<KeyValue> linkedList2=(XLinkedList<XHashMap<K, V>.KeyValue>) linkedList.shallowClone();
		
		for(KeyValue keyValue:linkedList2)
		{
			if(keyValue.key.equals(key))
			{
				linkedList.remove(keyValue);
			}
				
		}
		
		return this;
	}

	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("[ ");
		
		for(XLinkedList<KeyValue> linkedList:list)
		{
			for(KeyValue keyValue:linkedList)
			{
				buffer.append(keyValue.key+":"+keyValue.value+" ");
			}
		}
		
		buffer.append("]");
		
		
		return buffer.toString();
	}

}
