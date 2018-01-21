package com.valhallagame.traitserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraitData {
	@NotNull
	private TraitType name;

	int barIndex;
	
}
