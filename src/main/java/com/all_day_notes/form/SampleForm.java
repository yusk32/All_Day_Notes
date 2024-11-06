package com.all_day_notes.form;
/*
 * DTOクラスを定義のルール
 * クライアントから送信されるフィールドを全て定義する
 * フィールドの数に合わせてアクセサメソッド(setter、getter)を定義する
 */

public class SampleForm {
	//フォームから送信されるフィード
	private String name;
	
	private String bloodType;
	
	//アクセスメソッド
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getbloodType() {
		return bloodType;
	}
	
	public void setbloodType(String bloodType) {
		this.bloodType = bloodType;
	}
}
