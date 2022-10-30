package Task2_Loading;

import java.util.List;
import java.util.Scanner;

public class Service {
    public synchronized String selectUserByNumber(List<UserModel> list, int number) {
        String a = null;
        for (UserModel model : list) {
            if (model.getNumber() == number) {
                a = model.getName();
            }
        }
        return a;
    }
}
