package com.example.hello.service.search;

import com.example.hello.domain.food.TbFood;
import com.example.hello.domain.food.TbFoodRepository;
import com.example.hello.domain.search.TbSearch;
import com.example.hello.domain.search.TbSearchRepository;
import com.example.hello.utils.NaverApiMovie;
import com.example.hello.utils.NaverApiSearch;
import com.example.hello.web.dto.SearchSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchService {
    private final TbSearchRepository tbSearchRepository;
    private final TbFoodRepository tbFoodRepository;

    @Transactional
    public Long save(SearchSaveRequestDto searchSaveRequestDto){
        return tbSearchRepository.save(searchSaveRequestDto.toEntity()).getId();
    }

    public String news(SearchSaveRequestDto searchSaveRequestDto){
        return NaverApiSearch.newsApi(searchSaveRequestDto.getSearch());
    }

    public List<TbFood> findAll(){
        return tbFoodRepository.findAll();
    }

    public List<TbFood> findFoodRand(){
        return tbFoodRepository.findFoodRand();
    }

    public TbSearch findSearchRand(){
        return tbSearchRepository.findSearchRand();
    }

    public List<String> movie(){
        return NaverApiMovie.movie();
    }



}
