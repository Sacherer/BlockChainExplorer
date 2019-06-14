##1、块信息首页

调用该API，可以获取当前ontid是否有资格进行质押

- **获取是否有资格质押信息**

```json
url:/NodePledgeApi/v1/Nodepledge/getQuailifiedState?ontid={ontid}&address={address}
method：GET
successResponse：
{
    "QualifiedState": 0
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    QualifiedState|   Integer |  0有资格，1 ontid非法，2 address非法 |



##m.2 用户操作后的状态设置

调用该API，可以根据当前用户状态设置操作后的状态

- **设置状态**

```json
url:/NodePledgeApi/v1/Nodepledge/delegateSendTransaction
method：POST
{
	"ontid":"did:ont:AKbC3ZaSBQ1GuNKsbcqWxi3uL2oyf9F8vK",
	"stakewalletaddress": "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve",
    "transactionhash":"9de8dd240b1327abc3723acf486d6a3924fe6fd2b283bd7b00dd1ec9fb15ce7d",
    "transactionbodyhash": "asdfdd240b1327abc3723acf486d6a3924fe6fd2b283bd7b00dd1ec9fb15asdf"
}

successResponse：
{}
```

##m.3 用户操作后的状态设置

调用该API，可以根据当前用户状态设置操作后的状态

- **设置状态**

```json
url:/NodePledgeApi/v1/Nodepledge/setInfo
method：POST
{
	"ontid":"did:ont:AKbC3ZaSBQ1GuNKsbcqWxi3uL2oyf9F8vK",
	"stakewalletaddress": "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve",
	"stakequantity": 10
}

successResponse：
{}
```

##m.4 获取当前质押状态

调用该API，可以获取当前ontid节点质押的信息，包括状态

- **获取当前质押状态**

```json
url:/NodePledgeApi/v1/Nodepledge/info?ontid={ontid}
method：GET
successResponse：
{
    "ontid": "did:ont:AKbC3ZaSBQ1GuNKsbcqWxi3uL2oyf9F8vK",
    "stakewalletaddress": "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve",
    "publickey": "035384561673e76c7e3003e705e4aa7aee67714c8b68d62dd1fb3221f48c5d3da0",
    "contract": "testcontractname",
    "commitmentquantity": 100000,
    "stakequantity": 10,
    "transactionhash": "364a945fc0e0fbbb05b09ededbbf4b22e1357653c924341cc210906cbd5305e0",
    "status": 3
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    status|   integer |  当前状态  |

| 状态     |     数字 |
| :-----: | :--------:|
|    Paying|   0 |
|    PayFailed|   1 |
|    Auditing|   2 |
|    AuditFailed|   3 |
|    ToWithdraw|   4 |
|    Withdrawing|   5 |
|    QuitPledge|   6 |
|    WithdrawFailed|   7 |
|    Pledged|   8 |
|    Quiting|   9 |
|    Cancelling|   10 |
    



