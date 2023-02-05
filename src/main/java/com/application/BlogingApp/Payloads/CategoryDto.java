package com.application.BlogingApp.Payloads;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer id;
    @NotEmpty
    private String category_title;
    @NotEmpty
    private String category_description;
}
