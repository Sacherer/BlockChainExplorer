package com.example.demo.controller;

import com.example.demo.dto.BlockIndexDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/block")
public class BlockController {

    @RequestMapping("/blockIndex")
    public List<BlockIndexDto> blockIndex(){
        ArrayList<BlockIndexDto> blockIndexDtos = new ArrayList<>();

        return blockIndexDtos;
    }
}
