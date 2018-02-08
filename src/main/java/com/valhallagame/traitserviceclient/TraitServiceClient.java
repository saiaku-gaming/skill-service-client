package com.valhallagame.traitserviceclient;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.traitserviceclient.message.AddTraitParameter;
import com.valhallagame.traitserviceclient.message.GetTraitsParameter;
import com.valhallagame.traitserviceclient.message.SaveTraitBarIndexParameter;
import com.valhallagame.traitserviceclient.message.TraitData;
import com.valhallagame.traitserviceclient.message.TraitType;

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

	public RestResponse<String> addTrait(AddTraitParameter input) throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/add-trait",
				input, String.class);
	}

	public RestResponse<String> saveTraitBarIndex(String username, TraitType traitType, int barIndex)
			throws IOException {
		return restCaller.postCall(traitServiceServerUrl + "/v1/trait/save-trait-bar-index",
				new SaveTraitBarIndexParameter(username, traitType, barIndex), String.class);
	}
}
