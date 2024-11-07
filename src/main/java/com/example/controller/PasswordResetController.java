package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//TODO　エラーを解除する

@Controller
public class PasswordResetController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reset-password")
    public String showResetPasswordForm() {
        return "reset-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email) {
        // トークンの生成とメール送信処理（実装が必要）
        return "redirect:/login";
    }

}
