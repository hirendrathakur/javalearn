package singleton;

public enum  SingletonEnum {
    INSTANCE;
    private int secretValue;
    SingletonEnum() {
        secretValue = 5;
        System.out.println("invoked only once, when accessed for the first time");
    }

    public int getSecretValue() {
        return secretValue;
    }
}
