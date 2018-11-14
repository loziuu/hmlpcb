package pl.loziuu.hmlpcb.core.bot.factory;

import org.junit.Test;
import pl.loziuu.hmlpcb.core.bot.Bot;
import pl.loziuu.hmlpcb.core.bot.BotFactory;
import pl.loziuu.hmlpcb.core.bot.InMemoryBotFactory;
import pl.loziuu.hmlpcb.core.conversation.Conversation;
import pl.loziuu.hmlpcb.core.conversation.Message;
import pl.loziuu.hmlpcb.core.conversation.MessageAuthor;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryFactoryTest {

    @Test
    public void createBotWithCachedReplies() {
        BotFactory factory = new InMemoryBotFactory(
                CommandRepliesBuilder.getBuilder()
                        .greeting("Hi", "This is bot factory testLevenshteinAlgorithm.")
                        .build());

        Bot bot = factory.createBot();
        Conversation conversation = bot.greet("Hi");

        assertThat(conversation.getMessages()).contains(
                new Message(MessageAuthor.BOT, 1, "This is bot factory testLevenshteinAlgorithm."));
    }
}
