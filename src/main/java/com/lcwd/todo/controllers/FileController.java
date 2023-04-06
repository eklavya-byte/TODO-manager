package com.lcwd.todo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/single")
    private  String uploadSingle(@RequestParam("image") MultipartFile file)
    {
        logger.info("file name : {}",file.getName());
        logger.info("Content type : {}" ,file.getContentType());
        logger.info("original file name : {}",file.getOriginalFilename());
        return "file test";
    }

    @PostMapping("/multiple")
    public String uploadMultiple(@RequestParam("files") MultipartFile[] files)
    {
        Arrays.stream(files).forEach(f->{
            logger.info("file name : {}",f.getOriginalFilename());
            logger.info("File type {}" ,f.getContentType());
            System.out.println("+++++++++++++++++");
                        });
        return "upload done !";
    }

    //serving image file in the response
    @GetMapping("/serve-image")
    public void serveImageHandler()
    {
        //image

    }
}
