import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FolderWalker {
    public static void main(String[] args) throws Exception {
        Path start = Path.of(".");
        Path summaryFile = Files.createTempFile("summary_", ".txt");

        try (Stream<Path> stream = Files.walk(start, 2);
             BufferedWriter writer = Files.newBufferedWriter(summaryFile)) {

            stream.filter(Files::isRegularFile).forEach(p -> {
                try {
                    BasicFileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
                    writer.write(p.getFileName() + " | " + attrs.size() + " bytes | " + attrs.lastModifiedTime());
                    writer.newLine();
                } catch (Exception e) {
                }
            });
        }

        System.out.println("Folder traversal summary generated at: " + summaryFile.getFileName());
        Files.deleteIfExists(summaryFile);
    }
}
