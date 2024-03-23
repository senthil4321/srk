import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSRParser {
    public static void main(String[] args) {
        String csrFilePath = "path/to/your/csr.csr";

        try (BufferedReader br = new BufferedReader(new FileReader(csrFilePath))) {
            StringBuilder csrContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                csrContent.append(line).append("\n");
            }

            // Pattern to match subject fields in CSR
            Pattern pattern = Pattern.compile("(?<=Subject:)(.*?)(?=Subject Public Key Info)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(csrContent);

            if (matcher.find()) {
                String subjectFields = matcher.group().trim();
                String[] fields = subjectFields.split(", ");
                for (String field : fields) {
                    System.out.println(field);
                }
            } else {
                System.out.println("No subject fields found in CSR.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
