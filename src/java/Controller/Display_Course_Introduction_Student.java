/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Chap;
import Model.ChapDB;
import Model.Course;
import Model.CourseDB;
import Model.FAQ;
import Model.FAQDB;
import Model.Part;
import Model.PartDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A556U
 */
public class Display_Course_Introduction_Student extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Course course = (Course) request.getAttribute("course");      
       course = new Course(1, "", "", 1,null, "");
       if(course!=null)
        course = CourseDB.getCourseById(course.getCourseId());
       int maxChap=0;
       
       if(course==null)
       {
           String message =  "Không tìm thấy khóa học!";
           request.setAttribute("message",message);
       }
        if(course!=null)
        {
            request.setAttribute("course", course);
            int courseid= course.getCourseId();
            List<Chap> chapList = ChapDB.getAllChapByCourseId(courseid);
            if(chapList!=null)
            {
                for(Chap c : chapList)
                {
                    int chapid = c.getChapid();
                    request.setAttribute("chap"+chapid, c);
                    maxChap= c.getChapid();
                    
                    List<Part> partList = PartDB.getAllPartOfChap(courseid, chapid);
                    if(partList!=null)
                    {
                        for( Part p : partList)
                        {
                            request.setAttribute("chap"+chapid+"_part"+p.getPartId(), p);
                        }
                    }
                }
            }
            
            //Các câu hỏi thường gặp
            List<FAQ> faqList = FAQDB.getAllFAQOfCourse(courseid);
            if(faqList!=null)
            {
                for(FAQ f: faqList)
                {
                    request.setAttribute("FAQ"+f.getFAQId(), f);
                }
            }
        }
        
        request.setAttribute("maxChap", maxChap);
        getServletContext().getRequestDispatcher("/Views/Pages/Course_Introduction_Student.jsp").forward(request, response);        
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
