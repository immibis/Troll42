package nat.impl;

import nat.BinaryOperation;
import nat.Nat;
import nat.Operation;
import nat.SeptenaryOperation;
import nat.UnaryOperation;
import nat.WrongArityException;

public class AddImpl implements Operation, UnaryOperation, BinaryOperation {
	
	private NatFactoryImpl factory;
	
	public AddImpl(NatFactoryImpl factory) {
		this.factory = factory;
	}

	@Override
	public UnaryOperation asUnaryOperation() {
		return this;
	}

	@Override
	public BinaryOperation asBinaryOperation() {
		return this;
	}

	@Override
	public SeptenaryOperation asSeptenaryOperation() throws WrongArityException {
		throw new WrongArityException();
	}
	
	@Override
	public Nat compute(Nat operand) {
		return operand;
	}
	
	@Override
	public Nat compute(Nat operand1, Nat operand2) {
		Nat result = factory.getZero();
		for(Nat k = factory.getZero(); !k.equals(operand1); k = k.successor())
			result = result.successor();
		for(Nat k = factory.getZero(); !k.equals(operand2); k = k.successor())
			result = result.successor();
		return result;
	}

}
