package String;

import java.util.ArrayList;
import java.util.List;

/*
			2942. Find Words Containing Character
*/

public class WordsConatiningChar {
	
	public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> res=new ArrayList<>();

        for(int i=0;i<words.length;i++){
            int y=words[i].indexOf(x);
            if(y>=0)res.add(i);
        }
        
        return res;
    }

}
