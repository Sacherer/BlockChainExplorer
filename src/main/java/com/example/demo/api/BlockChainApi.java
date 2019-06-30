package com.example.demo.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bitcoin",url = "${bitcoin.restApi.url}")
public interface BlockChainApi {
    @GetMapping("/rest/chaininfo.json")
    JSONObject getChinInfo();

    @GetMapping("/rest/tx/{txhash}.json")
    JSONObject getTransactions(@PathVariable String txhash);

    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getBlocks(@PathVariable String blockhash);

    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getNodetailBlocks(@PathVariable String blockhash);

    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    List<JSONObject> getBlockHeaders(@PathVariable Integer count, @PathVariable String blockhash);

    @GetMapping("/rest/blockhashbyheight/{height}.json")
    JSONObject getBlockhashByHeight(@PathVariable Integer height);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getMempoolInfo();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getMempoolContents();
}
