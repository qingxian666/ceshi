package greedy;

public class JumpGames {
	public boolean canJump(int[] nums) {
        int maxLocation = 0;
    for(int i=0; i<nums.length; i++) {
        if(maxLocation<i) return false; // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
        maxLocation = (i+nums[i]) > maxLocation ? i+nums[i] : maxLocation; // greedy:
    }
    return true;
    }
}
