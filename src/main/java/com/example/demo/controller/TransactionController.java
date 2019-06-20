package com.example.demo.controller;

import com.example.demo.dto.TransactionGetDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.vo.TxDetail;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/tx")
public class TransactionController {

    @RequestMapping("/txIndex")
    public List<TransactionIndexDto> txIndex(){
        ArrayList<TransactionIndexDto> transactionIndexDtos = new ArrayList<>();
        TransactionIndexDto txIndex = new TransactionIndexDto();
        txIndex.setTime(new Date().getTime());
        txIndex.setTotalOutput((double)12312421);
        txIndex.setTxhash("c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6");
        transactionIndexDtos.add(txIndex);
        TransactionIndexDto txIndex2 = new TransactionIndexDto();
        txIndex2.setTime(new Date().getTime());
        txIndex2.setTotalOutput((double)12312421);
        txIndex2.setTxhash("c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6");
        transactionIndexDtos.add(txIndex2);
        return transactionIndexDtos;
    }
    @RequestMapping("/txDeatil/{txhash}")
    public TransactionGetDto txDeatil(@PathVariable String txhash){
        TransactionGetDto transactionGetDto = new TransactionGetDto();

        return transactionGetDto;
    }
}
