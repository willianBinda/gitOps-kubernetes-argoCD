package com.apiRestJava.apiRestJava.pizza;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PaginatePizzaDTO {
    private List<PizzaDTO> data;
    private long totalElements;
    private int totalPage;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public PaginatePizzaDTO(Page<PizzaDTO> paginatePizzaDTO){
        this.setData(paginatePizzaDTO.getContent());
        this.setTotalElements(paginatePizzaDTO.getTotalElements());
        this.setTotalPage(paginatePizzaDTO.getTotalPages());
        this.setCurrentPage(paginatePizzaDTO.getNumber() + 1);
        this.setFirst(paginatePizzaDTO.isFirst());
        this.setLast(paginatePizzaDTO.isLast());
        this.setHasNext(paginatePizzaDTO.hasNext());
        this.setHasPrevious(paginatePizzaDTO.hasPrevious());
    }

}
