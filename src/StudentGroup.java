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
                if(index<0 || index>= this.students.length) {
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
                } else if(index < 0 || index >= this.students.length) {
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
                    stu[i+1] = this.students[i];
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
                    stu[i] = this.students[i];
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
                } else if(index<0 || index>=this.students.length) {
                    throw new IllegalArgumentException("index out of bounds");
                } else {
                    Student[] stu = new Student[this.students.length+1];
                    int i;
                    for(i=0;i<index;i++) {
                        stu[i] = this.students[i];
                    }
                    stu[index] = student;
                    for(i=index+1;i<this.students.length;i++) {
                        stu[i] = this.students[i-1];
                    }
                 
                this.students = stu;
            }
                
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
                if(index < 0 || index >= this.students.length ) {
                    throw new IllegalArgumentException("Student not exist");
                } else {
                    Student[] stu = new Student[this.students.length-1];
                    int i,j=0;
                    for(i=0;i<this.students.length;i++) {
                        if(i == index) {
                            continue;
                        } else {
                            stu[j] = this.students[i];
                            j+=1;
                        }
                    }
                    this.students = stu;
                }
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
                Student[] stu = new Student[this.students.length-1];
                if(student == null) {
                    throw new IllegalArgumentException("Student not exist");
                } else {
                    int flag = 0,j=0;
                    for(int i=0;i<this.students.length;i++) {
                        if(this.students[i] == student) {
                            flag = 1;
                            continue;
                        } else {
                            stu[j] = this.students[i];
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
                if(index<0 || index>=this.students.length) {
                    throw new IllegalArgumentException("index out of bounds");
                } else {
                    //int j=0;
                    Student[] stu = new Student[this.students.length-index];
                    for(int i=0;i<this.students.length;i++) {
                        if(i == index+1) {
                            break;
                        } else {
                            stu[i] = this.students[i];
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
                    for(i=0;i<this.students.length;i++) {
                        if(this.students[i] == student) {
                          break;  
                        } 
               
                    }
                    index = i;
                    Student[] stu = new Student[index];
                    for(i=0;i<=index;i++) {
                        stu[i] = this.students[i];
                    }
                    this.students = stu;
                }
                
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
                 if(index<0 || index>=this.students.length) {
                    throw new IllegalArgumentException("index out of bounds");
                } else {
                     Student[] stu = new Student[this.students.length-index];
                     int j=0;
                     for(int i=index;i<this.students.length;i++) {
                         stu[j] = this.students[i];
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
                    for(i=0;i<this.students.length;i++) {
                        if(this.students[i] == student) {
                          break;  
                        } 
               
                    }
                    index = i;
                    int j=0;
                    Student[] stu = new Student[this.students.length-index];
                    for(i=index;i<this.students.length;i++) {
                        stu[j] = this.students[i];
                        j+=1;
                    }
                    this.students = stu;
                }
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
                
                for(int i=0;i<this.students.length;i++) {
                    for(int j=0;j<this.students.length-i-1;j++) {
                        if(this.students[j].getId() > this.students[j+1].getId()) {
                            Student stu = this.students[j];
                            this.students[j] = this.students[j+1];
                            this.students[j+1] = stu;
                        }
                    }
                }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
                if(date == null) {
                    throw new IllegalArgumentException("not valid");
                } else {
                     ArrayList<Student> stu = new ArrayList<Student>();
                    for(int i=0;i<this.students.length;i++) {
                        if(this.students[i].getBirthDate().compareTo(date) == 0) {
                            stu.add(this.students[i]);
                        }
                    }
                   this.students = stu.toArray(new Student[stu.size()]);
                    return this.students;
                }
		//return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
                if(firstDate == null || lastDate == null) {
                    throw new IllegalArgumentException("not valid");
                } else {
                    ArrayList<Student> stu = new ArrayList<Student>();
                    for(int i=0;i<this.students.length;i++) {
                        if(this.students[i].getBirthDate().after(firstDate) && this.students[i].getBirthDate().before(lastDate)) {
                            stu.add(this.students[i]);
                        }
                    }
                   this.students = stu.toArray(new Student[stu.size()]);
                    return this.students;
                }
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		
		
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		
		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
                double maxMark=0;
                int i;
                
                for(i=0;i<this.students.length;i++) {
                    if(this.students[i].getAvgMark() > maxMark) {
                        maxMark = this.students[i].getAvgMark();
                        //count+=1;
                    }
                }
                ArrayList<Student> al = new ArrayList<Student>();
                for(i=0;i<this.students.length;i++) {
                    if(this.students[i].getAvgMark() == maxMark) {
                        al.add(this.students[i]);
                    } 
                }
                this.students = al.toArray(new Student[al.size()]);
		return this.students;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
                if(student == null) {
                    throw new IllegalArgumentException("student not exist");
                } else {
                   int i;
                    for(i=0;i<this.students.length;i++) {
                        if(this.students[i] == student) {
                            break;
                        }
                    }
                    return this.students[i+1];
                }
		//return null;
	}
}
