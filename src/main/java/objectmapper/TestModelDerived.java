package objectmapper;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestModelDerived extends TestModel {

    public TestModelDerived(String x, String y) {
        super(x, y);
    }

    @Override
    public Foo getValidFoo() {
        return Foo.foo;
    }
}
