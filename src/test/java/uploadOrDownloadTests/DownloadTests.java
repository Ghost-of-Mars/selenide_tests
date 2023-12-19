package uploadOrDownloadTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class DownloadTests {

//    static {
//        Configuration.fileDownload = FileDownloadMode.PROXY;
//    }
    @Test
    void downloadTest() throws IOException {
        open("https://the-internet.herokuapp.com/download");
        File downloadedFile = $("a[href=\"download/some-file.txt\"]").download();

        try (InputStream inputStream = new FileInputStream(downloadedFile)) {
            byte[] contentBytes = inputStream.readAllBytes();
            String content = new String(contentBytes, StandardCharsets.UTF_8);
            assertThat(content).contains("\\margl1440\\margr1440\\vieww10800\\viewh8400\\viewkind0");
        }
    }
}
