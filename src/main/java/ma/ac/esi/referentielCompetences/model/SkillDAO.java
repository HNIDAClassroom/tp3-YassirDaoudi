package ma.ac.esi.referentielCompetences.model;

import java.sql.*;
import java.util.ArrayList;

public class SkillDAO {

    public static void addSkill(Skill skill){
        ConnectBd cnd = new ConnectBd();
        cnd.initCon();
        Connection con = cnd.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO Skills (name, description, domain, level) VALUES(?, ?, ?, ?)");
            pstmt.setString(1,skill.getName());
            pstmt.setString(2,skill.getDescription());
            pstmt.setString(3,skill.getDomain());
            pstmt.setString(4,skill.getLevel());
            pstmt.execute();
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void removeSkill(Integer id){
        ConnectBd cnd = new ConnectBd();
        cnd.initCon();
        Connection con = cnd.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "DELETE from skills where id = ?");
            pstmt.setInt(1,id);
            pstmt.execute();
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateSkill(Skill skill,Integer id ){
        ConnectBd cnd = new ConnectBd();
        cnd.initCon();
        Connection con = cnd.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "SELECT * from skills where id = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1,id);
            ResultSet rs =pstmt.executeQuery();
            if (!rs.next()){
                System.out.println("entered false");
                con.close();
                return;
            }

            do  {
                System.out.println("entered");
                rs.updateString("name",skill.getName());
                rs.updateString("description",skill.getDescription());
                rs.updateString("level",skill.getLevel());
                rs.updateString("domain",skill.getDomain());
                rs.updateRow();
            }while (rs.next());
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Skill> getSkills( ){
        ConnectBd cnd = new ConnectBd();
        cnd.initCon();
        Connection con = cnd.getConnection();

        try {
            Statement pstmt = con.createStatement();
            ResultSet rs =pstmt.executeQuery("SELECT * from skills ");
            ArrayList<Skill> skills = new ArrayList<>();
            if (!rs.next()){
                System.out.println("no skills");
                con.close();
                return new ArrayList<>();
            }

            do  {
                skills.add(new Skill(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }while (rs.next());
            con.close();
            return skills;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
