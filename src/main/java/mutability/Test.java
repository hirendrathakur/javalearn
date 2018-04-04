package mutability;

public class Test {
    public static void main(String[] args) {
        Mutate mutate = new Mutate("hirendra");
        TestModel testModel = new TestModel("1","2", mutate);
        Mutate mutate1 = testModel.getMutate();
        System.out.println(testModel.getMutate().getMutable());

        mutate1.setMutable("thakur");
        System.out.println(testModel.getMutate().getMutable());;
    }
}
