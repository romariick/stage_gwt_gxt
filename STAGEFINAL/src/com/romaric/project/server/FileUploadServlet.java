package com.romaric.project.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * servlet to handle file upload requests
 * 
 * @author hturksoy
 * 
 */
public class FileUploadServlet extends HttpServlet {

		//Récupérer le répértoire courant de l'application
	    static String a = System.getProperty("user.dir")+"\\resources\\pdf";
	    
        private static final String UPLOAD_DIRECTORY = a;
        
        private static final String DEFAULT_TEMP_DIR = ".";

        @Override
        

        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                // TODO Auto-generated method stub
                super.doGet(req, resp);
                
          	   String filename = req.getParameter("file");
         	   File file = new File("files/" + filename);
         	   InputStream in = new FileInputStream(file);
         	   OutputStream out = resp.getOutputStream();
         	   resp.setHeader("Content-Disposition", "attachment;filename=" + filename);   
         	   int count;
         	   byte buf[] = new byte[4096];
         	   while ((count = in.read(buf)) > -1) {
         	      out.write(buf, 0, count);
         	   }
         	   in.close();
         	   out.close();

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                
        	
                // process only multipart requests
                if (ServletFileUpload.isMultipartContent(req)) {

                        File tempDir = getTempDir();
                        if (!tempDir.exists()) {
                                tempDir.mkdirs();
                        }

                        // Create a factory for disk-based file items
                        FileItemFactory factory = new DiskFileItemFactory();

                        // Create a new file upload handler
                        ServletFileUpload upload = new ServletFileUpload(factory);

                        // Parse the request
                        try {
                                List<FileItem> items = upload.parseRequest(req);
                                for (FileItem fileItem : items) {
                                        // process only file upload
                                        if (fileItem.isFormField()) continue;
                                        
                                        String fileName = fileItem.getName();
                                        
                                        
                                        System.out.println("Nom du fichier:"+fileName);
                                        // get only the file name not whole path
                                        if (fileName != null) {
                                        fileName = FilenameUtils. getName(fileName);
                                    }

                                        File uploadedFile = new File(UPLOAD_DIRECTORY, fileName);
                                        if (uploadedFile.createNewFile()) {
                                                fileItem.write(uploadedFile);
                                                resp.setStatus(HttpServletResponse.SC_CREATED);
                                                resp.getWriter().print("The file was created successfully.");
                                                resp.flushBuffer();
                                        } else
                                                throw new IOException("The file already exists in repository.");
                                }
                        } catch (Exception e) {
                                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                                                "An error occurred while creating the file : " + e.getMessage());
                        }

                } else {
                        resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
                                                        "Request contents type is not supported by the servlet.");
                }
        }

        private File getTempDir() {
                return new File(DEFAULT_TEMP_DIR);
        }
        
        
        
      
}

