package misc;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IngestedClass {
    GetTask getTask;

    void testIfIngested() {
        System.out.println(getTask.getTask());
    }
}
