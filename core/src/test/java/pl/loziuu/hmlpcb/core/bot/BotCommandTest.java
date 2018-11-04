package pl.loziuu.hmlpcb.core.bot;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BotCommandTest {
    private final Bot bot = BotFixtures.bot();

    @Test
    public void greetingCommandShouldReturnGreetingFromBot() {
        String reply = bot.tell(Command.greeting("Hello!"));

        assertThat(reply).isEqualTo("Hello!");
    }

    @Test
    public void normalCommandShouldReturnAnswerFromFactory() {
        String reply = bot.tell(Command.normal("How are you today?"));

        assertThat(reply).isEqualTo("I'm great today, thank you.");
    }
}
