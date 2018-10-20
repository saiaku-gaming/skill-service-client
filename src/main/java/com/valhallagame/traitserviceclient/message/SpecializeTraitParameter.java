package com.valhallagame.traitserviceclient.message;

import com.valhallagame.common.validation.CheckLowercase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecializeTraitParameter {
    @NotBlank
    @CheckLowercase
    private String characterName;

    @NotNull
    private TraitType name;

    @NotNull
    @Min(0)
    private Integer specialization;

    @NotNull
    private Integer positionX;

    @NotNull
    private Integer positionY;
}
