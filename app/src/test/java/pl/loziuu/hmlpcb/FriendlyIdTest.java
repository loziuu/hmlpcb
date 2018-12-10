package pl.loziuu.hmlpcb;

import org.junit.Test;
import pl.loziuu.hmlpcb.shared.FriendlyId;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendlyIdTest {

    @Test
    public void testMyFriendliness() {
        UUID uuid = UUID.randomUUID();

        String friendUuid = FriendlyId.makeItFriendly(uuid);
        UUID friendzoned = FriendlyId.showMeYourTrueNature(friendUuid);

        assertThat(friendzoned).isEqualTo(uuid);
    }
}
