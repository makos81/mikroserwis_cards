package com.kodilla.cards.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MapperConfiguration {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
