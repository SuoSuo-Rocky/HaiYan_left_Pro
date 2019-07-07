package org.shiwei.fileLoad;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("FileLoad")
public class FileLoad {
	
	
	@RequestMapping("fileLoad.do")
	public String  fileLoad(@RequestParam("file") MultipartFile file,
			@RequestParam("info") String info,Map<String,Object> map) throws IOException {
	    System.out.println("此文件的描述信息为： " + info);
		String filename = file.getOriginalFilename();
		
		
		InputStream input = file.getInputStream();
		
		FileOutputStream outputStream = new FileOutputStream("F://" + filename);
		
		byte[] by = new byte[1024];
		
		int len = -1;
		
		while((len = input.read(by)) != -1){
			outputStream.write(by, 0, len);
		}
    
		outputStream.close();
		input.close();
		System.out.println("上传成功！");
	    map.put("info", "success");	
		return "success";
	}
	

}
