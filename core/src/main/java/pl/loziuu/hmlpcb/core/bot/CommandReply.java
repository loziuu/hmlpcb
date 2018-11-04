package pl.loziuu.hmlpcb.core.bot;

import java.util.Objects;

public class CommandReply {
    private final CommandType type;
    private final String question;
    private final String answer;

    public CommandReply(CommandType type, String question, String answer) {
        this.type = type;
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isApplicable(Command command) {
        return command.getType().equals(CommandType.GREETING) ||
                type.equals(command.getType()) && question.startsWith(command.getQuestion());
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
