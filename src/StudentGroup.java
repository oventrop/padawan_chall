import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 * 
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	int length;

	/**
	 * DO NOT remove or change this constructor, it will be used during task
	 * check
	 * 
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
		this.length = length;
	}

	@Override
	public Student[] getStudents() {
		if (students == null) {
			throw new IllegalArgumentException();
		}
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if (students.length <= 0 || students.length > length) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < students.length; i++) {
			this.students[i] = students[i];
		}
	}

	@Override
	public Student getStudent(int index) {
		if (index <= 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if (student == null || index <= 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length + 1];
		students2[0] = student;
		for (int i = 0; i < students.length; i++) {
			students2[i + 1] = students[i];
		}
		StudentGroup group = new StudentGroup(students2.length);
		group.setStudents(students2);
	}

	@Override
	public void addLast(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length + 1];
		students2[students2.length] = student;
		for (int i = 0; i < students.length; i++) {
			students2[i] = students[i];
		}
		StudentGroup group = new StudentGroup(students2.length);
		group.setStudents(students2);
	}

	@Override
	public void add(Student student, int index) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length + 1];
		students2[index] = student;
		for (int i = 0; i < students.length; i++) {
			if (i < index) {
				students2[i] = students[i];
			} else {
				students2[i + 1] = students[i];
			}
			StudentGroup group = new StudentGroup(students2.length);
			group.setStudents(students2);
		}
	}

	@Override
	public void remove(int index) {
		if (index <= 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length - 1];

		for (int i = 0; i < students2.length; i++) {
			if (i < index) {
				students2[i] = students[i];
			} else {
				students2[i] = students[i - 1];
			}
			StudentGroup group = new StudentGroup(students2.length);
			group.setStudents(students2);
		}
	}

	@Override
	public void remove(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[students.length - 1];
		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				x = i;
			} else {
				System.out.println("No such stud");
				break;
			}
		}

		for (int i = 0; i < students2.length; i++) {
			if (i < x) {
				students2[i] = students[i];
			} else {
				students2[i] = students[i - 1];

			}
			StudentGroup group = new StudentGroup(students2.length);
			group.setStudents(students2);
		}
	}

	@Override
	public void removeFromIndex(int index) {
		if (index <= 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		Student[] students2 = new Student[index];
		for (int i = 0; i < students2.length; i++) {
			students2[i] = students[i];
		}
		StudentGroup group = new StudentGroup(students2.length);
		group.setStudents(students2);
	}

	@Override
	public void removeFromElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				x = i;
			} else {
				System.out.println("No such stud");
				break;
			}
		}
		Student[] students2 = new Student[x];
		StudentGroup group = new StudentGroup(students2.length);
		group.removeFromIndex(x);

	}

	@Override
	public void removeToIndex(int index) {

		if (index <= 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}

		Student[] students2 = new Student[students.length - index];
		for (int i = 0; i < students2.length; i++) {
			students2[i] = students[index + i];
		}
		StudentGroup group = new StudentGroup(students2.length);
		group.setStudents(students2);
	}

	@Override
	public void removeToElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}

		int x = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				x = i;
			} else {
				System.out.println("No such stud");
				break;
			}
		}
		StudentGroup group = new StudentGroup(students.length - x);
		group.removeToIndex(x);
	}

	@Override
	public void bubbleSort() {
		int n = students.length;
		Student temp = null;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (students[j - 1].compareTo(students[j]) < 0) {

					temp = students[j - 1];
					students[j - 1] = students[j];
					students[j] = temp;
				}
			}
		}

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		return (Integer) null;	
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double max = students[0].getAvgMark();
		int x = 0;
		for (int i = 1; i < students.length; i++) {
			if (students[i].getAvgMark() > max) {
				max = students[i].getAvgMark();

			}
		}
		for (int i = 1; i < students.length; i++) {
			if (students[i].getAvgMark() == max) {
				x++;
			}
		}
		Student [] students2 = new Student[x];
		int z=0;
		for (int i =0; i<students2.length;i++){
			if (students[i].getAvgMark() == max){
				students2[z]=students[i];
				z++;
			}
		}
		return students2;
	}

	@Override
	public Student getNextStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		int x=0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				x = i;
			} else {
				System.out.println("No such stud");
				break;
			}
		}return students[x+1];
	}
}
