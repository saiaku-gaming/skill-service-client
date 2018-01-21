package com.valhallagame.skillserviceclient.message;

import javax.validation.constraints.NotNull;

import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSkillParameter {
	@NotNull
	@CheckLowercase
	private String characterName;

	@NotNull
	private SkillType name;
}
