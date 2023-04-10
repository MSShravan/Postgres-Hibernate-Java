package org.example;

import com.opencsv.CSVReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure(Main.class.getClassLoader().getResource("hibernate.cfg.xml")).buildSessionFactory();
        Session session = sessionFactory.openSession();
        addColors(session);
        addStates(session);
        addTeams(session);
        addPlayers(session);
        QueryFunc queryFunc = new QueryFunc();
        queryFunc.query1(session, 1, 35, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        queryFunc.query2(session, "Gold");
        queryFunc.query3(session, "Duke");
        queryFunc.query4(session, "NC", "DarkBlue");
        queryFunc.query5(session, 10);
        session.close();
    }

    private static void addColors(Session session) throws Exception {
        session.beginTransaction();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/org/example/color.txt"))) {
            List<String[]> rows = reader.readAll();
            for (String[] row : rows) {
                Color color = new Color();
                color.setName(row[1]);
                session.persist(color);
            }
        }
        session.getTransaction().commit();
    }

    private static void addStates(Session session) throws Exception {
        session.beginTransaction();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/org/example/state.txt"))) {
            List<String[]> rows = reader.readAll();
            for (String[] row : rows) {
                State state = new State();
                state.setName(row[1]);
                session.persist(state);
            }
        }
        session.getTransaction().commit();
    }

    private static void addTeams(Session session) throws Exception {
        session.beginTransaction();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/org/example/team.txt"))) {
            List<String[]> rows = reader.readAll();
            for (String[] row : rows) {
                Team team = new Team();
                team.setName(row[1]);
                team.setStateID(Integer.parseInt(row[2]));
                team.setColorID(Integer.parseInt(row[3]));
                team.setWins(Integer.parseInt(row[4]));
                team.setLosses(Integer.parseInt(row[5]));
                session.persist(team);
            }
        }
        session.getTransaction().commit();
    }

    private static void addPlayers(Session session) throws Exception {
        session.beginTransaction();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/org/example/player.txt"))) {
            List<String[]> rows = reader.readAll();
            for (String[] row : rows) {
                Player player = new Player();
                player.setTeamID(Integer.parseInt(row[1]));
                player.setUniformNum(Integer.parseInt(row[2]));
                player.setFirstName(row[3]);
                player.setLastName(row[4]);
                player.setMpg(Integer.parseInt(row[5]));
                player.setPpg(Integer.parseInt(row[6]));
                player.setRpg(Integer.parseInt(row[7]));
                player.setApg(Integer.parseInt(row[8]));
                player.setSpg(Double.parseDouble(row[9]));
                player.setBpg(Double.parseDouble(row[10]));
                session.persist(player);
            }
        }
        session.getTransaction().commit();
    }

}