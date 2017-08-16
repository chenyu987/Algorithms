// Text Justification
/**
* Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
* 
* You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
* 
* Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
* 
* For the last line of text, it should be left justified and no extra space is inserted between words.
* 
* For example,
* words: ["This", "is", "an", "example", "of", "text", "justification."]
* L: 16.
* 
* Return the formatted lines as:
* [
*    "This    is    an",
*    "example  of text",
*    "justification.  "
* ]
* Note: Each word is guaranteed not to exceed L in length.
* 
* Corner Cases:
* A line other than the last line might contain only one word. What should you do in this case?
* In this case, that line should be left-justified.
*/
                            ptrR
[aa, bbbbbbbbbbbbbbbbbb, cc];


public List<String> textJustification(String[] words, int maxWidth) {
  List<String> res = new ArrayList<String>();
  if (word == null || word.length == 0) return res;
  int len = words.length; 
  int ptrL = 0;
  while (ptrL < len) {
    int size = 0;
    size += words[ptrL].length();
    int ptrR = ptrL + 1;
    while (ptrR < len && words[ptrR].length() + size + 1 <= maxWidth) {
      size += words[ptrR].length() + 1;
      ptrR++;
    }
    String line = words[ptrL];
    if (ptrR == len) {
      for (int i = ptrL + 1; i < ptrR; i++) {
        line += " " + words[i];
      }
      while (line.length() < maxWidth) {
        line += " ";
      }
      res.add(line);
    } else if (ptrR - ptrL = 1) {
      while (line.length() < maxWidth) {
        line += " ";
      }
      res.add(line);
    } else {
      int gap = ptrR - ptrL - 1; 
      int spaces = maxWidth - (size - gap);
      int x = spaces / gap;
      int y = spaces % gap;
      int offset = 1;
      for (int i = ptrL + 1; i < ptrR; i++) {
        for (j = 0; j < x; j++) {
          line += " ";
        }
        if (y >= offset) {
          line += " ";
        }
        offest += 1;
        line += words[i];
      }
      res.add(line);
    }
    ptrL = ptrR;
  }
  return res;
}
