package nat;

public class OperationNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public OperationNotFoundException(String operationName) {
		super(operationName);
	}
}
