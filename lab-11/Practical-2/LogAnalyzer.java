// Practical: lab-11 - Practical-2 (LogAnalyzer.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) throws Exception {
        Path p1 = Files.createTempFile("log1_", ".txt");
        Path p2 = Files.createTempFile("log2_", ".txt");

        Files.write(p1, List.of("INFO server started", "ERROR connection refused", "INFO ready"));
        Files.write(p2, List.of("INFO job completed", "ERROR disk full"));

        Path[] paths = { p1, p2 };
        int totalLines = 0;
        int errorCount = 0;

        for (Path p : paths) {
            BasicFileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
            System.out.println("File: " + p.getFileName() + " Size: " + attrs.size() + " bytes");

            try (BufferedReader reader = Files.newBufferedReader(p)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    totalLines++;
                    if (line.contains("ERROR")) {
                        errorCount++;
                    }
                }
            }
            Files.deleteIfExists(p);
        }

        System.out.println("Total lines analyzed: " + totalLines);
        System.out.println("Keyword 'ERROR' matches: " + errorCount);
    }
}
