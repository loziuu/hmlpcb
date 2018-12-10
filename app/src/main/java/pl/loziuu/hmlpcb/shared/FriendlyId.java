package pl.loziuu.hmlpcb.shared;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class FriendlyId {

    private FriendlyId() {
    }

    public static String makeItFriendly(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16])
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits());
        String result = Base64.getUrlEncoder().encodeToString(bb.array());
        return result.substring(0, result.length() - 2);
    }

    public static UUID showMeYourTrueNature(String friendlyId) {
        byte[] bytes = Base64.getUrlDecoder().decode(friendlyId);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return new UUID(bb.getLong(), bb.getLong());
    }
}
