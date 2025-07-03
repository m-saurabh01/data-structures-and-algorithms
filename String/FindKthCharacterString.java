package String;

/*
			3304. Find the K-th Character in String Game I
*/
public class FindKthCharacterString {
	
	public char kthCharacter(int k) {
	    return (char) ('a' + Integer.bitCount(k - 1));
	  }

}
