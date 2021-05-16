package com.assignment.util;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.assignment.constant.CommonConstants;

/**
 * 
 * @author Kablu
 *
 */
public class CommonUtility { 

	public static Integer getRandmSleepSec() {
		Random random = new Random();
		Integer rndm = random.nextInt(CommonConstants.MAX);
		return rndm;
	}

	 public static <T> long findDuplicateByFrequency(List<T> list) {

	         Set<T> collect = list.stream().filter(i -> Collections.frequency(list, i) > 1)
	                .collect(Collectors.toSet());
	         long count = collect.stream().filter(f -> f!= null).count();
	         
	         return count;

	    }
}
