package com.question.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuestionDto {
	
	
	    @NotNull(message = "{notNull.userId}")
        private long userId;
	
	    @NotBlank(message = "{notBlank.title}")
	    private String title;

	    @NotBlank(message = "{notBlank.description}")
	    private String description;
	    
	    

}
