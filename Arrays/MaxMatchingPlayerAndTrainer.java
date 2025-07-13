package Arrays;

import java.util.Arrays;

/*
			2410. Maximum Matching of Players With Trainers
*/
public class MaxMatchingPlayerAndTrainer {
	
public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        
        Arrays.sort(trainers);

        
        int matches = 0;
    
        int trainerIndex = 0;

        for (int player : players) {
            
            while (trainerIndex < trainers.length && trainers[trainerIndex] < player) {
                trainerIndex++;
            }
            
            if (trainerIndex < trainers.length) {
                matches++; 
                trainerIndex++; 
            }
        }
        
        return matches;
    }

}
