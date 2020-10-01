import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	/**
	 * Demonstrates a binomial and negative binomal process
	 * @param args
	 */
	public static void main(String[] args) {
		binomial();
		negativeBinomial();
		double biProbs[] = new double [21];
		double biWins[] = new double [21];
		double negProbs[] = new double [22];
		double negWins[] = new double [22];
		for(int i = 0; i < 21; i++) {
			biProbs[i] = binomialFunction(i);
			biWins[i] = biProbs[i] * 1000;
			System.out.println(biWins[i]);
			
		}
		for(int i = 0; i < 22; i++) {
			negProbs[i] = negBiFunction(i);
		}
	}

	private static void binomial() {
		int wins[] = new int[20];
		Random rand = new Random();
		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < 20; j++) {
				if(rand.nextInt(20) >= 17) {
					wins[j]++;
				}
			}
		}
	}

	private static double binomialFunction(int wins) {
		int choice = choose(20, wins);
		double p = 0.2;
		double expected = choice * (Math.pow(p, (double)wins) * Math.pow((1 - p), (20 - wins)));
		DecimalFormat numberFormat = new DecimalFormat("#.00000000000000");
		return expected;
	}

	private static void negativeBinomial() {
		int thirdWin[] = new int[21];
		Random rand = new Random();
		for(int i = 0; i < 1000; i++) {
			int counter = 0;
			for(int j = 0; j < 20; j++) {
				if(rand.nextInt(20) >= 17) {
					counter++;
					if(counter == 3) {
						thirdWin[j]++;
						break;
					}
				}
			}
			if(counter < 3) {
				thirdWin[20]++;
			}
		}
	}


	private static double negBiFunction(int third) {
		return 0;
	}
	
	static int choose(final int N, final int K) {
	    int ret = 1;
	    for (int k = 0; k < K; k++) {
	    	ret = (ret * (N - k)) / (k + 1);
	    }
	    return ret;
	}
}