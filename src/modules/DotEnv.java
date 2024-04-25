package modules;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnv {

    public String getDotEnv(String key) {
        Dotenv dotEnv = Dotenv.configure()
                .directory(".")
                .filename(".env")
//                .filename("dev.env") // DEV
                .load();
        String value = dotEnv.get(key);
        return value;
    }

}
