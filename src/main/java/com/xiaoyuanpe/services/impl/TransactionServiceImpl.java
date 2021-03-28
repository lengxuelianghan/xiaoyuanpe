package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.TransactionMapper;
import com.xiaoyuanpe.pojo.Transaction;
import com.xiaoyuanpe.pojo.TransactionExample;
import com.xiaoyuanpe.services.TransactionService;
import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private TransactionMapper transactionMapper;

    @Override
    public void addTransaction(Transaction transaction) {
        this.transactionMapper.insert(transaction);
    }

    @Override
    public List<Transaction> findTransactionAll() {
        TransactionExample transactionExample = new TransactionExample();
        return this.transactionMapper.selectByExample(transactionExample);
    }

    @Override
    public Transaction findTransactionById(Integer id) {
        return this.transactionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyTransaction(Transaction transaction) {
        this.transactionMapper.updateByPrimaryKey(transaction);
    }

    @Override
    public void DeleteTransaction(Integer id) {
        this.transactionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteTransactionList(List<Integer> ids) {
        this.transactionMapper.deleteByPrimaryKeys(ids);
    }
}
