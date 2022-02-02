import java.lang.reflect.Field;

final class AccountUtils {

    private AccountUtils() {
    }

    public static void increaseBalance(Account account, long amount)
            throws IllegalAccessException, NoSuchFieldException {
        Field f1 = Account.class.getDeclaredField("balance");
        f1.setAccessible(true);
        f1.set(account, f1.getLong(account) + amount);


    }
}