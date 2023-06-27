import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class FileUploadTest {

    @Test
    void uploadTest() throws Exception {
        Configuration.browserSize = "1920x1080";
        Selenide.open( "https://tus.io/demo.html" );
        $( "input[type='file']" ).uploadFromClasspath( "cat1.png" );

    }
}
