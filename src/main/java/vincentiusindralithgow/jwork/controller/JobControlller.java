package vincentiusindralithgow.jwork.controller;


import org.springframework.web.bind.annotation.*;
import vincentiusindralithgow.jwork.*;

import java.util.ArrayList;

/**
 * Kelas JobControlller digunakan untuk menangani request yang berhubungan dengan job.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
@RequestMapping("/job")
@RestController
public class JobControlller {

    /**
     * Sebuah method to untuk mendapatkan semua job pada database
     * @return method ini mengembalikan semua job yang ada pada database
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public ArrayList<Job> getAllJob(){
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobDatabase();
        return job;
    }

    /**
     * Sebuah method to untuk mendapatkan job berdasarkan id dari job
     * @param id merupakan id dari job yang diinginkan
     * @return method ini mengembalikan job yang sesuai dengan id yang diinginkan
     */
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

    /**
     * Sebuah method to untuk mendapatkan job berdasarkan id dari recruiter
     * @param recruiterId merupakan id dari recruiter yang diinginkan
     * @return method ini mengembalikan job yang sesuai dengan id dari recruiter yang diinginkan
     */
    @RequestMapping(value="/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId){
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobByRecruiter(recruiterId);
        return job;
    }

    /**
     * Sebuah method to untuk mendapatkan job berdasarkan kategorinya
     * @param category merupakan kategori dari job yang diinginkan
     * @return method ini mengembalikan job yang sesuai dengan kategori yang diinginkan
     */
    @RequestMapping(value="/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobByCategory(category);
        return job;
    }

    /**
     * Sebuah method untuk menambahkan job kedalam database
     * @param name merupakan nama job yang diinginkan
     * @param fee merupakan biaya dari job yang diinginkan
     * @param category merupakan kategori dari job yang diinginkan
     * @param recruiterId merupakan id dari recruiter
     * @return method ini mengembalikan sebuah objek dari kelas Invoice
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                      @RequestParam(value="fee") int fee,
                      @RequestParam(value="category") JobCategory category,
                      @RequestParam(value="recruiterId") int recruiterId)
    {
        Job job = null;
        try {
            job = new Job(DatabaseJobseekerPostgre.getLastId()+1, name, DatabaseRecruiter.getRecruiterById(recruiterId), fee, category);
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
