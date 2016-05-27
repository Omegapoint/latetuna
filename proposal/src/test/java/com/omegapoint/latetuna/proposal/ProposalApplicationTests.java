package com.omegapoint.latetuna.proposal;

import com.omegapoint.latetuna.proposal.ProposalApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProposalApplication.class)
@WebAppConfiguration
public class ProposalApplicationTests {

	@Test
	public void contextLoads() {
	}

}
