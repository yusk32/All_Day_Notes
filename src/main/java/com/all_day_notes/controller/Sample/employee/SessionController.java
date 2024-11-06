package com.all_day_notes.controller.Sample.employee;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/session")
public class SessionController {

	/*
	 * 動作確認について
	 * Sessionへデータを保存する
	 * 	http://localhost:8080/session/set?name=太郎&bloodType=AB 
	 * 			「保存しました」と表示される
	 * 
	 * Sessionからデータを取得する
	 * 	http://localhost:8080/session/get にアクセスする
	 * 		保存した情報が表示される
	 * 	
	 * Sessionからデータを削除する
	 * 	http://localhost:8080/session/delete にアクセスする
	 * 	「削除しました」と表示される
	 * 
	 * 	http://localhost:8080/session/get にアクセスする
	 * 		名前： 名無し, 血液型： 不明と表示される
	 * 
	 */
	
	
    // HttpSession型のフィールドを定義する
    private HttpSession session;

    // コンストラクタを作成し、@Autowiredアノテーションを付与する
    // テキストu上だと書いてはあるが、今回は必要なさそう
   @Autowired
    public SessionController(HttpSession session) {
        // フィールドに代入する
        this.session = session;
    }
    // 保存処理
    // sessionの保存はよくPOSTメソッドにより行いますが、解説のためGETメソッドを採用しています
    @GetMapping("/set")
    @ResponseBody
    public String set(@RequestParam("name") String name, @RequestParam("bloodType") String bloodType) {
        // Sessionへの保存
        this.session.setAttribute("name", name);
        this.session.setAttribute("bloodType", bloodType);
        return "保存しました";
    }
    // 取得
    @GetMapping("/get")
    @ResponseBody
    public String get() {
        String name = (String) this.session.getAttribute("name");
        String bloodType = (String) this.session.getAttribute("bloodType");
        if (name == null) {
            name = "名無し";
        }
        if (bloodType == null) {
            bloodType = "不明";
        }
        return "名前: " + name + "<br>血液型: " + bloodType;
    }
    // 削除
    // sessionの削除はよくPOSTメソッドにより行いますが、解説のためGETメソッドを採用しています
    @GetMapping("/delete")
    @ResponseBody
    public String delete() {
        // Session名を指定して削除
        session.removeAttribute("name");
        session.removeAttribute("bloodType");
        return "削除しました";
    }
}