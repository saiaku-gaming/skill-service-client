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
public class SkillTraitParameter {
	@NotBlank
	@CheckLowercase
	private String characterName;

	@NotNull
	private TraitType name;

	@NotNull
	private AttributeType selectedAttribute;

	private Integer positionX;
	private Integer positionY;
}
