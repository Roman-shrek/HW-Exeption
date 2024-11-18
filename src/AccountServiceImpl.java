import exeption.WrongLoginException;
import exeption.WrongPasswordException;

import java.util.regex.Pattern;

public class AccountServiceImpl {
    private static final Pattern LOGINANDPASSWORD_PATTERN = Pattern.compile("[A-Za-z0-9_]{1,20}");

    public static void enterInAccount(String login, String password, String confirmPassword) {
        try {
            enterLoginAndPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
           throw new WrongLoginException (e.getMessage());
        } catch (WrongPasswordException e) {
            throw new WrongPasswordException(e.getMessage());
        } finally {
            System.out.println("Обработка выполнена");
        }
    }

    private static void enterLoginAndPassword(String login, String password, String confirmPassword) {
        if (!LOGINANDPASSWORD_PATTERN.matcher(login).matches()) {
            throw new WrongLoginException("Логин неверный, проверьте правильность символов");
        } else if (!LOGINANDPASSWORD_PATTERN.matcher(password).matches()) {
            throw new WrongPasswordException("Некорректный пароль");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль не совпадает");
        }
    }
}