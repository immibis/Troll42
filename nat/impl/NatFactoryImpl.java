package nat.impl;

import nat.Nat;
import nat.NatFactory;
import nat.Operation;
import nat.OperationNotFoundException;

public class NatFactoryImpl implements NatFactory {

	@Override
	public Nat getZero() {
		return new ZeroImpl(this);
	}

	@Override
	public Nat getOne() {
		return new OneImpl(this);
	}

	@Override
	public Nat getSix() {
		return new SixImpl(this);
	}
	
	@Override
	public Operation getOperation(String name) throws OperationNotFoundException {
		if(name.charAt(0) == 'A')
			if(name.charAt(1) == 'D')
				if(name.charAt(2) == 'D')
					if(name.length() == 3)
						return new AddImpl(this);
					else
						throw new OperationNotFoundException(name);
				else
					throw new OperationNotFoundException(name);
			else
				throw new OperationNotFoundException(name);
		else if(name.charAt(0) == 'D')
			if(name.charAt(1) == 'I')
				if(name.charAt(2) == 'V')
					if(name.length() == 3)
						return new DivImpl(this);
					else
						throw new OperationNotFoundException(name);
				else
					throw new OperationNotFoundException(name);
			else
				throw new OperationNotFoundException(name);
		else if(name.charAt(0) == 'M')
			if(name.charAt(1) == 'O')
				if(name.charAt(2) == 'D')
					if(name.length() == 3)
						return new ModImpl(this);
					else
						throw new OperationNotFoundException(name);
				else
					throw new OperationNotFoundException(name);
			else
				throw new OperationNotFoundException(name);
			throw new OperationNotFoundException(name);
	}

}
