package pl.loziuu.hmlpcb.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.loziuu.hmlpcb.core.bot.CommandReply;
import pl.loziuu.hmlpcb.core.bot.CommandType;

import java.util.UUID;

@Document(collection = "bot_responses")
public class BotResponseModel {

    @Id
    private UUID uuid = UUID.randomUUID();

    private CommandType type;
    private String question;
    private String answer;

    public CommandType getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public CommandReply asCommandReply() {
        return new CommandReply(type, question, answer);
    }
}
