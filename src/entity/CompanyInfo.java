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
public class CompanyInfo extends Job {
    
    private String companyName;
    
    public CompanyInfo(int jobID, String jobCategory, String jobName, int jobSalary, String jobStatus, String companyName){
        super(jobID, jobCategory, jobName, jobSalary, jobStatus);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format("%-5s", companyName);
    }
}
