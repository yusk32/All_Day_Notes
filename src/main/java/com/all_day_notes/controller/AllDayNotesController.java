package com.all_day_notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class AllDayNotesController {
	
	/*
	 * 本日の成果を表示する
	 * http://localhost:8080/main/OneDayRecorde
	 * にリクエストするとOneDayRecorde()が実行される
	 */
	@GetMapping("/OneDayRecorde")
	public String OneDayRecorde() {
		return "Web/nippou";
	}
	
	/*
	 * 一週間の実績を表示する
	 * http://localhost:8080/main/WeeklyRecorde
	 * にリクエストするとWeeklyRecorde()が実行される
	 */
	@GetMapping("/WeeklyRecorde")
	public String WeeklyRecorde() {
		return "Web/shuhou";
	}
	
	
}
