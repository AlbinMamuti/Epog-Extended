import java.util.LinkedList;
import java.util.PriorityQueue;

class HelloProgrammer {
	public static void main(String[] args) {

		int Geld = 50000;
		int Geldprev = 50000;

		for (int i = 0; i <= 10; i++) {

			Geld *= 1.07;
			Geld += 50000;
			int Gewinn = Geld - Geldprev;
			Geldprev = Geld;

			System.out.println("Jahr: " + i + " Haben Sie: " + Geld + " CHF");
			System.out.println("Gewinn: " + Gewinn);

		}

		PriorityQueue<Pair> heap = new PriorityQueue<>();
		Pair i = new Pair(1, 0);
		heap.add(new Pair(1, 10));
		heap.add(new Pair(2, 1));
		heap.add(new Pair(3, 15));
		heap.add(new Pair(4, 13));
		System.out.println(heap.poll().value);
		int[][] arr = new int[2][2];
		System.out.println(heap.contains(i));
		LinkedList<Integer> list = new LinkedList<>();
		list.size();

		double ans = 0;
		for (int j = 0; j < 5; j++) {
			ans += Math.random() < 0.5 ? 0 : 1;
		}
		System.out.println(ans / 5);
		System.out.println(power(2, 5));

		long startTime = System.nanoTime();
		int result1 = fib(50);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		double tT = (double) totalTime / 1000000;
		System.out.println(result1);
		System.out.println("rekursion");
		System.out.println(tT + " Tausenstel Sekunden");
		long startTime1 = System.nanoTime();
		int result12 =fib2(500);
		long endTime2 = System.nanoTime();
		long totalTime2 = endTime2 - startTime1;
		double tT2 = (double) totalTime2 / 1000000;
		System.out.println("rekursion");
		System.out.println(result12);
		System.out.println(tT2 + " Tausenstel Sekunden");
	}

	public static long power(long a, long b) {
		if (b == 0)
			return 1;
		long tmp = power(a, b / 2);
		long restult = tmp * tmp;
		if (b % 2 == 1)
			restult *= a;
		return restult;
	}

	public static long power1(long a, long b) {
		long result = 1;
		while (b > 0) {
			if (b % 2 == 1)
				result *= a;
			a *= a;
			b /= 2;
		}
		return result;
	}

	public static int fib(int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static int fib2(int n) {
		int[] arr = new int[n];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i = 2; i < n ; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n-1];

	}

}

class Pair implements Comparable<Pair> {

	public int index;
	public int value;

	public Pair(int index, int value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Pair other) {
		if (this.value < other.value) {
			return -1;
		} else if (this.value == other.value) {
			return 0;
		} else {
			return 1;
		}
	}
}