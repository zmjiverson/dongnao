package com.dongnao.jack.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	@Qualifier("mongoTemplate1")
	MongoTemplate mt;

	@RequestMapping("/test")
	public @ResponseBody String test() {
		GridFS fs = new GridFS(mt.getDb(),"mycon");
		try {
			GridFSInputFile gfs = fs.createFile(new File("F:\\hallv2\\WebRoot\\html\\images\\4glottery_img.PNG"));
			gfs.put("filename", "sss");
			gfs.save();
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		GridFSDBFile fs1 = fs.findOne("sss");
		InputStream is = fs1.getInputStream();
		
		try {
			FileOutputStream fos = new FileOutputStream("F:\\hallv2\\WebRoot\\html\\images\\aa.PNG");
			
			byte[] bytes = new byte[1024];
			while(is.read(bytes)!= -1) {
				fos.write(bytes);
			}
			is.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        catch (IOException e) {
			e.printStackTrace();
		}
		
		return "OK";
	}

}
