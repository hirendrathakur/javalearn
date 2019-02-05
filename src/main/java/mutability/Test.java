package mutability;

public class Test {
    public static void main(String[] args) {
        Mutate mutate = new Mutate("hirendra");
        TestModel testModel = new TestModel("1","2", mutate);
        Mutate mutate1 = testModel.getMutate();

        String s = mutate.getMutable();
        System.out.println(mutate.getMutable());
        System.out.println(mutate1.getMutable());

        mutate.setMutable("thakur");
        System.out.println(mutate.getMutable());
        System.out.println(mutate1.getMutable());

    }

    public Test(Test t ) {

    }
}


