package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Transaction;

import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);

    List<Transaction> findTransactionAll();

    Transaction findTransactionById(Integer id);

    void ModifyTransaction(Transaction transaction);

    void DeleteTransaction(Integer id);
    void DeleteTransactionList(List<Integer> ids);

}
