/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3lubao;

import java.util.logging.Level;
import java.util.logging.Logger;
import singlylinkedlist.SNode;
import singlylinkedlist.SList;
import queueexample.QueueList;

/**
 *
 * @author Jeo
 */
public class CustomerTransaction {

    public static void main(String[] args) {

        Customer person1 = new Customer(1, "Larry Gadon");
        Customer person2 = new Customer(2, "Ferdinand Megellan");
        Customer person3 = new Customer(256, "Thom Yorke");
        Customer person4 = new Customer(322, "Rodrigo Duterte");
        Customer person5 = new Customer(512, "Shinzo Abe");

        SNode<Customer> customer1 = new SNode<>(person1, null);
        SNode<Customer> customer2 = new SNode<>(person2, null);
        SNode<Customer> customer3 = new SNode<>(person3, null);
        SNode<Customer> customer4 = new SNode<>(person4, null);
        SNode<Customer> customer5 = new SNode<>(person5, null);

        QueueList<SNode> TransactionList = new QueueList<>();

        TransactionList.enqueue(customer1);
        TransactionList.enqueue(customer2);
        TransactionList.enqueue(customer3);
        TransactionList.enqueue(customer4);
        TransactionList.enqueue(customer5);

        System.out.println("Enqueued list \n");
        
        System.out.println("List of Transactions: \n");
        try {
            displayTransactions(TransactionList);
        } catch (EmptyQueueException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nDequeued list");

        try {
            TransactionList.dequeue();
        } catch (queueexample.EmptyQueueException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            displayTransactions(TransactionList);
        } catch (EmptyQueueException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void displayTransactions(QueueList<SNode> queueList) throws EmptyQueueException {
        try {
            SNode<Customer> temp = queueList.first();
            for (int i = 0; i < queueList.size(); i++) {
                System.out.println("Transaction Number " + (i + 1) + ": " + temp.getElement().getCustomerName() + ", Customer ID: " + temp.getElement().getCustomerID());
                temp = temp.getNext();
            }
        } catch (queueexample.EmptyQueueException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
