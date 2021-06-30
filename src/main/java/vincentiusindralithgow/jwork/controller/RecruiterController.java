package vincentiusindralithgow.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vincentiusindralithgow.jwork.*;

import java.util.ArrayList;

/**
 * Kelas RecruiterController digunakan untuk menangani request yang berhubungan dengan recruiter.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * Sebuah method to untuk mendapatkan semua job pada database
     * @return method ini mengembalikan semua job yang ada pada database
     */
    @RequestMapping(value ="", method = RequestMethod.GET)
    public ArrayList<Recruiter> getAllRecruiter() {
        ArrayList<Recruiter> recruiter = null;
        recruiter = DatabaseRecruiter.getRecruiterDatabase();
        return recruiter;
    }

    /**
     * Sebuah method to untuk mendapatkan recruiter berdasarkan id dari recruiter
     * @param id merupakan id dari recruiter yang diinginkan
     * @return method ini mengembalikan recruiter yang sesuai dengan id yang diinginkan
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;
        try {
            recruiter = DatabaseRecruiter.getRecruiterById(id);
        } catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }

        return recruiter;
    }

    /**
     * Sebuah method to untuk mendaftarkan seorang recruiter
     * @param name merupakan nama dari recruiter yang diinginkan
     * @param email merupakan email dari recruiter yang diinginkan
     * @param phoneNumber merupakan nomor telepon dari recruiter yang diinginkan
     * @param province merupakan provinsi dimana recruiter berada
     * @param description merupakan dekripsi dari lokasi seorang recruiter
     * @param city merupakan kota dimana recruiter berada
     * @return method ini mengembalikan sebuah objek dari kelas Jobseeker
     */
    @RequestMapping(value ="", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="phoneNumber") String phoneNumber,
                                  @RequestParam(value="province") String province,
                                  @RequestParam(value="description") String description,
                                  @RequestParam(value="city") String city)
    {
        Recruiter recruiter = new Recruiter(DatabaseRecruiter.getLastId()+1, name, email, phoneNumber, new Location(province, city, description));

        try{
            DatabaseRecruiter.addRecruiter(recruiter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return recruiter;
    }

}
