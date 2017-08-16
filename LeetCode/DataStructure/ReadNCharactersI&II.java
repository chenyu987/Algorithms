// 157
/**
* The API: int read4(char *buf) reads 4 characters at a time from a file.
* 
* The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
* 
* By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
* 
* Note:The read function will only be called once for each test case.
*/
buf is the array to be written.

char[] tmp = new char[4];
tmp = [0, 0, 0, 0];

// this function will write tmp data, and return the number of character read;
function: read4(char[] tmp)  

char buf = [1,2,3,4]

n = 5
==> 4

n = 3
==> 3

public class ReadNChar extends Read4 {
  public int read(char[] buf, int n) {
    boolean readEnd = false;
    int totalRead = 0;
    char[] tmp = new char[4];
    while (!readEnd && totalRead < n) {
      int cnt = read4(tmp);
      if (cnt < 4) {
        readEnd = true;
      }
      cnt = Math.min(cnt, n - totalRead);
      for (int i = 0; i < cnt; i++) {
        buf[totalRead++] = tmp[i];
      }
    }
    return totalRead;
  }
}

/**
* The API: int read4(char *buf) reads 4 characters at a time from a file.
* 
* The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
* 
* By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
* 
* Note:
* The read function may be called multiple times.
==>所以我们要尽可能减少调用开销
*/

/* The read4 API is defined in the parent class Reader4. 
      int read4(char[] buf); */  

public class ReadNCharII extends Reader4 {
  private boolean end = false;
  private Queue<Character> buff = new LinkedList<>();
  
  public int read(char[] buf, int n) {
    if (n == 0) return 0;
    int totalRead = 0;
    
    while (buff.size() < n && !end) {
      char[] tmp = new char[4];
      int curRead = read4(tmp);
      if (curRead < 4) {
        end = true;
      }
      for (int i = 0; i < curRead; i++) {
        buff.offer(tmp[i]);
      }
    }
    int minLen = Math.min(buff.size(), n);
    for (int i = 0; i < minLen; i++) {
      buf[i] = buff.poll();
      totalRead++;
    }
    return totalRead;
  }
}
