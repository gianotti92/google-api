package com.meli.challenge.apigoogle;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.api.services.drive.model.File;
import com.meli.challenge.service.ApiGoogleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiGoogleApplicationTests {
	
	@Autowired
	private ApiGoogleService apiGoogleService;

	@Test
	public void readFiles() throws IOException, GeneralSecurityException  {
		List<File> files = apiGoogleService.getFiles(10);
		files.stream().forEach(file -> System.out.println("nombre: " + file.getName() + " id: " + file.getId() + file.getDescription()));
		assertTrue(!files.isEmpty());
	}
	
	@Test
	public void createFile() throws IOException, GeneralSecurityException {
		File file = apiGoogleService.createFile("UNA COSA", "LAAA DESCRIPCION");
		String lastIdCreated = file.getId();
		assertTrue(file != null);
		
		boolean ok = apiGoogleService.containsWord(lastIdCreated, "LAAA DESCRIPCION");
		assertTrue(ok);
		
	}
	
}

