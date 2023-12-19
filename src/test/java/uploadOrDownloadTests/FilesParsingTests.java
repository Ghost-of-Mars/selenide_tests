package uploadOrDownloadTests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTests {

    ClassLoader classLoader = FilesParsingTests.class.getClassLoader();

    @Disabled
    @Test
    void testWithPDF() throws IOException {

        open("https://the-internet.herokuapp.com/download");
        File downloadedFile = $("a[href=\"download/dummy.pdf\"]").download();
        PDF content = new PDF(downloadedFile);
        assertThat(content.text).contains("Dummy PDF file");
    }

    @Disabled
    @Test
    void testWithXLSX() throws IOException {
        try (InputStream resourceAsStream = classLoader.getResourceAsStream("tests.zip")) {
            XLS xls = new XLS(resourceAsStream);
        }
    }

    @Test
    void zipParseTest() throws IOException, CsvException {
        try (InputStream is = classLoader.getResourceAsStream("tests.zip");
             ZipInputStream zis = new ZipInputStream(is)
        ) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {

                String fileName = zipEntry.getName();

                switch (fileName) {
                    case "test1.xlsx" -> {
                        XLS contentXLS = new XLS(zis);
                        assertThat(contentXLS.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).isEqualTo("Песня");
                        assertThat(contentXLS.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Группа");
                    }
                    case "test2.pdf" -> {
                        PDF contentPDF = new PDF(zis);
                        assertThat(contentPDF.text).contains("Властелин колец: Братство кольца");
                    }
                    case "Test3.csv" -> {
                        CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                        List<String[]> contentCSV = csvReader.readAll();
                        assertThat(contentCSV.get(0)[1]).contains(" книга");
                    }
                    default -> Assertions.fail("Не найден файл: " + fileName);
                }
            }
        }
    }
}
