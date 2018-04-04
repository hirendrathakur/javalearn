package objectmapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TestModel {
    String x;
    String y;

    TestModel copy (TestModel testModel) {
        return new TestModel(testModel.x, testModel.y);
    }
}
