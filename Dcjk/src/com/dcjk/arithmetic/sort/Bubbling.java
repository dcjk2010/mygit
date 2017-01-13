package com.dcjk.arithmetic.sort;

import java.util.Date;

/**
 * 冒泡排序
 * 
 * @author dcjk2010
 *
 */
public class Bubbling implements Sort {

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
		for (int i = list.length - 1; i > 0; --i) {
			outsideLoopCount++;
			for (int j = 0; j < i; ++j) {
				innerLoopCount++;
				if (list[j + 1] < list[j]) {
					temp = list[j];
					list[j] = list[j + 1];
					replaceCount++;
					list[j + 1] = temp;
					replaceCount++;
				}
			}
		}
		System.out.println("Bubbling loopSort timeLong:" + (new Date().getTime() - timeLong));
		System.out.println("Bubbling loopSort outsideLoopCount" + outsideLoopCount);
		System.out.println("Bubbling loopSort innerLoopCount" + innerLoopCount);
		System.out.println("Bubbling loopSort replaceCount" + replaceCount);
	}

	@Override
	public void recursionSort(Integer[] list) {
		innerLoopCount = 0;
		outsideLoopCount = 0;
		replaceCount = 0;
		timeLong = new Date().getTime();
		recursionSort(list, 1, list.length);
		System.out.println("Bubbling recursionSort timeLong:" + (new Date().getTime() - timeLong));
		System.out.println("Bubbling recursionSort outsideLoopCount" + outsideLoopCount);
		System.out.println("Bubbling recursionSort innerLoopCount" + innerLoopCount);
		System.out.println("Bubbling recursionSort replaceCount" + replaceCount);
	}

	private void recursionSort(Integer[] list, int i, int j) {
		if (i < j) {
			outsideLoopCount++;
			findMin(list, i, j);
			recursionSort(list, i, j - 1);
		}
	}

	private void findMin(Integer[] list, int i, int j) {
		int temp = 0;
		for (int k = 1; k < j; k++) {
			innerLoopCount++;
			if (list[k] < list[k - 1]) {
				temp = list[k - 1];
				list[k - 1] = list[k];
				replaceCount++;
				list[k] = temp;
				replaceCount++;
			}
		}
	}

}
