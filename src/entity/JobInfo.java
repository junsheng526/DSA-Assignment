/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Choo Jun Sheng
 */
public class JobInfo {
    private int jobID;
    private String jobCategory;
    private String jobName;
    private int jobSalary;
    private String jobStatus;
    
    public JobInfo(){
        
    }
    
    public JobInfo(int jobID, String jobCategory, String jobName, int jobSalary, String jobStatus){
        this.jobID = jobID;
        this.jobCategory = jobCategory;
        this.jobName = jobName;
        this.jobSalary = jobSalary;
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    
    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(int jobSalary) {
        this.jobSalary = jobSalary;
    }
    
    @Override
    public String toString(){
        return String.format("%-8s %-20s %-30s RM %-12s %-15s", jobID, jobCategory, jobName, jobSalary, jobStatus);
    }
}
