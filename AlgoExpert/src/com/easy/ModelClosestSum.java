package com.easy;

public class ModelClosestSum {
	
	int value;
	ModelClosestSum left;
	ModelClosestSum right;
	
	ModelClosestSum(int value){
		this.value = value;
	}
	
	ModelClosestSum(int value, ModelClosestSum left, ModelClosestSum right){
		this.value = value;
		this.left = left;
		this.right = right;
	}

}
