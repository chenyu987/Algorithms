/**
* Given an absolute path for a file (Unix-style), simplify it.
* 
* For example,
* path = "/home/", => "/home"
* path = "/a/./b/../../c/", => "/c"
* click to show corner cases.
* 
* Corner Cases:
* Did you consider the case where path = "/../"?
* In this case, you should return "/".
* Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
* In this case, you should ignore redundant slashes and return "/home/foo".
*/

/*
复杂度
时间： O(n) 空间(n)
思路：栈的应用
先将整个路径按照/分开来，然后用一个栈，遇到..时弹出一个，遇到.和空字符串则不变，遇到正常路径则压入栈中。
弹出栈时要先检查栈是否为空
corner cases:
如果结果为空，返回一个/
unix style path的规则如下：
/ -> root
/a -> in (a)
. -> THIS dir path
/a/./ -> still in /a
/a/./b -> in /a/b
.. -> go "up" one level
/a/./b/.. -> /a/b/.. -> /a
/a/./b/../.. -> /a/.. -> /
/a/./b/../../c -> /c
*/

public class SimplifyPath {
  public String simplifyPath(String path) {
    if (path == null || path.length() == 0) return "/";
    Stack<String> stack = new Stack<String>();
    String[] items = path.split("/");
    for (String item : items) {
	    switch (item) {
				case "." : // 跳过
					break;
				case "" :
					break;
				case ".." : 
					if (!stack.isEmpty()) {
						stack.pop();
					} 
					break;
			    //what does default mean here
				default: 
					stack.push(item);
			}
	  }
	  StringBuilder sb = new StringBuilder();
	  if (stack.isEmpty()) {
	    return "/";
	  }
	  while (!stack.isEmpty()) {
			sb.insert(0, "/" + stack.pop());
	  }
	  return sb.toString();
  }
} 


/*
Simplify Path 
Given an absolute path for a file (Unix-style), simplify it.

Example
"/home/", => "/home"

"/a/./b/../../c/", => "/c"
*/

public String SimPath(String path) {
  if (path == null || path.length() == 0) return "/";
  Satck<String> stack = new Stack<>();
  String[] items = path.split("/");
  for (String str : items) {
    switch(str) {
      case "":
        break;
      case ".": 
        break;
      case "..":
        if (!stack.isEmpty()) {
          stack.pop();
        }
        break;
      default:
        stack.push(str);
    }     
  }
  StringBuilder sb =new StringBuilder();
  if (stack.isEmpty()) {
    return "/";
  }
  while (!stack.isEmpty()) {
    sb.insert(0, "/" + stack.pop());
  }
  return sb.toString();
}