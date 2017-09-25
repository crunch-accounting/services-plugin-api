package uk.co.crunch.platform.api.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class RabbitCommands {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    // Config is now purely a factor of host (well, and port...) since a config permits *all* roles
    public static String getConfigName(final RabbitUser user) {
        return user.instance().customConfigName().isEmpty() ? user.instance().host().replace('.','_').replace('-','_') : user.instance().customConfigName();
    }

    public static String getRoleName(final RabbitUser user, final String serviceAppName) {
        return user.customRoleName().isEmpty() ? serviceAppName : user.customRoleName();
    }

    public static String getConnectionUrl(final RabbitUser user) {
        return "http://" + user.instance().host() + ":" + user.instance().port();
    }

    public static String getUserCreationStatement(final RabbitUser user) {
        final Map<String,String> inner = new HashMap<>();
        inner.put("configure", user.configPrivs());
        inner.put("read", user.readPrivs());
        inner.put("write", user.writePrivs());

        final Map<String,Map<String,String>> outer = new HashMap<>();
        outer.put("/", inner);

        try {
            return MAPPER.writeValueAsString(outer);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
