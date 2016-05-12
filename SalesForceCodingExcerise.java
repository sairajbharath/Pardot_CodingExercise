import java.util.*;

public class SalesForceCodingExcerise {

	public static void main(String[] args) {

		String str = args[0];
		try {
			// checks if the value passed is of valid format or not.
			if (str == null || !isNumber(str) || Integer.parseInt(str) <= 2) {
				System.out.println("Please enter a valid Integer greater than 2");
				return;
			}
			int n = Integer.parseInt(str);
			
			//Checks if Secret function is additive or not for the given value n
			if (isSecretAdditive(n))
				System.out.println("Secret function is Additive for "+n);
			else
				System.out.println("Secret function is Not Additive for "+n);
		} catch (NumberFormatException ex) {
			System.out.println("Please enter a valid Integer greater than 2 and less than Max value of Integer");
		}
	}
        
        //Determines whether Secret function is additive or not.
	public static boolean isSecretAdditive(int n) {
		//List of all primes less than n are collected.
		List<Integer> primes = generatePrimes(n);
		System.out.println("List of Primes less than "+n);
		for (int x : primes)
			System.out.println(x);
			
		for (int x = 0; x < primes.size(); x++) {
			for (int y = x; y < primes.size(); y++) {
				if (secret(primes.get(x) + primes.get(y)) != secret(primes.get(x)) + secret(primes.get(y))) {
					// If we reach this portion of code means that secret function is not additive for this particular value of n.
					return false;
				}
			}
		}
		return true;
	}

	//Determines whether passed string value is integer or not
	public static boolean isNumber(String str) {
		if (str == null)
			return false;
		for (char ch : str.toCharArray()) {
			if (ch < '0' || ch > '9')
				return false;
		}
		return true;
	}

	public static int secret(int n) {
		return n;
	}
	
	// Generate all prime integers less than n.
	public static List<Integer> generatePrimes(int n) {
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		int i = 2;
		while (i < n) {
			hm.put(i, false);
			i++;
		}
		ArrayList<Integer> li = new ArrayList<Integer>();
		Set<Integer> set = hm.keySet();
		li.addAll(set);
		for (int x = 0; x < li.size(); x++) {
			if (!hm.get(li.get(x))) {
				for (int y = x + 1; y < li.size(); y++) {
					if (!hm.get(li.get(y)))
						if (li.get(y) % li.get(x) == 0) {
							hm.put(li.get(y), true);
						}
				}
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int x : li) {
			if (!hm.get(x))
				list.add(x);
		}
		return list;
	}
}
