package objectmapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public enum JSONObjectMapper {
    INSTANCE;
    private ObjectMapper objectMapper;

    JSONObjectMapper() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ObjectMapper getObjectMapper () {
        return objectMapper;
    }

    public JavaType getJavaType(Class clasType) {
        return getObjectMapper().getTypeFactory().constructType(clasType);
    }


    public JavaType getJavaListType(Class classType) {
        return getObjectMapper().getTypeFactory().constructCollectionLikeType(List.class, classType);
    }

}
