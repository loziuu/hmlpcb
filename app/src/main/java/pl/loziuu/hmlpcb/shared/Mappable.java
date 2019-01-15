package pl.loziuu.hmlpcb.shared;

import java.util.function.Function;

public interface Mappable<U> {

    <T> T map(Function<U, T> function);
}
