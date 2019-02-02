package com.meli.challenge.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.drive.model.File;

public interface ApiGoogleService {
	List<File> getFiles(int number) throws IOException, GeneralSecurityException;
	boolean containsWord(String id, String word) throws IOException, GeneralSecurityException;
	File createFile (String tile, String description) throws IOException, GeneralSecurityException; 
}
