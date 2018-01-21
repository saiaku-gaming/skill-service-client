package com.valhallagame.skillserviceclient;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.skillserviceclient.message.AddSkillParameter;
import com.valhallagame.skillserviceclient.message.GetSkillsParameter;

public class SkillServiceClient {
	private static SkillServiceClient skillServiceClient;

	private String skillServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.SKILL_SERVICE_PORT;
	private RestCaller restCaller;

	private SkillServiceClient() {
		restCaller = new RestCaller();
	}

	public static void init(String skillServiceServerUrl) {
		SkillServiceClient client = get();
		client.skillServiceServerUrl = skillServiceServerUrl;
	}

	public static SkillServiceClient get() {
		if (skillServiceClient == null) {
			skillServiceClient = new SkillServiceClient();
		}

		return skillServiceClient;
	}

	public RestResponse<List<String>> getSkills(String username) throws IOException {
		return restCaller.postCall(skillServiceServerUrl + "/v1/skill/get-skills",
				new GetSkillsParameter(username), new TypeReference<List<String>>() {});
	}

	public RestResponse<String> addSkill(AddSkillParameter input) throws IOException {
		return restCaller.postCall(skillServiceServerUrl + "/v1/skill/add-skill",
				input, String.class);
	}
}
