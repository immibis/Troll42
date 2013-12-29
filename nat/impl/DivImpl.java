package nat.impl;

import nat.BinaryOperation;
import nat.Nat;
import nat.Operation;
import nat.SeptenaryOperation;
import nat.UnaryOperation;
import nat.WrongArityException;

public class DivImpl implements Operation, UnaryOperation, BinaryOperation {
	
	private NatFactoryImpl factory;
	
	public DivImpl(NatFactoryImpl factory) {
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
		Nat k = factory.getZero();
		Nat result = factory.getZero();
		while(true) {
			for(Nat i = factory.getZero(); !i.equals(operand2); k = k.successor(), i = i.successor()) {
				if(k.equals(operand1))
					return result;
			}
			result = result.successor();
		}
	}

}
