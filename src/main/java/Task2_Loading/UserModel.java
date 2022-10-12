package Task2_Loading;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class UserModel {
    private int number;
    private String name;
    public static List <UserModel> createCollection() {
        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(new UserModel(1, "Vasiliy"));
        userModelList.add(new UserModel(2, "Nikolay"));
        userModelList.add(new UserModel(3, "Natali"));
        userModelList.add(new UserModel(4, "Anatoliy"));
        userModelList.add(new UserModel(5, "Irina"));
        return userModelList;
    }
}
