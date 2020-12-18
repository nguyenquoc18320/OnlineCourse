/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import java.util.Date;

import javax.servlet.http.HttpSession;

/**
 *
 * @author A556U
 */
public class Process_CourseIntroduction_Teacher extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/CourseIntroduction_Teacher.jsp";

        HttpSession session = request.getSession();

        String objective = (String) request.getParameter("objective");
        String courseName = (String) request.getParameter("courseName");
        String courseId = (String) request.getParameter("courseId");

        Date now = java.util.Calendar.getInstance().getTime();

        String message = "";

        int courseid;
        //if courseid does not exist in the database
        if (courseId == null || "".equals(courseId)) {
            int max = CourseDB.getMaxCourseID();
            session.setAttribute("info", max);
            courseid = max + 1;
            Course course = new Course(max + 1, courseName, objective, 1, now, "");

            if (CourseDB.insertCourse(course)) {
                message = "Tạo khóa học mới thành công";
                request.setAttribute("course", course);
            } else {
                message = "Tạo khóa học mới thất bại";
            }
        } else {
            courseid = Integer.parseInt(courseId);
            Course course = new Course(courseid, courseName, objective, 1, now, "");
            try {
                if (CourseDB.courseExists(courseid)) {
                    request.setAttribute("course", course);
                    if (CourseDB.updateCourse(course)) {
                        message = "Cập nhật thành công";
                    } else {
                        message = "Lưu thất bại";
                    }
                } else {
                    message = "Không tìm thấy khóa học";
                }
            } catch (Exception ex) {
                message = "Lưu thất bại";
            }
        }

        //Process the chaps
       // for (int i = 1; i <= 10; i++) {
       int i=1;
            String chapName = (String) request.getParameter("Chap" + i);
            if (!"null".equals(chapName)) {
                Chap chap = new Chap(courseid, i, chapName);
                if (ChapDB.chapExists(courseid, i)) {
                    ChapDB.updateChap(chap);
                } else {
                    ChapDB.insertChap(chap);
                }
            }
        //}

        request.setAttribute("message", message);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
