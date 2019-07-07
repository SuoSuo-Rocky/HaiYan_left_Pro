package com.example.asynctaskdemo1;

public class Sleep {
	public void  hi(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
