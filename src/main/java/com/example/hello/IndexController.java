package com.example.hello;

import com.example.hello.domain.food.TbFood;
import com.example.hello.domain.search.TbSearch;
import com.example.hello.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final SearchService searchService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/movie")
    public String movie(){
        return "movie";
    }

    @GetMapping("/foodrandom")
    public String foodrandom(Model model){
        List<TbFood> flist = searchService.findFoodRand();
        model.addAttribute("flist", flist);
        return "foodrandom";
    }

    @GetMapping("/searchlist")
    public String searchList(Model model){
        List<TbSearch> list = searchService.findAll();
        model.addAttribute("slist", list);
        return "searchlist";
    }


}
