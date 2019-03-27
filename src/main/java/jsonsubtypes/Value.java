package jsonsubtypes;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class Value implements Serializable {
}
