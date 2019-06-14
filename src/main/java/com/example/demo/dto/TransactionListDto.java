package com.example.demo.dto;

import com.example.demo.po.TransactionDetail;

import java.util.Date;
import java.util.List;

public class TransactionListDto {
    private String txhash;

    private String blockhash;

    private Long size;

    private Integer weight;

    private Date time;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    private Integer confirm;

    private List<TransactionDetail> txdetails;

}
