package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.User;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<User> readUsersFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            return new Gson().fromJson(reader, new TypeToken<List<User>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // ... other methods
}
