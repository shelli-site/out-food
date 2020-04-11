package mb.te.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

/**
 * Created By shenxi On 2020/4/11 13:16
 */
public class JsonParseUtil extends JsonSerializer<String> {
    @Override
    public void serialize(String parseValue, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map res = mapper.readValue(parseValue, Map.class);
        gen.writeObject(res);
    }
}
