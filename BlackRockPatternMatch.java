import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BlackRockPatternMatch {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] splittedInput = line.split(";");
      String pattern = splittedInput[0];
      String blobs = splittedInput[1];
      BlackRockPatternMatch.doSomething(pattern, blobs);
    }
  }
  
  public static void doSomething(String pattern, String blobs) {
    // Write your code here. Feel free to create more methods and/or classes
    StringBuilder sb = new StringBuilder();
    int sum = 0;
    for (String blob : blobs.split("\\|")) {
      int count = 0;
      if (!pattern.isEmpty()) {
        for (int start = 0; start < blob.length();) {
          int occur = blob.indexOf(pattern, start);
          if (occur == -1) break;
          start = 1 + occur;
          count++;
        }
      }
      sum += count;
      sb.append("|").append(count);
    }
    sb.deleteCharAt(0).append("|").append(sum);
    System.out.println(sb);
  }
}