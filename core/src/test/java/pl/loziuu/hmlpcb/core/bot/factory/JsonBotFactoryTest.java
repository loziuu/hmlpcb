package pl.loziuu.hmlpcb.core.bot.factory;

import org.junit.Test;
import pl.loziuu.hmlpcb.core.bot.BotFactory;
import pl.loziuu.hmlpcb.core.bot.JsonBotFactory;

public class JsonBotFactoryTest {
    private final BotFactory factory = new JsonBotFactory();

    @Test
    public void loadJsonRepliesFromClasspath() {
        factory.createBot();
    }
}
