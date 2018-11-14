package pl.loziuu.hmlpcb.core.bot;

import org.junit.Test;
import pl.loziuu.hmlpcb.core.conversation.Conversation;
import pl.loziuu.hmlpcb.core.conversation.Message;
import pl.loziuu.hmlpcb.core.conversation.MessageAuthor;

import static org.assertj.core.api.Assertions.assertThat;

public class BotCommandTest {
    private final Bot bot = BotFixtures.bot();

    @Test
    public void greetingCommandShouldStartNewConversation() {
        Conversation conversation = bot.greet("Hi");

        assertThat(conversation.getMessages())
                .contains(new Message(MessageAuthor.USER, 0, "Hi"));
        assertThat(conversation.getMessages())
                .contains(new Message(MessageAuthor.BOT, 1, "Hello!"));
    }

    @Test
    public void normalCommandShouldReturnAnswerFromFactory() {
        String reply = bot.tell(Command.normal("How are you today?"));

        assertThat(reply).isEqualTo("I'm great today, thank you.");
    }
}
