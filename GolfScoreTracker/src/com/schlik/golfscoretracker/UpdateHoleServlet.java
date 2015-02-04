package com.schlik.golfscoretracker;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.KeyFactory;
import com.schlik.golfscoretracker.dao;
import com.schlik.golfscoretracker.Model.Hole;

public class UpdateHoleServlet extends HttpServlet {
	
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest req, HttpServletResponse resp)
  throws IOException {
    String color  = req.getParameter("color");
    Hole newHole = new Hole();
    newHole.setHoleNumber(new Integer(req.getParameter("holeNum")));
    newHole.setCourseColor(color);
    newHole.setKeyHashValue( newHole.getHoleNumber() + newHole.getCourseColor().hashCode());
    newHole.setId(KeyFactory.createKey(  Hole.class.getSimpleName(), newHole.getKeyHashValue() ));
    newHole.setWhiteTeeDistance(new Integer(req.getParameter("whiteDist")));
    newHole.setRedTeeDistance(new Integer(req.getParameter("redDist")));
    newHole.setBlueTeeDistance(new Integer(req.getParameter("blueDist")));
    newHole.setParValue(new Integer(req.getParameter("parVal")));
    newHole.setMensHandicap(new Integer(req.getParameter("menHcp")));
    newHole.setWomensHandicap(new Integer(req.getParameter("womenHcp")));
    dao.INSTANCE.update(newHole);
    resp.sendRedirect("/UpdateHole.jsp");
  }
} 
