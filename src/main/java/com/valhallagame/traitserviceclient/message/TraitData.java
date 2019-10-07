package com.valhallagame.traitserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraitData {

	@NotNull
	private List<TraitType> unlockedTraits;

	@NotNull
	private List<TraitType> purchasedTraits;

	@NotNull
	private List<SkilledTraitData> skilledTraits;
}
