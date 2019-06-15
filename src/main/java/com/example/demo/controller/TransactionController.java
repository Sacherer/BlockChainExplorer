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
        txIndex.setTime(new Date());
        txIndex.setTotalOutput((double)12312421);
        txIndex.setTxhash("c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6");
        transactionIndexDtos.add(txIndex);
        TransactionIndexDto txIndex2 = new TransactionIndexDto();
        txIndex2.setTime(new Date());
        txIndex2.setTotalOutput((double)12312421);
        txIndex2.setTxhash("c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6");
        transactionIndexDtos.add(txIndex2);
        return transactionIndexDtos;
    }
    @RequestMapping("/txDeatil/{txhash}")
    public TransactionGetDto txDeatil(@PathVariable String txhash){
        TransactionGetDto transactionGetDto = new TransactionGetDto();
        transactionGetDto.setConfirm(0);
        transactionGetDto.setFees(0.8);
        transactionGetDto.setSize((long)192);
        transactionGetDto.setTime(new Date());
        transactionGetDto.setTotalInput(0.31008597);
        transactionGetDto.setTotalOutput(0.30992593);
        transactionGetDto.setTxhash("9cd08b5651ac3dd2bdc763f3bf718cd91325265416741dfd2b12b8e41cfdd0b1");
        transactionGetDto.setWeight(768);
        ArrayList<TxDetail> txDetails = new ArrayList<>();
        TxDetail txDetail = new TxDetail();
        txDetail.setAddress("1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE");
        txDetail.setType((byte)2);
        txDetail.setAmount((double)1);
        txDetails.add(txDetail);
        TxDetail txDetail2 = new TxDetail();
        txDetail2.setAddress("1CK6KMY6MHgYvmRQ4PAafKYDrg1ejbH1cE");
        txDetail2.setType((byte)1);
        txDetail2.setAmount((double)1);
        txDetails.add(txDetail2);
        transactionGetDto.setTxdetails(txDetails);
        return transactionGetDto;
    }
}
