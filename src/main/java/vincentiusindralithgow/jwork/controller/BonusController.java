package vincentiusindralithgow.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vincentiusindralithgow.jwork.Bonus;
import vincentiusindralithgow.jwork.DatabaseBonus;
import vincentiusindralithgow.jwork.ReferralCodeAlreadyExistsException;

import java.util.ArrayList;

/**
 * Kelas BonusController digunakan untuk menangani request yang berhubungan dengan bonus.
 *
 * @author Vincentius Indra Lithgow
 * @version 27/6/2021
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {

    /**
     * Sebuah method to untuk mendapatkan semua bonus pada database
     * @return method ini mengembalikan semua bonus yang ada pada database
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus(){
        return(DatabaseBonus.getBonusDatabase());
    }

    /**
     * Sebuah method to untuk mendapatkan bonus berdasarkan referral code
     * @param referralCode merupakan referral code yang diinginkan
     * @return method ini mengembalikan bonus yang sesuai dengan referral code yang diinginkan
     */
    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode){
        return(DatabaseBonus.getBonusByRefferalCode(referralCode));
    }

    /**
     * Sebuah method to untuk menambahkan bonus baru ke database
     * @param referralCode merupakan referral code dari bonus tersebut
     * @param extraFee merupakan biaya tambahan dari bonus tersebut
     * @param minTotalFee merupakan biaya total minimal dari bonus tersebut
     * @param active merupakan status keaktifan dari bonus tersebut
     * @return method ini mengembalikan sebuah objek dari kelas Bonus
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                          @RequestParam(value="extraFee") int extraFee,
                          @RequestParam(value="minTotalFee") int minTotalFee,
                          @RequestParam(value="active") boolean active)
    {
        Bonus bonus = new Bonus(DatabaseBonus.getLastId() + 1, referralCode, extraFee, minTotalFee, active);
        try{
            DatabaseBonus.addBonus(bonus);
        }
        catch(ReferralCodeAlreadyExistsException e){
            e.getMessage();
            return null;
        }
        return bonus;
    }
}
