package com.question.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Component
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Message<T> {
	
	private String message;
	private T data;
	private List<?> list;

}