package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Question;
import model.User;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static void writeQuestionsToFile(List<Question> questions, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(questions);

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Question> readQuestionsFromFile(String filename) {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(filename)) {
            List<Question> questions = gson.fromJson(reader, new TypeToken<List<Question>>() {}.getType());
            if (questions == null) {
                return new ArrayList<>();
            }
            return questions;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
