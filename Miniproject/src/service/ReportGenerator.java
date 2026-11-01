package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class ReportGenerator {
    public static void generateReport(Path logsDir, Path reportFile) throws IOException {
        long totalDeposits = 0;
        long totalWithdrawals = 0;

        if (Files.exists(logsDir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(logsDir, "*.log")) {
                for (Path entry : stream) {
                    BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                    try (BufferedReader reader = Files.newBufferedReader(entry)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.trim().split("\\s+");
                            if (parts.length >= 3) {
                                String type = parts[0].toUpperCase();
                                long amount = Long.parseLong(parts[2]);
                                if (type.equals("DEPOSIT")) {
                                    totalDeposits += amount;
                                } else if (type.equals("WITHDRAW")) {
                                    totalWithdrawals += amount;
                                }
                            }
                        }
                    }
                }
            }
        }

        long netChange = totalDeposits - totalWithdrawals;
        if (reportFile.getParent() != null) {
            Files.createDirectories(reportFile.getParent());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(reportFile)) {
            writer.write("==============================\n");
            writer.write("BANK SUMMARY REPORT\n");
            writer.write("Total Deposits   : Rs. " + totalDeposits + "\n");
            writer.write("Total Withdrawals: Rs. " + totalWithdrawals + "\n");
            writer.write("Net Change       : Rs. " + netChange + "\n");
            writer.write("==============================\n");
        }
    }
}
