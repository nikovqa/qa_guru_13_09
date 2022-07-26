package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;


public class JsonTest {
    ClassLoader classLoader = JsonTest.class.getClassLoader();

    @Test
    void jsonTest() throws Exception {
        InputStream is = classLoader.getResourceAsStream("car.json");
        ObjectMapper objectMapper = new ObjectMapper();
        assert is != null;
        JsonNode jsonNode = objectMapper.readTree(new InputStreamReader(is, UTF_8));

        assertThat(jsonNode.findValue("name").findValue("rudeName").asText()).isEqualTo("Vedro");
        assertThat(jsonNode.withArray("model").findValue("isHatchback").asBoolean()).isEqualTo(true);
        assertThat(jsonNode.findValue("details").findValue("maxSpeed").asInt()).isEqualTo(250);
    }
}