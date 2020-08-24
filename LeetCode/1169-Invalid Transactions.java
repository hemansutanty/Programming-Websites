import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
A transaction is possibly invalid if:

the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.

Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.

 

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
        Set<String> result = new HashSet<>();
        Map<String, List<String>> nameTxMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        if(transactions == null || transactions.length==0)return resultList;
        for(String transaction: transactions){
            String[] txSplit = transaction.split(",");
            if(Integer.parseInt(txSplit[2])>1000){result.add(transaction);}
            if(!nameTxMap.containsKey(txSplit[0])){
                List<String> txList = new ArrayList<>();
                txList.add(transaction);
                nameTxMap.put(txSplit[0], txList);   
            }else{
                List<String> existingTransactions = nameTxMap.get(txSplit[0]);
                for(String existingTransaction: existingTransactions){
                    String[] exTxSplit = existingTransaction.split(",");
                    if(Math.abs(Integer.parseInt(exTxSplit[1])-Integer.parseInt(txSplit[1]))<=60 && !txSplit[3].equals(exTxSplit[3])){
                        result.add(transaction);result.add(existingTransaction);
                    }
                }
                nameTxMap.get(txSplit[0]).add(transaction);
            }
           
        }
        
        for(String s: result){
            resultList.add(s);
        }
        return resultList;
    }
}