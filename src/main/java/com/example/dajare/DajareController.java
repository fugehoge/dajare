package com.example.dajare;


import java.util.ArrayList;  // 必要に応じて追加
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DajareController {
	
	@Autowired
	private DajareService dajareService;

    @GetMapping("/")
    public String index() {
        return "index";  // トップページ
    }

    @GetMapping("/post")
    public String post() {
        return "post";  // 投稿ページ
    }

    @GetMapping("/complete")
    public String complete() {
        return "complete";  // 投稿完了ページ
    }
    
    
    @PostMapping("/complete")
    public String complete(@RequestParam String dajare,@RequestParam String author, Model model) {
        Dajare newDajare = new Dajare();
        newDajare.setContent(dajare);
        newDajare.setAuthor(author);
        dajareService.saveDajare(newDajare);  // ダジャレを保存
        return "complete";
    }

	
    @GetMapping("/view")
    public String view(Model model) {
        Iterable<Dajare> iterable = dajareService.getAllDajares();
        List<Dajare> dajares = new ArrayList<>();  // ArrayListのインスタンスを作成
        iterable.forEach(dajares::add);  // Iterableの全ての要素をListに追加
        model.addAttribute("dajares", dajares);  // モデルにダジャレを追加
        return "view";  // 投稿閲覧ページ
    }


}
