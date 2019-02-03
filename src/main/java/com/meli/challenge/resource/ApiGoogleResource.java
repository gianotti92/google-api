package com.meli.challenge.resource;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.drive.model.File;
import com.meli.challenge.dto.ApiGoogleResponseDTO;
import com.meli.challenge.service.ApiGoogleService;

@RequestMapping("/api-google/v1")
@RestController
public class ApiGoogleResource {
	
	@Autowired
	private ApiGoogleService apiGoogleService;
	
	@RequestMapping(value = "/search-in-doc/{id}", method = RequestMethod.GET)
	public ApiGoogleResponseDTO searchInDoc(@PathParam("id")String id, @RequestParam("word") String word) throws IOException, GeneralSecurityException {
		ApiGoogleResponseDTO response = new ApiGoogleResponseDTO();
		response.setContainsWord(apiGoogleService.containsWord(id, word));
		return response;
	}
	
	@RequestMapping(value = "/get-last-upload-file-id", method = RequestMethod.GET)
	public ApiGoogleResponseDTO getLastUploadFile() throws IOException, GeneralSecurityException {
		ApiGoogleResponseDTO response = new ApiGoogleResponseDTO();
		response.setId(apiGoogleService.getLastUploadFile());
		return response;
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public ApiGoogleResponseDTO createFile(ApiGoogleResponseDTO request) throws IOException, GeneralSecurityException {
		ApiGoogleResponseDTO response = new ApiGoogleResponseDTO();
		File f = apiGoogleService.createFile(request.getTitle(), request.getDescription());
		response.setId(f.getId());
		response.setDescription(f.getDescription());
		response.setTitle(f.getName());
		return response;
	}
}
