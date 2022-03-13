package test.lesson9qaguru;

import com.codeborne.pdftest.PDF;
        import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
        import org.junit.jupiter.api.Test;
import test.lesson9qaguru.jsonclass.MenuJson;

import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.Enumeration;
        import java.util.List;
        import java.util.zip.ZipEntry;
        import java.util.zip.ZipFile;

    import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.array;


public class ParsingZipTest {

    @Test
    public void fromFile() throws Exception {
        String pathFile = "src/test/resources/9HW.zip";
        ZipFile zipFile = new ZipFile(pathFile);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().contains("pdf")) {
                assertThat(entry.getName()).isEqualTo("pdfTest.pdf");
                parsePdfTest(zipFile.getInputStream(entry));
            } else if (entry.getName().contains("xlsx")) {
                assertThat(entry.getName()).isEqualTo("xlxTest.xlsx");
                parseXlsTest(zipFile.getInputStream(entry));
            } else if (entry.getName().contains("csv")) {
                assertThat(entry.getName()).isEqualTo("csvTest.csv");
                parseCsvTest(zipFile.getInputStream(entry));
            }
        }
    }

    void parsePdfTest(InputStream file) throws Exception {
        PDF pdf = new PDF(file);
        assertThat(pdf.text).contains(
                "Коллекции на вкладке"
        );
    }

    void parseXlsTest(InputStream file) throws Exception {
        XLS xls = new XLS(file);
        assertThat(xls.excel
                .getSheetAt(0)
                .getRow(0)
                .getCell(1)
                .getStringCellValue()).contains("Описание проверки");
    }

    void parseCsvTest(InputStream file) throws Exception {
        try (CSVReader csv = new CSVReader(new InputStreamReader(file))) {
            List<String[]> content = csv.readAll();
            assertThat(content.get(0)).contains(
                    "test 1;Sunday"
            );
        }
    }

    @Test
    void jsonTest() throws Exception{
            ClassLoader classLoader = getClass().getClassLoader();
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream is = classLoader.getResourceAsStream("JsonHW9.json")) {
                MenuJson json = mapper.readValue(is, MenuJson.class);
                assertThat(json.Menu).contains("sandvich");
                assertThat(json.Items).contains("hleb");
                assertThat(json.Actions).contains("kushat");
            }
    }
}
