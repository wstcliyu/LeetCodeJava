import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;


/*
Programming challenge description:
We say a portfolio matches the benchmark when the number of shares of each asset in the portfolio matches the number of shares of each asset in the benchmark. Your question is to write a program that determines the transactions necessary to make a portfolio match a benchmark.

A portfolio is a collection of assets such as stocks and bonds. A portfolio could have 10 shares of Vodafone stock, 15 shares of Google stock and 15 shares of Microsoft bonds. A benchmark is also just a collection of assets. A benchmark could have 15 shares of Vodafone stock, 10 shares of Google stock and 15 shares of Microsoft bonds.

A transaction is when you “buy” or “sell” a particular asset of certain asset type (“stock” or “bond”). For instance, you can decide to buy 5 shares of Vodafone stock which, given the portfolio described above, would result in you having 15 shares of Vodafone stock. Correspondingly, you decide to sell 5 shares of Microsoft bonds, which would result in 10 shares of Microsoft bonds in the above portfolio.

Assumptions:

Shares are positive decimals
There will always be at least 1 asset present in the Portfolio and Benchmark
A particular asset can be bond, stock, or both. For example, 5 shares of Microsoft bonds and 10 shares of Microsoft stock can both be present in the portfolio/benchmark
The trades should be sorted in alphabetical order based on the names of the assets; if both bonds and stock are present for an asset, list bonds first
Input:
The first part of the input is the Portfolio holdings (in the format Name,AssetType,Shares where each asset is separated by '|' symbol)
The second part of the input is the Benchmark holdings (in the format Name,AssetType,Shares where each asset is separated by '|' symbol)
Example input: Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15

Note that the two parts are separated by the ':' symbol.

Output:
The output is a list of transactions (separated by new line) in the format TransactionType,Name,AssetType,Shares. Note that the TransactionType should only be BUY or SELL.

Example output: SELL,Google,STOCK,5 BUY,Vodafone,STOCK,5

Test 1
Test Input
Download Test 1 Input
Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15
Expected Output
Download Test 1 Input
SELL,Google,STOCK,5
BUY,Vodafone,STOCK,5
Test 2
Test Input
Download Test 2 Input
Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10
Expected Output
Download Test 2 Input
SELL,Google,STOCK,5
BUY,Vodafone,BOND,10
BUY,Vodafone,STOCK,5
*/


public class BlackRockPortfolioBenchmark {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      BlackRockPortfolioBenchmark.matchBenchmark(line);
    }
  }
  
  private class Transaction {
    Asset asset;
    String transType;
    int quantity;
    Transaction(Map.Entry<Asset, Integer> entry) {
      asset = entry.getKey();
      quantity = Math.abs(entry.getValue());
    }
  }
  

  // Override boolean equals(Object o) and int hashCode()
  private class Asset {
    String name;
    String type;
    Asset(String _n, String _t) {
      name = _n;
      type = _t;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Asset asset = (Asset)o;    
      return this.name.equals(asset.name) && this.type.equals(asset.type);
    }
    
    @Override
    public int hashCode() {
      return (name + type).hashCode();
    }
  }
  
  
  // parse unstructured data
  private void parseData(String data, Map<Asset, Integer> map, int multiple) {
    String[] field = data.split(",");
    Asset asset = new Asset(field[0], field[1]);
    int quantity = Integer.valueOf(field[2]);
    map.put(asset, map.getOrDefault(asset, 0) + quantity * multiple);
  }
  
  public static void matchBenchmark(String input) {
    // Split into portfolio and benchmark by colon
    int colon = input.indexOf(":");
    String portfolio = input.substring(0, colon);
    String benchmark = input.substring(colon + 1);

    // Calculate how many assets to buy or sell
    Map<Asset, Integer> map = new HashMap<>();
    BlackRockPortfolioBenchmark solution = new BlackRockPortfolioBenchmark();
    for (String data : benchmark.split("\\|")) {
      solution.parseData(data, map, 1);
    }
    for (String data : portfolio.split("\\|")) {
      solution.parseData(data, map, -1);
    }

    // Store all needed transactions into a list
    List<Transaction> result = new ArrayList<>();
    for (Map.Entry<Asset, Integer> entry : map.entrySet()) {
      Transaction trans = solution.new Transaction(entry);
      if (entry.getValue() > 0) {
        trans.transType = "BUY";
        result.add(trans);
      } else if (entry.getValue() < 0) {
        trans.transType = "SELL";
        result.add(trans);
      }
    }

    // Sort the list and print output
    Collections.sort(result, Comparator.comparing((Transaction t) -> t.asset.name).thenComparing(t -> t.asset.type));
    for (Transaction t : result) {
      System.out.println(t.transType + "," + t.asset.name + "," + t.asset.type + "," + t.quantity);
    }
  }

}