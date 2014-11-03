
package com.mahadihasan.mc.patient;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class PrescriptionData {
    
    private String name;
    private String age;
    private String sex;
    
    private String problems;
    private String[] medicines;
    
    public PrescriptionData(String name, String age, String sex,
            String problems, String[] medicines) {
        
        setName(name);
        setAge(age);
        setSex(sex);
        setProblems(problems);
        setMedicines(medicines);
        
    }
    
    private void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void setAge(String age) {
        this.age = age;
    }
    
    public String getAge() {
        return age;
    }
    
    private void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getSex() {
        return sex;
    }
    
    private void setProblems(String problems) {
        this.problems = problems;
    }
    
    public String getProblems() {
        return problems;
    }
    
    private void setMedicines(String[] medicines) {
        this.medicines = medicines;
    }
    
    public String[] getMedicines() {
        return medicines;
    }
}
