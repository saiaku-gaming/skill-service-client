package com.valhallagame.traitserviceclient;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.traitserviceclient.message.GetTraitsParameter;
import com.valhallagame.traitserviceclient.message.LockTraitParameter;
import com.valhallagame.traitserviceclient.message.SkillTraitParameter;
import com.valhallagame.traitserviceclient.message.TraitData;
import com.valhallagame.traitserviceclient.message.UnlockTraitParameter;
import com.valhallagame.traitserviceclient.message.UnskillTraitParameter;

public class TraitServiceClient {
	private static TraitServiceClient traitServiceClient;

	private String traitServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.TRAIT_SERVICE_PORT;
	private RestCaller restCaller;

	private TraitServiceClient() {
		restCaller = new RestCaller();
	}

	public static void init(String traitServiceServerUrl) {
		TraitServiceClient client = get();
		client.traitServiceServerUrl = traitServiceServerUrl;
	}

	public static TraitServiceClient get() {
		if (traitServiceClient == null) {
			traitServiceClient = new TraitServiceClient();
		}

		return traitServiceClient;
	}

	public RestResponse<TraitData> getTraits(String username) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/get-traits",
				new GetTraitsParameter(username), new TypeReference<TraitData>() {
				});
	}

	public RestResponse<String> unlockTrait(UnlockTraitParameter input) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/unlock-trait",
				input, String.class);
	}

	public RestResponse<String> lockTrait(LockTraitParameter input) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/lock-trait",
				input, String.class);
	}

	public RestResponse<String> skillTrait(SkillTraitParameter input) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/skill-trait",
				input, String.class);
	}

	public RestResponse<String> unskillTrait(UnskillTraitParameter input) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/unskill-trait",
				input, String.class);
	}
}
