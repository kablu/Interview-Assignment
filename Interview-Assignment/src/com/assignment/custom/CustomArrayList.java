package com.assignment.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.assignment.constant.CommonConstants;
import com.assignment.exception.CustomArrayListException;
import com.assignment.exception.UnableToAddDataException;
import com.assignment.msg.CommonMessage;
import com.assignment.util.CommonUtility;

/**
 * 
 * @author Kablu
 *
 * @param <T>
 */
public final class CustomArrayList<T> extends ArrayList<T> {

	private static CustomArrayList instance = null;
	
	private static final long serialVersionUID = 1L;
	
	private int numElements = 0;
	private Object elementData[] = {};
	long size = 0;

	private CustomArrayList() {
		//elementData = new Object[INIT_CAPACITY];
	}
	
	public static synchronized <R> CustomArrayList<R> getInstance() {
	        if(instance == null) {
	            instance = new CustomArrayList<R>();
	        }
	        return instance;
	    }

	@Override
	public void ensureCapacity(int minCapacity) {
		if(elementData.length != CommonConstants.INIT_CAPACITY) elementData = new Object[minCapacity];
	}

	@Override
	public boolean add(T e) {
		 
		ensureCapacity(CommonConstants.INIT_CAPACITY);
		
		try {
			if(e == null) {
				throw new UnableToAddDataException(CommonMessage.NULL_VAL_NOT_ALLOWED);
			}
			
			if (numElements == elementData.length) {
				remove(0, e);
			}
			
			elementData[numElements++] = e;
			super.add(e);
			
			long duplicateValue = CommonUtility.findDuplicateByFrequency(Arrays.asList(elementData));
			
			if (duplicateValue > 0) {
				throw new UnableToAddDataException(CommonMessage.VALUE_EXISTS);
			}
			 
			Supplier<Integer> sup = CommonUtility::getRandmSleepSec;
			
			TimeUnit.MILLISECONDS.sleep(sup.get());
			
			System.out.println("Addde Item: " + e);
			
			size = Arrays.asList(elementData).stream().map(d -> super.add(e)).count();
			
			setSize(size);
			
		} catch (Exception exception) {
			throw new UnableToAddDataException(exception.getMessage());
		}
		// return super.add(e);
		return true;
	}

	private T remove(int index, T e) {
		if (index < 0 || index >= elementData.length) {
			throw new CustomArrayListException(CommonMessage.BAD_INDEX);
		}
		Object retval = shiftElementToLeft(index, e);
		System.out.println("Element Removed From First:" + retval);
		numElements--;
		return (T) retval;
	}


	private Object shiftElementToLeft(int start, T e) {
		Object retVal = elementData[start];
		for (int i = start; i < numElements - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		return retVal;
	}

	@Override
	public String toString() {
		String temp = "";
		for (int i = 0; i < numElements; i++) {
			if(elementData[i] != null) temp += elementData[i].toString() + "\n";
		}
		return temp;
	}


	
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public static void main(String[] args) { 
		CustomArrayList<String> cl = new CustomArrayList<String>();
		cl.add("Mumbai");
		cl.add("Lucknow");  
		cl.add("Delhi");  
		//cl.add(null);   
		cl.add("Ranchi");  
		cl.add("Bokaro");  
		cl.add("Patna");  
		cl.add("Chandigrah");  
		cl.add("Shimla");  

		System.out.println("Display Elements:" + cl.toString());

	}
}
