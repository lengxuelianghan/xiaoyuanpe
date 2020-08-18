package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Transaction;
import com.xiaoyuanpe.services.TransactionService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/addTransaction")
    public ResultBean addTransaction(@RequestBody Transaction transaction){
        ResultBean resultBean = new ResultBean();
        try {
            this.transactionService.addTransaction(transaction);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("交易信息添加失败！");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @PostMapping("/queryTransaction")
    public ResultBean queryTransaction(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.transactionService.findTransactionById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("交易信息查找失败！");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @PostMapping("/queryTransactionList")
    public ResultBean queryTransactionList(){
        ResultBean resultBean = new ResultBean();
        try {
            this.transactionService.findTransactionAll();
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("交易信息列表查找失败！");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @PostMapping("/updateTransaction")
    public ResultBean updateTransaction(@RequestBody Transaction transaction){
        ResultBean resultBean = new ResultBean();
        try {
            this.transactionService.ModifyTransaction(transaction);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("交易信息修改失败！");
            resultBean.setCode(1);
        }
        return resultBean;
    }

}
