package vincentiusindralithgow.jwork.controller;

import  vincentiusindralithgow.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Kelas JobseekerController digunakan untuk menangani request yang berhubungan dengan jobseeker.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * Sebuah method to untuk mendapatkan semua jobseeker pada database
     * @return method ini mengembalikan semua jobseeker yang ada pada database
     */
    @RequestMapping("")
    public ArrayList<Jobseeker> getAllJobseeker() {
        return DatabaseJobseekerPostgre.getJobseekerDatabase();
    }

    /**
     * Sebuah method to untuk mendapatkan jobseeker berdasarkan id dari jobseeker
     * @param id merupakan id dari jobseeker yang diinginkan
     * @return method ini mengembalikan jobseeker yang sesuai dengan id yang diinginkan
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        jobseeker = DatabaseJobseekerPostgre.getJobseekerById(id);
        return jobseeker;
    }

    /**
     * Sebuah method to untuk mendaftarkan seorang jobseeker
     * @param name merupakan nama dari jobseeker yang diinginkan
     * @param email merupakan email dari jobseeker yang diinginkan
     * @param password merupakan password dari jobseeker yang diinginkan
     * @return method ini mengembalikan sebuah objek dari kelas Jobseeker
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                       @RequestParam(value="email") String email,
                                       @RequestParam(value="password") String password)
    {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseeker.getLastId()+1, name, email, password);
        DatabaseJobseekerPostgre.addJobseeker(jobseeker);
        return jobseeker;
    }

    /**
     * Sebuah method to untuk melakukan proses login seorang jobseeker
     * @param email merupakan email dari jobseeker yang diinginkan
     * @param password merupakan password dari jobseeker yang diinginkan
     * @return method ini mengembalikan jobseeker yang sesuai dengan email dan password yang diberikan
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value="email") String email,
                                    @RequestParam(value="password") String password)
    {
        return DatabaseJobseekerPostgre.getJobseekerLogin(email, password);
    }
}