package be.abis.sandwichorder.manager;

import be.abis.sandwichorder.model.Session;
import be.abis.sandwichorder.repository.SessionRepository;

import java.time.LocalDate;
import java.util.List;

public class SessionManager {

    private static SessionManager instance;
    private SessionManager() {}

    private static SessionRepository sr = new SessionRepository();
    public static SessionManager getInstance() {
        if (instance == null) instance = new SessionManager();
        return instance;
    };

    public static List<Session> getTodaysSessions(LocalDate date){
        return sr.findByDate(date);
    }

}
