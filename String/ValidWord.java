package String;

/*
		3136. Valid Word
*/
public class ValidWord {
	
	public boolean isValid(String word) {
	      
	      if(word.length()<3)return false;

	      boolean isVw=false,isCn=false;

	      for(char c:word.toLowerCase().toCharArray()){

	        if(Character.isLetter(c)){
	            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
	                isVw=true;
	            }else{
	                isCn=true;
	            }
	        }
	        else if(!Character.isDigit(c)){
	            return false;
	        }
	      }

	      return isVw && isCn;
	    }

}
