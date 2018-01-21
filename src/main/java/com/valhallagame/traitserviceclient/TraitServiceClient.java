package com.valhallagame.traitserviceclient;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.traitserviceclient.message.AddTraitParameter;
import com.valhallagame.traitserviceclient.message.GetTraitsParameter;

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

	public RestResponse<List<String>> getTraits(String username) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/get-traits",
				new GetTraitsParameter(username), new TypeReference<List<String>>() {});
	}

	public RestResponse<String> addTrait(AddTraitParameter input) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/add-trait",
				input, String.class);
	}
}
