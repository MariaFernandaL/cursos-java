package co.edu.cue.webapp.consultas.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    private String comisionPCT;
    private double salary;


    private int idJob;
    private int idDepartament;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public Employee(int idEmployee, int idJob){
        this.idEmployee= idEmployee;
        this.idJob=idJob;
    }
    public Employee(int idEmployee, double salary){
        this.idEmployee= idEmployee;
        this.salary=salary;
    }
    public Employee(int idEmployee, String firstName, Date hireDate){
        this.idEmployee= idEmployee;
        this.firstName=firstName;
        this.hireDate=hireDate;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getComisionPCT() {
        return comisionPCT;
    }

    public void setComisionPCT(String comisionPCT) {
        this.comisionPCT = comisionPCT;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public int getIdDepartment() {
        return idDepartament;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartament = idDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", comisionPCT='" + comisionPCT + '\'' +
                ", salary=" + salary +'\'' +
                ", idJob=" + idJob +'\'' +
                ", idDepartment=" + idDepartament +
                '}';
    }

    public String listarNombresEmail() {
        return "Employee{" +
                ", firstName='" + firstName +
                ", lastName='" + lastName + '\'' +
                ", email='" + email +
                '}';
    }

    public String listarIdYJobYIdEmpleado() {
        return "Employee{" +
                "idEmployee=" + idEmployee +'\'' +
                ", idJob=" + idJob +
                '}';
    }

    public String listarIdYJobYSalario() {
        return "Employee{" +
                "idEmployee=" + idEmployee +'\'' +
                ", salary=" + salary +
                '}';
    }

    public String listarIdEmpleadoYNombreYFecha() {
        return "Employee{" +
                "idEmployee=" + idEmployee +'\'' +
                ", firstName=" + firstName +'\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
