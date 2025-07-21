package String;

/*
		1957. Delete Characters to Make Fancy String
*/
public class DeleteCharacterToMakeStringFancy {
	
	public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        if(s.length()>0){
        sb.append(s.charAt(0));
        }
        if(s.length()>1){
        sb.append(s.charAt(1));
        }

        int x=2;
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)!=sb.charAt(x-1) || s.charAt(i)!=sb.charAt(x-2)){
                sb.append(s.charAt(i));
                x++;
            }

            
        }
        
        return sb.toString();
    }

}
