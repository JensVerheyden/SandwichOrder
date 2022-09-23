package be.abis.sandwichorder.manager;

import be.abis.sandwichorder.model.DailySession;
import be.abis.sandwichorder.model.Session;
import be.abis.sandwichorder.repository.SessionRepository;

import java.util.ArrayList;

public class SessionManager {

    public static ArrayList<DailySession> createDailySessions(String date){
        ArrayList<Session> currentSessions = SessionRepository.findByDate(date);
        ArrayList<DailySession> todaysSessions = new ArrayList<DailySession>();
        for (Session se:currentSessions){
            DailySession ds1 = new DailySession(se.getCourseName(),date, se.getStudents(), se.getTeacher());
            todaysSessions.add(ds1);
        }
        return todaysSessions;
    }

}
