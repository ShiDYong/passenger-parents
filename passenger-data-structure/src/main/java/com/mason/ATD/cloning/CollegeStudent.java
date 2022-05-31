package com.mason.ATD.cloning;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/4/29 11:26
 */
public class CollegeStudent extends Student implements Cloneable {
    private int year;  //Year of graduation
    private String degree;  // Degree sought

    public CollegeStudent() {
        super();  //Must be first statement in constructor
        year = 0;
        degree = "";
    }


    public CollegeStudent(Name studentName, String studentId,
                          int graduationYear, String degreeSought) {
        super(studentName, studentId); // Must be first
        year = graduationYear;
        degree = degreeSought;
    } // end constructor

    public void setStudent(Name studentName, String studentId,
                           int graduationYear, String degreeSought) {
        setFullName(studentName); // NOT fullName = studentName;
        setId(studentId);     // NOT id = studentId;
        // Or setStudent(studentName, studentId); (see Segment C.16)

        year = graduationYear;
        degree = degreeSought;
    } // end setStudent

    @Override
    public String toString() {
        return super.toString() + ", " + degree + ", " + year;
    } // end toString

    @Override
    public Object clone() {
        CollegeStudent theCopy = (CollegeStudent) super.clone();
        return theCopy;
    }
}
