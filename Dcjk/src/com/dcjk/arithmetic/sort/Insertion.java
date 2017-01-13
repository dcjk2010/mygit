package com.dcjk.arithmetic.sort;

import java.util.Date;

/**
 * 插入排序
 * 
 * @author dcjk2010
 *
 */
public class Insertion implements Sort {

	long timeLong = 0;
	int innerLoopCount = 0;
	int outsideLoopCount = 0;
	int replaceCount = 0;

	@Override
	public void loopSort(Integer[] list) {
		innerLoopCount = 0;
		outsideLoopCount = 0;
		replaceCount = 0;
		timeLong = new Date().getTime();
		int temp = 0;
		int key = 0;
		for (int i = 1; i < list.length; i++) {
			outsideLoopCount++;
			temp = list[i];
			key = i;
			for (int j = i - 1; j >= 0; j--) {
				innerLoopCount++;
				if (list[j] > temp) {
					list[j + 1] = list[j];
					replaceCount++;
					key--;
				} else {
					break;
				}
			}
			list[key] = temp;
			replaceCount++;
		}
		System.out.println("Insertion loopSort timeLong:" + (new Date().getTime() - timeLong));
		System.out.println("Insertion loopSort outsideLoopCount" + outsideLoopCount);
		System.out.println("Insertion loopSort innerLoopCount" + innerLoopCount);
		System.out.println("Insertion loopSort replaceCount" + replaceCount);
	}

	@Override
	public void recursionSort(Integer[] list) {
		innerLoopCount = 0;
		outsideLoopCount = 0;
		replaceCount = 0;
		timeLong = new Date().getTime();
		recursionSort(list, list.length - 1, 0);
		System.out.println("Insertion recursionSort timeLong:" + (new Date().getTime() - timeLong));
		System.out.println("Insertion recursionSort outsideLoopCount" + outsideLoopCount);
		System.out.println("Insertion recursionSort innerLoopCount" + innerLoopCount);
		System.out.println("Insertion recursionSort replaceCount" + replaceCount);
	}

	private void recursionSort(Integer[] list, int i, int j) {
		if (i > j) {
			outsideLoopCount++;
			insert(list, i, j);
			recursionSort(list, i, j + 1);
		}
	}

	private void insert(Integer[] list, int i, int j) {
		int temp = list[j + 1];
		int key = j;
		while (key >= 0 && list[key] > temp) {
			innerLoopCount++;
			list[key + 1] = list[key];
			replaceCount++;
			key--;
		}
		list[key + 1] = temp;
		replaceCount++;
	}
}
