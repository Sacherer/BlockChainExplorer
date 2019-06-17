package com.example.demo.service;

import com.example.demo.dto.BlockIndexDto;

import java.util.List;

public interface BlockService {
    List<BlockIndexDto> getBlockIndex() throws Throwable;

}
