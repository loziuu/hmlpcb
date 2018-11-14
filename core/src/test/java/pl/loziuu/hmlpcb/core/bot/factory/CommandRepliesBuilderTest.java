package pl.loziuu.hmlpcb.core.bot.factory;

import org.junit.Test;
import pl.loziuu.hmlpcb.core.bot.CommandReply;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandRepliesBuilderTest {

    @Test
    public void commandReplyBuilder() {
        Set<CommandReply> replies = CommandRepliesBuilder
                .getBuilder()
                .normal("How are you today?", "I'm fine, thank you.")
                .normal("What programming language do you recommend?", "Java, of course :)")
                .greeting("Hi", "Hi, how can I help you today?")
                .build();

        assertThat(replies).hasSize(3);
    }

    @Test
    public void creatingTwoExactSameRepliesShouldReturnOnlyOne() {
        Set<CommandReply> replies = CommandRepliesBuilder.getBuilder()
                .normal("Test", "Test")
                .normal("Test", "Test")
                .build();

        assertThat(replies).hasSize(1);
    }
}
