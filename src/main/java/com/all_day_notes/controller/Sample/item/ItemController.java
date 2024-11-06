package com.all_day_notes.controller.Sample.item;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.all_day_notes.entity.sample_entity.Item;
import com.all_day_notes.form.sample_item.ItemForm;
import com.all_day_notes.service.sample_service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
	/*
	 * 下記2つがセットに、４つの項目が必要になる必要になる
	 * get
	 * post
	 * 
	 * 項目
	 * ・表示
	 * ・登録
	 * ・編集
	 * ・削除
	 *
	 */
    // 商品一覧の表示
    @GetMapping
    public String index(Model model) {
	    // データの疎通確認
	    List<Item> items = this.itemService.findAll();
	    // コンソールよりListの中身を確認する
	    System.out.println(items.toString());

        return "sample/sample_item/index";
    }

    // 商品登録ページ表示用
    @GetMapping("toroku")
    public String torokuPage(@ModelAttribute("itemForm") ItemForm itemForm) {
        // 処理を追加
        return "sample/sample_item/torokuPage";
    }

    // 商品登録の実行
    @PostMapping("toroku")
    public String toroku(ItemForm itemForm) {
        // 処理を追加
        return "redirect:/item";
    }

    // 商品編集ページ
    @GetMapping("henshu/{id}")
    public String henshuPage(@PathVariable("id") Integer id, Model model
                             , @ModelAttribute("itemForm") ItemForm itemForm) {
        // 処理を追加
        return "sample/sample_item/henshuPage";
    }

    // 商品編集の実行
    @PostMapping("henshu/{id}")
    public String henshu(@PathVariable("id") Integer id, @ModelAttribute("itemForm") ItemForm itemForm) {
        // 処理を追加

        return "redirect:/item";
    }

    // 商品削除の実行
    @PostMapping("sakujo/{id}")
    public String sakujo(@PathVariable("id") Integer id) {
        // 処理を追加
        return "redirect:/item";
        
        
    }
    
    


}
