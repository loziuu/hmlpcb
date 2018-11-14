package pl.loziuu.hmlpcb.core.bot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CommandReply {
    private final CommandType type;
    private final String question;
    private final String answer;
    private final CommandApplicablePolicy policy;

    @JsonCreator
    public CommandReply(
            @JsonProperty("type") CommandType type,
            @JsonProperty("question") String question,
            @JsonProperty("answer") String answer) {
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.policy = new LevenshteinBasedPolicy(5);
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isApplicable(Command command) {
        return type.equals(CommandType.GREETING) && type.equals(command.getType())  ||
                type.equals(command.getType()) && command.getQuestion().startsWith(question) ||
                policy.isApplicable(question, command);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandReply)) return false;
        CommandReply that = (CommandReply) o;
        return type == that.type &&
                Objects.equals(question, that.question) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, question, answer);
    }
}
