package pt.init.enumtype;

public enum MathematicalSign {
	ADD("Add"), 
	SUBSTRACT("Subtract"),
	MULTIPLY("Multiply"); 

	private final String nameOfSign;

	MathematicalSign(String nameOfSign) {
		this.nameOfSign = nameOfSign;
	}

	public String getNameOfSign() {
		return nameOfSign;
	}
}
