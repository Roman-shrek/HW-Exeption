import exeption.WrongLoginException;
import exeption.WrongPasswordException;

import java.util.regex.Pattern;

public class AccountServiceImpl {
    private static final Pattern LOGIN_PATTERN = Pattern.compile("[A-Za-z0-9_]{1,20}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[A-Za-z0-9_]{1,20}");

    public static void enterInAccount(String login, String password, String confirmPassword) {
        try {
            enterLogin(login);
            enterPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Задача отработана");
        }
    }

    private static void enterLogin(String login) throws WrongLoginException {
        if (!LOGIN_PATTERN.matcher(login).matches()) {
            throw new WrongLoginException("Логин неверный, проверьте правильность символов");
        }
    }

    private static void enterPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!PASSWORD_PATTERN.matcher(password).matches()){
            throw new WrongPasswordException("Некорректный пароль");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
