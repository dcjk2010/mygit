package com.dcjk.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSort {

	public static void main(String[] args) {
		Integer[] list = {};
		List<Integer> t = new ArrayList<Integer>();
		for (int i = 10000; i > 0; i--) {
			t.add(i);
		}
		list = t.toArray(list);
		Integer[] tempList;
		Sort sort;

		sort = new Insertion();
		tempList = list.clone();
		sort.loopSort(tempList);
//		System.out.println(Arrays.toString(tempList));
		tempList = list.clone();
		sort.recursionSort(tempList);
//		System.out.println(Arrays.toString(tempList));
		
		System.out.println("-------------------------------");

//		sort = new Bubbling();
//		tempList = list.clone();
//		sort.loopSort(tempList);
//		System.out.println(Arrays.toString(tempList));
//		tempList = list.clone();
//		sort.recursionSort(tempList);
//		System.out.println(Arrays.toString(tempList));

	}
}
