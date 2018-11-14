package pl.loziuu.hmlpcb.core.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JsonBotFactory implements BotFactory {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public Bot createBot() {
        final Set<CommandReply> replies = loadReplies();
        return new Bot(replies);
    }

    private Set<CommandReply> loadReplies() {
        File folder = createFolder();
        File repliesFile = new File("replies/replies.json");
        Set<CommandReply> replies = new HashSet<>();
        try {
            final FileInputStream stream = new FileInputStream(repliesFile);
            replies = MAPPER.readValue(stream, new TypeReference<Set<CommandReply>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return replies;
    }

    private File createFolder() {
        File file = new File("replies");
        if (!file.exists())
            file.mkdir();
        return file;
    }
}
