package com.pdfservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.DocumentException;

import com.pdfservice.*;

@Controller
public class GreetingController {
	
	Person results;
	ASR asr;
	public static final String DEST = "c:\\FDA\\sample.pdf";
	App app = new App();

    @RequestMapping(value = "/greeting", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, @RequestBody ASR asrWeb) {
        model.addAttribute("name", name);
        System.out.println(asrWeb.getApplicationnumber());
        asr = asrWeb;
        System.out.println(asr.getApplicationnumber());
        return "greeting";
    }
    
    //@GetMapping("/meeting")
    @RequestMapping(value = "/pdf", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces="application/pdf" )
    @ResponseBody
    public ResponseEntity<byte[]> meeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model,@RequestBody ASR asrWeb2) throws IOException, DocumentException, URISyntaxException {
    	/*ResponseEntity<InputStreamResource>*/ 
//    	/*FileSystemResource */
    	model.addAttribute("name", name);
        System.out.println(asrWeb2.getTech());
        app.createPdf(DEST, asrWeb2);
        
        File file = new File("c:\\FDA\\sample.pdf");
        byte[] bytesArray = new byte[(int)file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytesArray);
        fis.close();
        
        //byte[] contents = ("c:\\FDA\\sample.pdf");
        
        
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
//        String filename = DEST;//"file:///C:/fda/sample.pdf"; //DEST;
//        ClassPathResource pdfFile = new ClassPathResource(filename);
//        System.out.println(pdfFile);
//       	headers.setContentDispositionFormData(filename, filename);
//        headers.add("Content-Disposition", "filename=" + filename);
//        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//        headers.setContentLength(pdfFile.contentLength());
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]> (bytesArray, headers, HttpStatus.OK);
        /*new InputStreamResource(pdfFile.getInputStream())*/
        /*new ResponseEntity<InputStreamResource>(new InputStreamResource(pdfFile.getInputStream())*/
        /*response*/
      //return "greeting";
        
        return response;
        
    }

}