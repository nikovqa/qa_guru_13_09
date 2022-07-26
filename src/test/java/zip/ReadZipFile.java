package zip;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadZipFile {

    ClassLoader classLoader = ReadZipFile.class.getClassLoader();

    @DisplayName("Check PDF")
    @Test
    void readPdfFromZip() {
        try(ZipFile file = new ZipFile(Objects.requireNonNull(classLoader.getResource("test.zip")).getFile())) {
            ZipEntry entry = file.getEntry("test.pdf");
            PDF pdf;
            try (InputStream stream = file.getInputStream(entry)) {
                pdf = new PDF(stream);
            }
            assertThat(pdf.text).contains("This is pdf file");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Check CSV")
    @Test
    void readCsvFromZip() throws Exception {
        try (ZipFile file = new ZipFile(Objects.requireNonNull(classLoader.getResource("test.zip")).getFile())){
            ZipEntry entry = file.getEntry("test.csv");
            List<String[]> list;
            try (InputStream stream = file.getInputStream(entry)) {
                CSVReader reader = new CSVReader(new InputStreamReader(stream));
                list = reader.readAll();
            }
            assertThat(list).contains(
                    new String[]{"29", "august", "1984"}
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Check XLS")
    @Test
    void readXlsxFromZip(){
        try(ZipFile file = new ZipFile(Objects.requireNonNull(classLoader.getResource("test.zip")).getFile())) {
            ZipEntry entry = file.getEntry("test.xlsx");
            XLS xls;
            try (InputStream stream = file.getInputStream(entry)) {
                xls = new XLS(stream);
            }
            assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue()).contains("year");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}