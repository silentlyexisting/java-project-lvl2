package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private final Path path = Paths.get("src/test/resources/jsonexpected").toAbsolutePath().normalize();
    private final String file = Files.readString(path);

    private final Path path2 = Paths.get("src/test/resources/jsonRecursiveExpected").toAbsolutePath().normalize();
    private final String file2 = Files.readString(path2);

    AppTest() throws IOException {}

    @Test
    void getTestForJson() throws Exception {
        String readedFile1 = "src/test/resources/fixtures/jsonfile1.json";
        String readedFile2 = "src/test/resources/fixtures/jsonfile2.json";
        String actual = Differ.generate(readedFile1, readedFile2);
        String expected = file;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTestForYaml() throws Exception {
        String yamlFilePath1 = "src/test/resources/fixtures/yamlfile1.yaml";
        String yamlFilePath2 = "src/test/resources/fixtures/yamlfile2.yaml";
        String actual = Differ.generate(yamlFilePath1, yamlFilePath2);
        String expected = file;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTestForFlatJson() throws Exception {
        String jsonFilePath1 = "src/test/resources/fixtures/jsonRecursiveFile1.json";
        String jsonFilePath2 = "src/test/resources/fixtures/jsonRecursiveFile2.json";
        String actual = Differ.generate(jsonFilePath1, jsonFilePath2);
        String expected = file2;
        Assertions.assertEquals(expected, actual);
    }



}