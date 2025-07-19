package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
			1233. Remove Sub-Folders from the Filesystem
*/
public class RemoveSubfoldersFromFileSystem {
	
	public List<String> removeSubfolders(String[] folder) {
	    List<String> ans = new ArrayList<>();
	    String prev = "";

	    Arrays.sort(folder);

	    for (final String f : folder) {
	      if (!prev.isEmpty() && f.startsWith(prev) && f.charAt(prev.length()) == '/')
	        continue;
	      ans.add(f);
	      prev = f;
	    }

	    return ans;
	  }

}
