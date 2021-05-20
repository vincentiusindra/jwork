package vincentiusindralithgow.jwork.controller;


import org.springframework.web.bind.annotation.*;
import vincentiusindralithgow.jwork.*;

import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobControlller {

    @RequestMapping(value="", method = RequestMethod.GET)
    public ArrayList<Job> getAllJob(){
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobDatabase();
        return job;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Job getJobById(@PathVariable int id){
        Job job = null;
        try {
            job = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        }
        return job;
    }

    @RequestMapping(value="/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId){
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobByRecruiter(recruiterId);
        return job;
    }

    @RequestMapping(value="/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobByCategory(category);
        return job;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                      @RequestParam(value="fee") int fee,
                      @RequestParam(value="category") JobCategory category,
                      @RequestParam(value="recruiterId") int recruiterId)
    {
        Job job = null;
        try {
            job = new Job(DatabaseJobseeker.getLastId()+1, name, DatabaseRecruiter.getRecruiterById(recruiterId), fee, category);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
        }
        boolean status = DatabaseJob.addJob(job);
        if(status){
            return job;
        }
        else{
            return null;
        }
    }
}
