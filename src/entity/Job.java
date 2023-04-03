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
import java.time.LocalDate;
public class Job implements Comparable <Job>{
    
    private JobInfo job;
    private LocalDate sDateAdded;
    
    public Job(){
        
    }
    
    public Job(int jobID, String jobCategory, String jobName, int jobSalary, String jobStatus){
        this.job = new JobInfo(jobID, jobCategory, jobName, jobSalary, jobStatus);
        this.sDateAdded = LocalDate.now();
    }
    
    public JobInfo getJobCategory() {
        return job;
    }

    public void setJobCategory(JobInfo job) {
        this.job = job;
    }
    
    public LocalDate getsDateAdded() {
        return sDateAdded;
    }

    public void setsDateAdded(LocalDate sDateAdded) {
        this.sDateAdded = sDateAdded;
    }
    
    @Override
    public int compareTo(Job t) {
        if(job.getJobID() > t.getJobCategory().getJobID()){
            return 1;
        } 
        else{
            return -1;
        }
    }
    
    @Override
    public boolean equals(Object obj){
        return (this.job.getJobID() == ((Job)obj).getJobCategory().getJobID()) || (this.job.getJobCategory().equals(((Job)obj).job.getJobCategory())) || (this.job.getJobName().equals(((Job)obj).job.getJobName())) || (this.job.getJobStatus().equals(((Job)obj).job.getJobStatus()));
    }
    
    @Override
    public String toString(){
        return String.format(" %-5s %-15s", job.toString(), sDateAdded);
    }
    
}
