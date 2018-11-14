package pl.loziuu.hmlpcb.core.bot;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LevenshteinTest {
    private final CommandApplicablePolicy policy = new LevenshteinBasedPolicy(1);

    @Test
    public void testLevenshteinAlgorithm() {
        Command command = Command.normal("Can yo help me?");

        boolean applicable = policy.isApplicable("Can you help me?", command);

        assertThat(applicable).isTrue();
    }

    @Test
    public void testCommandReplyApplicable() {
        CommandReply reply = new CommandReply(CommandType.NORMAL, "Can you help me", "No");
        Command command = Command.normal("Can you help me, nigga?");

        boolean result = reply.isApplicable(command);

        assertThat(result).isTrue();
    }
}
