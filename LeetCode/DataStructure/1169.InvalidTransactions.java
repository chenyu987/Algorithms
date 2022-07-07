/*

A transaction is possibly invalid if:

the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.

Return a list of transactions that are possibly invalid. You may return the answer in any order.

 

Example 1:

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
Example 2:

Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Example 3:

Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]

*/

class Solution {
  public List<String> invalidTransactions(String[] transactions) {
    Map<String, List<Transaction>> nameToTransaction = new HashMap<>();
    for (int i = 0; i < transactions.length; i++) {
      Transaction t = new Transaction(transactions[i], i);
      nameToTransaction.putIfAbsent(t.name, new ArrayList<>());
      nameToTransaction.get(t.name).add(t);
    }
    List<String> invalid = new ArrayList<>();
    for (List<Transaction> list : nameToTransaction.values()) {
      for (Transaction t : list) {
        if (t.isInvalidAmount()) invalid.add(transactions[t.id]);
        else {
          for (Transaction otherT : list) {
            if (t.isInvalidCity(otherT)) {
              invalid.add(transactions[t.id]);
              break;
            }
          }
        }
      }
    }
    return invalid;
  }
}

class Transaction {
  String name, city;
  int time, amount, id;

  Transaction(String s, int id) {
    this.id = id;
    String[] split = s.split(",");
    name = split[0];
    time = Integer.parseInt(split[1]);
    amount = Integer.parseInt(split[2]);
    city = split[3];
  }

  public boolean isInvalidAmount() {
    return this.amount > 1000;
  }

  public boolean isInvalidCity(Transaction t) {
    return !city.equals(t.city) && Math.abs(t.time - time) <= 60;
  }
}
