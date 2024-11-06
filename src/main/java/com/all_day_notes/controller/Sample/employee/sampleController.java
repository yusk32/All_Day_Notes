package com.all_day_notes.controller.Sample.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.all_day_notes.form.SampleForm;

@Controller
@RequestMapping("/sample")
public class sampleController {
	
	/*
	 * サンプルコントローラー用
	 * http://localhost:8080/sample/index
	 * にリクエストするとsample()が実行される
	 */
	@GetMapping("/index")
	public String sample(SampleForm samplesampleForm,Model model) {
		//変数定義
		String text = "Hellow Spring Boot!!";
		
		//指定した属性名をhtml内で変数のように扱う
		model.addAttribute("message", text);
		model.addAttribute("sampleForm",samplesampleForm);
		return "sample/index";
	}
		
	/*
	 * 本日の成果を表示する
	 * http://localhost:8080/sample/request_test?name=太郎&bloodType=AB
	 * にリクエストするとgetTestが実行される
	 * Requestparam用
	 * 実行結果
	 * 名前：太郎
	 * 血液型：AB
	 * 
	 * 
	 */	
	@GetMapping("/request_test")
	@ResponseBody
	public String getTest(@RequestParam("name") String name , @RequestParam("bloodType") String bloodType) {
		return "名前: " + name + "<br>血液型: " + bloodType ;
		
	}
	
	
	@PostMapping("/request_test")
	@ResponseBody
	public String postTest(SampleForm sampleForm) {
		return "名前:"+ sampleForm.getName() + "<br>血液型:" + sampleForm.getbloodType();
	}
	
	
}
