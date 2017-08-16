/**
* Reverse bits of a given 32 bits unsigned integer.
* 
* For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
* 
* Follow up:
* If this function is called many times, how would you optimize it?
*/

int: 
0101 1100 0010 1101 0011 0011 1011 111         0

0 zzzzzzzz 110  
00 zzzzzzzz 11
0 
0
0 -> 0 -> 1 -> 1




res = 0;
0000 0000 0000 0000 0000 0000 0000 0000;

0:
1
res: 1 
0;
10;
101;
1011;

0000 zzzz 0000 left shift 1: 

1100 | 0011 -> 1111

res = (res << 1) | bit;

abcd 

res = "";

loop0: d res = "";
res = "d";

loop1: c res = "d"; ->"dc";
d left shift 1 bit: "d0", bit or with c: "dc";

loop2: b: res = ""

public class ReverseBits {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
        res = (n & 1) | (res << 1);
        n = n >> 1;
    }
    return res;
  }
}

If this function is called many times, how would you optimize it?

input: abcd abcd acer qwer acer qwer abcd abcd 

output: bcda dcba rewq ..................dcba

abcd 
>>> -> 0000 abcd 
>> -> aaaa abcd
0000001111 1111 
      aaaa abcd 

00000000000 1111 1111
FF -> 1111 1111
bytes[0] -> aaaa abcd; 
bytes[1] -> qere dfsa;


public class ReverseBits {
  // you need treat n as an unsigned value
  private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
	
	public int reverseBits(int n) {
		byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++) {
			bytes[i] = (byte)((n >>> 8*i) & 0xFF); //1 byte = 8 bits 
		}	
		int res = 0;
		for (int i = 0; i < 4; i++) {
			res += reverseByte(bytes[i]); //reverse per byte 
			if (i < 3) {
				res <<= 8;
			}	
		}
		return res;
	}
	
	private int reverseByte(byte b) {
		Integer value = cache.get(b); // look up if it's cached
		if (value != null) {
			return value;
		}
		value = 0;
		// reverse bit by bit 
		for (int i = 0; i < 8; i++) {
			value += ((b>>>i) & 1);
			if (i < 7) {
				value <<= 1;
			}
		}
		cache.put(b, value);
		return value;
	}
}