package com.valhallagame.traitserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraitBarItem {

	@NotNull
	private TraitType name;

	private int barIndex;

}
