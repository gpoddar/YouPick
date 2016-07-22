
package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.Poll;
import service.PollAddService;

/**
 * Servlet implementation class PollEditController
 */
@WebServlet("/PollEditController")
@MultipartConfig
public class PollEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PollEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file;
        Poll poll = new Poll();

        PollAddService pollAddService = new PollAddService();
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> fileItems = upload.parseRequest(request);
                Iterator<FileItem> i = fileItems.iterator();
                boolean isImageUnchanged=false;
                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {

                    	if(fi.getName()==null|| fi.getName().isEmpty()||fi.getSize() == 0)
                    	{
                    		isImageUnchanged=true;
           
                    	}
                    	else
                    	{
                        String imgName = pollAddService.getImageName();
                        String relativeWebPath = "/pollImages/" + fi.getName();
                        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        file = new File("/Users/gaurangpoddar/Documents/YouPick/PollingImages/" + imgName + ".jpg");
                        //file = new File(getServletContext().getRealPath("pollImages") , fi.getName());
                        poll.setImgSrc("ImageServlet?imageId=" + imgName + ".jpg");
                        fi.write(file);
                    	}
                    }
                    else {
                        String fieldname = fi.getFieldName();
                        String fieldvalue = fi.getString();
                        if (fieldname.equals("pollid"))
                            poll.setPollId(Double.parseDouble(fieldvalue));
                        if (fieldname.equals("question"))
                            poll.setTitle(fieldvalue);
                        if (fieldname.equals("description"))
                            poll.setDescription(fieldvalue);
                        if (fieldname.equals("optionD"))
                            poll.setOptionFour(fieldvalue);
                        if (fieldname.equals("optionA"))
                            poll.setOptionOne(fieldvalue);
                        if (fieldname.equals("optionC"))
                            poll.setOptionThree(fieldvalue);
                        if (fieldname.equals("optionB"))
                            poll.setOptiontwo(fieldvalue);
                        if (fieldname.equals("category"))
                            poll.setCategory(Long.parseLong(fieldvalue));
                        if (fieldname.equals("polltype")) {
                            if (fieldvalue.equals("binary"))
                                poll.setBinary(1);
                            else
                                poll.setBinary(0);
                        }
                        if(isImageUnchanged&&fieldname.equals("oldimgsrc"))
                        {
                        	poll.setImgSrc(fieldvalue);
                        }

                    }
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        int x = pollAddService.editPoll(poll);
        if (x == 1)
            response.sendRedirect("success.jsp");
        else
            response.sendRedirect("fail.jsp");

    }

}
