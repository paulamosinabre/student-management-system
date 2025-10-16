
package com.mycompany.studentmanagement;

public class StudentFullName extends Student {
    private String middleName;
    
    public StudentFullName(String id, String firstName, String middleName, String lastName, String gender, String course, String year, double GPA){
        super(id, firstName, lastName, gender, course, year, GPA);
        this.middleName = middleName;
    }
    
    public String getMiddleName(){
        return middleName;
    }
    
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    
    @Override
    public String getFullName(){
        return getFirstName() + " " + getMiddleName().substring(0,1) + ". " + getLastName(); 
    }
}
