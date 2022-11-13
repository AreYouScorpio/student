package hu.webuni.student.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SemesterService {

    private Random random = new Random();

    public int getFreeSemester(long centralId) {
        System.out.println("getFreeSemester called");
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
        }
        int result = random.
                nextInt(0, 6);
        System.out.println("randomFreeSemester: " + result);
        return result;
    }


}
