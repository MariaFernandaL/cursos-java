package co.edu.cue.webapp.consultas.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="job")
public class Job implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJob;

    private String jobTitle;
    private int minSalary;
    private int maxSalary;

    public Job() {
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "idJob=" + idJob +
                ", jobTitle='" + jobTitle + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
