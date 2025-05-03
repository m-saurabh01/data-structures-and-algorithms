package Arrays;

/*
			1007. Minimum Domino Rotations For Equal Row
*/
public class MinDominoRotation {
	

	    private int arrayLength;
	    private int[] tops;
	    private int[] bottoms;

	    
	    public int minDominoRotations(int[] tops, int[] bottoms) {
	        arrayLength = tops.length;
	        this.tops = tops;
	        this.bottoms = bottoms;

	        int rotations = Math.min(findRotationsForValue(tops[0]), findRotationsForValue(bottoms[0]));

	        return rotations > arrayLength ? -1 : rotations;
	    }

	    
	    private int findRotationsForValue(int value) {
	        int countTops = 0, countBottoms = 0;

	        for (int i = 0; i < arrayLength; ++i) {
	            if (tops[i] != value && bottoms[i] != value) {
	                return arrayLength + 1;
	            }

	            if (tops[i] == value) {
	                countTops++;
	            }
	            if (bottoms[i] == value) {
	                countBottoms++;
	            }
	        }

	        return arrayLength - Math.max(countTops, countBottoms);
	    }



}
