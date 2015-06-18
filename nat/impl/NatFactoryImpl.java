package nat.impl;

import nat.StringUtil;
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
		if(StringUtil.charAt(this, name, getZero()) == 'A')
			if(StringUtil.charAt(this, name, getOne()) == 'D')
				if(StringUtil.charAt(this, name, getOne().successor()) == 'D')
					if(StringUtil.strLength(this, name).equals(getOne().successor().successor()))
						return new AddImpl(this);
					else
						throw new OperationNotFoundException(name);
				else
					throw new OperationNotFoundException(name);
			else
				throw new OperationNotFoundException(name);
		else if(StringUtil.charAt(this, name, getZero()) == 'D')
			if(StringUtil.charAt(this, name, getOne()) == 'I')
				if(StringUtil.charAt(this, name, getOne().successor()) == 'V')
					if(StringUtil.strLength(this, name).equals(getOne().successor().successor()))
						return new DivImpl(this);
					else
						throw new OperationNotFoundException(name);
				else
					throw new OperationNotFoundException(name);
			else
				throw new OperationNotFoundException(name);
		else if(StringUtil.charAt(this, name, getZero()) == 'M')
			if(StringUtil.charAt(this, name, getOne()) == 'O')
				if(StringUtil.charAt(this, name, getOne().successor()) == 'D')
					if(StringUtil.strLength(this, name).equals(getOne().successor().successor()))
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
