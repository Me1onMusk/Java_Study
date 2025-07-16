package annotation.validator;

import static util.MyLogger.log;

public class ValidatorV2Main {
    public static void main(String[] args) {

        User user1 = new User("user1", 0);
        Team team = new Team("", 0);

        try {
            log("== user 검증 ==");
            Validator.validate(user1);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("== team 검증 ==");
            Validator.validate(team);
        } catch (Exception e) {
            log(e);
        }

    }
}
