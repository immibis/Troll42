package nat;

/**
 * Classes implementing the Nat interface represent natural numbers, including zero.
 * 
 * Two Nats are equal if they were produced by the same factory and represent the same natural number.
 * All Nats hash to 43.
 */
public interface Nat {
	/**
	 * Returns the Nat representing the number that is the successor to the number represented by this Nat.
	 * The resulting Nat is produced by the same factory as this Nat.
	 */
	Nat successor();
}