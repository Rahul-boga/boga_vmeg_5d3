
import java.util.*;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
                if(students == null) {
                    throw new IllegalArgumentException("student not exist");
                } else {
                    this.students = students;
                }
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
                if(index<0 || index>= students.length) {
                    throw new IllegalArgumentException("index out of bounds");
                } else {
                    return this.students[index];
                }
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
                if(student == null){
                    throw new IllegalArgumentException("Student not exist");
                } else if(index < 0 || index >= students.length) {
                    throw new IllegalArgumentException("index out of bound");
                } else {
                    this.students[index] = student;
                }
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
                if(student == null) {
                    throw new IllegalArgumentException("student not exist");
                } else {
                Student[] stu = new Student[this.students.length+1];
                stu[0] = student;
                for(int i=0;i<this.students.length;i++) {
                    stu[i+1] = students[i];
                }
                this.students = stu;
                }
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
                if(student == null) {
                    throw new IllegalArgumentException("student not exist");
                } else {
                Student[] stu = new Student[this.students.length+1];
                int i;
                for(i=0;i<this.students.length;i++) {
                    stu[i] = students[i];
                }
                stu[i+1] = student;
                this.students = stu;
                }
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
                if(student == null) {
                    throw new IllegalArgumentException("student not exist");
                } else if(index<0 || index>=students.length) {
                    throw new IllegalArgumentException("index out of bounds");
                } else {
                    Student[] stu = new Student[this.students.length+1];
                    int i;
                    for(i=0;i<index;i++) {
                        stu[i] = students[i];
                    }
                    stu[index] = student;
                    for(i=index+1;i<this.students.length;i++) {
                        stu[i] = students[i-1];
                    }
                 
                this.students = stu;
            }
                
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
                if(index < 0 || index >= students.length ) {
                    throw new IllegalArgumentException("Student not exist");
                } else {
                    Student[] stu = new Student[this.students.length-1];
                    int i,j=0;
                    for(i=0;i<students.length;i++) {
                        if(i == index) {
                            continue;
                        } else {
                            stu[j] = students[i];
                            j+=1;
                        }
                    }
                    this.students = stu;
                }
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
                Student[] stu = new Student[students.length-1];
                if(student == null) {
                    throw new IllegalArgumentException("Student not exist");
                } else {
                    int flag = 0,j=0;
                    for(int i=0;i<students.length;i++) {
                        if(students[i] == student) {
                            flag = 1;
                            continue;
                        } else {
                            stu[j] = students[i];
                            j+=1;
                        }
                    }
                    if(flag == 0) {
                        throw new IllegalArgumentException("Student not exist");
                    } else {
                        this.students =stu;
                    }
                }
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
                if(index<0 || index>=students.length) {
                    throw new IllegalArgumentException("index out of bounds");
                } else {
                    //int j=0;
                    Student[] stu = new Student[students.length-index];
                    for(int i=0;i<students.length;i++) {
                        if(i == index+1) {
                            break;
                        } else {
                            stu[i] = students[i];
                        }
                    }
                    this.students = stu;
                }
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
                if(student == null) {
                    throw new IllegalArgumentException("student not exist");
                } else {
                    int index=-1,i;
                    for(i=0;i<students.length;i++) {
                        if(students[i] == student) {
                          break;  
                        } 
               
                    }
                    index = i;
                    Student[] stu = new Student[index];
                    for(i=0;i<=index;i++) {
                        stu[i] = students[i];
                    }
                    students = stu;
                }
                
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
                 if(index<0 || index>=students.length) {
                    throw new IllegalArgumentException("index out of bounds");
                } else {
                     Student[] stu = new Student[this.students.length-index];
                     int j=0;
                     for(int i=index;i<students.length;i++) {
                         stu[j] = students[i];
                         j+=1;
                     }
                     this.students = stu;
                 }
                
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
                if(student == null) {
                    throw new IllegalArgumentException("student not exist");
                } else {
                    int index=-1,i;
                    for(i=0;i<students.length;i++) {
                        if(students[i] == student) {
                          break;  
                        } 
               
                    }
                    index = i;
                    int j=0;
                    Student[] stu = new Student[this.students.length-index];
                    for(i=index;i<students.length;i++) {
                        stu[j] = students[i];
                        j+=1;
                    }
                    this.students = stu;
                }
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
                
                for(int i=0;i<students.length-1;i++) {
                    for(int j=0;j<students.length;j++) {
                        if(students[j].getId() > students[j+1].getId()) {
                            Student stu = students[j];
                            students[j] = students[j+1];
                            students[j+1] = stu;
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
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
                double maxMark=0;
                int i;
                
                for(i=0;i<students.length;i++) {
                    if(students[i].getAvgMark() > maxMark) {
                        maxMark = students[i].getAvgMark();
                        //count+=1;
                    }
                }
                ArrayList<Student> al = new ArrayList<Student>();
                for(i=0;i<students.length;i++) {
                    if(students[i].getAvgMark() == maxMark) {
                        al.add(students[i]);
                    } 
                }
                students = al.toArray(new Student[al.size()]);
		return students;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
                if(student == null) {
                    throw new IllegalArgumentException("student not exist");
                } else {
                   int i;
                    for(i=0;i<students.length;i++) {
                        if(students[i] == student) {
                            break;
                        }
                    }
                    return students[i+1];
                }
		//return null;
	}
}
