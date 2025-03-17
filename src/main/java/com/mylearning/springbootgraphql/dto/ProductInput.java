package com.mylearning.springbootgraphql.dto;

//records are immutable they don't have any setters
public record ProductInput(String name, String category, Double price, Integer quantity, String description) {
}


