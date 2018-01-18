package com.valhallagame.wardrobeserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddWardrobeItemParameter {
	@NotNull
	private String characterName;
	
	@NotNull
	private WardrobeItem name;
}
