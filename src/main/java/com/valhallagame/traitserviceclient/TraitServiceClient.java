package com.valhallagame.traitserviceclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.AbstractServiceClient;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestResponse;
import com.valhallagame.traitserviceclient.message.*;

import java.io.IOException;

public class TraitServiceClient extends AbstractServiceClient {
	private static TraitServiceClient traitServiceClient;

	private TraitServiceClient() {
		serviceServerUrl = "http://localhost:" + DefaultServicePortMappings.TRAIT_SERVICE_PORT;
	}

	public static void init(String serviceServerUrl) {
		TraitServiceClient client = get();
		client.serviceServerUrl = serviceServerUrl;
	}

	public static TraitServiceClient get() {
		if (traitServiceClient == null) {
			traitServiceClient = new TraitServiceClient();
		}

		return traitServiceClient;
	}

	public RestResponse<TraitData> getTraits(String username) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/get-traits",
				new GetTraitsParameter(username), new TypeReference<TraitData>() {
				});
	}

	public RestResponse<String> unlockTrait(UnlockTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/unlock-trait",
				input, String.class);
	}

	public RestResponse<String> lockTrait(LockTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/lock-trait",
				input, String.class);
	}

	public RestResponse<SkilledTraitData> purchaseTrait(PurchaseTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/purchase-trait",
				input, SkilledTraitData.class);
	}

	public RestResponse<SkilledTraitData> depurchaseTrait(DepurchaseTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/depurchase-trait",
				input, SkilledTraitData.class);
	}

	public RestResponse<String> skillTrait(SkillTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/skill-trait",
				input, String.class);
	}

	public RestResponse<String> unskillTrait(UnskillTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/unskill-trait",
				input, String.class);
	}

	public RestResponse<String> specializeTrait(SpecializeTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/specialize-trait",
				input, String.class);
	}

	public RestResponse<String> unspecializeTrait(UnspecializeTraitParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/trait/unspecialize-trait",
				input, String.class);
	}
}
