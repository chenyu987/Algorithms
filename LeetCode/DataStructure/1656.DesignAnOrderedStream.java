/*
There is a stream of n (idKey, value) pairs arriving in an arbitrary order, where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.

Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.

Implement the OrderedStream class:

OrderedStream(int n) Constructs the stream to take n values.
String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream, then returns the largest possible chunk of currently inserted values that appear next in the order.

Input
["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
[[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
Output
[null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]

Explanation
// Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
OrderedStream os = new OrderedStream(5);
os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
// Concatentating all the chunks returned:
// [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
// The resulting order is the same as the order above.
*/

class OrderedStream {
    String[] array;
    int pos;
    public OrderedStream(int n) {
        array = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<String>();
        array[--idKey] = value;
        while (pos < array.length) {
            if (array[pos] != null ) {
                result.add(array[pos]);
            } else {
                break;
            }
            pos++;
        }
        return result;
    }
}

// from bloomberg

"""
Sequencer
 
seq, char
1,B -- B int start:1
2,L -- L start: 2
4,O -- (Can’t print yet)
5,M -- (Can’t print yet)
3,O -- O O M. -- I can print 3 ; 3 --> 0 , 4 --> 0
6,B -- B
8,R -- (CAN'T PRINT)
7,E -- E R
9,G -- G
void printPacket(int seq, char value)
*/
 
 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
 
class Interview {
   HashMap<Intger, Character> map = new HashMap<Integer, Character>();
   int position = 0;
   public void stream(int idKey, String value) {
       // List<String> result = new ArrayList<String>();
       map.put(idKey, value);//{4:O, 5:M, 3:O}
       if (idKey == position + 1) {
           int j = idKey; // j =3
           while (map.containsKey(j)) {
               // result.add(map.get(j));
               System.out.print(map.get(j));
               //PRINT HERE
               map.remove(j);
               j++;
           }
           position = j--; //position = 2;
       } else {
           return;
       }
   }
