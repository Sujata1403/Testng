package common_utils;

import java.util.Random;

public class JavaUtil {
	
	public int getRandomNumber() {
		Random random=new Random();
		//to create random number everytime
		int ran = random.nextInt(500);
		return ran;
	}
	
	
}
