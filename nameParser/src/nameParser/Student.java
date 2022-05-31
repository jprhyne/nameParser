package nameParser;

public class Student {
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean canGoOnTrip;
	
	public Student(String firstName, String middleName, String lastName, boolean canGoOnTrip) {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setCanGoOnTrip(canGoOnTrip);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) 
			throw new IllegalArgumentException("Cannot have a Student with a null first name");
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		if (middleName == null) 
			throw new IllegalArgumentException("Cannot have a Student with a null middle name");
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) 
			throw new IllegalArgumentException("Cannot have a Student with a null last name");
		this.lastName = lastName;
	}

	public boolean isCanGoOnTrip() {
		return canGoOnTrip;
	}

	public void setCanGoOnTrip(boolean canGoOnTrip) {
		this.canGoOnTrip = canGoOnTrip;
	}
	
	
}
