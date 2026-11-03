// Practical 11 - Program 3: Java NIO Recursive Folder Walker (Interactive)
// Student ID: 25CS011 | Fenil Jagdishbhai Finava
import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;

public class FolderWalker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Java NIO Directory Scanner (Files.walk) ===");
        System.out.print("Enter folder path to scan (or press Enter for current dir '.'): ");
        String pStr = sc.nextLine().trim();
        if (pStr.isEmpty()) pStr = ".";

        Path startPath = Paths.get(pStr);
        if (!Files.exists(startPath)) {
            System.out.println("Path does not exist: " + startPath);
            return;
        }

        try {
            long[] stats = { 0, 0 }; // count, totalBytes
            Files.walk(startPath)
                 .filter(Files::isRegularFile)
                 .filter(p -> p.toString().endsWith(".java"))
                 .forEach(p -> {
                     try {
                         stats[0]++;
                         stats[1] += Files.size(p);
                         System.out.println("  • " + p.getFileName() + " (" + Files.size(p) + " bytes)");
                     } catch (IOException e) {}
                 });

            System.out.println("\nScan Complete!");
            System.out.println("Total Java Source Files found: " + stats[0]);
            System.out.println("Total Size: " + stats[1] + " bytes (" + String.format("%.2f", stats[1] / 1024.0) + " KB)");
        } catch (IOException e) {
            System.out.println("Error walking folder: " + e.getMessage());
        }
    }
}
