import org.junit.Test;

import java.net.URLDecoder;

public class test {

    @Test
    public void test(){
        String user = URLDecoder.decode("user");
        System.out.println(user);
    }

}
