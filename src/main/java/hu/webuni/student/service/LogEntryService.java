package hu.webuni.student.service;

import hu.webuni.student.model.LogEntry;
import hu.webuni.student.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LogEntryService {

    @Autowired
    LogEntryRepository logEntryRepository;

    public void createLog(String description) {

        // callBackendSystem(); // pl titkosító kulcs kérése, hogy tudjunk menteni //átmenetileg kivéve, m a service-ben mindkét mentésre hívom és h ne az elsőn szálljon el
        logEntryRepository.save(
                new LogEntry(description,
                        SecurityContextHolder.getContext().getAuthentication().getName()));

    }

    private void callBackendSystem() {
        if(new Random().nextInt(4) == 1) throw new RuntimeException();
    }
}
