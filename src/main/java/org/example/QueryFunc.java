package org.example;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryFunc {

    public void query1(Session session,
                       int use_mpg, int min_mpg, int max_mpg,
                       int use_ppg, int min_ppg, int max_ppg,
                       int use_rpg, int min_rpg, int max_rpg,
                       int use_apg, int min_apg, int max_apg,
                       int use_spg, double min_spg, double max_spg,
                       int use_bpg, double min_bpg, double max_bpg) {
        Boolean isAnd = false;
        String sql = "FROM Player ";
        String where = "WHERE ";
        if (use_mpg == 1) {
            where += "mpg>=:min_mpg AND mpg<=:max_mpg";
            isAnd = true;
        }
        if (use_ppg == 1) {
            if (isAnd) {
                where += " AND ";
            }
            where += "ppg>=:min_ppg AND ppg<=:max_ppg";
            isAnd = true;
        }
        if (use_rpg == 1) {
            if (isAnd) {
                where += " AND ";
            }
            where += "rpg>=:min_rpg AND rpg<=:max_rpg";
            isAnd = true;
        }
        if (use_apg == 1) {
            if (isAnd) {
                where += " AND ";
            }
            where += "apg>=:min_apg AND apg<=:max_apg";
            isAnd = true;
        }
        if (use_spg == 1) {
            if (isAnd) {
                where += " AND ";
            }
            where += "spg>=:min_spg AND spg<=:max_spg";
            isAnd = true;
        }
        if (use_bpg == 1) {
            if (isAnd) {
                where += " AND ";
            }
            where += "bpg>=:min_bpg AND bpg<=:max_bpg";
            isAnd = true;
        }
        if (isAnd) {
            sql += where;
        }
        Query query = session.createQuery(sql);
        if (use_mpg == 1) {
            query.setParameter("min_mpg", min_mpg);
            query.setParameter("max_mpg", max_mpg);
        }
        if (use_ppg == 1) {
            query.setParameter("min_ppg", min_ppg);
            query.setParameter("max_ppg", max_ppg);
        }
        if (use_rpg == 1) {
            query.setParameter("min_rpg", min_rpg);
            query.setParameter("max_rpg", max_rpg);
        }
        if (use_apg == 1) {
            query.setParameter("min_apg", min_apg);
            query.setParameter("max_apg", max_apg);
        }
        if (use_spg == 1) {
            query.setParameter("min_spg", min_spg);
            query.setParameter("max_spg", max_spg);
        }
        if (use_bpg == 1) {
            query.setParameter("min_bpg", min_bpg);
            query.setParameter("max_bpg", max_bpg);
        }

        List<Player> players = query.list();
        System.out.println("PLAYER_ID TEAM_ID UNIFORM_NUM FIRST_NAME LAST_NAME MPG PPG RPG APG SPG BPG");
        players.forEach(player -> {
            System.out.println(player.getPlayerID() + " " +
                    player.getTeamID() + " " +
                    player.getUniformNum() + " " +
                    player.getFirstName() + " " +
                    player.getLastName() + " " +
                    player.getMpg() + " " +
                    player.getPpg() + " " +
                    player.getRpg() + " " +
                    player.getApg() + " " +
                    player.getSpg() + " " +
                    player.getBpg());
        });

    }

    public void query2(Session session, String teamColor) {
        String sql = "SELECT t.name FROM Team t, Color c WHERE t.colorID=c.colorId AND c.name=:teamColor";
        Query query = session.createQuery(sql);
        query.setParameter("teamColor", teamColor);
        List results = query.list();
        System.out.println("NAME");
        results.forEach(result -> System.out.println(result));
    }

    public void query3(Session session, String teamName) {
        String sql = "SELECT p.firstName, p.lastName FROM Player p, Team t WHERE p.teamID=t.teamID AND t.name=:teamName ORDER BY p.ppg DESC";
        Query query = session.createQuery(sql);
        query.setParameter("teamName", teamName);
        List<Object[]> results = query.list();
        System.out.println("FIRST_NAME LAST_NAME");
        results.forEach(data -> {
            System.out.println(data[0] + " " + data[1]);
        });
    }

    public void query4(Session session, String teamState, String teamColor) {
        String sql = "SELECT player.uniformNum, player.firstName, player.lastName " +
                "FROM Player player, Team team, State state, Color color " +
                "WHERE player.teamID=team.teamID " +
                "AND team.stateID=state.stateID " +
                "AND team.colorID=color.colorId " +
                "AND state.name=:teamState " +
                "AND color.name=:teamColor";
        Query query = session.createQuery(sql);
        query.setParameter("teamState", teamState);
        query.setParameter("teamColor", teamColor);
        List<Object[]> results = query.list();
        System.out.println("UNIFORM_NUM FIRST_NAME LAST_NAME");
        results.forEach(data -> {
            System.out.println(data[0] + " " + data[1] + " " + data[2]);
        });
    }

    public void query5(Session session, int numWins) {
        String sql = "SELECT player.firstName, player.lastName, team.name, team.wins FROM Player player, Team team  WHERE player.teamID=team.teamID AND team.wins>:numWins";
        Query query = session.createQuery(sql);
        query.setParameter("numWins", numWins);
        List<Object[]> results = query.list();
        System.out.println("FIRST_NAME LAST_NAME NAME WINS");
        results.forEach(data -> {
            System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3]);
        });
    }
}
