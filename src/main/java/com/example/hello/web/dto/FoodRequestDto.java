package com.example.hello.web.dto;

import com.example.hello.domain.food.TbFood;
import com.example.hello.domain.search.TbSearch;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FoodRequestDto {
    private String name;
    private String img;

    @Builder
    public FoodRequestDto (String name, String img){
        this.name = name;
        this.img = img;
    }

    public TbFood toEntity(){
        return TbFood.builder()
                .name(name)
                .img(img)
                .build();
    }
}
