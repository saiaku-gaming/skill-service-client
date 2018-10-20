package com.valhallagame.traitserviceclient.message;

import com.valhallagame.common.validation.CheckLowercase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnspecializeTraitParameter {
    @NotBlank
    @CheckLowercase
    private String characterName;

    @NotNull
    private TraitType name;
}
