## 1、块信息首页

调用该API，可以获取最新出块信息

```json
url:"/block/blockIndex"
method:GET
successResponse:
[
    {
        "blockhash": "00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55fb",
        "height": 580770,
        "time": 1560567886090,
        "transactions": 2867,
        "miner": "SlushPool",
        "size": 1225464
    },
    {
        "blockhash": "00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55ff",
        "height": 580770,
        "time": 1560567886090,
        "transactions": 2867,
        "miner": "SlushPool",
        "size": 1225464
    }
]
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块哈希值 |
|    height|   Integer |  区块高度 |
|    time|   Long |   |
|    transactions|   Integer |  
|    miner|   String |  
|    size|   Long |  


## 2 块详细信息

调用该API，根据区块高度查询区块详细信息  
```json
url:"/block/blockDetail/{height}"

successResponse:
{
    "blockhash": "00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55fb",
    "blockchainId": 1,
    "height": 580770,
    "time": 1560567903453,
    "transactions": 2867,
    "size": 1225464,
    "difficulty": 1,
    "prevBlockhash": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
    "nextBlockhash": "00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951",
    "outputTotal": 1647.45939539,
    "fees": 0.8,
    "merkleRoot": "5207117cb3ef0635be556974a3c781e17905c0e2d4390aec212b5f6a1110e32b",
    "miner": "SlushPool",
    "timestamp": 1560567903453,
    "txhash": "c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6",
    "txtime": 1560567903453,
    "txdetails": [
        {
            "address": "1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE ",
            "type": 1,
            "amount": 1
        },
        {
            "address": "1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE ",
            "type": 2,
            "amount": 1
        }
    ]
}
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块哈希值 |
|    height|   Integer |  区块高度 |
|    time|   Long |   |
|    transactions|   Integer |  
|    miner|   String |  
|    size|   Long |  
|    blockchainId|   Integer |  货币种类
|    prevBlockhash|   String |  
|    nextBlockhash|   String |  
|    outputTotal|   Double |  
|    difficulty|   Double |  难度系数
|    fees|   Double |  
|    merkleRoot|   String |  
|    timestamp|   Long |  
|    txhash|   String |  交易哈希
|    txtime|   Long |  交易时间
|    address|   String |  地址
|    type|   Byte |   1支出 2收入
|    amount|   Double | 

## 3、块查看更多页面

调用该API，可以根据日期段获取所有块信息

```json
url:"/block/blockList/{startDate}/{endDate}"
method:GET
successResponse:
[
    {
        "blockhash": "00000000000000000018165ff0bbbc2a93493c693d45dd65c6a8dcbb881f51fb",
        "height": 580770,
        "time": 1560567971188,
        "transactions": 2867,
        "miner": "SlushPo1ol",
        "size": 1225464
    },
    {
        "blockhash": "00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55af",
        "height": 580770,
        "time": 1560567971188,
        "transactions": 2867,
        "miner": "Slush1Pool",
        "size": 1225464
    }
]
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块哈希值 |
|    height|   Integer |  区块高度 |
|    time|   Long |   |
|    transactions|   Integer |  
|    miner|   String |  
|    size|   Long |  

## 4、交易信息首页

调用该API，可以获取最新交易信息

```json
url:"/tx/txIndex"
method:GET
successResponse:
[
    {
        "txhash": "c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6",
        "time": 1560568006940,
        "totalOutput": 12312421
    },
    {
        "txhash": "c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6",
        "time": 1560568006940,
        "totalOutput": 12312421
    }
]
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    txhash|   String |  交易哈希值 |
|    time|   Long |  交易时间 |
|    totalOutput|   Double | 钱  |

## 5、交易信息详情

调用该API，可以根据交易哈希获取交易信息

```json
url:"/tx/txDeatil/{txhash}"

successResponse:
{
    "txhash": "9cd08b5651ac3dd2bdc763f3bf718cd91325265416741dfd2b12b8e41cfdd0b1",
    "size": 192,
    "weight": 768,
    "time": 1560568025165,
    "totalInput": 0.31008597,
    "totalOutput": 0.30992593,
    "fees": 0.8,
    "confirm": 0,
    "txdetails": [
        {
            "address": "1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE",
            "type": 2,
            "amount": 1
        },
        {
            "address": "1CK6KMY6MHgYvmRQ4PAafKYDrg1ejbH1cE",
            "type": 1,
            "amount": 1
        }
    ]
}
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    txhash|   String |  交易哈希值 |
|    size|   Long |   |
|    weight|   Integer |   |
|    time|   Long |   |
|    totalInput|   Double |   |
|    totalOutput|   Double |   |
|    fees|   Double |   |
|    confirm|   Integer |   次数|
|    address|   String |  地址
|    type|   Byte |  是否是支出、收入 1支持 2收入
|    amount|   Double | 

## 6 搜索区块信息

调用该API，根据区块哈希和币种查询区块详细信息  
```json
url:"/blockChain/blockByHash/{blockChainId}/{blockHash}"
method:GET

