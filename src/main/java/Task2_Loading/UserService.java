package Task2_Loading;

import java.util.List;
import java.util.Scanner;

public class UserService {
    public synchronized static void selectUserByNumber (){
        List<UserModel> list = UserModel.createCollection();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = in.nextInt();
        for (UserModel userModel : list) {
            if (userModel.getNumber() == number) {
                System.out.println(userModel.getName());
            }
        }
    }
}
