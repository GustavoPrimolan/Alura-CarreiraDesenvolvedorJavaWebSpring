package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//RECONHECIDO COMO SENDO UM COMPONENTE DO SPRING
//É UM COMPONENTE GENÉRICO
@Component
public class FileSaver {

	//SPRING INSTANCIA
	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile file) {
		
		try {
			String realPath = request.getServletContext().getRealPath("\\"+baseFolder);
			String path = realPath + "\\" + file.getOriginalFilename();
			System.out.println(path);
			file.transferTo(new File(path));
			
			//APENAS RETORNA O CAMINHO RELATIVO
			return baseFolder + "\\" + file.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
