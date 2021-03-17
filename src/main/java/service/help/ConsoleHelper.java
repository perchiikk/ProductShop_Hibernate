package service.help;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readText(){
        try {
            return reader.readLine();
        }
        catch (NullPointerException e){
            ConsoleHelper.writeMessage("Вы ввели пустую строку");
        }
        catch (Exception e){
            ConsoleHelper.writeMessage("Произошла ошибка");
        }
        return null;
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readText());
        }
        catch (NumberFormatException e){
            ConsoleHelper.writeMessage("Вы ввели неверное число. Повторите ввод");
        }
        catch (Exception e){
            ConsoleHelper.writeMessage("Произошла ошибка");
        }
        return 0;
    }

    public static String firstUpperCase(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
