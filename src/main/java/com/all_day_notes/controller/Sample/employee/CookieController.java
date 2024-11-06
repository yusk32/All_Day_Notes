package com.all_day_notes.controller.Sample.employee;

// CookieクラスとHttpServletResponseクラスをインポートします
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
//CookieValueクラスをインポートします	
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("cookie")
public class CookieController {
/*
 * 1 Cookieを保存 http://localhost:8080/cookie/set?value=test
 * 2 Cookieの値を表示 http://localhost:8080/cookie/get
 * 3 Cookieの値を削除 http://localhost:8080/cookie/delete
 * 4 Cookieの値を表示（Cookieが削除されてエラーページが表示される)http://localhost:8080/cookie/get
 */

    // cookieの保存はよくPOSTメソッドにより行いますが、解説のためGETメソッドを採用しています
    @GetMapping("/set")
    @ResponseBody
    public String setCookie(@RequestParam String value, HttpServletResponse res) {
        // cookie名をtest_cookieとして保存します
        res.addCookie(new Cookie("test_cookie", value));
        return "保存しました";
    }
    
    
    @GetMapping("/get")
    @ResponseBody
    public String getCookie(@CookieValue("test_cookie") Cookie cookie) {
        // cookieの値を取得します
        return "cookieValue: " + cookie.getValue();
	    }
    
    @GetMapping("/delete")
    @ResponseBody
    public String deleteCookie(@CookieValue("test_cookie") Cookie cookie, HttpServletResponse res) {
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return "削除しました";
    }
}
