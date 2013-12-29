import java.util.ServiceLoader;

import nat.BinaryOperation;
import nat.Nat;
import nat.NatFactory;
import nat.OperationNotFoundException;
import nat.WrongArityException;


public class FortyTwoMain {
	public static void main(String[] args) {
		NatFactory factory = ServiceLoader.load(NatFactory.class).iterator().next();
		
		Nat forty = factory.getZero().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor();
		Nat two = factory.getZero().successor().successor();
		
		BinaryOperation add, div, mod;
		try {
			add = factory.getOperation("ADD").asBinaryOperation();
			div = factory.getOperation("DIV").asBinaryOperation();
			mod = factory.getOperation("MOD").asBinaryOperation();
		} catch(OperationNotFoundException e) {
			System.err.println("Error.");
			return;
		} catch(WrongArityException e) {
			System.err.println("Error!");
			return;
		}
		
		Nat result = add.compute(forty, two);
		System.out.println(numberToString(factory, result, div, mod));
	}

	private static String numberToString(NatFactory factory, Nat result, BinaryOperation div, BinaryOperation mod) {
		if(result.equals(factory.getZero())) return "0";
		else if(result.equals(factory.getZero().successor())) return "1";
		else if(result.equals(factory.getZero().successor().successor())) return "2";
		else if(result.equals(factory.getZero().successor().successor().successor())) return "3";
		else if(result.equals(factory.getZero().successor().successor().successor().successor())) return "4";
		else if(result.equals(factory.getZero().successor().successor().successor().successor().successor())) return "5";
		else if(result.equals(factory.getZero().successor().successor().successor().successor().successor().successor())) return "6";
		else if(result.equals(factory.getZero().successor().successor().successor().successor().successor().successor().successor())) return "7";
		else if(result.equals(factory.getZero().successor().successor().successor().successor().successor().successor().successor().successor())) return "8";
		else if(result.equals(factory.getZero().successor().successor().successor().successor().successor().successor().successor().successor().successor())) return "9";
		else {
			Nat ten = factory.getZero().successor().successor().successor().successor().successor().successor().successor().successor().successor().successor();
			Nat ones = mod.compute(result, ten);
			Nat tens = div.compute(result, ten);
			return numberToString(factory, tens, div, mod) + numberToString(factory, ones, div, mod);
		}
	}
}
