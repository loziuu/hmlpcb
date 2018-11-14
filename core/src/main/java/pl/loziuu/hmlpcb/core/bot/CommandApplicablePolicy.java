package pl.loziuu.hmlpcb.core.bot;

public interface CommandApplicablePolicy {

    boolean isApplicable(String question, Command command);
}
