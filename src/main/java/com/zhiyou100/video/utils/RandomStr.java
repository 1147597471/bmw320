package com.zhiyou100.video.utils;

import java.util.Random;

public class RandomStr {
		
	
	 public static String getRandom(int length){
		 Random rand = new Random();
			String str="";
			for(int i =0 ;i<length;i++){
				int a = rand.nextInt(10);
				str+=a;
			}
			return str;
	 }
}