successResponse:
{
    "blockhash": "00000000000000000018a65ff0bbbc2a93493c693d052d65c6a8dcbb881f55fb",
    "blockchainId": 1,
    "height": 580770,
    "time": 1560568140102,
    "transactions": 28671,
    "size": 1225462,
    "difficulty": 2,
    "prevBlockhash": "00000000000000000006a0173f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
    "nextBlockhash": "00000000000000000025c889729b9f97cb3fc683742601fd61c7e481a7e2c951",
    "outputTotal": 1647.4593939,
    "fees": 0.8,
    "merkleRoot": "5207117cb3ef0635be556974a3c781e17905c0e2d4360aec212b5f6a1110e32b",
    "miner": "SlushPoo1l",
    "timestamp": 1560568140102,
    "txhash": "c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e119eed56030967a6",
    "txtime": 1560568140102,
    "txdetails": [
        {
            "address": "1CK6KHY6MAg1vmRQ4PAafKYDrg1ejbH1cE ",
            "type": 2,
            "amount": 2
        },
        {
            "address": "1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE ",
            "type": 1,
            "amount": 1
        }
    ]
}
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块哈希值 |
|    height|   Integer |  区块高度 |
|    time|   Long |   |
|    transactions|   Integer |  
|    miner|   String |  
|    size|   Long |  
|    blockchainId|   Integer |  货币种类
|    prevBlockhash|   String |  
|    nextBlockhash|   String |  
|    outputTotal|   Double |  
|    difficulty|   Double |  难度系数
|    fees|   Double |  
|    merkleRoot|   String |  
|    timestamp|   Long |  
|    txhash|   String |  交易哈希
|    txtime|   Long |  交易时间
|    address|   String |  地址
|    type|   Byte |  是否是支出、收入 1支持 2收入
|    amount|   Double | 

## 7 搜索地址信息

调用该API，根据地址信息和币种查询地址详细信息  
```json
url:"/blockChain/blockByAddress/{blockChainId}/{Address}"  

successResponse:
{
    "address": "1Ma2DrB78K7jmAwaomqZNRMCvgQrNjE2QC",
    "totalReceived": 0.65650635,
    "finalBalance": 0,
    "txhash": "12ba70fe122e4e17411100dc349692bf25eeb1222c837b85b93f5a2f358a6197",
    "noTxSize": 107,
    "time": 1560568160523,
    "confirm": 11,
    "txdetails": [
        {
            "address": "1CK6KHY6MAg1vmRQ4P1afKYDrg1ejbH1cE ",
            "type": 1,
            "amount": 3
        },
        {
            "address": "1CK6KHY6MHgY1mRQ4PAafKYDrg1ejbH1cE ",
            "type": 2,
            "amount": 1
        }
    ]
}
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    address|   String | 
|    totalReceived|   Double |  
|    finalBalance|   Double |  
|    noTxSize|   Double |  
|    txhash|   String |  交易哈希
|    address|   String |  地址
|    type|   Byte |  是否是支出、收入 1支持 2收入
|    amount|   Double | 
|    time|   Long | 时间戳  |
|    confirm|   Integer |   次数|

## 8、搜索交易信息

调用该API，根据交易哈希信息和币种查询地址详细信息

```json
url:"/blockChain/blockByTxhash/{blockChainId}/{Txhash}}"

successResponse:
{
    "txhash": "9cd08b5651ac3dd2xdc763f3bf718cd91325265416741dfd2b12b8e41cfdd0b1",
    "size": 192,
    "weight": 718,
    "time": 1560568577577,
    "totalInput": 0.31008597,
    "totalOutput": 0.30992593,
    "fees": 0.1,
    "confirm": 11,
    "height": 11111,
    "txdetails": [
        {
            "address": "1CK6KHY6MHgYvmRQ1PAafKYDrg1ejbH1cE",
            "type": 2,
            "amount": 3
        },
        {
            "address": "1CK6KMY6MHgYvmQQ4PAafKYDrg1ejbH1cE",
            "type": 1,
            "amount": 2
        }
    ]
}
```
| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    txhash|   String |  交易哈希值 |
|    size|   Long |   |
|    weight|   Integer |   |
|    height|   Integer |  所在块高度 |
|    time|   Long |   |
|    totalInput|   Double |   |
|    totalOutput|   Double |   |
|    fees|   Double |   |
|    confirm|   Integer |   次数|
|    address|   String |  地址
|    type|   Byte |  是否是支出、收入 1支持 2收入
|    amount|   Double | 