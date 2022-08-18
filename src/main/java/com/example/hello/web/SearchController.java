package com.example.hello.web;

import com.example.hello.domain.search.TbSearch;
import com.example.hello.domain.search.TbSearchRepository;
import com.example.hello.service.search.SearchService;
import com.example.hello.utils.NaverApiMovie;
import com.example.hello.web.dto.SearchSaveRequestDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchController {
    private final SearchService searchService;

    @PostMapping("/api/v1/search")
    public Long save(@RequestBody SearchSaveRequestDto searchSaveRequestDto){
        return searchService.save(searchSaveRequestDto);
    }

    @PostMapping("/api/v1/news")
    public String news(@RequestBody SearchSaveRequestDto searchSaveRequestDto){
        return searchService.news(searchSaveRequestDto);
    }

    @PostMapping("/api/v1/movie")
    public String movie(){
        List<String> movieList = searchService.movie();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(movieList);
        return json;
    }


//    @GetMapping("/api/v1/foodrand")
//    public TbSearch foodrandom(){
//        return searchService.findSearchRand();
//    }


}
