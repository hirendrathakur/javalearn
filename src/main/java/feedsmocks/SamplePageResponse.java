package feedsmocks;

import com.flipkart.rome.datatypes.response.page.v4.PageData;
import com.flipkart.rome.datatypes.response.page.v4.PageMeta;
import flipkart.lego.api.entities.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SamplePageResponse implements DataType {
    private PageMeta pageMeta;
    private List<Object> slots;
    private PageData pageData;

}
