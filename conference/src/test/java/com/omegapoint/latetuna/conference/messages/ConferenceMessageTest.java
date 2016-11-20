package com.omegapoint.latetuna.conference.messages;

import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit.PactRunner;
import com.omegapoint.latetuna.conference.domain.Conference;
import com.omegapoint.latetuna.conference.resource.JsonUtil;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)
public class ConferenceMessageTest {

	@PactVerifyProvider("when a conference is created it")
	public String verifyCreateConferenceMessage() {
		Conference conference = new Conference("QCon", "London");
		return JsonUtil.toJson(conference);
	}
}
