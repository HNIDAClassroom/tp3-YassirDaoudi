package ma.ac.esi.referentielCompetences.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;

@WebServlet("/SkillServlet")
public class SkillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String domain = request.getParameter("domain");
        String level = request.getParameter("level");

        Skill skill = new Skill(name,
                                description,
                                domain,
                                level);
        if(SkillDAO.addSkill(skill)){
            request.setAttribute("message","the skill has been successfully added");
        }else{
            request.setAttribute("error","An error has occurred");

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("SkillCrud.jsp");
        dispatcher.forward(request,response);

    }
}