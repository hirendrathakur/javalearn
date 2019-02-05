package powermockito;

import java.util.Collection;

public class Truck {
    public double addLoad(Collection<Double> boxWeightsToAdd) {
        for (Double boxWeight : boxWeightsToAdd) {
            addBoxToLoad(boxWeight);
        }
        return getLoadWeight();
    }
    private double getLoadWeight() {
        return 10;
    }
    private void addBoxToLoad(double weight) {
        throw new UnsupportedOperationException("Fail is not mocked! [weight="
                + weight + "]");
    }
}
