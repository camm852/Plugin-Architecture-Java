package com.software.Dto;

import java.io.File;


public class JavaFileDto {
    
    File javaFIle;
    
    public JavaFileDto(File javaFile){
        this.javaFIle = javaFile;
    }
    
    
    public File getFile(){
        return this.javaFIle;
    }
    
}
