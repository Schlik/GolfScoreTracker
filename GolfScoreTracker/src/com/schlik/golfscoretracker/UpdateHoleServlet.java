package com.schlik.golfscoretracker;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schlik.golfscoretracker.dao;
import com.schlik.golfscoretracker.Model.Hole;

public class UpdateHoleServlet extends HttpServlet {
	
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest req, HttpServletResponse resp)
  throws IOException {
    String color  = req.getParameter("color");
    Hole newHole = new Hole();
    newHole.setmHoleNumber(new Integer(req.getParameter("holeNum")));
    newHole.setmCourseColor(color);
    newHole.setId(newHole.getmHoleNumber() + newHole.getmCourseColor().hashCode() );
    dao.INSTANCE.update(newHole);
    resp.sendRedirect("/UpdateHole.jsp");
  }
} 
