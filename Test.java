package com.minhduc.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test{
	public static void main(String[] args) {
		compareToGetMax compare = new compareToGetMax();
		List<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(18);
		list.add(591);
		list.add(99);
		list.add(2);
		
		
		// tao mang
		int [] arr = new int[] {
				1, 2, 3, 4, 5
		};

		
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j ++) {
				if (compare.compare(list.get(i), list.get(j)) == 1) {
					int temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		for (int number : list) {
			System.out.println(number);
		}
	}
}

class compareToGetMax implements Comparator<Integer> {
	
	@Override 
	public int compare(Integer X, Integer Y) {
		String XY = String.valueOf(X) + String.valueOf(Y); // 494
		String YX = String.valueOf(Y) + String.valueOf(X); // 944
		return Integer.parseInt(XY) > Integer.parseInt(YX) ? 1 : 0;
	}
}
